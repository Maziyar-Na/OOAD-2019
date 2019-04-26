//authors: Sepideh Goodarzy, Maziyar Nazari, Dwight Brown
//purpose: this class is responsible for connecting to database and executing select and other query on that
//architecture: DAO directory is the data access layer
package DAO;


import java.sql.*;

public class ConnectionDao {

    private String jdbcHost = null;
    private String dbName = null;
    private String userName = null;
    private String password = null;
    private Connection conn = null;
    private String connectionString = null;
    private String urlString = null;

    public ConnectionDao(){
        this.jdbcHost = "localhost:8889";
        this.dbName = "Library";
        this.userName = "root";
        this.password = "root";
    }

    //connecting to db
    public Connection connect() throws ClassNotFoundException {
        System.out.println("[dbg] here is the username: " + userName +" and password: " + password);
        connectionString = String.format("user=%s&password=%s",userName,password);
        urlString = String.format("jdbc:mysql://%s/%s",jdbcHost,dbName);
        System.out.println("[dbg] here is the url string: " + urlString);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(urlString,userName,password);
            return conn;
        }catch (SQLException ex){
            System.out.println("SQLException: "+ ex.getMessage());
            System.out.println("SQLState :" + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
            return null;
        }

    }

    //executing select
    public ResultSet execute_select(String query) throws SQLException {
        System.out.println("Query is : " + query);
        Statement statement =  conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        // statement.close();
        return resultSet;
    }

    //executing other query
    public void execute_other_query(String query) throws SQLException {
        System.out.println("Query is : " + query);
        Statement statement =  conn.createStatement();
        statement.execute(query);
    }
}
