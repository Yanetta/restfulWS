package rest;

import javax.ws.rs.core.Response.Status;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MateGroupServiceClient {

    public static void main(String[] args) {
        try {
            HttpURLConnection conn = getMateGroup();
            showInfo(conn);
             conn = getTeacher();
            showInfo(conn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showInfo(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != Status.OK.getStatusCode()
                && conn.getResponseCode() != Status.ACCEPTED.getStatusCode()) {
            System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }

    private static HttpURLConnection getMateGroup() throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        return conn;
    }
    private static HttpURLConnection getTeacher() throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/teacher");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        return conn;
    }
}

