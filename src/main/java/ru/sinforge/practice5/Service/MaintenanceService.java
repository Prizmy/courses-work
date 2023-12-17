package ru.sinforge.practice5.Service;

import ru.sinforge.practice5.Entity.Maintenance;

import java.util.List;

public interface MaintenanceService {
    Maintenance add(Maintenance maintenance);
    List<Maintenance> findAll();
    Maintenance findById(Long id);
    void deleteById(Long id);
}
