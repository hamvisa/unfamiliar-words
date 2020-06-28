package dbadapter;


import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.MyConnection;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/27/20
 * Time: 9:21 PM
 */
class BaseDbAdapter {


    private static final Connection connection = MyConnection.getDbConnection(Constants.URL, Constants.USER, Constants.PASSWORD);


    protected static void insert(String query) {
        try {
            if (connection == null)
                return;
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.print("Insert Exception. Query: " + query + "\t");
            System.out.println(e.getMessage());
        }
    }

    protected static void update(String query) {
        try {
            if (connection == null)
                return;
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.print("Update Exception. Query: " + query + "\t");
            System.out.println(e.getMessage());
        }
    }

    protected static void delete(String query) {
        try {
            if (connection == null)
                return;
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.print("Delete Exception. Query: " + query + "\t");
            System.out.println(e.getMessage());
        }
    }

    protected static @Nullable ResultSet select(String query) {
        try {
            if (connection == null)
                return null;
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.print("Select Exception. Query: " + query + "\t");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
