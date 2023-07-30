package com.elk.service;

import com.elk.entity.School;
import com.elk.repo.SchoolRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Vikrant_Gopewar on 30-07-2023
 * @Project SpringBoot_E_L_K
 */


@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Byte id) {
        return schoolRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(" id not found "));
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public School updateSchool(Byte id,School school) {
        School school1 = schoolRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" id not found "));
        return schoolRepository.save(school);
    }

    public void deleteSchool(Byte id) {
        schoolRepository.deleteById(id);
    }
}

