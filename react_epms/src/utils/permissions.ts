// Permission mapping: backend permission -> frontend menu visibility
export const hasAnyPermission = (userPermissions: string[] | undefined, requiredPermissions: string[]): boolean => {
    if (!userPermissions || userPermissions.length === 0) return false;
    if (!requiredPermissions || requiredPermissions.length === 0) return true;
    
    return requiredPermissions.some(required => 
        userPermissions.some(userPerm => userPerm.includes(required))
    );
};

// Check if user can view a specific module
export const canViewModule = (userPermissions: string[] | undefined, module: string): boolean => {
    if (!userPermissions) return false;
    
    const modulePatterns = {
        'KPI': ['KPI_READ_OWN', 'KPI_READ_TEAM', 'KPI_READ_DEPARTMENT', 'KPI_READ_ALL'],
        'APPRAISAL': ['APPRAISAL_READ_OWN', 'APPRAISAL_READ_TEAM', 'APPRAISAL_READ_ALL'],
        'FEEDBACK': ['CONTINUOUSFEEDBACK_READ_OWN', 'CONTINUOUSFEEDBACK_READ_TEAM', '360FEEDBACK_READ_OWN', '360FEEDBACK_READ_TEAM'],
        'PIP': ['PIP_READ_OWN', 'PIP_READ_TEAM', 'PIP_READ_ALL'],
        'REPORTING': ['REPORTING_READ_TEAM', 'REPORTING_READ_DEPARTMENT', 'REPORTING_READ_ALL'],
        'USER_MANAGEMENT': ['USERMANAGEMENT_READ_TEAM', 'USERMANAGEMENT_READ_ALL'],
    };
    
    const patterns = modulePatterns[module as keyof typeof modulePatterns];
    if (!patterns) return false;
    
    return patterns.some(pattern => userPermissions.includes(pattern));
};