package com.example.toyproject.domain.board;

import com.example.toyproject.config.FileHandler;
import com.example.toyproject.domain.photo.Photo;
import com.example.toyproject.domain.photo.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final PhotoRepository photoRepository;
    private final FileHandler fileHandler;
    @Transactional
    public Long create(
            BoardCreateRequestDto requestDto,
            List<MultipartFile> files
    ) throws Exception {
        // 파일 처리를 위한 Board 객체 생성
        Board board = new Board(
                requestDto.getName(),
                requestDto.getContent()
        );

        List<Photo> photoList = fileHandler.parseFileInfo(files);


        // 파일이 존재할 때에만 처리
        if(!photoList.isEmpty()){
            for(Photo photo : photoList)
                // 파일을 DB에 저장
                board.addPhoto(photoRepository.save(photo));
        }

        return boardRepository.save(board).getId();
    }
}
