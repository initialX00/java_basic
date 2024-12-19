package chapter03;

public class B_Array {
    public static void main(String[] args) {
        /*
            다차원 배열
            : 배열의 배열 (2, 3, 4, ... 차원)
            데이터를 테이블 형태로 구성할 때 유용하다
            게임 보드, 데이터 분석, 그래픽 등에 사용한다.

            1.다차원 배열의 선언과 초기화
             2차원 배열 선언 >> 데이터타입[][] 배열명;
             배열 선언 후 값 할당 >> 배열명[헹][열] = 값;
             선언과 동시에 초기화 >> 데이터타입[][] 배열명 = {{값,값}. {값,값}};
             배열의 출력 >> for(데이터타입[] 배열명2: 배열명) {
                             for(데이터타입 변수명: 배열명2) {
                                 System.out.println(변수명);
                             }
                          }
         */

        //2차원 배열
        int[][] matrix = new int[3][3];
        //각 요소에 값을 할당
        matrix[0][0] = 1; //1행 1열
        matrix[0][1] = 1; //1행 2열
        matrix[0][2] = 1; //1행 3열
        //선언과 동시에 초기화
        int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}}; //4행 3열

        //다차원배열 출력
        for(int[] row: matrix2){ //row에 행배열 대입
            for(int value: row){ //value에 행으로 나눠진 row의 각요소 대입
                System.out.print(value + " ");
            }
            System.out.println();
        }
        //배열 활용
        int[] scores = {85, 100, 75, 60, 90};
        int total = 0;
        for(int i: scores){
            total += i;  //total = total + i; 대입연산자 자꾸 까먹고 풀어서 적음
        }
        double average = (double) total / scores.length;
        System.out.println("평균 점수: " + average);
    }
}
