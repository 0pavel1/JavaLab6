import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

}

public class SalesTracker {
    private Map<Product, Integer> sales;

    public SalesTracker() {
        sales = new HashMap<>();
    }

    public void addSale(Product product, int quantity) {
        sales.put(product, sales.getOrDefault(product, 0) + quantity);
    }

    public void printSales() {
        System.out.println("Список продаж:");
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + ", " + entry.getKey().getPrice() + "$");
        }
    }

    public double getTotalSales() {
        double totalSales = 0;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            totalSales += entry.getKey().getPrice() * entry.getValue();
        }
        return totalSales;
    }

    public Product getMostPopularProduct() {
        Product mostPopularProduct = null;
        int maxSales = 0;

        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopularProduct = entry.getKey();
            }
        }
        return mostPopularProduct;
    }

    public Product searchProduct(String nameProduct){
        for (Product p : sales.keySet()) {
            if (p.getName().equals(nameProduct))
                return p;
        }
        return null;
    }


    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить или изменить товар");
            System.out.println("2. Добавить продажу");
            System.out.println("3. Показать список продаж и цен");
            System.out.println("4. Показать общую сумму продаж");
            System.out.println("5. Показать самый популярный товар");
            System.out.println("6. Выход");
            
            try{
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                switch (choice) {
                    case 1:
                        System.out.print("Введите название товара: ");
                        String productName = scanner.nextLine();
                        System.out.print("Введите цену товара: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
    
                        Product product = tracker.searchProduct(productName);
                        if (product == null){
                            product = new Product(productName, price);
                            tracker.addSale(product, 0);
                        }
                        else{
                            product.setPrice(price);
                        }
    
                        break;
                    case 2:
                        System.out.print("Введите название товара: ");
                        String productName1 = scanner.nextLine();
                        System.out.print("Введите количество: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
    
                        product = tracker.searchProduct(productName1);
                        if(product != null){
                            tracker.addSale(product, quantity);
                        }
                        else {
                            System.out.println("Товар не найден.");
                        }
    
                        break;
                    case 3:
                        tracker.printSales();
                        break;
                    case 4:
                        System.out.println("Общая сумма продаж: " + tracker.getTotalSales() + "$");
                        break;
                    case 5:
                        Product mostPopular = tracker.getMostPopularProduct();
                        if (mostPopular != null) {
                            System.out.println("Самый популярный товар: " + mostPopular.getName());
                        } else {
                            System.out.println("Продаж нет");
                        }
                        break;
                    case 6:
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный выбор.");
                }
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                scanner.nextLine();
            }
        }
    }
}