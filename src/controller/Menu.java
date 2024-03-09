
package controller;

import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Menu {
     public static int chooseInputOption(){
            System.out.println("-------------------------------------------");
            System.out.println("1. Import CSV.");
            System.out.println("2. Format name.");
            System.out.println("3. Format address.");
            System.out.println("4. Export CSV. ");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------");
        int option = InputUtils.inputOption(1, 5);
        return option;
    }
}
