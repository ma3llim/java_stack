import type { AxiosError, AxiosInstance, AxiosResponse, InternalAxiosRequestConfig } from "axios";
import axios from "axios";

const axiosInstance: AxiosInstance = axios.create({
    baseURL: import.meta.env.BASE_URL,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
    timeout: 3000,
    withCredentials: true,
});

// Request Interceptor
axiosInstance.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        const token = localStorage.getItem("accessToken");

        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }

        // Add request ID for tracking
        config.headers["X-Request-ID"] = crypto.randomUUID();

        return config;
    },
    (error: AxiosError) => {
        return Promise.reject(error);
    },
);

// Response Interceptor
axiosInstance.interceptors.response.use(
    (response: AxiosResponse) => {
        return response;
    },
    async (error: AxiosError) => {
        const originalRequest = error.config as InternalAxiosRequestConfig & { _retry?: boolean };
        // Handle 401 Unauthorized - Token refresh
        if (error.response?.status === 401 && !originalRequest._retry) {
            originalRequest._retry = true;
            try {
                const refreshToken = localStorage.getItem("refreshToken");
                if (refreshToken) {
                    const response = await axios.post(`${import.meta.env.BASE_URL}/users/refresh-token`, { refreshToken });
                    const newToken = response.data.token;
                    localStorage.setItem("authToken", newToken);

                    // Retry original request
                    originalRequest.headers.Authorization = `Bearer ${newToken}`;
                    return axiosInstance(originalRequest);
                }
            } catch (refreshError) {
                // Redirect to login
                localStorage.removeItem("authToken");
                localStorage.removeItem("refreshToken");
                window.location.href = "/login";
                return Promise.reject(refreshError);
            }
        }

        // Handle other errors
        if (error.response) {
            // Server responded with error status
            console.error("API Error:", error.response.status, error.response.data);
        } else if (error.request) {
            // Request made but no response
            console.error("Network Error:", error.request);
        } else {
            // Something else happened
            console.error("Error:", error.message);
        }

        return Promise.reject(error);
    },
);

export default axiosInstance;
