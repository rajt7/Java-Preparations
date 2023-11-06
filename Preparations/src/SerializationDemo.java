/*
 * Serialization - It is process of saving the state of the object into a binary.
 * Deserialization - It is process of re-construction of an object from its saved state into a binary file.
 * 
 * It is used when you want to transfer an object over the network.
 * 
 * transient keyword - Telling the compiler that do not serialize the attribute.
 */

import java.io.*;

class Laptop implements Serializable{
    private int id;
    private String name;
    private double cost;

    public Laptop(int id, String name, double cost){
        super();
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
}

public class SerializationDemo {

	public static void main(String[] args){
        File file = new File("xyz.dat");

        // Serializing the object to binary
        try {
			FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Laptop(101, "HP", 40000));
            oos.writeObject(new Laptop(102, "Dell", 35000));
            oos.close();
            fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

        // Deserializing the binary to object
        try {
			FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Laptop l1 = (Laptop)ois.readObject();
            System.out.println(l1);
            Laptop l2 = (Laptop)ois.readObject();
            System.out.println(l2);
            ois.close();
            fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
