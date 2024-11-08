package infrastructure;

import domain.Weather;
import domain.WeatherService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class WeatherServiceImpl implements WeatherService {
    private static final String API_URL = "https://api.example.com/weather?location=";
    private static final String API_KEY = "YOUR_API_KEY";  // Replace with your actual API key

    @Override
    public Weather getCurrentWeather(String location) {
        try {
            
            URI uri = URI.create(API_URL + location + "&apikey=" + API_KEY);
            URL url = uri.toURL();

          
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }

            
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder inline = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inline.append(line);
            }
            bufferedReader.close();

           
            String response = inline.toString();

           
            String[] lines = response.split("\n");
            double temperature = 0.0;
            for (String l : lines) {
                if (l.startsWith("Temperature:")) {
                    String tempStr = l.split(":")[1].trim();  // Get the part after "Temperature: "
                    temperature = Double.parseDouble(tempStr);
                    break;
                }
            }

            
            return new Weather(location, temperature);

        } catch (Exception e) {
            e.printStackTrace();
            return null;  
        }
    }
}






