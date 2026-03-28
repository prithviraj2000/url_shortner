package com.url.shortner.service;

import com.url.shortner.dto.UrlShortnerRequest;


public interface UrlShortnerService {

     String shortenUrl(UrlShortnerRequest request);

     String getOriginalUrl(String shortUrl);
}
