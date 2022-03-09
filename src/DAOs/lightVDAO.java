package DAOs;

import Model.lightVModel;
import Utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class lightVDAO {

    public ArrayList<lightVModel> ListAllLightVs() {

        Connection conn = null;
        ArrayList<lightVModel> myLightVs = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM ligero;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    lightVModel myLightV = new lightVModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3));
                    myLightVs.add(myLightV);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myLightVs;
    }

    public static lightVModel SELECTLightV(int myPlate) {

        Connection conn = null;
        lightVModel myLightV = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM ligero WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myLightV = new lightVModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myLightV;
    }

    public static void INSERTLightV(lightVModel myLightVModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "INSERT INTO ligero VALUES(?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myLightVModel.getPlate());
                statement.setString(2, myLightVModel.getColor());
                statement.setString(3, myLightVModel.getAndroid());
                int InsertedRows = statement.executeUpdate();
                if (InsertedRows > 0) {
                    System.out.println("\nEl vehículo ligero listado a continuación fue agregado exitosamente a la base de datos:\n"
                            + "MATR\t COLOR\t\t\t ANDROIDE\n" + myLightVModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void UPDATELightV(lightVModel myLightVModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                lightVModel datedLightV = SELECTLightV(myLightVModel.getPlate());

                String sql = "UPDATE ligero SET color=?, androide=? WHERE matricula=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //statement.setInt(1,myLightVModel.getClient_id());
                statement.setString(1, myLightVModel.getColor());
                statement.setString(2, myLightVModel.getAndroid());
                statement.setInt(3, myLightVModel.getPlate());
                int UpdatedRows = statement.executeUpdate();
                if (UpdatedRows > 0) {
                    System.out.println("\t\t\t\tMATR\t COLOR\t\t\t ANDROIDE \nEl registro del vehículo:\t" + datedLightV + "\nFue actualizado a:\t\t" + myLightVModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void DELETELightV(int myPlate) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                lightVModel droppedLightV = SELECTLightV(myPlate);

                String sql = "DELETE FROM ligero WHERE matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl vehículo ligero listado a continuación fue "
                            + "eliminado exitosamente de la base de datos:\n"
                            + "MATR\t COLOR\t\t\t ANDROIDE\n" + droppedLightV + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }
}
