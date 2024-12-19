package chapter16;

public class E_Thread {
    public static void main(String[] args) {
        //단일 스레드는 순서대로 작업한다
//        for(int i = 0; i < 10; i++) {
//            System.out.println("첫번쨰 for문 : " + i);
//        }
//        for(int i = 0; i < 10; i++) {
//            System.out.println("두번쨰 for문 : " + i);
//        }

        //스레드는 동시적으로 작업한다.
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println("스레드1 : " + i);
                try{
                    Thread.sleep(1000); //1초동안 스레드를 일시정지
                } catch(InterruptedException e){ //슬립은 InterruptedException와 같이써야한다
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println("스레드2: " + i);
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
