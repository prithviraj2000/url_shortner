package com.url.shortner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UrlShortnerRequest {
    private String originalUrl;
    private String shortUrl;

}
