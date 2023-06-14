package Marius.Momkus.demo.Data;

import Marius.Momkus.demo.Chart.CandlestickChart;
import Marius.Momkus.demo.Chart.ColumnChart;

// ChartData.java
public class ChartData {
    private final CandlestickChart candlestickChart;
    private final ColumnChart columnChart;

    public ChartData(CandlestickChart candlestickChart, ColumnChart columnChart) {
        this.candlestickChart = candlestickChart;
        this.columnChart = columnChart;
    }

    public CandlestickChart getCandlestickChart() {
        return candlestickChart;
    }

    public ColumnChart getColumnChart() {
        return columnChart;
    }
}
