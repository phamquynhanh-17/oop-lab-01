//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class EquationSolver {
    public EquationSolver() {
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));
        DecimalFormat df = new DecimalFormat("#.00");
        if (a == (double)0.0F) {
            if (b == (double)0.0F) {
                if (c == (double)0.0F) {
                    JOptionPane.showMessageDialog((Component)null, "WOW");
                } else {
                    JOptionPane.showMessageDialog((Component)null, "NO");
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog((Component)null, df.format(x));
            }
        } else {
            double delta = b * b - (double)4.0F * a * c;
            if (delta < (double)0.0F) {
                JOptionPane.showMessageDialog((Component)null, "NO");
            } else if (delta == (double)0.0F) {
                double x = -b / ((double)2.0F * a);
                JOptionPane.showMessageDialog((Component)null, df.format(x));
            } else {
                double x1 = (-b - Math.sqrt(delta)) / ((double)2.0F * a);
                double x2 = (-b + Math.sqrt(delta)) / ((double)2.0F * a);
                if (x1 > x2) {
                    double temp = x1;
                    x1 = x2;
                    x2 = temp;
                }

                String var10001 = df.format(x1);
                JOptionPane.showMessageDialog((Component)null, var10001 + " " + df.format(x2));
            }
        }

        System.exit(0);
    }
}
