package com.company.project.register.brand.application.usecases.find;

import com.company.project.register.brand.domain.Brand;
import com.company.project.register.brand.domain.exceptions.BrandNotFoundException;
import com.company.project.register.brand.domain.usecases.FindBrandByIdUseCase;
import com.company.project.register.brand.infrastructure.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class FindBrandByIdUseCaseImpl implements FindBrandByIdUseCase {

    private BrandRepository repository;

    @Autowired
    public FindBrandByIdUseCaseImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Brand execute(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException("The selected brand does not exist"));
    }

}