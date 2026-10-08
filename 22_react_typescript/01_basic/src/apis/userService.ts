import axiosInstance from "./axiosInstance";

export interface User {
    id: string;
    name: string;
    email: string;
}

export interface ApiResponse<T> {
    data: T;
    message?: string;
    statusCode?: number;
}

const userService = {
    // fetch all users
    getUsers: async (page = 1, limit = 10) => {
        const response = await axiosInstance.get<ApiResponse<User[]>>("/users", {
            params: { page, limit },
        });
        return response.data;
    },

    getUserById: async (userId: string) => {
        const response = await axiosInstance.get<ApiResponse<User>>(`/users/${userId}`);
        return response.data;
    },
};

export default userService;
