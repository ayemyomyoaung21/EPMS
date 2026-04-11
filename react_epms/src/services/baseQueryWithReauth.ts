import { logout, setTokens} from "../features/auth/authSlice";
// import type { AuthResponse } from "../features/auth/authTypes";
import { baseQuery } from "./baseQuery";
import type { FetchBaseQueryError } from "@reduxjs/toolkit/query";
import type { AuthResponse } from "../features/auth/authTypes";
export const baseQueryWithReauth = async(args: any, api: any, extraOptions: any) => {
    let result = await baseQuery(args, api, extraOptions);
    // If 401 → try refresh
    if (args.url === "/auth/refresh") return result;

  if (result.error && result.error.status === 401) {
    const refreshToken = (api.getState() as any).auth.refreshToken;
    if (!refreshToken) {
      api.dispatch(logout());
      return result;
    }
    // Try refresh token
    const refreshResult = await baseQuery(
      {
        url: "/auth/refresh",
        method: "POST",
        body: { refreshToken: refreshToken },
        headers: {
      Authorization: "", 
    },
      },
      api,
      extraOptions
    );

    if (refreshResult.data) {
      const data = refreshResult.data as AuthResponse;
      // Save new tokens
      api.dispatch(setTokens(data));

      // Retry original request
      // result = await baseQuery(args, api, extraOptions);
      result = await baseQuery(
        {
          ...args,
          headers: {
            ...args.headers,
            Authorization: `Bearer ${data.access_token}`,
          },
        },
        api,
        extraOptions
      );
    } else {
      const err = refreshResult.error as FetchBaseQueryError;

      if (err.status === 401 || err.status === 403) {
        api.dispatch(logout());
      }
    }
  }
  return result;
}