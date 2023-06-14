package Marius.Momkus.demo.Services;

// ExternalApiService.java
import Marius.Momkus.demo.ApiClient;
import Marius.Momkus.demo.Data.ChartData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExternalApiService {
    private final ApiClient apiClient;

    public ExternalApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ChartData fetchChartData(String ticker, LocalDate start, LocalDate end) {
        // Implement the logic to fetch the chart data from the external API
        // Use the provided ticker, start, and end dates to make the API request
        // Parse the response and construct the ChartData object
        // Return the constructed chart data
    }
}
