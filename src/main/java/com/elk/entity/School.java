package com.elk.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    private Byte id;
    private String name;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> studentList;

}
