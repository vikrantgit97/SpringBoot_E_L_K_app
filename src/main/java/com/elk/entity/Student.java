package com.elk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Pattern(regexp = "^[A-Za-z]", message="Invalid firstName")
    private String firstName;

    //@Pattern(regexp = "^[A-Za-z]", message="Invalid lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

}
