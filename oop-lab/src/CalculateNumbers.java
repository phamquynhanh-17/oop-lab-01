//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import javax.swing.JOptionPane;

public class CalculateNumbers {
    public CalculateNumbers() {
    }

    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog((Component)null, "Please input the first number:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog((Component)null, "Please input the second number:"));
        String strNotification = "The results are as follows:\nSum: " + (num1 + num2) + "\nDifference: " + (num1 - num2) + "\nProduct: " + num1 * num2 + "\nQuotient: " + String.valueOf(num2 != (double)0.0F ? num1 / num2 : "Cannot divide by zero") + "\n";
        JOptionPane.showMessageDialog((Component)null, strNotification, "Calculation Results", 1);
        System.exit(0);
    }
}
