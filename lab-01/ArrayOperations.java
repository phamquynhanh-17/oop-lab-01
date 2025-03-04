//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class ArrayOperations {
    public ArrayOperations() {
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{1789, 2035, 1899, 1456, 2013};
        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));
        int sum = 0;

        for(int num : myArray) {
            sum += num;
        }

        double average = (double)sum / (double)myArray.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
