package Layer2_Database;
import java.sql.*;
import java.util.*;


public class Data {


    public static Boolean saveSession(Connection connection ,Integer id,Integer chips)  throws SQLException{


            try( final Statement stmt = connection.createStatement() ) {
                boolean gotAResultSet = stmt.execute(
                        "INSERT INTO session(id , chips) VALUES (" + id + " , " + chips + ");");

                if (gotAResultSet) {
                    throw new RuntimeException("Unexpectedly got a SQL resultset.");
                } else {
                    System.out.println("Saved a Session.");
                    return true;
                }
            }
    }

    public static String loadSession(Connection connection ,Integer id)  throws SQLException {

        String finalString = "";

                    Statement stmt = connection.createStatement();
                    ResultSet results = stmt.executeQuery("SELECT * FROM session Where id = "+id+";");

                    final int idNumber = results.getInt("id");
                    final int chips = results.getInt( "chips" );

                    if (idNumber == id){
                        final StringBuilder b = new StringBuilder()
                                .append( idNumber ).append(",")
                                .append( chips )
                                ;
                        System.out.println( b.toString() );
                        finalString = b.toString();
                    }
                    else{
                        finalString = "Couldnt Find Session";
                    }


            return finalString;
        }


    public static Boolean deleteSession (Connection connection , Integer id){
        Boolean success = false;
        try (final Statement stmt = connection.createStatement()) {
            String sql = "DELETE FROM session WHERE id = \"" + id + "\" ";
            stmt.executeUpdate(sql);
            success = true;
        } catch (Exception e) {
            System.out.println("No such world");
        }

        return success;
    }
}
