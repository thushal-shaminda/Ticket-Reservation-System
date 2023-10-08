package com.tickectreservation.data.repositories;

import com.tickectreservation.data.api.ApiService;
import com.tickectreservation.data.models.User;

import java.io.IOException;

import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public User getUser(int userId) {
        try {
            Response<User> response = apiService.getUser(userId).execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException e) {
            System.out.println("Exception in UserRepository.getUser: " + e);
        }
        return null;
    }
}