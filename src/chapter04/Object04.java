package chapter04;

//클래스 생성 Book
class Book{
    //클래스 내부 데이터(속성, 필드)
    String title; //제목
    String publisher; //출판사
    int pageNumber; //페이지 수
    //클래스 내부 동작(행동, 메서드)
    //리턴으로 받을 값이 없기에 void 작성
    void displayInfo(){
        System.out.println(title + " - " + publisher);
        //return; 리턴을 받을 값이 없기때문에 생략되어있다.
    }
    //리턴을 받기에 void 미작성
    int returnPageNumber(){
        return this.pageNumber;
    }
    /*
        //생성자 함수//
        : new 연산자 사용 시 호출 될 메서드
         생략 시 속성에 기본 값이 할당된다
        - 기본타입: int(0), boolean(false), char('')
        - 참조타입: null
        - 사용자 정의 생성자 함수 생략 시 클래스명과 동일하면서 매개변수가 없는 메서드가 생략되어있다.
     */
    Book(){ //원래는 생략되어있지만 아래의 Book생성자때문에 생략하면 안됨
    }
    Book(String title, String publisher, int pageNumber){
        this.title = title;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
    }
}

public class Object04 {
    public static void main(String[] args) {
        //Book생성자는 생략되어 있기때문에 정의하지 않더라도 사용 가능하다
        Book myBook = new Book();
        System.out.println(myBook.title); //null
        System.out.println(myBook.publisher); //null
        System.out.println(myBook.pageNumber); //0

        //생성자 호출
        Book anotherBook = new Book("백설공주", "코리아it아카데미", 50);
        Book thirdBook = new Book("신데렐라", "코리아it아카데미", 100);

        System.out.println(anotherBook.title);
        System.out.println(anotherBook.pageNumber);
        System.out.println(thirdBook.publisher);
        System.out.println(thirdBook.title);
        System.out.println();

        //메서드 호출
        anotherBook.displayInfo();
        int thirdBookPageNumber = thirdBook.returnPageNumber();
        System.out.println(thirdBookPageNumber);

        myBook.title = "개구리왕자";
        myBook.publisher = "안녕출판사";
        myBook.pageNumber = 1234;
        myBook.displayInfo();

    }
}
