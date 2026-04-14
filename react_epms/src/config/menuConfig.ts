import {type MenuItem } from '../features/auth/authTypes';

// Define all possible menu items (with their required permissions)
export const ALL_MENU_ITEMS: MenuItem[] = [
    {
        key: 'dashboard',
        label: 'Dashboard',
        icon: 'LayoutDashboard',
        path: '/dashboard',
        requiredPermissions: [], // Everyone can see dashboard
    },
    {
        key: 'my-info',
        label: 'My Info',
        icon: 'User',
        path: '/my-info',
        requiredPermissions: [], // Everyone can see their own info
    },
    {
        key: 'kpi',
        label: 'KPIs',
        icon: 'Target',
        path: '/kpis',
        requiredPermissions: ['KPI_READ_OWN', 'KPI_READ_TEAM', 'KPI_READ_ALL'],
    },
    {
        key: 'appraisal',
        label: 'Appraisals',
        icon: 'Star',
        path: '/appraisals',
        requiredPermissions: ['APPRAISAL_READ_OWN', 'APPRAISAL_READ_TEAM', 'APPRAISAL_READ_ALL'],
    },
    {
        key: 'feedback',
        label: 'Feedback',
        icon: 'MessageSquare',
        path: '/feedback',
        requiredPermissions: ['CONTINUOUSFEEDBACK_READ_OWN', 'CONTINUOUSFEEDBACK_READ_TEAM', '360FEEDBACK_READ_OWN'],
    },
    {
        key: 'pip',
        label: 'Performance Plans',
        icon: 'FileWarning',
        path: '/pip',
        requiredPermissions: ['PIP_READ_OWN', 'PIP_READ_TEAM', 'PIP_READ_ALL'],
    },
    {
        key: 'reports',
        label: 'Reports',
        icon: 'BarChart3',
        path: '/reports',
        requiredPermissions: ['REPORTING_READ_TEAM', 'REPORTING_READ_DEPARTMENT', 'REPORTING_READ_ALL'],
    },
    {
        key: 'employees',
        label: 'Employees',
        icon: 'Users',
        path: '/employees',
        requiredPermissions: ['USERMANAGEMENT_READ_TEAM', 'USERMANAGEMENT_READ_ALL'],
    },
    {
        key: 'settings',
        label: 'Settings',
        icon: 'Settings',
        path: '/settings',
        requiredPermissions: ['USERMANAGEMENT_UPDATE_ALL', 'POSITIONMANAGEMENT_READ_ALL'],
    },
    {
        key: 'notifications',
        label: 'Notifications',
        icon: 'Bell',
        path: '/notifications',
        requiredPermissions: [], // Everyone can see notifications
    },
];

// Function to filter menu items based on user permissions
export const getFilteredMenuItems = (userPermissions: string[] | undefined): MenuItem[] => {
    if (!userPermissions) {
        // Return only items with no permission required
        return ALL_MENU_ITEMS.filter(item => (item.requiredPermissions ?? []).length === 0);
    }
    
    return ALL_MENU_ITEMS.filter(item => {
        const requiredPermissions = item.requiredPermissions ?? [];
        if (requiredPermissions.length === 0) return true;
        return requiredPermissions.some(required => 
            userPermissions.some(userPerm => userPerm.includes(required.split('_')[0]))
        );
    });
};