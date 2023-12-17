package ru.sinforge.practice5.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sinforge.practice5.Entity.Application;
import ru.sinforge.practice5.Repository.ApplicationRepository;
import ru.sinforge.practice5.Service.ApplicationService;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository repository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Application> findAll() {
        return repository.findAll();
    }

    @Override
    public Application add(Application application) {
        System.out.println(application);
        return repository.save(application);
    }

    @Override
    public Application findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
