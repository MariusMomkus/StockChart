package Marius.Momkus.demo.Controllers;

// StockChartController.java
import Marius.Momkus.demo.Services.StockDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class StockChartController {
    private final StockDataService stockDataService;

    public StockChartController(StockDataService stockDataService) {
        this.stockDataService = stockDataService;
    }

    @GetMapping("/chart-data")
    public ChartData getChartData(
            @RequestParam("ticker") String ticker,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
        return stockDataService.getChartData(ticker, start, end);
    }
}

