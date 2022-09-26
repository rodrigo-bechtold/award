package com.rodrigo.award.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity()
@Table(name = "PRODUCER")
@NoArgsConstructor
public class ProducerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255, unique = true)
    private String name;

    public ProducerModel(String name){
        this.name = name;
    }
}
