package chapter13.practice.view;

import chapter13.practice.model.Book;
import chapter13.practice.model.NonFiction;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenu() {
        System.out.println("=======");
        System.out.println("도서관리 시스템");
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 전체 조회");
        System.out.println("3. 도서 단건 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("0. 종료");
        System.out.println("=====");
        System.out.print("선택 >>> ");
    }

    //사용자 입력값에 대한 유효성 검증 로직
    //: 프로세스 로직 입력값과 데이터 입력값 둘다 검증한다
    public int getInput() {
        int choice;
        try{
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요");
            scanner.nextLine();
            return -1;
        }
        return choice;
    }

    public Book getBookDetails() {
        System.out.println("도서 ID : ");
        int id = getInput();
        if(id == -1) return null;

        scanner.nextLine(); //정수값이 잘 입력된 경우 nextInt()의 버퍼를 처리한다
        System.out.println("제목 : ");
        String title = scanner.nextLine().trim();
        //cf)문자열 메서드 : 문자열.trim()
        //   - 문자열 양끝의 공백을 제거한다.

        if(title.isEmpty()){
            System.out.println("공백으로만 검색되지 않습니다");
            return null;
        }
        System.out.println("저자 : ");
        String author = scanner.nextLine().trim();
        if(author.isEmpty()){
            System.out.println("공백으로만 검색되지 않습니다");
            return null;
        }

        System.out.println("1. Fiction / 2. NonFiction");
        int type =  getInput(); //getInput으로 이미 정수만 받는다.
        if (type == -1) return null;
        scanner.nextLine();

        if(type == 1) {
            System.out.println("장르 : ");
            String genre = scanner.nextLine().trim();
            if(genre.isEmpty()){
                System.out.println("공백으로 검색할 수 없습니다");
                return null;
            }
            return new NonFiction(id, title, author, genre);
        } else if(type == 2) {
            System.out.println("분야 : ");
            String field = scanner.nextLine().trim();
            if(field.isEmpty()){
                System.out.println("공백으로 검색할 수 없습니다");
                return null;
            }
            return new NonFiction(id, title, author, field);
        } else { //getInput으로 이미 정수만 받기에 else로 예외처리
            System.out.println("잘못된 선택입니다. 1 또는 2를 입력해주세요");
            return null;
        }
    }

    public void displayBooks(List<Book> books) {
        if(books.isEmpty()){
            System.out.println("등록된 도서가 없습니다");
        } else {
            for(Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    public void displayBook(Book book) {
        if(book == null) {
            System.out.println("해당도서를 찾을 수 없습니다");
        } else {
            System.out.println(book);
        }
    }
}