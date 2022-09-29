package com.boot.mybatis20220923jaehyo.dto;

import com.boot.mybatis20220923jaehyo.domain.News;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class NewsWriteReqDto {
    private String title;
    private String broadcastingName;
    private String writer;
    private String content;
    private List<MultipartFile> files;

    public News toEntity(String writer) {
        return News.builder()
                .news_title(title)
                .news_writer(writer)
                .news_broadcasting(broadcastingName)
                .news_content(content)
                .build();
    }
}
