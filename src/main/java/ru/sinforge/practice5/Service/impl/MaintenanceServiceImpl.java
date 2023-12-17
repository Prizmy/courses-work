package ru.sinforge.practice5.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sinforge.practice5.Entity.Maintenance;
import ru.sinforge.practice5.Repository.MaintenanceRepository;
import ru.sinforge.practice5.Service.MaintenanceService;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    private final MaintenanceRepository repository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maintenance add(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    @Override
    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    @Override
    public Maintenance findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
