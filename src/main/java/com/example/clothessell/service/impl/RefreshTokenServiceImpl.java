package com.example.clothessell.service.impl;

import com.example.clothessell.entity.RefreshToken;
import com.example.clothessell.repository.IRefreshTokenRepository;
import com.example.clothessell.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
    @Autowired
    private IRefreshTokenRepository refreshTokenRepository;

    @Value("${jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Override
    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken createRefreshToken(int userId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
        }
        return token;
    }

    @Override
    public int deleteByUserId(int userId) {
        return 0;
    }
}
