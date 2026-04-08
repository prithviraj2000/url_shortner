package com.url.shortner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UrlShortnerResponse {
    private String shortUrl;
    private String originalUrl;
}
