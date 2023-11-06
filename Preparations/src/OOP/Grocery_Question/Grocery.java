package OOP.Grocery_Question;
import java.util.*;

public class Grocery {
    private static int r=100;
    private int id;
    private String name;
    private double price;
    private int stockAvailable;
    private Date stockUpdateDate;

    public Grocery(String name, double price, int stock){
        this.id = r;
        this.name = name;
        this.price = price;
        this.stockAvailable = stock;
        this.stockUpdateDate = new Date();
        r++;
    }

    public int getId() {
        return id;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public String getName() {
        return name;
    }

    public Date getStockUpdateDate() {
        return stockUpdateDate;
    }

    public void updateStock(int quantity){
        stockAvailable += quantity;
        this.stockUpdateDate = new Date();
    }

    @Override
    public String toString() {
        return "\n\nGrocery Item ID: " + id + "\nName: " + name + "\nPrice: $" + price + 
                "\nStock: " + stockAvailable + "\nStock Update Date: " + stockUpdateDate + "\n";
    }

    public static void main(String[] args){
        List<Grocery> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while(choice != 6){
            System.out.println("Menu");
            System.out.println("1. Add a new item");
            System.out.println("2. Update the quantity of a stock");
            System.out.println("3. Display");
            System.out.println("4. Remove all empty stock items");
            System.out.println("5. Display all products for which stock updated in last 3 days");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");            
            choice = sc.nextInt();

            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Add grocery item name: ");
                    String name = sc.next();
                    System.out.print("Add grocery item price: ");
                    double price = sc.nextDouble();
                    System.out.print("Add grocery item stock: ");
                    int stock = sc.nextInt();
                    
                    items.add(new Grocery(name, price, stock));
                    System.out.println(name + " addedd successfully");
                    break;
                case 2:
                    System.out.print("Enter the item id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter the quantity to add/subtract: ");
                    int quantity = sc.nextInt();

                    for(Grocery item: items){
                        if(item.getId() == id){
                            item.updateStock(quantity);
                            System.out.println("Stock updated successfully");
                            break;
                        }
                    }
                    break;
                case 3:
                    items.stream().forEach(i -> System.out.println(i));
                    break;
                case 4:
                    // List<Integer> idx = new ArrayList<>();
                    // for(int i=0; i<items.size(); i++){
                    //     Grocery item = items.get(i);
                    //     if(item.getStockAvailable() == 0){
                    //         idx.add(i);
                    //     }
                    // }

                    // idx.stream().forEach(i -> System.out.print(i + " "));

                    // for(int i: idx){
                    //     items.remove(i);
                    // }
                    items.removeIf(item -> item.getStockAvailable() == 0);
                    break;
                case 5:
                    System.out.println("Items Updated in the Last 3 Days:");
                    Date currentDate = new Date();
                    for(Grocery item: items){
                        long timeDifference = currentDate.getTime() - item.getStockUpdateDate().getTime();
                        long threeDaysInMillis = 3 * 24 * 60 * 60 * 1000;

                        if(timeDifference <= threeDaysInMillis){
                            System.out.println(item);
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
