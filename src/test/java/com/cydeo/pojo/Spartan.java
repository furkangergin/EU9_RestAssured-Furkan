package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonIgnoreProperties(value = "id",allowSetters = true) //başka pojo class oluşturup 3 field da koyabilirdik
                                                        // serialization yapınca ignore et demek (annotation to tell only deserialize, do NOT serialize. )
public class Spartan {
    //getter setter
    //toString
    private int id;
    private String name;
    private String gender;
    private long phone;


}
