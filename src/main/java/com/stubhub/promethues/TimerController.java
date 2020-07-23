package com.stubhub.promethues;

import io.prometheus.client.Histogram;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TimerController {


    @Timed(value="timer_test_duration", quantiles = {0.5,1,2,3})
    @RequestMapping(method= RequestMethod.GET,value="/timer_test")
    public String timerConsumeOneSeconds(){

        try {
            Thread.sleep(10000);
        }catch(InterruptedException exception){

        }

        return "timer successfully";
    }



    static final Histogram requestLatency = Histogram.build().buckets(1.0,2.0,3.0)
            .name("requests_latency_seconds").help("Request latency in seconds.").register();

    @RequestMapping("/histogram")
    public String histogram() {
        Histogram.Timer requestTimer = requestLatency.startTimer();
        try {
            // Your code here.
            Thread.sleep(RandomUtils.nextInt(800,3000));
            return "histogram success";
        } catch (Exception exception){
        }
        finally {
            requestTimer.observeDuration();
        }
        return "histogram success";
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.nextInt(800,3000));
    }

}
