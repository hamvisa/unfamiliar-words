//package test;
//
//import connection.MyConnection;
//import dbadapter.BaseDbAdapter;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * Created by IntelliJ IDEA.
// * User: sahil.mai
// * Date: 6/27/20
// * Time: 9:37 PM
// */
//public class BaseDbAdapterTest extends BaseDbAdapter {
//    public static void main(String[] args) throws InterruptedException, SQLException {
//        String insertQuery1 = "INSERT INTO temp (column_1, column_2) VALUES(1, 'Sahil');";
//        String insertQuery2 = "INSERT INTO temp (column_1, column_2) VALUES(2, 'Maniar');";
//        String updateQuery = "UPDATE temp SET column_2 = 'Updated Value Maniar' WHERE column_1 = 2 AND column_2 = 'Maniar';";
//        String deleteQuery1 = "DELETE FROM temp WHERE column_1 = 1;";
//        String deleteQuery2 = "DELETE FROM temp WHERE column_1 = 2;";
//
//        String selectQuery = "SELECT * FROM temp";
//
//        insert(insertQuery1);
//        insert(insertQuery2);
//        update(updateQuery);
//        ResultSet rs = select(selectQuery);
//        delete(deleteQuery1);
//        delete(deleteQuery2);
//        while (rs.next()) {
//            System.out.println(rs.getInt("column_1"));
//            System.out.println(rs.getString("column_2"));
//            System.out.println();
//        }
//    }
//}
