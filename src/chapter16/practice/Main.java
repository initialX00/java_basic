package chapter16.practice;

//chapter13 practice - 도서 관리 시스템에 Enum 자료형 사용 추가

import chapter16.practice.entity.Category;
import chapter16.practice.entity.Item;
import chapter16.practice.service.LibraryManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("===Library System===");
            System.out.println("1.Search by Category");

            System.out.println("Select an Option : ");

            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        System.out.println("Enter Category : ");
                        String searchCategory = scanner.nextLine();
                        try {
                            Category searchCategoryEnum = Category.formString(searchCategory);
                            List<Item> categoryResults = manager.searchByCategory(searchCategoryEnum);
                            if(categoryResults.isEmpty()){
                                System.out.println("No items found in category : " + searchCategoryEnum);
                            } else {
                                categoryResults.forEach(Item::display);
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number");
                //serr : 인자 내의 문자열을 오류로 인식하고 출력
            } catch (NoSuchElementException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
