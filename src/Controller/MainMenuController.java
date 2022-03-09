package Controller;

import DAOs.clientDAO;
import DAOs.vehicleRecordDAO;
import static View.MainDisplayer.MainMenuDisplayer;

public class MainMenuController {

    public static void SelectMainMenuOption() {
        boolean flag = true;
        while (flag) {
            int option = MainMenuDisplayer();
            switch (option) {
                case 1 -> {
                    clientDAO myClientDAO = new clientDAO();
                    clientController myClientController = new clientController(myClientDAO);
                    myClientController.UpdateClientDisplay();
                    myClientController.SelectClientOptions();
                }
                case 2 -> {
                    vehicleRecordDAO myVehicleRecordDAO = new vehicleRecordDAO();
                    vehicleRecordController myvehicleRecordController = new vehicleRecordController(myVehicleRecordDAO);
                    myvehicleRecordController.UpdateVehicleRecordDisplay();
                    myvehicleRecordController.SelectVehicleRecordOptions();
                }
                case 3 ->
                    flag = false;
            }
        }
    }
}
