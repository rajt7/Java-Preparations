import java.util.*;

class Laptop implements Comparable<Laptop>{
    private int srno;
    private String make;
    private double cost;

    public int getSrno() {
        return srno;
    }

    public Laptop(int srno, String make, double cost){
        this.srno = srno;
        this.make = make;
        this.cost = cost;
    }

    public void display(){
        System.out.println(srno + " " + make + " " + cost);
    }

    @Override
    public int compareTo(Laptop o){
        if(this.cost > o.cost)
            return 1;
        else if(this.cost < o.cost)
            return -1;
        else
            return 0;
    }
    
}

class CompareLaptops implements Comparator<Laptop>{
    @Override
    public int compare(Laptop o1, Laptop o2){
        if(o1.getSrno() > o2.getSrno())
            return 1;
        else if(o1.getSrno() < o2.getSrno())
            return -1;
        else
            return 0;
    }
}


public class ArrayListDemo {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(7);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        // Now creating array list of laptop objects
        List<Laptop> list1 = new ArrayList<>();
        list1.add(new Laptop(101, "hp", 45000));
        list1.add(new Laptop(102, "apple", 75000));
        list1.add(new Laptop(103, "lenovo", 30000));

        for(Laptop l: list1)
            l.display();

        //Sorting according to cost, 
        Collections.sort(list1);
        System.out.println();
        for(Laptop l: list1)
            l.display();

        //Sorting according to srno
        Collections.sort(list1, new CompareLaptops());
        System.out.println();
        for(Laptop l: list1)
            l.display();
    }
}
