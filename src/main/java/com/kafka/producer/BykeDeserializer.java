package com.kafka.producer;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BykeDeserializer implements Deserializer<Byke> {

    @Override
    public Byke deserialize(String s, byte[] bytes) {

        try {
            if (bytes.length > 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    Byke byke = (Byke) objectInputStream.readObject();
                    objectInputStream.close();
                    return byke;
                }
            return null;

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return null;
        }

    }
}

