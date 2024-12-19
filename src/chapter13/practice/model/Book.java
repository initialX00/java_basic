package chapter13.practice.model;

//추상화로 직접적인 인스턴스화는 안되지만 생성자 생성을 통해 super를 사용하는건 가능하다
public abstract class Book {
    private int id;
    private String title;
    private String author;

    //추상 클래스 : Book
    //- 직접적인 인스턴스화 불가
    //- 생성자는 하위클래스 생성자 내에서 호출용도로 정의된다.
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id;}
    public String getTitle() { return title;}
    public String getAuthor() {return author; }

    @Override
    public String toString(){
        return "ID : " + id + ", Title : " + title  + ", Author : " + author;
    }
}
