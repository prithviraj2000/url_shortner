package com.url.shortner.service.impl;

import com.url.shortner.dto.UrlShortnerRequest;
import com.url.shortner.dto.UrlShortnerResponse;
import com.url.shortner.entity.UrlInfo;
import com.url.shortner.helper.UrlHelper;
import com.url.shortner.repository.UrlShortnerRepository;
import com.url.shortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService {

    @Autowired
    private UrlShortnerRepository urlShortnerRepository;

    @Override
    public UrlShortnerResponse shortenUrl(UrlShortnerRequest request) {
        StringBuilder urlHash = generateSHA256Hash(request.getOriginalUrl());
        String uniqueId = UrlHelper.generateId();
        String combinedHash = urlHash.append(uniqueId).toString();

        String encodedUrl = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(combinedHash.getBytes(StandardCharsets.UTF_8));

        UrlInfo urlInfo = UrlInfo.builder()
                .id(uniqueId)
                .originalUrl(request.getOriginalUrl())
                .shortUrl(encodedUrl)
                .createdAt(new java.util.Date())
                .build();

        urlShortnerRepository.save(urlInfo);


        return ResponseEntity.ok(UrlShortnerResponse.builder()
                .originalUrl(request.getOriginalUrl())
                .shortUrl(encodedUrl)
                .build()).getBody();

    }

    @Override
    public UrlShortnerResponse getOriginalUrl(String shortUrl) {
        Optional<UrlInfo> urlInfo = urlShortnerRepository.findById(shortUrl);
        if(urlInfo.isPresent()){
            return ResponseEntity.ok(UrlShortnerResponse.builder()
                    .originalUrl(urlInfo.get().getOriginalUrl())
                    .build()).getBody();
        } else{
            return (UrlShortnerResponse) ResponseEntity.notFound().build().getBody();
        }

    }

    public static StringBuilder generateSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hexString.append(String.format("%02x", hashByte));
            }

            return hexString;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }
}
