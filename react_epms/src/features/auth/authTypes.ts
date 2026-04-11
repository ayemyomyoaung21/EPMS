export interface AuthRequest{
    email:string;
    password:string;
}

export interface RegisterDto{
    name:string;
    email:string;
    password:string;
    roleId: number;
}

export interface AuthResponse{
    access_token: string;
    refresh_token: string;
    message: string;
}

export interface RefreshTokenRequest{
    refreshToken: string;
}

export interface User{
    id:number;
    name:string;
    email:string;
    roles?:string[];
    role:{
        id:number;
        role:string;
    };
}

export interface UpdateUser{
    name:string;
    email:string;
}

export interface AuthState{
    user: User | null;
    accessToken: string | null;
    refreshToken: string | null;
    isAuthenticated: boolean;
}