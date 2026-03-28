package com.url.shortner.controler;

import com.url.shortner.dto.UrlShortnerRequest;
import com.url.shortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short-url")
public class UrlShortnerControler {

    @Autowired
    private UrlShortnerService urlShortnerService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlShortnerRequest request) {
        // Logic to shorten the URL
        return urlShortnerService.shortenUrl(request);
    }

}
