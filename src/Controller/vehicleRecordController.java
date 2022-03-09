package Controller;

import static DAOs.vehicleDAO.UPDATEVehicle;
import DAOs.vehicleRecordDAO;

import static DAOs.vehicleRecordDAO.*;
import Model.captainModel;
import Model.lightVModel;
import Model.transportVModel;
import Model.vehicleModel;
import Model.vehicleRecordModel;
import static View.VehicleDisplayer.DisplayVehicleRecordOptions;
import java.util.Scanner;
import static View.VehicleDisplayer.DisplayVehicleRecordsData;
import java.util.ArrayList;

public class vehicleRecordController {

    vehicleRecordDAO myvehicleRecordDAO;

    public vehicleRecordController(vehicleRecordDAO myVehicleRecordDAO) {
        this.myvehicleRecordDAO = myVehicleRecordDAO;
    }

    public void UpdateVehicleRecordDisplay() {
        DisplayVehicleRecordsData(LISTVehicleRecords());
    }

    public void SelectVehicleRecordOptions() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            int option = DisplayVehicleRecordOptions();
            switch (option) {
                case 1 ->
                    DisplayVehicleRecordsData(LISTVehicleRecords());
                case 2 -> {
                    System.out.print("\nDigite la Matrícula del Vehiculo a buscar: ");
                    int searchMATR = Integer.parseInt(sc.nextLine());
                    DisplayVehicleRecordsData(SELECTVehicleRecord(searchMATR));
                }
                case 3 -> {
                    INSERTTypeOfVehicle();
                    DisplayVehicleRecordsData(LISTVehicleRecords());
                }
                case 4 ->
                    UPDATETypeOfVehicle();
                case 5 -> {
                    System.out.print("\nDigite la Matrícula del Vehículo a eliminar: ");
                    int toDeleteMATR = Integer.parseInt(sc.nextLine());
                    DELETEVehicleRecord(toDeleteMATR);
                }
                case 6 ->
                    flag = false;
            }

        }

    }

    public static void INSERTTypeOfVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*****TIPO DEL VEHICULO A AGREGAR*****");
        System.out.println("1. Ligero");
        System.out.println("2. Transporte");
        System.out.println("3. Indeterminado");
        System.out.println("4. Volver al Menú Anterior");
        int optionA = Integer.parseInt(sc.nextLine());
        switch (optionA) {
            case 1 -> {
                System.out.println("\n*****ASISTENCIA DE CONDUCCIÓN*****");
                System.out.println("1. Androide");
                System.out.println("2. Sin Asistencia");
                int optionB = Integer.parseInt(sc.nextLine());
                switch (optionB) {
                    case 1 -> {
                        System.out.println("\n*****VEHÍCULO LIGERO*****");
                        System.out.print("Digite el Nombre del Vehículo: ");
                        String myName1 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite el Color: ");
                        String myColor1 = sc.nextLine();
                        System.out.print("Digite el nombre del Androide:");
                        String myAID1 = sc.nextLine();

                        INSERTVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1), new lightVModel(myColor1, myAID1));
                    }

                    case 2 -> {
                        System.out.println("\n*****VEHÍCULO LIGERO*****");
                        System.out.print("Digite el Nombre Vehículo: ");
                        String myName2 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite el Color: ");
                        String myColor2 = sc.nextLine();

                        INSERTVehicleRecord(new vehicleModel(myName2, mySpeed2, myLength2), new lightVModel(myColor2, null));
                    }
                }
            }
            case 2 -> {
                System.out.println("\n*****VEHÍCULO DE TRANSPORTE*****");
                System.out.println("1. Con Capitán Asignado");
                System.out.println("2. Sin Capitán Asignado");
                int optionC = Integer.parseInt(sc.nextLine());
                switch (optionC) {
                    case 1 -> {
                        System.out.println("\n*****VEHÍCULO DE TRANSPORTE*****");
                        System.out.print("Digite el Nombre del vehículo: ");
                        String myName1 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite el tamaño de la Tripulación: ");
                        int myCrewSize1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Digite la cantidad máxima de pasajeros que soporta: ");
                        int myPassengersCapacity1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Digite el Nombre del Capitán a cargo: ");
                        String myCaptainName1 = sc.nextLine();
                        System.out.print("Digite la Especie del Capitán: ");
                        String myCaptainSpecies1 = sc.nextLine();

                        INSERTVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1), new transportVModel(myCrewSize1, myPassengersCapacity1), new captainModel(myCaptainName1, myCaptainSpecies1));
                    }
                    case 2 -> {
                        System.out.println("\n*****VEHÍCULO DE TRANSPORTE*****");
                        System.out.print("Digite el Nombre del vehículo: ");
                        String myName2 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite el tamaño de la Tripulación: ");
                        int myCrewSize2 = Integer.parseInt(sc.nextLine());
                        System.out.print("Digite la cantidad máxima de pasajeros que soporta: ");
                        int myPassengersCapacity2 = Integer.parseInt(sc.nextLine());

                        INSERTVehicleRecord(new vehicleModel(myName2, mySpeed2, myLength2), new transportVModel(myCrewSize2, myPassengersCapacity2));
                    }
                }
            }
            case 3 -> {
                System.out.println("\n*****VEHÍCULO*****");
                System.out.print("Digite el Nombre: ");
                String myName1 = sc.nextLine();
                System.out.print("Digite la Velocidad Máxima: ");
                double mySpeed1 = Double.parseDouble(sc.nextLine());
                System.out.print("Digite la Longitud: ");
                double myLength1 = Double.parseDouble(sc.nextLine());

                INSERTVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1));
            }
            case 4 -> {
            }
        }
    }

    public static void UPDATETypeOfVehicle() {
        boolean invalidMATR = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*****ACTUALIZAR VEHICULO*****");
        System.out.print("Digite la Matrícula del Vehículo a actualizar: ");
        int myMATR = Integer.parseInt(sc.nextLine());
        ArrayList<vehicleRecordModel> ALLVehicleRecords = LISTVehicleRecords();
        for (vehicleRecordModel c : ALLVehicleRecords) {
            if (myMATR == c.getPlate()) {
                invalidMATR = false;
                switch (c.getType()) {
                    case "Ligero" -> {
                        if (c.getSubject().equals("Ninguno")) {
                            System.out.print("Digite el Nombre Vehículo: ");
                            String myName2 = sc.nextLine();
                            System.out.print("Digite la Velocidad Máxima: ");
                            double mySpeed2 = Double.parseDouble(sc.nextLine());
                            System.out.print("Digite la Longitud: ");
                            double myLength2 = Double.parseDouble(sc.nextLine());
                            System.out.print("Digite el Color: ");
                            String myColor2 = sc.nextLine();
                            UPDATEVehicleRecord(new vehicleModel(myName2, mySpeed2, myLength2), new lightVModel(myColor2, null));
                        } else {
                            System.out.print("Digite el Nombre del Vehículo: ");
                            String myName1 = sc.nextLine();
                            System.out.print("Digite la Velocidad Máxima: ");
                            double mySpeed1 = Double.parseDouble(sc.nextLine());
                            System.out.print("Digite la Longitud: ");
                            double myLength1 = Double.parseDouble(sc.nextLine());
                            System.out.print("Digite el Color: ");
                            String myColor1 = sc.nextLine();
                            System.out.print("Digite el nombre del Androide:");
                            String myAID1 = sc.nextLine();
                            UPDATEVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1), new lightVModel(myColor1, myAID1));
                        }
                    }
                    case "Transporte" -> {
                        System.out.println("\n*****VEHÍCULO DE TRANSPORTE*****");
                        System.out.print("Digite el Nombre del vehículo: ");
                        String myName1 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite el tamaño de la Tripulación: ");
                        int myCrewSize1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Digite la cantidad máxima de pasajeros que soporta: ");
                        int myPassengersCapacity1 = Integer.parseInt(sc.nextLine());
                        System.out.print("Desea actualizar el Capitán a cargo del Vehículo [Sí (S) / No (Cualquier otra tecla)]: ");
                        char myUpdateCaptainOption = sc.nextLine().charAt(0);
                        if (myUpdateCaptainOption == 'S' | myUpdateCaptainOption == 's') {
                            System.out.print("Digite el Nombre del Capitán a cargo: ");
                            String myCaptainName1 = sc.nextLine();
                            System.out.print("Digite la Especie del Capitán: ");
                            String myCaptainSpecies1 = sc.nextLine();
                            UPDATEVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1),
                                    new transportVModel(myCrewSize1, myPassengersCapacity1),
                                    new captainModel(myCaptainName1, myCaptainSpecies1, myMATR));
                        } else {
                            UPDATEVehicleRecord(new vehicleModel(myName1, mySpeed1, myLength1),
                                    new transportVModel(myCrewSize1, myPassengersCapacity1));
                        }
                    }
                    default -> {
                        System.out.print("Digite el Nombre Vehículo: ");
                        String myName2 = sc.nextLine();
                        System.out.print("Digite la Velocidad Máxima: ");
                        double mySpeed2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite la Longitud: ");
                        double myLength2 = Double.parseDouble(sc.nextLine());
                        UPDATEVehicle(new vehicleModel(myName2, mySpeed2, myLength2));
                    }
                }
                break;
            }
        }
        if (invalidMATR) {
            System.out.println("No existe vehículo alguno con el número de Matrícula ingresado.\n");
        } else {
            DisplayVehicleRecordsData(LISTVehicleRecords());
        }
    }
}
