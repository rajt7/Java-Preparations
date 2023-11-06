package OOP.Pen_Question;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

class Pen {
    private static final AtomicInteger count = new AtomicInteger(1);
    private int id;
    private String name;
    private String color;
    private String material;
    private int stock;
    private Date stockUpdateDate;
    private Date stockListingDate;
    private double price;
    private double discount;

    public Pen(String name, String color, String material, int stock, double price, Date stockListingDate) {
        this.id = count.getAndIncrement();
        this.name = name;
        this.color = color;
        this.material = material;
        this.stock = stock;
        this.stockUpdateDate = new Date();
        this.stockListingDate = stockListingDate;
        this.price = price;
        this.discount = 0.0;
    }

    // Getters and setters for fields
    

    public void updateStock(int quantity) {
        this.stock += quantity;
        this.stockUpdateDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getStock() {
        return stock;
    }

    public Date getStockUpdateDate() {
        return stockUpdateDate;
    }

    public Date getStockListingDate() {
        return stockListingDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isSoldInLast3Months() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        Date threeMonthsAgo = calendar.getTime();
        return stockUpdateDate.after(threeMonthsAgo);
    }

    public boolean isNeverSoldIn9Months() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -9);
        Date nineMonthsAgo = calendar.getTime();
        return stockListingDate.before(nineMonthsAgo) && stock == 0;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Pen ID: " + id + "\nName: " + name + "\nColor: " + color + "\nMaterial: " + material +
                "\nStock: " + stock + "\nStock Update Date: " + dateFormat.format(stockUpdateDate) +
                "\nStock Listing Date: " + dateFormat.format(stockListingDate) + "\nPrice: " + price +
                "\nDiscount: " + discount + "%\n";
    }
}

public class PenStockManagement {
    public static void main(String[] args) {
        List<Pen> penList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new Pen");
            System.out.println("2. Update stock of a Pen");
            System.out.println("3. Set a 20% discount for unsold pens in the last 3 months");
            System.out.println("4. Remove Pens that were never sold in the last 9 months");
            System.out.println("5. Display all pens");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Pen Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Pen Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter Pen Material: ");
                    String material = scanner.nextLine();
                    System.out.print("Enter Initial Stock Quantity: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter Pen Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Listing Date (dd-MM-yyyy): ");
                    String stockListingDateString = scanner.next();

                    try {
                        Date stockListingDate = dateFormat.parse(stockListingDateString);
                        Pen newPen = new Pen(name, color, material, stock, price, stockListingDate);
                        penList.add(newPen);
                        System.out.println("Pen added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please enter the date in the format dd-MM-yyyy.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the Pen ID to update stock: ");
                    int penId = scanner.nextInt();
                    System.out.print("Enter the quantity to add/subtract: ");
                    int quantity = scanner.nextInt();

                    for (Pen pen : penList) {
                        if (pen.getId() == penId) {
                            pen.updateStock(quantity);
                            System.out.println("Stock updated successfully.");
                            break;
                        }
                    }
                    break;

                case 3:
                    for (Pen pen : penList) {
                        if (!pen.isSoldInLast3Months()) {
                            pen.setDiscount(20);
                        }
                    }
                    System.out.println("Discount set for unsold pens in the last 3 months.");
                    break;

                case 4:
                    List<Pen> pensToRemove = new ArrayList<>();
                    for (Pen pen : penList) {
                        if (pen.isNeverSoldIn9Months()) {
                            pensToRemove.add(pen);
                        }
                    }
                    penList.removeAll(pensToRemove);
                    System.out.println("Pens that were never sold in the last 9 months removed.");
                    break;

                case 5:
                    penList.stream().forEach(pen -> System.out.println(pen));
                    break;
                
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

