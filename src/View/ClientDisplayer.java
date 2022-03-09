package View;

import Model.clientModel;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientDisplayer {

    public static void DisplayClientData(ArrayList<clientModel> myClientModel) {
        System.out.println("********************** NUESTROS CLIENTES **********************");
        System.out.println("ID\t NOMBRE\t\t\t ESPECIE\t GÉNERO");
        myClientModel.forEach(c -> {
            System.out.println(c);
        });
        System.out.println("\n");
    }

    public static void DisplayClientData(clientModel myClientModel) {
        System.out.println("********************** NUESTRO CLIENTE **********************");
        if (myClientModel != null) {
            System.out.println("ID\t NOMBRE\t\t\t ESPECIE\t GÉNERO");
            System.out.println(myClientModel);
            System.out.println("\n");
        } else {
            System.out.println("\nNO EXISTE CLIENTE ALGUNO CON EL ID SUMINISTRADO.\n");
        }

    }

    public static int DisplayClientOptions() {
        int option;
        Scanner sc = new Scanner(System.in);

        System.out.println("****************CLIENTES****************");
        System.out.println("Digite una opción para continuar: ");
        System.out.println("1. Ver listado de todos los clientes");
        System.out.println("2. Buscar Cliente por ID");
        System.out.println("3. Agregar Cliente");
        System.out.println("4. Actualizar Datos de Cliente");
        System.out.println("5. Eliminar Cliente");
        System.out.println("6. Ir al Menú Principal");
        System.out.print("\nOpción: ");
        option = Integer.parseInt(sc.nextLine());
        return option;
    }
}
