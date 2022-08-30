import java.util.Scanner;
public class Fibonacci {
    int [] arrofFib;
    Fibonacci(int num){
        arrofFib=new int[num];
        int first=0, second=1,current;

        for(int i = 0; i < num; i++){
            arrofFib[i] = first;
            current = first + second;
            first = second;
            second = current;
            System.out.print(arrofFib[i]+" ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of Fibonacci numbers to find the sum: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(num<=0){
            System.out.println("This number is incorrect!");
            System.exit(1);
        }

        Fibonacci object = new Fibonacci(num);
        System.out.println("\nSum of squares "+ num+" numbers: "+object.findSum(num));
    }
    public int findSum(int num){
        int rez=0;

        for(int i=0;i< num;i++){
            int num1=arrofFib[i];
            int rez1=(num1*num1);
            rez+=rez1;
        }
       
        return rez;
    }
}