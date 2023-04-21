package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducationalUnitService {

    @Autowired
    private EducationalUnitRepository educationalUnitRepository;

    public EducationalUnitModel save(EducationalUnitModel educationalUnit) {
        return educationalUnitRepository.save(educationalUnit);
    }

    public Optional<EducationalUnitModel> findById(Long id) {
        return educationalUnitRepository.findById(id);
    }

    public Page<EducationalUnitModel> findAll(Pageable pageable) {
        return educationalUnitRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        educationalUnitRepository.deleteById(id);
    }

    public EducationalUnitModel update(EducationalUnitModel educationalUnit) {
        return educationalUnitRepository.save(educationalUnit);
    }

    public Page<EducationalUnitModel> paginate(List<EducationalUnitModel> clienteResponseV2List, Pageable customPageable) {
        int inicio, fim;
        inicio = (int) customPageable.getOffset();
        fim = (inicio + customPageable.getPageSize()) > clienteResponseV2List.size() ? clienteResponseV2List.size() : (inicio + customPageable.getPageSize());
        return new PageImpl<>(clienteResponseV2List.stream().collect(Collectors.toList()).subList(inicio, fim), customPageable, clienteResponseV2List.size());
    }
}
