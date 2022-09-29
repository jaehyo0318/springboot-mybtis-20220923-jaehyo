package com.boot.mybatis20220923jaehyo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewsFile {
    private int file_id;
    private int news_id;
    private String file_origin_name;
    private String file_temp_name;
}
