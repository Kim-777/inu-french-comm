package com.example.toyproject.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateRequestDto {

    private String name;
    private String content;

    @Builder
    public BoardCreateRequestDto(String name, String content){

        this.name = name;
        this.content = content;

    }
}
