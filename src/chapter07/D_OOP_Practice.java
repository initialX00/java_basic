package chapter07;

/*
    ===도서 관리 시스켐 만들기===
    책의 정보를 저장, 책의 정보를 출력, 책의 상태(대여 가능여부) 확인

    1)Book 클래스
    속성 : title(String), author(String), isAvailable(boolean)
    메서드 : 생성자(title, author), borrowBook(), returnBook(), displayInfo()
    2)EBook 클래스
    Book 클래스를 상속
    추가 속성 : fileSize(double)
    추가 메서드 : 생성자(title, author, fileSize)
                오버라이딩(displayInfo + fileSize)
    반납이 불가하도록 Book클래스의 returnBook() 메서드에 final을 적용
 */

class Book{
    private String title;
    private String author;
    private boolean isAvailable = true;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        //isAvailable = true; - 생략
    }
    //책 대여
    void borrowBook() {
        if(isAvailable){
            System.out.println("대여 완료되었습니다");
            isAvailable = false;
        } else{
            System.out.println("현재 대여 중입니다. 대여불가");
        }
    }
    //책 반납, E북은 반납 불가
    final void returnBook() {
        if(!isAvailable){
            System.out.println("반납이 완료되었습니다");
            isAvailable = true;
        } else{
            System.out.println("이미 반납된 책입니다. 반납 불가");
        }
    }
    //책 정보 출력
    void displayInfo(){
        System.out.print("책 제목: " + title + ", ");
        System.out.print("책 저자: " + author + ", ");
        System.out.println((isAvailable ? "대여가능" : "대여불가"));
    }
}

//에러 There is no parameterless constructor available in 'chapter07.Book'
//오류 자체는 기본 생성자 Book() {}를 생성하면 되지만 쓸데없는 로직이 추가된다.
//Book클래스에 빈생성자가 없으므로 매개변수를 전부 기입한 생성자를 만들때까지는 오류가 지속적으로 노출된다.
class EBook extends Book {
    private double fileSize;

    EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    //오버라이딩
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("파일크기: " + fileSize + "MB");
    }
}


public class D_OOP_Practice {
    public static void main(String[] args) {
        //Book객체 생성
        Book book1 = new Book("작별하지 않는다", "한강");
        book1.displayInfo();
        book1.borrowBook();
        book1.borrowBook();
        book1.returnBook();
        book1.returnBook();
        //EBook객체 생성
        EBook ebook1 = new EBook("달려구트 꿈 백화점", "이미에", 867.00);
        ebook1.displayInfo();
        ebook1.borrowBook();
        //ebook1.returnBook();- 쓸 수만 있고 재정의만 막아 놓은 상태
    }
}
