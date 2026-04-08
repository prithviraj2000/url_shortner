package com.url.shortner.service;

import com.url.shortner.dto.UrlShortnerRequest;
import com.url.shortner.dto.UrlShortnerResponse;


public interface UrlShortnerService {

     UrlShortnerResponse shortenUrl(UrlShortnerRequest request);

     UrlShortnerResponse getOriginalUrl(String shortUrl);
}
