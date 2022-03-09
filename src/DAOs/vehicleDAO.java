package DAOs;

import Model.vehicleModel;
import Utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class vehicleDAO {

    public ArrayList<vehicleModel> ListAllVehicles() {

        Connection conn = null;
        ArrayList<vehicleModel> myVehicles = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM vehiculo;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    vehicleModel myVehicle = new vehicleModel(result.getInt(1),
                            result.getString(2),
                            result.getDouble(3),
                            result.getDouble(4));
                    myVehicles.add(myVehicle);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myVehicles;
    }

    public static vehicleModel SELECTVehicle(int myPlate) {

        Connection conn = null;
        vehicleModel myVehicle = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM vehiculo WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myVehicle = new vehicleModel(result.getInt(1),
                            result.getString(2),
                            result.getDouble(3),
                            result.getDouble(4));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myVehicle;
    }

    public static Integer SELECTLastInsertedMATR() {
        Integer LastMATR = null;
        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                //String sql = "SELECT LAST_INSERT_ID();";
                String sql = "SELECT MAX(matricula) FROM vehiculo;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                if (result.next()) {
                    LastMATR = result.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return LastMATR;
    }

    public static void INSERTVehicle(vehicleModel myVehicleModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "INSERT INTO vehiculo(nombre, velocidad, longitud) VALUES(?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, myVehicleModel.getName());
                statement.setDouble(2, myVehicleModel.getSpeed());
                statement.setDouble(3, myVehicleModel.getLength());
                int InsertedRows = statement.executeUpdate();
                if (InsertedRows > 0) {
                    System.out.println("\nEl vehículo listado a continuación fue agregado exitosamente a la base de datos:\n"
                            + "MATR\t NOMBRE\t\t\t VELOCIDAD\t LONGITUD\n" + myVehicleModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void UPDATEVehicle(vehicleModel myVehicleModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                vehicleModel datedVehicle = SELECTVehicle(myVehicleModel.getPlate());

                String sql = "UPDATE vehiculo SET nombre=?, velocidad=?, longitud=? WHERE matricula=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //statement.setInt(1,myVehicleModel.getClient_id());
                statement.setString(1, myVehicleModel.getName());
                statement.setDouble(2, myVehicleModel.getSpeed());
                statement.setDouble(3, myVehicleModel.getLength());
                statement.setInt(4, myVehicleModel.getPlate());
                int UpdatedRows = statement.executeUpdate();
                if (UpdatedRows > 0) {
                    System.out.println("\t\t\t\tMATR\t NOMBRE\t\t\t VELOCIDAD\t LONGITUD \nEl registro del vehículo:\t" + datedVehicle + "\nFue actualizado a:\t\t" + myVehicleModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void DELETEVehicle(int myPlate) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                vehicleModel droppedVehicle = SELECTVehicle(myPlate);

                String sql = "DELETE FROM vehiculo WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl vehículo listado a continuación fue eliminado exitosamente de la base de datos:\nMATR\t NOMBRE\t\t\t VELOCIDAD\t LONGITUD\n" + droppedVehicle + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }
}
