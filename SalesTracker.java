import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesTracker {

    public static void main(String[] args) {
        Map<String, Integer> sales = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Добавить продажу");
                System.out.println("2. Показать список продаж");
                System.out.println("3. Показать общую сумму продаж");
                System.out.println("4. Показать самый популярный товар");
                System.out.println("5. Выход");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Введите название товара: ");
                        String productName = scanner.nextLine();
                        System.out.print("Введите количество: ");
                        int quantity = scanner.nextInt();
                        sales.put(productName, sales.getOrDefault(productName, 0) + quantity);
                        break;
                    case 2:
                        System.out.println("Список продаж:");
                        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        break;
                    case 3:
                        int totalSales = 0;
                        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                            totalSales += entry.getValue();
                        }
                        System.out.println("Общая сумма продаж: " + totalSales);
                        break;
                    case 4:
                        String mostPopularProduct = null;
                        int maxSales = 0;
                        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                            if (entry.getValue() > maxSales) {
                                maxSales = entry.getValue();
                                mostPopularProduct = entry.getKey();
                            }
                        }
                        if (mostPopularProduct != null) {
                            System.out.println("Самый популярный товар: " + mostPopularProduct);
                        } else {
                            System.out.println("Продаж не было.");
                        }

                        break;
                    case 5:
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный выбор.");
                }
                System.out.println("");
            }
        }
    }
}