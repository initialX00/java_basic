package chapter13.practice.service;

/*
    도서관리 시스템의 비즈니스 로직을 인터페이스화
    : CRUD 기능 정의
 */

import java.util.List;

public interface BookManager<T> {
    void addBook(T book);
    List<T> listAllBooks();
    T findBookById(int id);
    void updateBook(int id, T updateBook);
    void removeBook(int id);

}
