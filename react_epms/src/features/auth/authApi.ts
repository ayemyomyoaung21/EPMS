import { api } from "../../services/api";

export const authApi = api.injectEndpoints({
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (data) => ({
        url: "/auth/login",
        method: "POST",
        body: data,
      }),
      transformResponse: (response: any) => {
        // Transform backend response to match expected format
        return {
          access_token: response.accessToken || response.access_token,
          refresh_token: response.refreshToken || response.refresh_token,
          message: response.message,
          userInfo: response.userInfo,
        };
      },
    }),
    register: builder.mutation({
      query: (data) => ({
        url: "/auth/register",
        method: "POST",
        body: data,
      }),
    }),
    refreshToken: builder.mutation({
      query: (data) => ({
        url: "/auth/refresh",
        method: "POST",
        body: data,
      }),
    }),
  }),
});

export const { useLoginMutation, useRegisterMutation, useRefreshTokenMutation } = authApi;