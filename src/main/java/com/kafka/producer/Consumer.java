package com.kafka.producer;

import com.sun.deploy.util.SessionState;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String args[])
    {
        /*setting properties*/

        Properties property = new Properties();

        property.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        property.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        property.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"com.kafka.producer.BykeDeserializer");
        property.put(ConsumerConfig.GROUP_ID_CONFIG,"consumergroup12");
        property.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        /*creating consumer object*/

        KafkaConsumer consumer =new KafkaConsumer(property);

        /*subscribe to topic*/

        consumer.subscribe(Collections.singletonList("producer12"));

        /*poll loop to return records*/

        while (true) {
            ConsumerRecords<String,Byke> record= consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String,Byke> consumerrecord : record)
            {

//                if(consumerrecord.value()!=null){
                    System.out.println( "key:" +consumerrecord.key()+" "+"value:"+consumerrecord.value().toString()+" "+consumerrecord.topic());
//                }

                }
            }

        }



    }

