package chapter03;

import java.util.Arrays;

public class C_Array {
    public static void main(String[] args) {
        /*
            Arrays 클래스
            : 배열을 조작하는데 유용한 기능들을 제공해주는 자바 내부 클래스
            - 정렬, 검색, 변환 등
        */

        /*
            Arrays 클래스 사용법
            1.배열 생성 방법
             >> 데이터타입[] 배열명 = {요소};

            2.배열 정렬 (오름차순)
             >> Arrays.sort(배열명);
              cf).(마침표) :: 해당 클래스의 내부 기능 사용
                 Arrays 임포트작성 필요

            3.배열 변환
             >> Arrays.toString();
              배열은 참조 자료이기때문에 배열 접근 시 주소가 나온다.
              배열의 전체 구조를 파악할 수 있는 기능
              각 요소를 수회하며 문자열 [요소1,요소2,...]형태로 변환

            4.배열 내 검색
             >> Arrays.binarySearch(배열명, 검색내용);
              존재 시 해당 인덱스 번호 반환
              존재하지 않을 시 음수로 반환

            5.배열의 비교
             >> Arrays.equals(배열명1, 배열명2))
              true, false 논리형태로 반환

            6.배열의 채움
             >> Arrays.fill(배열, 삽입할 값);
              배열의 모든 요소를 특정 값으로 채운다

         */

        //배열 생성
        int[] numbers = {3, 2, 5, 4, 1};
        //배열 정렬 (오름차순)
        Arrays.sort(numbers);
        System.out.println(numbers[0]); // 1
        //배열 변환
        System.out.println(numbers); //[I@3ac3fd8b
        System.out.println(Arrays.toString(numbers)); //[1, 2, 3, 4, 5]
        //배열 검색
        System.out.println(Arrays.binarySearch(numbers, 1)); //0
        System.out.println(Arrays.binarySearch(numbers, 6)); //-6
        //배열의 비교
        int[] numbers2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.equals(numbers, numbers2)); // numbers를 정령했으므로 true
        //배열의 채움
        int[] example = new int[3];
        System.out.println(Arrays.toString(example)); // [0,0,0]
        Arrays.fill(example, 10);
        System.out.println(Arrays.toString(example)); // [10,10,10]

    }
}
