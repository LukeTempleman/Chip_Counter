package Layer1_EntryPoint;

import Layer2_Database.*;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import io.javalin.http.NotFoundResponse;

import java.sql.Connection;
import java.sql.SQLException;


public class apiHandler {
    private static final databaseManegment database = new databaseManegment();
    Connection connection = database.startConnection();
    Data data = new Data();

    public apiHandler() throws SQLException {
    }


    public static void getOne(Context context) throws SQLException {
        Connection connection = database.startConnection();
        Integer id = context.pathParamAsClass("id", Integer.class).get();
        String chips = Data.loadSession(connection,id);
        if (chips.equals("")) {
            throw new NotFoundResponse("Session not found: " + id);
        }
        context.json(chips);

    }



}
