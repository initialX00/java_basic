package chapter15.boardApp.entity;

/*
    Board 게시판
    - id :  게시판 고유 번호
    - title : 게시판 제목
    - content : 게시판 내용
    - author : 게시판 작성자

    entity -> dto -> view ->  controller -> service -> repository
 */

import lombok.Data;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
