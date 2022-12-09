package com.example.clothessell.service;

import com.example.clothessell.entity.RefreshToken;

public interface IRefreshTokenService {
    RefreshToken findByToken(String token);
    RefreshToken createRefreshToken(int userId);
    RefreshToken verifyExpiration(RefreshToken token);

    int deleteByUserId(int userId);
}
