package com.example.clothessell.service.impl;

import com.example.clothessell.entity.RefreshToken;
import com.example.clothessell.repository.IRefreshTokenRepository;
import com.example.clothessell.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
    @Autowired
    private IRefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken findByUserId(int userId) {
        return refreshTokenRepository.findByUserId(userId);
    }

    @Override
    public RefreshToken createRefreshToken(int userId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    public void delete(RefreshToken refreshToken) {
        refreshTokenRepository.delete(refreshToken);
    }

}
