package chapter13;
/*
    === 제네릭(Generic, 일반적인) ===
    : 데이터의 타입(type)을 일반화하는 것을 말한다
    : 클래스나 메서드의 데이터 타입을 미리 지정하지 않고,
      구체적인 타입은 사용하는 시점에 지정할 수 있도록 설계된 기능을 말한다
    - 특정 타입에 의존하지 않고 다양한 타입을 지원하는 클래스 또는 메서드 설계가 가능하다.

    1. 제너릭 사용 목적
    - 타입의 안정성을 높인다
    - 코드의 재사용성을 높인다
    - 가독성을 높인다

    2.제네릭 클래스
    : 제네릭타입의 명시는 필수가 아니다 : 제네릭 타입의 구조에 값이 들어올 경우 해당 값으로 타입을 유추한다
    : 제네릭 타입의 경우 클래스 형식의 참조 자료형을 사용해야한다
      Wrapper 자료형 : int >> Integer / boolean >> Boolean / char >> Character
    - 선언부
      >> class 클래스명<제네릭타입> {
        제너릭 타입을 사용하여 필드, 생성자, 메서드를 정의한다.
       }
    - 호출부
      >> 클래스명 인스턴스명 = new 클래스명<>(인자값);
      >> 클래스명<제네릭타입> 인스턴스명 = new 클래스명<>(인자값);


    3.제네릭 메서드
    : 메서드 호출 시 전달된 타입에 따라 제네릭타입이 결정된다
    : 타입 변수는 Type의 앞글자를 따서 <T>형식을 주로 사용한다
    - 선언부
     >> (*접근제한자 static*) <제네릭타입> 반환타입 메서드명(매개변수) {실행코드;}
    - 호출부
     >> 제네릭클래스명.(*<제네릭타입>*)메서드명(인자값);
        제네릭클래스의객체명.(*<제네릭타입>*)메서드명(인자값);

 */


//제네릭 클래스 선언
//키-값의 쌍을 저장
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey() {return key;}
    public V getValue() {return value;}

    //제네릭 메서드
    static <T>void print(T value){
        System.out.println(value);
    }

}


public class A_Generic {
    public static void main(String[] args) {
        //제네릭 클래스 호출
        Pair pair = new Pair<>(100, "백");
        Pair<Integer, String> pair1 = new Pair<>(123, "안녕하세요");
        Pair<String, Integer> pair2 = new Pair<>("안녕하세요", 123); //코드의 재사용성을 높다
        System.out.println(pair.getKey());
        System.out.println(pair1.getKey());
        System.out.println(pair2.getValue());

        pair1.<String>print("안녕");
        pair1.print(111);
        Pair.<Integer>print(222);
    }
}
