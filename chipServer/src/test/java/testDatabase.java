import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import Layer2_Database.*;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.*;





public class testDatabase {

    @Test
    public void connectToDatabase(){
        databaseManegment data = new databaseManegment();
        Connection connect = null;

        try {
             connect = data.startConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertNotNull(connect);


    }

    @Test
    public void createSession(){
        databaseManegment data = new databaseManegment();

        Boolean success = false;
        try {
            success = Data.saveSession( data.startConnection(),1,300);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(success);

    }


    @Test
    public void deleteSession(){
        databaseManegment data = new databaseManegment();
        Boolean deleted = false;
        try {
            deleted = Data.deleteSession(data.startConnection(),1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertTrue(deleted);

    }

}
