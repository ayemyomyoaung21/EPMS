import { createSlice, type PayloadAction } from "@reduxjs/toolkit";
import type { AuthResponse, AuthState, User } from "./authTypes";

interface LoginPayload extends AuthResponse {}
const accessToken = localStorage.getItem("accessToken");
const refreshToken = localStorage.getItem("refreshToken");
const initialState: AuthState = {
  user: null,
  accessToken,
  refreshToken,
  isAuthenticated: !!accessToken,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    loginSuccess: (state, action: PayloadAction<LoginPayload>) => {
      // state.user = action.payload.user || null;
      state.accessToken = action.payload.access_token;
      state.refreshToken = action.payload.refresh_token;
      state.isAuthenticated = true;

      localStorage.setItem("accessToken", action.payload.access_token);
      localStorage.setItem("refreshToken", action.payload.refresh_token);
    },
    setTokens: (state, action: PayloadAction<LoginPayload>) => {
      state.accessToken = action.payload.access_token;
      state.refreshToken = action.payload.refresh_token;

      localStorage.setItem("accessToken", action.payload.access_token);
      localStorage.setItem("refreshToken", action.payload.refresh_token);
    },
    logout: (state) => {
      state.user = null;
      state.accessToken = null;
      state.isAuthenticated = false;
      localStorage.removeItem("accessToken");
      localStorage.removeItem("refreshToken");
    },
    setUser: (state, action: PayloadAction<User>) => {
      state.user = action.payload;
    },
  },
});

export const { loginSuccess, logout, setTokens,setUser } = authSlice.actions;
export default authSlice.reducer;
