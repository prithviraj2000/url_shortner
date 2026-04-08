package com.url.shortner.controler;

import com.url.shortner.dto.UrlShortnerRequest;
import com.url.shortner.dto.UrlShortnerResponse;
import com.url.shortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short-url")
public class UrlShortnerControler {

    @Autowired
    private UrlShortnerService urlShortnerService;

    @PostMapping("/shorten")
    public UrlShortnerResponse shortenUrl(@RequestBody UrlShortnerRequest request) {
        // Logic to shorten the URL
        return urlShortnerService.shortenUrl(request);
    }

    @GetMapping("/original")
    public UrlShortnerResponse getOriginalUrl(@RequestParam String shortUrl) {
        return urlShortnerService.getOriginalUrl(shortUrl);
    }

}
