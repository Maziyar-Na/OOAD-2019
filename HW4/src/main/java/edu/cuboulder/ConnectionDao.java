package edu.cuboulder;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

    private String jdbcHost = null;
    private String dbName = null;
    private String userName = null;
    private String password = null;
    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;

    public ConnectionDao(String jdbcHost, String dbName, String userName, String password){
        this.jdbcHost = jdbcHost;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }


    public Connection connect() {

        connectionString = String.format("user=%s&password=%s",userName,password);
        urlString = String.format("jdbc:mysql//%s/%s?",jdbcHost,dbName);
        try{
            conn = DriverManager.getConnection(urlString+connectionString);
            return conn;
        }catch (SQLException ex){
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState :" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
            return null;
        }

    }
}
