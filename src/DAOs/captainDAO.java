package DAOs;

import Model.captainModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.ConnectionProvider;

public class captainDAO {

    public ArrayList<captainModel> ListAllCaptains() {

        Connection conn = null;
        ArrayList<captainModel> myCaptains = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM capitan;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    captainModel myCaptain = new captainModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getInt(4));
                    myCaptains.add(myCaptain);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myCaptains;
    }

    public static captainModel SELECTCaptain(int myLicense) {

        Connection conn = null;
        captainModel myCaptain = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM capitan WHERE licencia = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myLicense);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myCaptain = new captainModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getInt(4));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myCaptain;
    }

    public static captainModel SELECTCaptainFromVehicle(int myPlate) {

        Connection conn = null;
        captainModel myCaptain = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM capitan WHERE v_matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myPlate);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myCaptain = new captainModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getInt(4));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myCaptain;
    }

    public static void INSERTCaptain(captainModel myCaptainModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "INSERT INTO capitan(nombre, especie, v_matricula) VALUES(?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, myCaptainModel.getName());
                statement.setString(2, myCaptainModel.getSpecies());
                statement.setInt(3, myCaptainModel.getInChargeOf());
                int InsertedRows = statement.executeUpdate();
                if (InsertedRows > 0) {
                    System.out.println("\nEl capitán listado a continuación fue agregado exitosamente a la base de datos:\n"
                            + "LIC\t NOMBRE\t\t\t ESPECIE\t VEHÍCULO\n" + myCaptainModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void UPDATECaptain(captainModel myCaptainModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                captainModel datedCaptain = SELECTCaptain(myCaptainModel.getLicense());

                String sql = "UPDATE capitan SET nombre=?, especie=?, v_matricula=? WHERE licencia=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //statement.setInt(1,myCaptainModel.getClient_id());
                statement.setString(1, myCaptainModel.getName());
                statement.setString(2, myCaptainModel.getSpecies());
                statement.setInt(3, myCaptainModel.getInChargeOf());
                statement.setInt(4, myCaptainModel.getLicense());
                int UpdatedRows = statement.executeUpdate();
                if (UpdatedRows > 0) {
                    System.out.println("\t\t\t\tLIC\t NOMBRE\t\t\t ESPECIE\t VEHÍCULO \nEl registro del capitán:\t" + datedCaptain + "\nFue actualizado a:\t\t" + myCaptainModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void DELETECaptain(int myLicense) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                captainModel droppedCaptain = SELECTCaptain(myLicense);

                String sql = "DELETE FROM capitan WHERE licencia = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myLicense);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl capitán listado a continuación fue eliminado exitosamente de la base de datos:\nLIC\t NOMBRE\t\t\t ESPECIE\t VEHÍCULO\n" + droppedCaptain + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public static void DELETECaptainFromVehicle(int myInChargeOf) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                captainModel droppedCaptain = SELECTCaptainFromVehicle(myInChargeOf);

                String sql = "DELETE FROM capitan WHERE v_matricula = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myInChargeOf);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl capitán listado a continuación fue eliminado exitosamente de la base de datos:\nLIC\t NOMBRE\t\t\t ESPECIE\t VEHÍCULO\n" + droppedCaptain + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }
}
