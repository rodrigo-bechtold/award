package com.rodrigo.award.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Entity()
@Table(name = "NOMINATION")
public class NominationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "nomination_year")
    private short year;

    @Column(nullable = false, length = 255)
    private String title;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "nominations_studios",
            joinColumns = @JoinColumn(name = "nomination_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private Set<StudioModel> studios;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "nominations_producers",
            joinColumns = @JoinColumn(name = "nomination_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private Set<ProducerModel> producers;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean winner;

    @Override
    public String toString() {
        return "NominationModel{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", winner=" + winner +
                '}';
    }
}
