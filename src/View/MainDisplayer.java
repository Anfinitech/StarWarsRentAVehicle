/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;
import static Controller.MainMenuController.SelectMainMenuOption;

/**
 *
 * @author anfme
 */
public class MainDisplayer {
    
    public MainDisplayer(){
    initComponents();
    }
    
    public static void initComponents(){
          SelectMainMenuOption();
    }

    public static int MainMenuDisplayer(){
        int option;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n****************MENÚ DE OPCIONES****************");
        System.out.println("Digite una opción para continuar: ");
        System.out.println("1. Clientes");
        System.out.println("2. Vehículos");
        System.out.println("3. Salir");
        System.out.print("\nOpción: ");
        option = Integer.parseInt(sc.nextLine());
        return option;
    }
    
}
