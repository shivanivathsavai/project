package com.kafka.txt;

import com.kafka.producer.Byke;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Producer {


    public static void main(String args[]) throws Exception {

        Logger logger = LoggerFactory.getLogger(Producer.class);

        /*setting producer properties*/

        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, " org.apache.kafka.common.serialization.StringSerializer");

        try {
            /*Giving path of file*/
        File file =new File("C:\\Shivani\\shivani.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
            /*creating producer object*/
        KafkaProducer producer = new KafkaProducer(prop);

            while (true) {
                String string = buffer.readLine();
                if (string == null) {

                } else {
                    ProducerRecord<String, String> record = new ProducerRecord<>("shivani-new", string);
                    producer.send(record);
                    System.out.println(record.value());
                    producer.flush();
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}








