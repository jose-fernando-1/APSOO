package com.apsoo.br.verificador_metricas.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {
    private Float metrics;
    private String name;
    private LocalDateTime timestamp;
    private ArrayList<String> data;

    public Float getMetrics() {
        return metrics;
    }

    public void setMetrics(Float metrics) {
        this.metrics = metrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
