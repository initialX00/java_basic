package chapter05;
/*
    메서드(Method)
    : 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것을 말한다.
      어떤 값들을 입력하면 해당 값들로 작업을 수행하여 결과를 반환한다.
    
    === 메서드의 구조 ===
    : 선언부, 구현부
    >> 반환타입 메서드명() {}
    - 선언부: 반환타입 메서드명()
    - 구현부: { 메서드 호출 시 수행될 코드 }
    - 메서드를 "정의한다" : 선언부와 구형부를 작성한다.
    
    1. 메서드 선언부
    : '반환타입', '메서드명', '매개변수 선언'
    1) 반환타입(return type)
    - 메서드의 작업 수행 결과인 반환값의 타입을 명시해야한다.
    - void는 반환값이 없는 경우 작성한다.
    2) 매개변수(parameter) 선언
    - 메서드가 작업을 수행하는데 필요한 값들을 제공받기 위한 것
    - 필요한 값의 개수만큼 변수를 선언하고, 데이터 타입과 변수명을 쉽표(,)로 구분하여 나열한다
      일반 변수와 달리 변수 선언 시 변수들의 데이터 타입이 같더라도 생략이 불가능하다.
    
    2. 메서드의 구현부
    : 메서드 선언부 다음에 오는 중괄호 {}를 말한다.
      반환타입이 void가 아닐 경우 return문을 반드시 포함해야한다
    - 해당 반환 값은 반환타입과 일치하거나 자동 형 변환이 가능한 데이터여야 한다.
        double addDouble(int a, int b){
            return a + b;
        }
       cf) 지역변수(local variable)
         : 메서드 내에 선언된 변수
         - 해당 메서드 내에서망 사용 가능하다
         - 매개변수뿐만 아니라 구현부 내에서 작성된 변수도 지역변수 취급한다.
    
 */

class Example{
    int x, y;  // 인스턴스 변수 - 데이터 타입이 같을 경우 생략 가능
    int add(int x, int y){  //매개변수 x,y
        int result = x + y;  //double로 선언 시 자동 형 변환이 불가하여 오류
        return result;
    }
    double multiplay(int x, int y){
        int result = x + y; //자동 형 변환 가능하여 오류가 안 남
        return result;
    }

    //매개 변수와 반환값이 없는 경우
    void print99dan() {
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.print(j * i + " ");
            }
            System.out.println();
        }
    }
}

public class Method02 {
    public static void main(String[] args) {
        Example example =new Example();
        example.print99dan();

        System.out.println(example.add(10,20));  //인자 10, 20
        //example.add(10,20,30); 인자값의 수는 매개변수의 수와 같아야한다
        //example.add("10","20"); 인자값은 매개변수의 타입과 같거나 자동 형 변환이 가능해야한다.
        System.out.println(example.add('a','b')); // char타입(2)여서 자동 형 변환이 이루어진다.

        /*
            함수의 파라미터에 데이터 전달
            : 함수 호출 시 ()영역 내에서 parameter에 전달되는 값을 argument라고 부른다.

            매개변수(Parmeter)와 인자(인수, Argument)
            1.매개변수
            - 메서드를 정의할 때 괄호 안에 선언되는 '변수'
            - 메서드가 호출될 떄 값을 전달받기 위한 입력변수로 사용한다.
            - 메서드의 선언부에 정의, 호출 시 전달받은 값은 내부적으로 사용된다
            2.인자(인수)
            - 메서드를 호출할 떄 괄호 안에 전달하는 '값'
            - 호출된 메서드의 매개변수에 실제 값을 전달한다.
            - 메서드의 호출부에서 전달, 매개변수에 전달되어 메서드 안에서 사용된다.
         */


    }
}
