import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import type { RootState } from '../app/store';
import { logout } from '../features/auth/authSlice';
import { Bell, ChevronDown, LogOut, Menu, Search, User, X } from 'lucide-react';

interface HeaderProps {
  onMenuClick?: () => void;
  showSearch?: boolean;
}

const Header = ({ onMenuClick, showSearch = true }: HeaderProps) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [userMenuOpen, setUserMenuOpen] = useState(false);
  const [notificationsOpen, setNotificationsOpen] = useState(false);
  
  const user = useSelector((state: RootState) => state.auth.user);
  
  const handleLogout = () => {
    dispatch(logout());
    navigate('/login');
  };
  
  return (
    <header className="sticky top-0 z-40 shadow-md" style={{ backgroundColor: '#044f76' }}>
      <div className="px-4 h-16 flex items-center justify-between">
        {/* Left - Menu button (mobile) + Logo */}
        <div className="flex items-center space-x-3">
          <button
            onClick={onMenuClick}
            className="lg:hidden text-white p-2 hover:bg-white/10 rounded-lg transition-colors"
          >
            <Menu className="w-5 h-5" />
          </button>
          <div className="flex items-center space-x-2">
            <div className="w-8 h-8 bg-white rounded-lg flex items-center justify-center">
              <span className="text-[#044f76] font-bold text-lg">E</span>
            </div>
            <span className="text-white font-semibold text-xl hidden sm:block">EPMS</span>
          </div>
        </div>
        
        {/* Center - Search Bar */}
        {showSearch && (
          <div className="hidden md:flex items-center bg-white/10 rounded-lg px-3 py-1.5 w-80">
            <Search className="w-4 h-4 text-white/60" />
            <input
              type="text"
              placeholder="Search here..."
              className="bg-transparent ml-2 flex-1 outline-none text-white placeholder-white/50 text-sm"
            />
          </div>
        )}
        
        {/* Right - Notifications & User Menu */}
        <div className="flex items-center space-x-2">
          {/* Notifications */}
          <div className="relative">
            <button
              onClick={() => setNotificationsOpen(!notificationsOpen)}
              className="p-2 rounded-lg hover:bg-white/10 transition-colors relative"
            >
              <Bell className="w-5 h-5 text-white" />
              <span className="absolute top-1 right-1 w-2 h-2 bg-red-500 rounded-full"></span>
            </button>
            
            {notificationsOpen && (
              <div className="absolute right-0 mt-2 w-80 bg-white rounded-lg shadow-lg z-50">
                <div className="p-3 border-b">
                  <h3 className="font-semibold text-gray-800">Notifications</h3>
                </div>
                <div className="max-h-96 overflow-y-auto">
                  <div className="p-4 text-center text-gray-500 text-sm">
                    No new notifications
                  </div>
                </div>
              </div>
            )}
          </div>
          
          {/* User Menu */}
          <div className="relative">
            <button
              onClick={() => setUserMenuOpen(!userMenuOpen)}
              className="flex items-center space-x-3 px-2 py-1.5 rounded-lg hover:bg-white/10 transition-colors"
            >
              <div className="w-8 h-8 rounded-full bg-white/20 flex items-center justify-center">
                <User className="w-4 h-4 text-white" />
              </div>
              <div className="hidden md:block text-left">
                <p className="text-white text-sm font-medium">
                  {user?.staffName || user?.name || 'User'}
                </p>
                <p className="text-white/60 text-xs">{user?.email || ''}</p>
              </div>
              <ChevronDown className="w-4 h-4 text-white/60" />
            </button>
            
            {userMenuOpen && (
              <div className="absolute right-0 mt-2 w-56 bg-white rounded-lg shadow-lg py-1 z-50">
                <div className="px-4 py-3 border-b">
                  <p className="text-sm font-medium text-gray-800">
                    {user?.staffName || user?.name || 'User'}
                  </p>
                  <p className="text-xs text-gray-500">{user?.email}</p>
                </div>
                <button className="w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">
                  Profile
                </button>
                <button className="w-full text-left px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">
                  Settings
                </button>
                <hr className="my-1" />
                <button 
                  onClick={handleLogout}
                  className="w-full text-left px-4 py-2 text-sm text-red-600 hover:bg-gray-100"
                >
                  Logout
                </button>
              </div>
            )}
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;