package com.boot.mybatis20220923jaehyo.repository;

import com.boot.mybatis20220923jaehyo.domain.News;
import com.boot.mybatis20220923jaehyo.domain.NewsFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsRepository {
    public int save(News news);
    public int saveFiles(List<NewsFile> newsFileList);
    public News getNews(int news_id);

}
