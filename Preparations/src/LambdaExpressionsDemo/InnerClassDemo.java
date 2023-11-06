package LambdaExpressionsDemo;

interface A{
    public void show();
}

// class B implements A {
//     public void show(){
//         System.out.println("In B, show called...");
//     }
// }

public class InnerClassDemo {
    public static void main(String[] args){
        // A a = new B();
        A a = new A(){
            public void show() {
                System.out.println("this is anonymous inner class demo..");
            }
        };
        a.show();
    }
}
