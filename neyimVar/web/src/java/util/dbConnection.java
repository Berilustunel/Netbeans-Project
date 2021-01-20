package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class dbConnection {

    private Connection connection;

    public Connection connect() throws SQLException {
        
    if (this.connection == null || this.connection.isClosed()){
        
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hastatani?user=root";
            Properties connectionProps = new Properties();
            connectionProps.setProperty("user", "root");
            connectionProps.setProperty("password", "123");
            connectionProps.setProperty("useSSL", "false");
            connectionProps.setProperty("serverTimezone", "UTC");
            connectionProps.setProperty("allowPublicKeyRetrieval", "true");
            connection = DriverManager.getConnection(url, connectionProps);
            /*Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastatani?user=root&password=123");
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/hastatani", "postgres", "hesap123");*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        return this.connection;
    }
}
