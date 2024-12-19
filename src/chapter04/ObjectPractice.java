package chapter04;
//스파이더 카드게임 만들기 (오브젝트 06 이후)
class Card{
    //인스턴스 변수
    //: 각 카드마다 고유의 속성(개별 속성)
    int number;
    String kind;
    //클래스 변수
    //: 모든 카드가 공유할 속성
    static int width = 100;
    static int height = 250;
}

public class ObjectPractice {
    public static void main(String[] args) {
        //정적 변수
        System.out.println(Card.width);
        System.out.println(Card.height);
        //클래스 Card의 객체(인스턴스) 생성
        Card c1 = new Card();
        c1.kind = "Spade";
        c1.number = 7;
        System.out.println(c1.kind + c1.number); //Spade7
    }
}
