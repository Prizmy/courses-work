package ru.sinforge.practice5.Service;


import ru.sinforge.practice5.Entity.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> findAll();
    Application add(Application application);
    Application findById(Long id);
}