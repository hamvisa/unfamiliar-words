package connection;


import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;

import static utils.CheckUtil.isSet;


/**
 * Created by IntelliJ IDEA.
 * User: sahil.mai
 * Date: 6/21/20
 * Time: 11:12 AM
 */


public class MyConnection {


    private enum ConnectionType {
        GET,
        POST
    }

    private static Connection dbConnection;

    private static @Nullable URL getURLObject(String url) {
        if (!isSet(url))
            return null;

        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static @Nullable HttpURLConnection getConnection(String urlString, ConnectionType type) {
        try {
            URL url = getURLObject(urlString);
            if (!isSet(url)) {
                return null;
            }

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(type.name());
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            return connection;
        } catch (Exception e) {
            return null;
        }
    }

    public static @Nullable String getGETResponse(String url) {
        int status;
        String line;
        StringBuilder response;
        HttpURLConnection connection;

        if (!isSet(url))
            return null;

        connection = getConnection(url, ConnectionType.GET);
        if (!isSet(connection))
            return null;

        try {
            connection.connect();

            status = connection.getResponseCode();
            response = new StringBuilder();

            if (status > 299)
                return null;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            while ((line = in.readLine()) != null) {
                response.append(line+"\n");
            }

            in.close();
            connection.disconnect();

            return response.toString();

        } catch (Exception e) {
            return null;
        }
    }

    public static @Nullable Connection getDbConnection(String url, String user, String password) {
        if (!isSet(dbConnection)) {
            if (!isSet(url) || !isSet(user) || !isSet(password))
                return null;
            try {
                dbConnection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                dbConnection = null;
            }
        }
        return dbConnection;
    }
}
