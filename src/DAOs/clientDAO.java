package DAOs;

import Model.clientModel;
import Utils.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class clientDAO {

    public ArrayList<clientModel> ListAllClients() {

        Connection conn = null;
        ArrayList<clientModel> myClients = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM cliente;";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    clientModel myClient = new clientModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4));
                    myClients.add(myClient);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \nError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myClients;
    }

    public static clientModel SELECTClient(int myID) {

        Connection conn = null;
        clientModel myClient = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "SELECT * FROM cliente WHERE id = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myID);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    myClient = new clientModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4));
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }
        return myClient;
    }

    public void INSERTClient(clientModel myClientModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();

                String sql = "INSERT INTO cliente VALUES(?, ?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myClientModel.getClientID());
                statement.setString(2, myClientModel.getName());
                statement.setString(3, myClientModel.getSpecies());
                statement.setString(4, myClientModel.getGender());
                int InsertedRows = statement.executeUpdate();
                if (InsertedRows > 0) {
                    System.out.println("\nEl cliente listado a continuación fue agregado exitosamente a la base de datos:\n"
                            + "ID\t NOMBRE\t\t\t ESPECIE\t GÉNERO\n" + myClientModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public void UPDATEClient(clientModel myClientModel) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                clientModel datedClient = SELECTClient(myClientModel.getClientID());

                String sql = "UPDATE cliente SET nombre=?, especie=?, genero=? WHERE id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //statement.setInt(1,myClientModel.getClient_id());
                statement.setString(1, myClientModel.getName());
                statement.setString(2, myClientModel.getSpecies());
                statement.setString(3, myClientModel.getGender());
                statement.setInt(4, myClientModel.getClientID());
                int UpdatedRows = statement.executeUpdate();
                if (UpdatedRows > 0) {
                    System.out.println("\t\t\t\tID\t NOMBRE\t\t\t ESPECIE\t GÉNERO \nEl registro del cliente:\t" + datedClient + "\nFue actualizado a:\t\t" + myClientModel + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code: " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }

    public void DELETEClient(int myID) {

        Connection conn = null;

        try {
            if (conn == null) {
                conn = ConnectionProvider.Connect();
                clientModel droppedClient = SELECTClient(myID);

                String sql = "DELETE FROM cliente WHERE id = ?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, myID);
                int DeletedRows = statement.executeUpdate();
                if (DeletedRows > 0) {
                    System.out.println("\nEl cliente listado a continuación fue eliminado exitosamente de la base de datos:\nID\t NOMBRE\t\t\t ESPECIE\t GÉNERO\n" + droppedClient + "\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println("Code : " + ex.getErrorCode() + " \tError: " + ex.getMessage());
            //ex.printStackTrace();
        }

    }
}
