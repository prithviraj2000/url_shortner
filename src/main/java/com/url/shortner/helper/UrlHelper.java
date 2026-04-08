package com.url.shortner.helper;

import java.util.UUID;

public class UrlHelper {

    private static final String BASE_URL = "http://short.url/";

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
