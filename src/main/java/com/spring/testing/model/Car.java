package com.spring.testing.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CARS")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    //RequiredArgConstructor is not working
    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
