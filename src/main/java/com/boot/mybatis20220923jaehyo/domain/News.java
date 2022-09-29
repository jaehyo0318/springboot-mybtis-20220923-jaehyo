package com.boot.mybatis20220923jaehyo.domain;

import com.boot.mybatis20220923jaehyo.dto.NewsReadRespDto;
import com.boot.mybatis20220923jaehyo.dto.NewsWriteRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News {
    private int news_id;

    private String news_title;
    private String news_writer;
    private String news_broadcasting;
    private String news_content;

    private List<NewsFile> news_file;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public NewsReadRespDto toNewsReadRespDto() {
        return NewsReadRespDto.builder()
               .id(news_id)
               .title(news_title)
               .writer(news_writer)
               .broadcastingName(news_broadcasting)
                .content(news_content)
                .createDate(create_date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")))
                .fileList(news_file)
                .build();
    }

    public NewsWriteRespDto toNewsWriteRespDto(List<NewsFile> newsFileList) {
        return NewsWriteRespDto.builder()
                .id(news_id)
                .title(news_title)
                .writer(news_writer)
                .broadcastingName(news_broadcasting)
                .content(news_content)
                .newsFileList(newsFileList)
                .build();
    }

}
