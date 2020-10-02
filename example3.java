import java.util.Scanner;

public class example3 {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println("Wat voor aantal?");
        int aantal = obj.nextInt();
        maken(aantal);

        
    }

    private static void maken(int keren) {
        for (int i = 0; i < keren; i++) {
            for (int x = 1; x < keren; x++) {
                System.out.print("*");
            }
            System.out.println("+");
        }


    }

}
