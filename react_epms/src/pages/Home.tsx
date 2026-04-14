// Home.tsx
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { useLoginMutation } from '../features/auth/authApi';
import { loginSuccess } from '../features/auth/authSlice';
import type { RootState } from '../app/store';
import { Mail, Lock, LogIn, Eye, EyeOff, X } from 'lucide-react';

const Home = () => {
  const [showLoginForm, setShowLoginForm] = useState(false);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [error, setError] = useState('');
  
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [login, { isLoading }] = useLoginMutation();
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated);
  
  if (isAuthenticated) {
    navigate('/dashboard');
    return null;
  }
  
  const handleLoginSubmit = async (e: React.FormEvent) => {
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
  
  return (
    <div className="min-h-screen" style={{ backgroundColor: '#cfe3ec' }}>
      {/* Header */}
      <header className="sticky top-0 z-40 shadow-md" style={{ backgroundColor: '#044f76' }}>
        <div className="px-6 py-3 flex items-center justify-between">
          {/* Logo */}
          <div className="flex items-center space-x-2">
            <div className="w-8 h-8 bg-white rounded-lg flex items-center justify-center">
              <span className="text-[#044f76] font-bold text-lg">E</span>
            </div>
            <span className="text-white font-semibold text-xl">EPMS</span>
          </div>
          
          {/* Login Button */}
          <button
            onClick={() => setShowLoginForm(true)}
            className="flex items-center gap-2 px-5 py-2 bg-white/10 hover:bg-white/20 rounded-lg transition-colors text-white font-medium"
          >
            <LogIn size={18} />
            <span>Login</span>
          </button>
        </div>
      </header>
      
      {/* Main Content */}
      <div className="container mx-auto px-6 py-12 max-w-6xl">
        <div className="grid md:grid-cols-2 gap-12 items-center">
          
          {/* Left Column - Image */}
          <div className="flex justify-center">
            <img 
              src="/image.png" 
              alt="EPMS"
              className="w-full max-w-md rounded-2xl shadow-xl"
            />
          </div>
          
          {/* Right Column */}
          <div>
            {!showLoginForm ? (
              // Info Section
              <div>
                <h1 className="text-4xl font-bold mb-4" style={{ color: '#044f76' }}>
                  Performance Management
                </h1>
                <p className="text-gray-600 text-lg mb-6">
                  Streamline your employee evaluations, track KPIs, and boost productivity.
                </p>
                <button
                  onClick={() => setShowLoginForm(true)}
                  className="px-6 py-2.5 rounded-lg text-white font-medium transition-colors"
                  style={{ backgroundColor: '#044f76' }}
                >
                  Get Started
                </button>
              </div>
            ) : (
              // Login Form Section
              <div className="bg-white rounded-2xl shadow-xl p-8">
                <div className="flex justify-between items-center mb-6">
                  <h2 className="text-2xl font-bold" style={{ color: '#044f76' }}>Sign In</h2>
                  <button 
                    onClick={() => {
                      setShowLoginForm(false);
                      setError('');
                      setEmail('');
                      setPassword('');
                    }}
                    className="text-gray-400 hover:text-gray-600"
                  >
                    <X size={20} />
                  </button>
                </div>
                
                <form onSubmit={handleLoginSubmit} className="space-y-5">
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-2">Email</label>
                    <div className="relative">
                      <div className="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                        <Mail size={18} className="text-gray-400" />
                      </div>
                      <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        className="w-full pl-10 pr-3 py-2.5 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#044f76] focus:border-transparent"
                        required
                      />
                    </div>
                  </div>
                  
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-2">Password</label>
                    <div className="relative">
                      <div className="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                        <Lock size={18} className="text-gray-400" />
                      </div>
                      <input
                        type={showPassword ? "text" : "password"}
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        className="w-full pl-10 pr-10 py-2.5 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-[#044f76] focus:border-transparent"
                        required
                      />
                      <button
                        type="button"
                        onClick={() => setShowPassword(!showPassword)}
                        className="absolute inset-y-0 right-0 flex items-center pr-3"
                      >
                        {showPassword ? (
                          <EyeOff size={18} className="text-gray-400 hover:text-gray-600" />
                        ) : (
                          <Eye size={18} className="text-gray-400 hover:text-gray-600" />
                        )}
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
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;