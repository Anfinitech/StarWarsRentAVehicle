package Controller;

import DAOs.clientDAO;
import static DAOs.clientDAO.SELECTClient;
import Model.clientModel;
import java.util.Scanner;
import static View.ClientDisplayer.*;

public class clientController {

    clientDAO myClientDAO = new clientDAO();

    public clientController(clientDAO myClientDAO) {
        this.myClientDAO = myClientDAO;
    }

    public void UpdateClientDisplay() {
        DisplayClientData(myClientDAO.ListAllClients());
    }

    public void SelectClientOptions() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            int option = DisplayClientOptions();
            switch (option) {
                case 1 ->
                    DisplayClientData(myClientDAO.ListAllClients());
                case 2 -> {
                    System.out.print("\nDigite el ID del Cliente a buscar: ");
                    int searchID = Integer.parseInt(sc.nextLine());
                    DisplayClientData(SELECTClient(searchID));
                }
                case 3 -> {
                    System.out.print("\nDigite el ID: ");
                    int newID = Integer.parseInt(sc.nextLine());
                    System.out.print("\nDigite el nombre: ");
                    String newName = sc.nextLine();
                    System.out.print("\nDigite la especie: ");
                    String newSpecies = sc.nextLine();
                    System.out.print("\nDigite el género: ");
                    String newGender = sc.nextLine();

                    clientModel myNewClientModel = new clientModel(newID, newName, newSpecies, newGender);
                    myClientDAO.INSERTClient(myNewClientModel);
                }
                case 4 -> {
                    System.out.print("\nDigite el ID del Cliente a actualizar: ");
                    int toUpdateID = Integer.parseInt(sc.nextLine());
                    System.out.print("\nDigite el nombre: ");
                    String updateName = sc.nextLine();
                    System.out.print("\nDigite la especie: ");
                    String updateSpecies = sc.nextLine();
                    System.out.print("\nDigite el género: ");
                    String updateGender = sc.nextLine();
                    clientModel myUpdatedClientModel = new clientModel(toUpdateID, updateName, updateSpecies, updateGender);
                    myClientDAO.UPDATEClient(myUpdatedClientModel);
                }
                case 5 -> {
                    System.out.print("\nDigite el ID del Cliente a eliminar: ");
                    int toDeleteID = Integer.parseInt(sc.nextLine());
                    myClientDAO.DELETEClient(toDeleteID);
                }
                case 6 ->
                    flag = false;
            }
        }
    }
}
