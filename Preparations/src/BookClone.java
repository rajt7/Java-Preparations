public class BookClone implements Cloneable {
    private String name;
    private double price;
    private String author;
    private int year;           //release year of the book

    public BookClone(String name, String author, int year, double price){
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + ", author=" + author + ", year=" + year + "]";
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        BookClone book1 = new BookClone("To Kill a Mockingbird", "Harper Lee", 1960, 9.99);
        BookClone book2 = new BookClone("1984", "George Orwell", 1949, 8.49);
        BookClone book3 = (BookClone)book1.clone();


        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

    }
}
