import { useNavigate, useLocation } from 'react-router-dom';
import { useSelector } from 'react-redux';
import type { RootState } from '../app/store';
import { getFilteredMenuItems } from '../config/menuConfig';
import * as Icons from 'lucide-react';
import { useEffect } from 'react';

interface SidebarProps {
  isMobile?: boolean;
  onItemClick?: () => void;
}

const Sidebar = ({ isMobile = false, onItemClick }: SidebarProps) => {
  const navigate = useNavigate();
  const location = useLocation();
  
  const user = useSelector((state: RootState) => state.auth.user);
  const userPermissions = useSelector((state: RootState) => state.auth.user?.permissions);
  
  // Debug: Log permissions to console
  useEffect(() => {
    console.log('===== PERMISSION DEBUG =====');
    console.log('User object:', user);
    console.log('User permissions array:', userPermissions);
    console.log('============================');
  }, [user, userPermissions]);
  
  const menuItems = getFilteredMenuItems(userPermissions);
  
  // Debug: Log filtered menu items
  useEffect(() => {
    console.log('Filtered menu items based on permissions:', menuItems.map(m => m.label));
  }, [menuItems]);
  
  const getIcon = (iconName: string) => {
    const IconComponent = (Icons as any)[iconName];
    return IconComponent ? <IconComponent className="w-5 h-5" /> : null;
  };
  
  const handleNavigation = (path: string) => {
    navigate(path);
    if (onItemClick) onItemClick();
  };
  
  return (
    <div className="flex flex-col h-full">
      {/* Logo */}
      <div className="flex items-center justify-between mb-6 pb-4 border-b border-white/10 px-4">
        <div className="flex items-center space-x-2">
          <div className="w-8 h-8 bg-white rounded-lg flex items-center justify-center">
            <span className="text-[#044f76] font-bold text-lg">E</span>
          </div>
          {!isMobile && <span className="text-white font-semibold text-lg">EPMS</span>}
        </div>
      </div>
      
      {/* Menu Items */}
      <ul className="space-y-2 px-3">
        {menuItems.length === 0 && (
          <li className="text-white/50 text-sm text-center py-4">
            No menu items available
          </li>
        )}
        {menuItems.map((item) => {
          const isActive = location.pathname === item.path;
          return (
            <li key={item.key}>
              <button
                onClick={() => handleNavigation(item.path)}
                className={`w-full flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors
                  ${isActive 
                    ? 'bg-white/20 text-white' 
                    : 'text-white/70 hover:text-white hover:bg-white/10'
                  }`}
              >
                {getIcon(item.icon)}
                <span className="text-sm">{item.label}</span>
              </button>
            </li>
          );
        })}
      </ul>
    </div>
  );
};

export default Sidebar;