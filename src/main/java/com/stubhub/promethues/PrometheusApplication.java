package com.stubhub.promethues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.metrics.export.prometheus.EnablePrometheusScraping;


@EnablePrometheusMetrics
@EnablePrometheusScraping
@SpringBootApplication
public class PrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class);
    }

}
