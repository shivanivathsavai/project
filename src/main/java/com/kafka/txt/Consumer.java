package com.kafka.txt;

import com.kafka.producer.Byke;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.io.*;
public class Consumer {


    public static void main(String args[]) throws Exception {
        /*setting properties*/

        Properties property = new Properties();

        property.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        property.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        property.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        property.put(ConsumerConfig.GROUP_ID_CONFIG, "Consumergroupid");
        property.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        /*creating consumer object*/

        KafkaConsumer consumer = new KafkaConsumer(property);

        /*subscribe to topic*/

        consumer.subscribe(Collections.singletonList("shivani-new"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\Shivani\\transfer.txt"));
        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                        System.out.println(record.value().toString());



                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







