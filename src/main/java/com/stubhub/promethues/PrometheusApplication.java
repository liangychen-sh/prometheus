package com.stubhub.promethues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;
import org.springframework.metrics.export.prometheus.EnablePrometheusScraping;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnablePrometheusMetrics
@EnablePrometheusScraping
@SpringBootApplication
@EnableScheduling
public class PrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class);
    }

}
