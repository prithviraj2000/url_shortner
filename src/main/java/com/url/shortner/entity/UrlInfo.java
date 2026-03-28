package com.url.shortner.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "url-info")
@Getter
@Setter
@AllArgsConstructor
public class UrlInfo {

    @Id
    private String id;
    private String shortUrl;
    private String originalUrl;
    private Date createdAt;
    private Date accessedAt;

}
