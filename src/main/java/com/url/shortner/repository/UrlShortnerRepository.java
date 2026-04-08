package com.url.shortner.repository;

import com.url.shortner.entity.UrlInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortnerRepository extends MongoRepository<UrlInfo, String> {

     Optional<UrlInfo> findById(String shortUrl);
}
