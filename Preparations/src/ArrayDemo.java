import java.util.Scanner;

public class ArrayDemo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int [][] arr = new int[3][3];
        
        System.out.println("Enter the element: ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Array:-");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Transpose of an array
        System.out.println("Transpose of an Array:-");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }    
}
