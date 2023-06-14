package Marius.Momkus.demo.Data;

// DataCache.java
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataCache {
    private final Map<String, Map<String, Map<LocalDate, ChartData>>> cache;

    public DataCache() {
        this.cache = new HashMap<>();
    }

    public ChartData getChartData(String ticker, LocalDate start, LocalDate end) {
        if (cache.containsKey(ticker) && cache.get(ticker).containsKey(start.toString())) {
            Map<LocalDate, ChartData> dataMap = cache.get(ticker).get(start.toString());
            if (dataMap.containsKey(end)) {
                return dataMap.get(end);
            }
        }
        return null;
    }

    public void putChartData(String ticker, LocalDate start, LocalDate end, ChartData chartData) {
        cache.putIfAbsent(ticker, new HashMap<>());
        cache.get(ticker).putIfAbsent(start.toString(), new HashMap<>());
        cache.get(ticker).get(start.toString()).put(end, chartData);
    }
}
