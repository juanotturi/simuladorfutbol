package com.project.simuladorfutbol.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@DiscriminatorValue("NATIONAL")
public class NationalTeamEntity extends TeamEntity {

    @Column(name = "confederation")
    private String confederation;

    public NationalTeamEntity() {
        super();
    }

    public NationalTeamEntity(String name, String code, int score, String confederation) {
        super(name, code, score);
        this.confederation = confederation;
    }
}
