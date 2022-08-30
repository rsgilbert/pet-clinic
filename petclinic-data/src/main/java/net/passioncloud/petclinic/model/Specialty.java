package net.passioncloud.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Specialty extends BaseEntity {
    private String description;

    public Specialty(String description) {
        this.description = description;
    }
}
