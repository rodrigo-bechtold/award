package com.rodrigo.award.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@Data
@Entity()
@Table(name = "STUDIO")
@NoArgsConstructor
public class StudioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255, unique = true)
    private String name;

    public StudioModel(String name){
        this.name = name;
    }
}
