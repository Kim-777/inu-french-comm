package com.example.toyproject.domain.board;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Data
public class BoardFileVO {

    private String name;
    private String content;
    private List<MultipartFile> image;
}
