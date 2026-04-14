import { createSlice, type PayloadAction } from "@reduxjs/toolkit";
import type { AuthResponse, AuthState, User } from "./authTypes";

const loadFromSessionStorage = () => {
  try {
    const accessToken = sessionStorage.getItem("accessToken");
    const refreshToken = sessionStorage.getItem("refreshToken");
    const user = sessionStorage.getItem("user");
    return {
      accessToken,
      refreshToken,
      user: user ? JSON.parse(user) : null,
    };
  } catch {
    return { accessToken: null, refreshToken: null, user: null };
  }
};

const { accessToken: savedAccessToken, refreshToken: savedRefreshToken, user: savedUser } = loadFromSessionStorage();

const initialState: AuthState = {
  user: savedUser || null,
  accessToken: savedAccessToken || null,
  refreshToken: savedRefreshToken || null,
  isAuthenticated: !!savedAccessToken,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    loginSuccess: (state, action: PayloadAction<{ access_token: string; refresh_token: string; user?: User }>) => {
      state.accessToken = action.payload.access_token;
      state.refreshToken = action.payload.refresh_token;
      state.isAuthenticated = true;
      
      if (action.payload.user) {
        state.user = action.payload.user;
      }
      
      sessionStorage.setItem("accessToken", action.payload.access_token);
      sessionStorage.setItem("refreshToken", action.payload.refresh_token);
      if (action.payload.user) {
        sessionStorage.setItem("user", JSON.stringify(action.payload.user));
      }
    },
    setTokens: (state, action: PayloadAction<{ access_token: string; refresh_token: string }>) => {
      state.accessToken = action.payload.access_token;
      state.refreshToken = action.payload.refresh_token;
      state.isAuthenticated = true;
      
      sessionStorage.setItem("accessToken", action.payload.access_token);
      sessionStorage.setItem("refreshToken", action.payload.refresh_token);
    },
    logout: (state) => {
      state.user = null;
      state.accessToken = null;
      state.refreshToken = null;
      state.isAuthenticated = false;
      
      sessionStorage.removeItem("accessToken");
      sessionStorage.removeItem("refreshToken");
      sessionStorage.removeItem("user");
    },
    setUser: (state, action: PayloadAction<User>) => {
      state.user = action.payload;
      sessionStorage.setItem("user", JSON.stringify(action.payload));
    },
  },
});

export const { loginSuccess, logout, setTokens, setUser } = authSlice.actions;
export default authSlice.reducer;