package com.project.simuladorfutbol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "team")
@DiscriminatorColumn(name = "team_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String code;

    private int score;

    public TeamEntity() {}

    public TeamEntity(String name, String code, int score) {
        this.name = name;
        this.code = code;
        this.score = score;
    }
}
