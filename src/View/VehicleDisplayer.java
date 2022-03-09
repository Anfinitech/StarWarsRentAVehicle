package View;

import Model.vehicleRecordModel;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleDisplayer {

    public static void DisplayVehicleRecordsData(ArrayList<vehicleRecordModel> myVehicleRecordModels) {
        System.out.println("********************** NUESTROS VEHICULOS **********************");
        System.out.println("MATR\t NOMBRE\t\t\t VELOCIDAD\t   LONGITUD \t TIPO \t\t ANDROIDE/CAPITÁN");
        myVehicleRecordModels.forEach(v -> {
            System.out.println(v);
        });
        System.out.println("\n");
    }

    public static void DisplayVehicleRecordsData(vehicleRecordModel myVehicleRecordModel) {
        System.out.println("********************** NUESTRO VEHICULO **********************");
        if (myVehicleRecordModel != null) {
            System.out.println("MATR\t NOMBRE\t\t\t VELOCIDAD\t LONGITUD \t TIPO \t\t ANDROIDE/CAPITÁN");
            System.out.println(myVehicleRecordModel);
            System.out.println("\n");
        } else {
            System.out.println("\nNO EXISTE VEHICULO ALGUNO CON LA MATRÍCULA SUMINISTRADA.\n");
        }

    }

    public static int DisplayVehicleRecordOptions() {
        int option;
        Scanner sc = new Scanner(System.in);

        System.out.println("****************VEHICULOS****************");
        System.out.println("Digite una opción para continuar: ");
        System.out.println("1. Ver listado de todos los vehiculos");
        System.out.println("2. Buscar Vehiculo por Matricula");
        System.out.println("3. Agregar Vehiculo");
        System.out.println("4. Actualizar Datos de Vehiculo");
        System.out.println("5. Eliminar Vehiculo");
        System.out.println("6. Ir al Menú Principal");
        System.out.print("\nOpción: ");
        option = Integer.parseInt(sc.nextLine());
        return option;
    }
}
