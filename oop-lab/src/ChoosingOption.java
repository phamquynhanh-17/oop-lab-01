//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public ChoosingOption() {
    }

    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog((Component)null,
                "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog((Component)null,
                "You've chosen: " + (option == 0 ? "Yes" : "No"));

        System.exit(0);
    }
}
