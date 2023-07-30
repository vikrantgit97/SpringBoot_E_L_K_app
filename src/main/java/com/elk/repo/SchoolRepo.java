package com.elk.repo;

import com.elk.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */
public interface SchoolRepo extends JpaRepository<School,Byte> {

}