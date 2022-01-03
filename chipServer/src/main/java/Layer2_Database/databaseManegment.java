package Layer2_Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseManegment {

    public static String path = Paths.get("Sessions.db").toAbsolutePath().toString();
    public static final String DISK_DB_URL = "jdbc:sqlite:" + path;

    public Connection startConnection() throws SQLException{
        return DriverManager.getConnection(DISK_DB_URL);
    }

    }

