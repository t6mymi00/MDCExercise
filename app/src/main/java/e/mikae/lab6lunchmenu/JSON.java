package e.mikae.lab6lunchmenu;

import org.androidannotations.annotations.Background;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSON {

    public static String getJSON(String url) {
        HttpURLConnection urlConnection = null;
        String allData = "";
        try {
            urlConnection = (HttpURLConnection) new URL(url).openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            allData = fromStream(in);
            in.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return allData;
    }

    private static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}
