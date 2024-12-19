package chapter17.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Reservation {
    //각 예약이 가지는 고유한 id값
    private final String reservationId;
    //예약자 정보
    private final String userId;
    private final Date reservationTime;
    //초기값 설정
    //:해당 예약의 활성화 상태를 저장
    //true면 예약완료, false면 예약취소
    private boolean isActive = true;

    public void cancel() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        String isActiveMessage = isActive ? "예약 중" : "예약 취소";

        return "예약 ID : " + reservationId + ", 사용자 ID : " + userId +
                ", 예약날짜 : " + reservationTime + ", 예약상태 : " + isActiveMessage;
    }
}
