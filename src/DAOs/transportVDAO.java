package DAOs;

import Model.transportVModel;
import Utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class transportVDAO {

    public ArrayList<transportVModel> ListAllTransportVs() {

        Connection conn = null;
        ArrayList<transportVModel> myTransportVs = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM transporte;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    transportVModel myTransportV = new transportVModel(result.getInt(1),
                            result.getInt(2),
                            result.getInt(3));
                    myTransportVs.add(myTransportV);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myTransportVs;
    }

    public static transportVModel SELECTTransportV(int myPlate) {

        Connection conn = null;
        transportVModel myTransportV = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM transporte WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myTransportV = new transportVModel(result.getInt(1),
                            result.getInt(2),
                            result.getInt(3));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myTransportV;
    }

    public static void INSERTTransportV(transportVModel myTransportVModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "INSERT INTO transporte VALUES(?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myTransportVModel.getPlate());
                statement.setInt(2, myTransportVModel.getCrewSize());
                statement.setInt(3, myTransportVModel.getPassengersCapacity());
                int InsertedRows = statement.executeUpdate();
                if (InsertedRows > 0) {
                    System.out.println("\nEl vehículo de transporte listado a continuación fue agregado exitosamente a la base de datos:\n"
                            + "MATR\t TRIPULANTES\t\t\t PASAJEROS\n" + myTransportVModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void UPDATETransportV(transportVModel myTransportVModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                transportVModel datedTransportV = SELECTTransportV(myTransportVModel.getPlate());

                String sql = "UPDATE transporte SET tripulantes=?, pasajeros=? WHERE matricula=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //statement.setInt(1,myTransportVModel.getClient_id());
                statement.setInt(1, myTransportVModel.getCrewSize());
                statement.setInt(2, myTransportVModel.getPassengersCapacity());
                statement.setInt(3, myTransportVModel.getPlate());
                int UpdatedRows = statement.executeUpdate();
                if (UpdatedRows > 0) {
                    System.out.println("\t\t\t\tMATR\t TRIPULANTES\t\t\t PASAJEROS \nEl registro del vehículo:\t" + datedTransportV + "\nFue actualizado a:\t\t" + myTransportVModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void DELETETransportV(int myPlate) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                transportVModel droppedTransportV = SELECTTransportV(myPlate);

                String sql = "DELETE FROM transporte WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl vehículo de transporte listado a continuación fue "
                            + "eliminado exitosamente de la base de datos:\n"
                            + "MATR\t TRIPULANTES\t\t\t PASAJEROS\n" + droppedTransportV + "\n");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }
}
