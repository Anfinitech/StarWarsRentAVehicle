/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import static DAOs.captainDAO.DELETECaptainFromVehicle;
import static DAOs.captainDAO.INSERTCaptain;
import static DAOs.lightVDAO.DELETELightV;
import static DAOs.lightVDAO.INSERTLightV;
import static DAOs.lightVDAO.UPDATELightV;
import static DAOs.transportVDAO.DELETETransportV;
import static DAOs.transportVDAO.INSERTTransportV;
import static DAOs.transportVDAO.UPDATETransportV;
import static DAOs.vehicleDAO.DELETEVehicle;
import static DAOs.vehicleDAO.INSERTVehicle;
import static DAOs.vehicleDAO.SELECTLastInsertedMATR;
import static DAOs.vehicleDAO.UPDATEVehicle;
import Model.captainModel;
import Model.lightVModel;
import Model.transportVModel;
import Model.vehicleModel;
import Model.vehicleRecordModel;
import Utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class vehicleRecordDAO {

    public static ArrayList<vehicleRecordModel> LISTVehicleRecords() {

        Connection conn = null;

        String base_sql = "SELECT vehiculo.matricula AS Matrícula,\n"
                + "        vehiculo.nombre AS Nombre, \n"
                + "        velocidad AS Velocidad, \n"
                + "        longitud AS \"Tamaño\", \n"
                + "        IF(ligero.matricula = vehiculo.matricula, \"Ligero\", IF(transporte.matricula = vehiculo.matricula, \"Transporte\", \"No Definido\")) AS Tipo,\n"
                + "        IF(ligero.matricula = vehiculo.matricula, IFNULL(ligero.androide, \"Ninguno\"), IF(transporte.matricula = vehiculo.matricula, IFNULL(capitan.nombre,\"Ninguno\"), \"Ninguno\")) AS \"Androide/Capitan\"\n"
                + "        FROM vehiculo \n"
                + "        LEFT JOIN ligero ON vehiculo.matricula = ligero.matricula \n"
                + "        LEFT JOIN capitan ON vehiculo.matricula = capitan.v_matricula \n"
                + "        LEFT JOIN transporte ON transporte.matricula = vehiculo.matricula;";

        ArrayList<vehicleRecordModel> myVehicleRecords = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(base_sql);
                while (result.next()) {
                    vehicleRecordModel myVehicleRecord = new vehicleRecordModel(result.getInt(1),
                            result.getString(2),
                            result.getDouble(3),
                            result.getDouble(4),
                            result.getString(5),
                            result.getString(6));
                    myVehicleRecords.add(myVehicleRecord);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myVehicleRecords;
    }

    public static vehicleRecordModel SELECTVehicleRecord(int myPlate) {

        Connection conn = null;
        vehicleRecordModel myVehicleRecord = null;

        String base_sql = "SELECT vehiculo.matricula AS Matrícula,\n"
                + "        vehiculo.nombre AS Nombre, \n"
                + "        velocidad AS Velocidad, \n"
                + "        longitud AS \"Tamaño\", \n"
                + "        IF(ligero.matricula = vehiculo.matricula, \"Ligero\", IF(transporte.matricula = vehiculo.matricula, \"Transporte\", \"No Definido\")) AS Tipo,\n"
                + "        IF(ligero.matricula = vehiculo.matricula, IFNULL(ligero.androide, \"Ninguno\"), IF(transporte.matricula = vehiculo.matricula, IFNULL(capitan.nombre,\"Ninguno\"), \"Ninguno\")) AS \"Androide/Capitan\"\n"
                + "        FROM vehiculo \n"
                + "        LEFT JOIN ligero ON vehiculo.matricula = ligero.matricula \n"
                + "        LEFT JOIN capitan ON vehiculo.matricula = capitan.v_matricula \n"
                + "        LEFT JOIN transporte ON transporte.matricula = vehiculo.matricula";

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = base_sql + " WHERE vehiculo.matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myVehicleRecord = new vehicleRecordModel(result.getInt(1),
                            result.getString(2),
                            result.getDouble(3),
                            result.getDouble(4),
                            result.getString(5),
                            result.getString(6));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myVehicleRecord;
    }

    public static void INSERTVehicleRecord(vehicleModel myVehicleModel) {
        INSERTVehicle(myVehicleModel);
    }

    public static void INSERTVehicleRecord(vehicleModel myVehicleModel, lightVModel myLightVModel) {
        INSERTVehicle(myVehicleModel);
        myLightVModel.setPlate(SELECTLastInsertedMATR());
        INSERTLightV(myLightVModel);
    }

    public static void INSERTVehicleRecord(vehicleModel myVehicleModel, transportVModel myTransportVModel) {
        INSERTVehicle(myVehicleModel);
        myTransportVModel.setPlate(SELECTLastInsertedMATR());
        INSERTTransportV(myTransportVModel);
    }

    public static void INSERTVehicleRecord(vehicleModel myVehicleModel, transportVModel myTransportVModel, captainModel myCaptainModel) {

        INSERTVehicle(myVehicleModel);
        myTransportVModel.setPlate(SELECTLastInsertedMATR());
        INSERTTransportV(myTransportVModel);
        myCaptainModel.setInChargeOf(myTransportVModel.getPlate());
        INSERTCaptain(myCaptainModel);
    }

    public static void UPDATEVehicleRecord(vehicleModel myVehicleModel) {
        UPDATEVehicle(myVehicleModel);
    }

    public static void UPDATEVehicleRecord(vehicleModel myVehicleModel, lightVModel myLightVModel) {
        UPDATEVehicle(myVehicleModel);
        UPDATELightV(myLightVModel);
    }

    public static void UPDATEVehicleRecord(vehicleModel myVehicleModel, transportVModel myTransportVModel) {
        UPDATEVehicle(myVehicleModel);
        UPDATETransportV(myTransportVModel);
    }

    public static void UPDATEVehicleRecord(vehicleModel myVehicleModel, transportVModel myTransportVModel, captainModel myCaptainModel) {
        UPDATEVehicle(myVehicleModel);
        UPDATETransportV(myTransportVModel);
        INSERTCaptain(myCaptainModel);
    }

    public static void DELETEVehicleRecord(int myPlate) {
        ArrayList<vehicleRecordModel> ALLVehicleRecords = LISTVehicleRecords();
        for (vehicleRecordModel c : ALLVehicleRecords) {
            if (myPlate == c.getPlate()) {
                if (c.getType().equals("Ligero")) {
                    DELETELightV(myPlate);
                } else if (c.getType().equals("Transporte")) {
                    DELETECaptainFromVehicle(myPlate);
                    DELETETransportV(myPlate);
                }
                DELETEVehicle(myPlate);
                break;
            }
        }
    }
}
