package com.example.toyproject.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/image")
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(BoardFileVO boardFileVO) throws Exception {

        BoardCreateRequestDto requestDto =
                BoardCreateRequestDto.builder()
                        .name(boardFileVO.getName())
                        .content(boardFileVO.getContent())
                        .build();

        return boardService.create(requestDto, boardFileVO.getImage());
    }
}
