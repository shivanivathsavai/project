package com.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {

    public static void main(String args[])
    {

        Logger logger = LoggerFactory.getLogger(Producer.class);

        /*setting producer properties*/

        Properties prop =new Properties();
      prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
      prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
      prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"com.kafka.producer.BykeSerializer");

      /*creating object for byke class*/

        Byke byke = new Byke(13,"Honda");

        /*creating producer object*/

      KafkaProducer<String,Byke> producer = new KafkaProducer<String,Byke>(prop);

        /*constructing producerrecord*/

        ProducerRecord<String,Byke> record = new ProducerRecord<String,Byke>("producer12",byke);

      /*sending messages*/

      producer.send(record);
      System.out.println(record.topic());
      System.out.println(record.value());
      producer.flush();
      producer.close();
    }
}
