package com.educational.service;

import com.educational.model.CurriculumModel;
import com.educational.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public CurriculumModel save(CurriculumModel curriculum) {
        return curriculumRepository.save(curriculum);
    }

    public Optional<CurriculumModel> findById(Long id) {
        return curriculumRepository.findById(id);
    }

    public List<CurriculumModel> findAll() {
        return curriculumRepository.findAll();
    }

    public void deleteById(Long id) {
        curriculumRepository.deleteById(id);
    }

    public CurriculumModel update(CurriculumModel curriculum) {
        return curriculumRepository.save(curriculum);
    }
}
