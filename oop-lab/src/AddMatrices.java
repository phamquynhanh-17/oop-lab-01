//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class AddMatrices {
    public AddMatrices() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                mat1[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                mat2[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                System.out.print(sum[i][j] + " ");
            }

            System.out.println();
        }

        scanner.close();
    }
}
