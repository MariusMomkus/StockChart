package Marius.Momkus.demo.Services;

// StockDataService.java
import Marius.Momkus.demo.Data.ChartData;
import Marius.Momkus.demo.Data.DataCache;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StockDataService {
    private final ExternalApiService externalApiService;
    private final DataCache dataCache;

    public StockDataService(ExternalApiService externalApiService, DataCache dataCache) {
        this.externalApiService = externalApiService;
        this.dataCache = dataCache;
    }

    public ChartData getChartData(String ticker, LocalDate start, LocalDate end) {
        // Check the cache first
        ChartData cachedData = dataCache.getChartData(ticker, start, end);
        if (cachedData != null) {
            return cachedData;
        }

        // Fetch data from the external API
        ChartData newData = externalApiService.fetchChartData(ticker, start, end);

        // Store the fetched data in the cache
        dataCache.putChartData(ticker, start, end, newData);

        return newData;
    }
}
