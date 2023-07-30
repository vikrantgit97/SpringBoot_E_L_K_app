package com.elk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private Byte id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "school_id")
    private School school;

}
