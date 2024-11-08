package ui;

import application.WeatherApplication;
import domain.Weather;
import infrastructure.WeatherServiceImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherUI {
    private JFrame frame;
    private JTextField locationField;
    private JLabel locationLabel;
    private JLabel temperatureLabel;
    private JLabel forecastLabel;

    public static void main(String[] args) {
        // Launch the GUI
        EventQueue.invokeLater(() -> {
            try {
                WeatherUI window = new WeatherUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public WeatherUI() {
        // Create the main frame for the GUI
        frame = new JFrame("Weather Application");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(4, 2, 10, 10));

        // Create and add components to the frame
        JLabel locationLabelPrompt = new JLabel("Enter Location:");
        locationLabelPrompt.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(locationLabelPrompt);

        locationField = new JTextField();
        frame.getContentPane().add(locationField);
        locationField.setColumns(10);

        JButton getWeatherButton = new JButton("Get Weather");
        frame.getContentPane().add(getWeatherButton);

        locationLabel = new JLabel("Location: ");
        frame.getContentPane().add(locationLabel);

        temperatureLabel = new JLabel("Temperature: ");
        frame.getContentPane().add(temperatureLabel);

        forecastLabel = new JLabel("Forecast: ");
        frame.getContentPane().add(forecastLabel);

        // Action listener for the button to get weather data
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText().trim();
                if (!location.isEmpty()) {
                    // Initialize WeatherApplication with WeatherService
                    WeatherApplication app = new WeatherApplication(new WeatherServiceImpl());

                    // Get weather data for the location
                    Weather weather = app.getWeatherForLocation(location);

                    // Update the labels with the weather data
                    if (weather != null) {
                        locationLabel.setText("Location: " + weather.getLocation());
                        temperatureLabel.setText("Temperature: " + weather.getTemperature() + "°C");
                        forecastLabel.setText("Forecast: " + weather.getForecast());
                    } else {
                        locationLabel.setText("Location not found!");
                        temperatureLabel.setText("");
                        forecastLabel.setText("");
                    }
                } else {
                    locationLabel.setText("Please enter a location!");
                    temperatureLabel.setText("");
                    forecastLabel.setText("");
                }
            }
        });
    }
}


