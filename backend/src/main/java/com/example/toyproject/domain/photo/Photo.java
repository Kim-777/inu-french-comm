package com.example.toyproject.domain.photo;

import com.example.toyproject.config.BaseTimeEntity;
import com.example.toyproject.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Photo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="board_id")
    private Board board;

    @Column(nullable = false)
    private String filePath;    // 파일 저장 경로

    @Column(nullable =  false)
    private String origFileName;    // 파일 원본명

    private Long fileSize;

    @Builder
    public Photo(String origFileName, String filePath, Long fileSize){
        this.origFileName = origFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    // 밑에꺼 굳이 있어야되나...? 나중에 체크
    public void setBoard(Board board){
        this.board = board;

        // 게시글에 현재 파일이 존재하지 않는다면
        if(!board.getPhoto().contains(this))
            // 파일 추가
            board.getPhoto().add(this);
    }
}
