import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useLoginMutation } from '../features/auth/authApi';
import { loginSuccess } from '../features/auth/authSlice';
import type { RootState } from '../app/store';
import { Mail, Lock, LogIn, Eye, EyeOff, X } from 'lucide-react';

interface LoginProps {
  isOpen?: boolean;
  onClose?: () => void;
}

const Login = ({ isOpen: propIsOpen, onClose }: LoginProps) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [error, setError] = useState('');
  const [isModalOpen, setIsModalOpen] = useState(false);
  
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [login, { isLoading }] = useLoginMutation();
  
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);
  
  // Use prop isOpen if provided, otherwise use internal state
  const open = propIsOpen !== undefined ? propIsOpen : isModalOpen;
  
  useEffect(() => {
    if (isAuthenticated) {
      if (onClose) onClose();
      setIsModalOpen(false);
      navigate('/dashboard');
    }
  }, [isAuthenticated, navigate, onClose]);
  
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');
    
    try {
      const result = await login({ email, password }).unwrap();
      
      dispatch(loginSuccess({
        access_token: result.access_token,
        refresh_token: result.refresh_token,
        user: result.userInfo ? {
          id: result.userInfo.id,
          email: result.userInfo.email,
          staffName: result.userInfo.staffName,
          staffNo: result.userInfo.staffNo,
          permissions: result.userInfo.permissions,
        } : undefined
      }));
      
    } catch (err: any) {
      setError(err.data?.message || 'Invalid email or password');
    }
  };
  
  if (!open) return null;
  
  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/50 backdrop-blur-sm">
      <div className="bg-white rounded-2xl shadow-2xl w-full max-w-md mx-4 animate-fadeIn">
        {/* Modal Header */}
        <div className="flex justify-between items-center p-6 border-b">
          <div className="flex items-center space-x-2">
            <div className="w-10 h-10 rounded-xl flex items-center justify-center" style={{ backgroundColor: '#044f76' }}>
              <LogIn className="w-5 h-5 text-white" />
            </div>
            <h2 className="text-2xl font-bold" style={{ color: '#044f76' }}>Welcome Back</h2>
          </div>
          <button 
            onClick={onClose || (() => setIsModalOpen(false))}
            className="text-gray-400 hover:text-gray-600 transition-colors"
          >
            <X className="w-5 h-5" />
          </button>
        </div>
        
        {/* Modal Body */}
        <form onSubmit={handleSubmit} className="p-6 space-y-5">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-2">Email Address</label>
            <div className="relative">
              <Mail className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-gray-400" />
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                className="w-full pl-10 pr-3 py-2.5 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#044f76] focus:border-transparent"
                placeholder="admin@epms.com"
                required
              />
            </div>
          </div>
          
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-2">Password</label>
            <div className="relative">
              <Lock className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-gray-400" />
              <input
                type={showPassword ? "text" : "password"}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                className="w-full pl-10 pr-10 py-2.5 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#044f76] focus:border-transparent"
                placeholder="••••••••"
                required
              />
              <button
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                className="absolute right-3 top-1/2 -translate-y-1/2"
              >
                {showPassword ? <EyeOff className="w-4 h-4 text-gray-400" /> : <Eye className="w-4 h-4 text-gray-400" />}
              </button>
            </div>
          </div>
          
          {error && (
            <div className="bg-red-50 border border-red-200 text-red-600 px-4 py-2 rounded-lg text-sm">
              {error}
            </div>
          )}
          
          <button
            type="submit"
            disabled={isLoading}
            className="w-full py-2.5 rounded-lg text-white font-medium transition-colors disabled:opacity-50"
            style={{ backgroundColor: '#044f76' }}
          >
            {isLoading ? 'Logging in...' : 'Sign In'}
          </button>
        </form>
      </div>
    </div>
  );
};

export default Login;