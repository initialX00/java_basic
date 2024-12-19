package chapter03;

public class A_Array {
    public static void main(String[] args) {
        /*
            배열(Array)
            : 같은 타입의 여러 변수를 하나의 집합으로 묶어서 처리하는 자료 구조이다.
            >> 데이터타입[] 배열명;
               데이터타입 배열명[];
            -데이터를 연속적으로 저장
            -순서가 있다 (index 인덱스 번호 0부터 n-1까지)
            -중복이 된다 (동일한 값을 여러 요소에 저장할 수 있다)
            cf)요소란 배열에서 각각의 데이터를 말한다.

            1.배열의 생성
            : 실제 데이터가 저장되는게 아니다. 데이터 배열이 저장된 첫 번쨰 메모리 주소가 저장된다.
            >> new 데이터타입[배열의 길이]
               데이터 타입[] 배열명 = new 데이터타입[배열의 길이]
            cf) 참조 자료형 - 주소값이 저장


            2.배열의 요소에 접근
            >> 배열명[인덱스 번호]
            데이터 변경 및 삽입
            >> 배열명[인덱스 번호] = 데이터값;
            cf)배열 생성 시 모든 요소는 해당 데이터 타입의 기본값으로 초기화
               숫자(0), 문자열(''), 논리형(false)

            3.배열의 선언과 동시에 초기화
            : new 연산자를 사용한 직접적인 배열 생성 시 길이 지정을 하지 않는다
              요소의 개수를 파악하여 배열의 길이를 자동 지정된다.
            >> 데이터 타입[] 배열명 = new 데이터타입[] {요소1, 요소2, ....}
               데이터 타입[] 배열명 = {요소1, 요소2, ...}

            4.배열의 길이(크기)
            : .length 속성으로 확인한다.

            5.배열의 특징
            : 한번 생성되면 크기 변경이 불가하다
              참조 타입이다, 주소값이 저장된다
              모든 요소는 같은 자료형이여야 한다.

            6.문자열 배열의 생성
            : String 타입 배열의 초기값은 null이다.

            7.배열 요소의 삭제
            : 삭제 기능을 담당하는 문법이 없다.
              삭제할 요소를 제외한 나머지 요소로 새로운 배열을 복사해야한다.
            
            8.배열을 순회하는 향상된 for문 (for each문)
            >> for (데이터타입 변수명: 해당 데이터타입의 배열) {
                배열의 모든 요소에 순차적으로 접근하는 코드
            }
         */

        /*
            배열과 변수의 비교
            배열 - 생성한다 (new 연산자)
                  데이터타입[] 배열명; or 데이터타입 배열명[];
                  같은 타입의 데이터를 여러개 저장 가능하다
            변수 - 선언한다 (데이터 타입)
                  데이터타입 변수명;
                  하나의 데이터만 저장 가능하다
         */

        //변수
        int korea = 90;
        int math = 75;
        int english = 80;

        //배열
        int[] array;

        //배열의 생성
        array = new int[3];
        System.out.println(array); // 주소 [I@43a25848

        //배열의 접근
        array[1] = 456;
        array[0] = 123;
        System.out.println(array[1]);
        System.out.println(array[0]);
        //System.out.println(array[3]);  //범위 초과 ArrayIndexOutOfBoundsException

        //배열의 선언과 초기화
        int[] scoreList = new int[] {90, 85, 100};
        System.out.println(scoreList[0]);
        char[] greet = {'h','e','l','l','o'};
        System.out.print(greet[0]);
        System.out.print(greet[1]);
        System.out.print(greet[2]);
        System.out.print(greet[3]);
        System.out.println(greet[4]);

        //배열의 크기
        System.out.println(greet.length);

        //문자열 배열 생성
        String[] fruits = new String[3];
        System.out.println(fruits[0]);
        fruits[0] = "사과";
        System.out.println(fruits[0]);

        //배열 요소 삭제
        int[] original = {1, 2, 3, 4};
        int removeIndex = 2; //삭제할 요소 위치
        int[] newArray = new int[original.length - 1];
        int k = 0; //새 배열의 요소 위치
        int originalLength = original.length;
        for(int index = 0; index  < originalLength; index ++){
            if(index  == removeIndex){
                continue; //해당 인덱스 건너뛰기
            }
            newArray[k++] = original[index]; //해당 인덱스 대입
            // 사용될 인덱스 0, 0 / 1, 1 / 2, 3
        }
        System.out.println(newArray[0]);
        System.out.println(newArray[1]);
        System.out.println(newArray[2]);

        //향상된 for문 (for each문)
        int[] arrayNumber = {1, 3, 5, 7, 9};
        for (int number: arrayNumber) { //한단계 하위 범주의 요소가 변수에 순차적으로 대입
            System.out.println(number);
        }


    }
}
