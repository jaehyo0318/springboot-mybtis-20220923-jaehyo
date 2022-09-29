package com.boot.mybatis20220923jaehyo.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequestMapping("/download")
@RestController
public class DownloadController {

    @Value("${file.path}")
    private String filePath;

    @GetMapping("/news")
    public ResponseEntity<?> download(@RequestParam String originFileName, @RequestParam String tempFileName) throws IOException {
        Path path = Paths.get(filePath + "news/" + tempFileName); //실제 파일경로
        String contentType = Files.probeContentType(path); // MIME형식으로 바꿔줌
        log.info("ContentType: {}" + contentType);


        //다운로드 정보를 입력
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(originFileName, StandardCharsets.UTF_8)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return ResponseEntity.ok().headers(headers).body(resource);
    }

}
