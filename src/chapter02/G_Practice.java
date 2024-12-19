package chapter02;

public class G_Practice {
    public static void main(String[] args) {
        /*
            *****
            ****
            ***
            **
            *
            ----------
            *****
             ****
              ***
               **
                *
         */

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //선생님은 가감연산자를 사용하여 5,4,3,2,1을 표현
        /*
            for(int i = 5; i >= 1; i--){
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
         */

        System.out.println("---------");

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 5-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //선생님은 가감연산자를 사용하여 5,4,3,2,1을 표현
        /*
            for(int i = 5; i >= 1; i--){
                for(int k = 1; k <= 5-i; k++){
                    System.out.print("*");
                }
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
         */
    }
}
