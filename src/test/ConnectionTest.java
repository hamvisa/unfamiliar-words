/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 12:27 PM
 */

package test;

import connection.MyConnection;

public class ConnectionTest {
    public static void main(String[] args) {
        String response = MyConnection.getGETResponse("https://api.dictionaryapi.dev/api/v1/entries/en/hello");
        System.out.println(response);
    }
}
