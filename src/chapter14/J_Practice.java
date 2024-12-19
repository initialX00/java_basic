package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//주문목록에서 상품별 총 판매량 계산//
//주문클래스
@AllArgsConstructor
@Getter
@ToString
class Order {
    private String product; //제품
    private int quantity; //수량
}

public class J_Practice {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("노트북", 5),
                new Order("핸드폰", 7),
                new Order("스위치", 4),
                new Order("태블릿", 3),
                new Order("노트북", 1),
                new Order("스위치", 5)
        );
        //상품별 총 판매량 계산
        //Map<String, Integer>
        Map<String, Integer>  productSales = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,
                        Collectors.summingInt(Order::getQuantity)));
        System.out.println(productSales); //{태블릿=3, 핸드폰=7, 노트북=6, 스위치=9}

    }


}
