package com.stubhub.promethues;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleJob {

    private static final Logger log = LoggerFactory.getLogger(ScheduleJob.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {

        for(int i=1;i<=10;i++){
            Person person = new Person();
            person.setId(Long.valueOf(i));
            person.setPhone("123456");
            person.setUsername("abcd");
            ResponseEntity res = restTemplate.postForEntity("http://localhost:8080/prom/api/person",person,String.class);
            log.info(res.getBody().toString());
        }

        for(int i = 1;i<=10;i++){
            ResponseEntity res = restTemplate.getForEntity("http://localhost:8080/prom/api/person/"+i,String.class);
            log.info(res.getBody().toString());
        }

       for(int i=1;i<=2;i++){
            Person person = new Person();
            person.setId(Long.valueOf(i));
            person.setPhone("123456");
            person.setUsername("abcd");
            try{
                ResponseEntity res = restTemplate.postForEntity("http://localhost:8080/prom/api/person",person,String.class);
            }catch (Exception e){

            }
        }

        ResponseEntity entity = restTemplate.getForEntity("http://localhost:8080/prom/api/clear",String.class);
        log.info("{}", entity.getBody().toString());
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
