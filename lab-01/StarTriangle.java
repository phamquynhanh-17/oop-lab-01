//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class StarTriangle {
    public StarTriangle() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều cao của tam giác (n): ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j < 2 * i - 1; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

        scanner.close();
    }
}
