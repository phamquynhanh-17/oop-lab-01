//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class InputFromKeyboard {
    public InputFromKeyboard() {
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name?: ");
        String name = keyboard.nextLine();
        System.out.println("How old are you? ");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)? ");
        double dHeight = keyboard.nextDouble();
        System.out.println("Mrs/Ms. " + name + ", " + iAge + " years old. Your height is " + dHeight + "m.");
    }
}
