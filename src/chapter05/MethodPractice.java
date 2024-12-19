package chapter05;

import java.util.Scanner;

class BaseballPlayer{
    /*
        ===인스턴스 변수
        선수이름(name - 문자열)
        타율(battingAverage - 실수)
        홈런 수(homeRuns - 정수)
        ===정적 변수
        생성된 선수의 총 인원(playerCount - 정수)
        - 모든 인스턴스에서 공유
        ===생성자
        - 인스턴스 변수 초기화 및 정적 변수 후위 증가(변수명++)
        ===인스턴스 메서드
        선수의 타율과 홈런 수를 업데이트하는 메서드
        - 매개변수로 newBattingAverage, newHomeRuns를 받아 기존 인스턴스 변수에 재할당
     */
    String name;
    double battingAverage;
    int homeRuns;

    static int playerCount;

    BaseballPlayer(String name, double battingAverage, int homeRuns){
        this.name = name;
        this.battingAverage = battingAverage;
        this.homeRuns = homeRuns;
        playerCount++;
    }

    void updatesStatus (double newBattingAverage, int newHomeRuns){
        battingAverage = newBattingAverage;
        homeRuns = newHomeRuns;
    }

    //정적 메서드
    //특정 홈런 수 이상인 선수를 평가
    static String evaluateHomeRun(int homeRunCount){
        if (homeRunCount > 20) {
            return "홈런상 후보에 등록됩니다";
        } else{
            return "홈런상 후보에 등록되지 않습니다";
        }
    }
}

public class MethodPractice {
    public static void main(String[] args) {
        //인스턴스 생성
        BaseballPlayer player1 = new BaseballPlayer("홍길동",0.345, 16);
        BaseballPlayer player2 = new BaseballPlayer("홍길동",0.345, 16);
        BaseballPlayer player3 = new BaseballPlayer("홍길동",0.345, 16);
        BaseballPlayer player4 = new BaseballPlayer("홍길동",0.345, 16);
        System.out.println("선수의 수" + BaseballPlayer.playerCount);

        player1.updatesStatus(0.555, 18);
        System.out.println(player1.battingAverage + " " + player1.homeRuns);

        System.out.println(BaseballPlayer.evaluateHomeRun(21));
        System.out.println(BaseballPlayer.evaluateHomeRun(19));



    }
}
