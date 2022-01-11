package com.kafka.producer;
import java.io.Serializable;
public class Byke  implements  Serializable {
    /*properties*/
    private int model;
    private String name;


    /*creating byke constructor*/
    Byke(int model, String name)
      {
          this.model=model;
          this.name=name;

      }
    /*getters and setters*/
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Byke{" +
                "model=" + model +
                ", name='" + name + '\'' +
                '}';
    }
}
