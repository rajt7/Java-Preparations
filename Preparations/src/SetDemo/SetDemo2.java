package SetDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double cost;

    public Product(int id, String name, double cost){
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
            return false;
        return true;
    }

    public void display(){
        System.out.println(id + " " + name + " " + cost);
    }

    @Override
    public int compareTo(Product o) {
        if(this.cost > o.cost)
            return 1;
        else if(this.cost < o.cost)
            return -1;
        else
            return 0;
    }
}

public class SetDemo2 {
    public static void main(String[] args){
        Set<Product> products = new HashSet<>();
        products.add(new Product(50, "shoes", 3000));
        products.add(new Product(51, "socks", 300));
        products.add(new Product(52, "Shirt", 1200));
        products.add(new Product(52, "Shirt", 1200));

        for(Product s: products)
            s.display();

        System.out.println();

        // For a TreeSet, Comparable needs to be implemented
        Set<Product> products1 = new TreeSet<>();
        products1.add(new Product(50, "shoes", 3000));
        products1.add(new Product(51, "socks", 300));
        products1.add(new Product(52, "Shirt", 1200));
        products1.add(new Product(52, "Shirt", 1200));     
        
        
        for(Product s: products1)
            s.display();
    }
}
