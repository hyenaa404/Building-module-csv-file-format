/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        Controller ct = new Controller();
        int choice;
        while(true){
            choice = Menu.chooseInputOption();
            switch(choice){
                case 1 -> {
                    ct.importFile();
                }
                case 2 -> {
                    ct.formatName();
                }
                case 3 -> {
                    ct.formatAddress();
                }
                case 4 -> {
                    ct.exportFile();
                }
                case 5 ->
                    System.exit(0);
            }
        }
    }
}
