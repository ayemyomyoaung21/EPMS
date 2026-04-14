export interface AuthRequest {
    email: string;
    password: string;
}

export interface RegisterDto {
    name: string;
    email: string;
    password: string;
    roleId: number;
}

export interface AuthResponse {
    access_token: string;
    refresh_token: string;
    message: string;
    userInfo?: UserInfo;
}

export interface UserInfo {
    id: number;
    staffNo: string;
    staffName: string;
    email: string;
    role: string;
    positionName?: string;
    departmentName?: string;
    permissions?: string[];  // e.g., ['KPI_READ_OWN', 'KPI_READ_TEAM', 'APPRAISAL_READ_ALL']
    dataScopes?: string[];
}

export interface RefreshTokenRequest {
    refreshToken: string;
}

export interface User {
    id: number;
    name?: string;
    staffName?: string;
    staffNo?: string;
    email: string;
    roles?: string[];
    role?: {
        id: number;
        role: string;
    };
    permissions?: string[];
}

export interface UpdateUser {
    name: string;
    email: string;
}

export interface AuthState {
    user: User | null;
    accessToken: string | null;
    refreshToken: string | null;
    isAuthenticated: boolean;
}

// Menu item structure
export interface MenuItem {
    key: string;
    label: string;
    icon: string; // icon name
    path: string;
    requiredPermissions?: string[]; // if empty, show to everyone
}