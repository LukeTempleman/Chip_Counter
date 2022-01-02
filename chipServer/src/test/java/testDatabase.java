import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import Layer2_Database.Data;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;





public class testDatabase {

    @Test
    public void connectToDatabase(){

    }

    @Test
    public void createSession(){
        Boolean success = Data.saveSession(1,300);
        assertTrue(success);

    }

    @Test
    public void getSession(){
        String session = Data.loadSession(1);
        assertEquals(session,"1,300");
    }

    @Test
    public void deleteSession(){
        Boolean deleted = Data.deleteSession(1);
        assertTrue(deleted);

    }

}
