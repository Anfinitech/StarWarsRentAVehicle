/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anfme
 */
import java.sql.Connection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConnectionProvider {

    public static Connection Connect() {
        JSONParser parser = new JSONParser();
        Connection conn = null;
        try {
            String credentials_path = System.getProperty("user.dir") + "/src/Utils/dbCredentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String dbname = (String)jsonObject.get("db_name");
            String password = (String)jsonObject.get("db_password");
            String dbURL = "jdbc:mysql://"+host+":"+port+"/"+dbname;
            
            
            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("\n***Connection Succeeded***\n");
            }

        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Code : " + ex.getErrorCode() + " \nError: " + ex.getMessage());
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
