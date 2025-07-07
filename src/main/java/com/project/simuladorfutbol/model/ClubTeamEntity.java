package com.project.simuladorfutbol.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@DiscriminatorValue("CLUB")
public class ClubTeamEntity extends TeamEntity {

    private String league;

    public ClubTeamEntity() {
        super();
    }

    public ClubTeamEntity(String name, String code, int score, String league) {
        super(name, code, score);
        this.league = league;
    }
}
