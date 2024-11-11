package WeatherApp;

import java.io.BufferedReader;
import java.lang.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class WeatherFetcher {
    private static final String API_KEY = "920f67bd5c6c94e347cdc71af32dbe71";
    private static final String Base_Url = "http://api.openweathermap.org/data/2.5/weather";


    public static void main(String []args){
        fetchWeather("Hannover");
    }

    public static void fetchWeather(String city){
        try{
            String urlString = Base_Url + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();    
                while((inputLine = in.readLine()) != null){
                    content.append(inputLine);
                }
                in.close();
                System.out.println("Weather data "+ content.toString());
            }else{
                System.out.println("Failed to fetch the weather " + responseCode);
            }
        }catch(Exception e){
            System.out.println("Error getting weather" + e.getMessage());
        }
    }
}
