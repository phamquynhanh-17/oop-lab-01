package OtherProjects.Lab03.OtherProjects.Lab01;

import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String[] args) {
		java.util.Scanner keyboard = new Scanner(System.in);
		System.out.println("What's your name?");
		String strName = keyboard.nextLine();
		System.out.println("How are you?");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyboard.nextDouble();
		
		System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
	}
}
