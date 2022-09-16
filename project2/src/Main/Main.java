package Main;
import House.House;
import java.util.Scanner;

public class Main {
    House[] arr;
    public Main() {
        arr = new House[7];
        arr[0] = new House(1, 23, 18, 1, 2, "Lysenka");
        arr[1] = new House(2, 24, 20, 2, 3, "Shevchenka");
        arr[2] = new House(3, 25, 19, 2, 2, "Bandery");
        arr[3] = new House(4, 26, 11, 3, 1, "Bandery");
        arr[4] = new House(5, 27, 24, 1, 1, "Bandery");
        arr[5] = new House(6, 28, 19, 5, 2, "Shevchenka");
        arr[6] = new House(7, 21, 15, 6, 1, "Lysenka");
    }
    public void check_room() {
        Scanner scan = new Scanner(System.in);
        int num;

        System.out.println("Введіть кількість кімнат: ");
        num = scan.nextInt();

        for (House obj1 : arr) {
            if (obj1.getRoom_number() == num) {
                System.out.println(obj1.toString());
            }
        }
    }
    public void check_floor() {
        Scanner scan1 = new Scanner(System.in);
        int num1, floor1, floor2;

        System.out.println("Введіть кількість кімнат: ");
        num1 = scan1.nextInt();
        System.out.println("Введіть проміжок між поверхами: ");
        floor1 = scan1.nextInt();
        floor2 = scan1.nextInt();

        for (House obj1 : arr) {
            if (obj1.getRoom_number() == num1 && obj1.getFloor() <= floor2 && obj1.getFloor() >= floor1) {
                System.out.println(obj1.toString());
            }
        }
    }
    public void check_square(){
        Scanner scan2 = new Scanner(System.in);
        int square;

        System.out.println("Введіть площу квартири: ");
        square = scan2.nextInt();

        for (House obj1 : arr) {
            if(obj1.getSquare()>square)
                System.out.println(obj1.toString());
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.check_room();
        m.check_floor();
        m.check_square();
    }
}
