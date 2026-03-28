package com.url.shortner.service.impl;

import com.url.shortner.dto.UrlShortnerRequest;
import com.url.shortner.service.UrlShortnerService;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService {

    @Override
    public String shortenUrl(UrlShortnerRequest request) {

        return "short.ly/" + request.getOriginalUrl().hashCode();
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        // Logic to retrieve the original URL from the shortened URL
        // This is a placeholder implementation. You would typically look this up in a database.
        return "http://example.com/original-url";
    }
}
