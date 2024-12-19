package chapter10.practice;

// 재고관리 시스템 InventorySystem
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("=== Inventory System ===");
            System.out.println("1. Add Book");
            System.out.println("2. List All Book");
            System.out.println("3. Search Book");
            System.out.println("4. Search by Category");
            System.out.println("5. Search by Price Range");
            System.out.println("6. Update Stock");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Select an option : ");

            try {
                // scanner.nextLine();  문자열로 입력값을 받는다
                int choice = Integer.parseInt(scanner.nextLine());
                //데이터를 분석하여 Int형태로 변경한다. parse : 분석하다
                //숫자형태로 변경할 수 없는 값이 입력되는 경우 NumberFormatException 예외가 발생한다
                switch (choice) {
                    case 1 :
                        System.out.println("Enter Book ID : ");
                        String id = scanner.nextLine();
                        System.out.println("Enter Book Title : ");
                        String title = scanner.nextLine();
                        System.out.println("Enter Book ISBN : ");
                        String isbn = scanner.nextLine();
                        System.out.println("Enter Book Author : ");
                        String author = scanner.nextLine();
                        System.out.println("Enter Book Publisher : ");
                        String publisher = scanner.nextLine();

                        System.out.println("Enter Book Publish Year : ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter Book Price : ");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter Book Stock Quantity : ");
                        int stock = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter Category : ");
                        String category = scanner.nextLine();

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock, category));
                        break;

                    case 2 :
                        manager.listAll();
                        break;

                    case 3 :
                        System.out.println("Enter search keyword");
                        String keyword = scanner.nextLine();
                        List<Item> searchResult = manager.search(keyword);
                        if(searchResult.isEmpty()){
                            System.out.println("No item found in keyword : " + keyword);
                        } else{
                            for (Item item : searchResult){
                                item.display();
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Enter category : ");
                        String searchCategory = scanner.nextLine();
                        List<Item> categoryResults = manager.searchByCategory(searchCategory);
                        if (categoryResults.isEmpty()) {
                            System.out.println("No items found in category: " + searchCategory);
                        } else {
                            for (Item item : categoryResults) {
                                item.display();
                            }
                        }
                        break;

                    case 5 :
                        System.out.println("Enter minimum price : ");
                        int minPrice = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter maximum price : ");
                        int maxPrice = Integer.parseInt(scanner.nextLine());
                        List<Item> priceResults = manager.searchByPriceRange(minPrice, maxPrice);
                        if(priceResults.isEmpty()){
                            System.out.println("No items found in price range");
                        } else{
                            for (Item item : priceResults) {
                                item.display();
                            }
                            //위에 for문이랑 같다  priceResults.forEach(Item::display);
                        }
                        break;

                    case 6 :
                        System.out.println("Enter Book ID to update stock : ");
                        String updateId = scanner.nextLine();
                        System.out.println("Enter quantity to add/subtract : ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        manager.updateStock(updateId, quantity);
                        break;

                    case 7 :
                        System.out.println("Enter Book Id to remove : ");
                        String removeId = scanner.nextLine();
                        manager.remove(removeId);
                        break;

                    case 8 :
                        System.out.println("=== Exiting ===");
                        return;

                    default :
                        System.out.println("Invalid option. Try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid number");
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
