package com.MicroserviceApp.AnalyticsMicroservice.StartUp;

import com.MicroserviceApp.AnalyticsMicroservice.AnalyticsMicroserviceApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class WetherAttributeRunner implements ApplicationRunner {

    private Timer timer;
    private TimerTask task;

    private static final Logger log = LoggerFactory.getLogger(AnalyticsMicroserviceApplication.class);
    private TimerTask getTask(){
        return new TimerTask() {
            @Override
            public void run() {
                log.info("i tick");
                Quote quote = restClient.getForObject(
                        "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
                log.info(quote.toString());
            }
        };
    }

    @Autowired
    RestTemplate restClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.timer = new Timer();
        this.task = this.getTask();
        this.timer.schedule(this.task, 0, 2000);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Value {

        private Long id;
        private String quote;

        public Value() {
        }

        public Long getId() {
            return this.id;
        }

        public String getQuote() {
            return this.quote;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", quote='" + quote + '\'' +
                    '}';
        }
    }

    public static class Quote {

        private String type;
        private Value value;

        public Quote() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
