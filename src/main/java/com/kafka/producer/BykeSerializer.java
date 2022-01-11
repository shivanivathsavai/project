package com.kafka.producer;

import com.sun.net.httpserver.Headers;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class BykeSerializer implements org.apache.kafka.common.serialization.Serializer {

    public void configure(Map configs, boolean iskey){

      }

    public byte[] serialize(String s, Object ob) {

        try {
            Byke byke = (Byke) ob;
            ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(byke);
            objectOutputStream.close();
            byte[] b = byteArrayOutputStream.toByteArray();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }




    public void close() {

    }
}

