package chapter10;

/*
    === 이벤트 관리 시스템
    이벤트 참가자 명단과 대기열 관리를 위한 시스템
    참가자는 사전 등록된 명단을 통해 이벤트에 참가
    명단이 꽉 차면 대기열로 추가, 참가자가 떠나면 대기열에 다음 사람이 추가된다.

    1.이벤트 참가자 명단 관리
      사전에 등록되어야하며 이벤트 당일에는 추가적인 참가자 등록이 불가하다.
      ArrayList (목록 추가 및 삭제 없음 / 참가자 조회 가능)

    2. 대기열 관리
      이벤트에는 좌석이 한정되어있다. 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록된다
      LinkedList (목록 추가 및 삭제 가능 / 참가자 조회 없음)
 */

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    //필드 - 이벤트 참가자 명단
    ArrayList<String> participantList = new ArrayList<>();
    //필드 - 대기열 명단
    LinkedList<String> waitingQueue = new LinkedList<>();

    //메서드
    void addParticipant(String name){
        participantList.add(name);
    }
    void addToWaitingQueue(String name){
        waitingQueue.add(name);
    }
    void leaveParticipant(String name){
        if (waitingQueue.size() > 0){
            String nextParticipant = waitingQueue.remove(0); // 대입 후 제거
            addParticipant(nextParticipant);
        }
    }
    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}


public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("김씨");
        eventManagement.addParticipant("박씨");
        eventManagement.addParticipant("이씨");
        eventManagement.addParticipant("최씨");
        eventManagement.addToWaitingQueue("백씨");
        eventManagement.addToWaitingQueue("권씨");
        eventManagement.addToWaitingQueue("유씨");

        System.out.println(eventManagement.participantList); //[김씨, 박씨, 이씨, 최씨]
        System.out.println(eventManagement.waitingQueue); //[백씨, 권씨, 유씨]

        eventManagement.leaveParticipant("최씨");
        System.out.println(eventManagement.participantList);  //[김씨, 박씨, 이씨, 최씨, 백씨]

        eventManagement.leaveParticipant("이씨");
        System.out.println(eventManagement.participantList);  //[김씨, 박씨, 이씨, 최씨, 백씨, 권씨]

        System.out.println(eventManagement.checkParticipant("김씨"));  //true
        System.out.println(eventManagement.checkParticipant("유씨"));  //false

        System.out.println(eventManagement.waitingQueue);  //[유씨]


    }
}
