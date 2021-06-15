package com.example.toyproject.domain.photo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class PhotoDto {

    private String origFileName;

    private String filePath;

    private Long fileSize;

    @Builder
    public PhotoDto(String origFileName, String filePath, Long fileSize){
        this.origFileName = origFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}
