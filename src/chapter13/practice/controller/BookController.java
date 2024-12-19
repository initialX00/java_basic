package chapter13.practice.controller;

import chapter13.practice.model.Book;
import chapter13.practice.service.BookServiceImpl;
import chapter13.practice.view.BookView;

import java.util.List;

//사용자의 요청을 처리
public class BookController {
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInput(); //숫자 값을 검증하여 가져오는 메소드

            switch(choice) {
                case 1: //책 추가 : 요청데이터가 있고, 반환데이터가 있다
                    Book book = view.getBookDetails();
                    if(book != null) {
                        service.addBook(book);
                    } else {
                        System.out.println("책은 장르 또는 분야를 입력해야합니다");
                    }
                    break;
                case 2: //전체 책 조회 : 요청데이터는 없고, 반환데이터가 있다
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 3: //단건 책 조회 : 요청데이터가 있고, 반환데이터도 있다
                    int findBookId = view.getInput(); //검색하고자 하는 Book의 id
                    if(findBookId != -1) {
                        Book findBook = service.findBookById(findBookId); //해당 id로 찾은 Book 객체화
                        view.displayBook(findBook); //객체 반환
                    } else{
                        System.out.println("유효하지 않은 ID입니다");
                    }
                    break;
                case 4: //책 수정 : 요청데이터는 있고, 반환데이터는 없다.
                    int modifiedId = view.getInput();
                    if (modifiedId != -1) {
                        Book updatedBook = view.getBookDetails();
                        if(updatedBook != null) {
                            service.updateBook(modifiedId, updatedBook);
                        } else {
                            System.out.println("도서 정보가 유효하지 않습니다");
                        }
                    } else {
                        System.out.println("유효하지 않은 ID입니다");
                    }
                    break;
                case 5:
                    int removeId = view.getInput();
                    if(removeId != -1) {
                        service.removeBook(removeId);
                    } else {
                        System.out.println("유효하지 않은 ID입니다");
                    }

                    break;
                case 0:
                    System.out.println("===프로그램 종료===");
                    return;
                default:
                    System.out.println("잘못된 입력입니다");
                    break;
            }
        }
    }
}
