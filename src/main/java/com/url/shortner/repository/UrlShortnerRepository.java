package com.url.shortner.repository;

import com.url.shortner.entity.UrlInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlShortnerRepository extends MongoRepository<UrlInfo, String> {

     void saveUrlMapping(String shortUrl, String originalUrl);

     String getOriginalUrl(String shortUrl);
}
