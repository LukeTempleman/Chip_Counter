package Layer2_Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseManegment {

        public static final String IN_MEMORY_DB_URL = "jdbc:sqlite::memory:";

        public static final String DISK_DB_URL = "jdbc:sqlite:";


        private String dbUrl = null;

        private void DbConnect(String[] args ) {
            processCmdLineArgs( args );

            try( final Connection connection = DriverManager.getConnection( dbUrl ) ){
                System.out.println( "Connected to database " );
                runTest( connection );
            }catch( SQLException e ){
                System.err.println( e.getMessage() );
            }
        }

        private void runTest( Connection connection ) {
            try( final Statement stmt = connection.createStatement() ){
                stmt.executeUpdate( "CREATE TABLE test( test_id, success )" );
                System.out.println( "Success creating test table!" );
            }catch( SQLException e ){
                System.err.println( e.getMessage() );
            }
        }

        private void processCmdLineArgs( String[] args ){
            if( args.length == 2 && args[ 0 ].equals( "-f" )){
                dbUrl = DISK_DB_URL + args[ 1 ];
            }else if( args.length == 0 ){
                dbUrl = IN_MEMORY_DB_URL;
            }else{
                throw new RuntimeException( "Illegal command-line arguments." );
            }
        }
    }

