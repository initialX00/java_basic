package chapter13.practice.model;

public class Fiction extends Book {
    private String genre; //장르

    public Fiction(int id, String title, String author, String genre){
        super(id, title, author); //추상클래스 Book의 인스턴스
        this.genre = genre;
    }
    public String getGenre() {return genre;}

    @Override
    public String toString(){
        return super.toString() + ", Genre : " + genre;
    }
}
