package com.example.clothessell.service;

import com.example.clothessell.entity.RefreshToken;

public interface IRefreshTokenService {
    RefreshToken findByToken(String token);

    RefreshToken findByUserId(int userId);

    RefreshToken createRefreshToken(int userId);

    void delete(RefreshToken refreshToken);

}
