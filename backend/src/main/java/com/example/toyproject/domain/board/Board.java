package com.example.toyproject.domain.board;

import com.example.toyproject.config.BaseTimeEntity;
import com.example.toyproject.domain.photo.Photo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;
@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

//    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Member.class)
//    @JoinColumn(name = "member_id", updatable = false)
//    @JsonBackReference
//    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(
            mappedBy = "board",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Photo> photo = new ArrayList<>();

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Board에서 파일 처리 위함
    public void addPhoto(Photo photo) {
        this.photo.add(photo);
        // 게시글에 파일이 저장되어있지 않은 경우
        if(photo.getBoard() != this)
            // 파일 저장
            photo.setBoard(this);
    }
}
