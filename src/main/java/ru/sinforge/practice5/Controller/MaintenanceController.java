package ru.sinforge.practice5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sinforge.practice5.DTO.MaintenanceDTO;
import ru.sinforge.practice5.Entity.Maintenance;
import ru.sinforge.practice5.Service.MaintenanceService;


@Controller
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("/maintenance/create")
    public Maintenance addMaintenance(@ModelAttribute("maintenance") MaintenanceDTO maintenanceDTO){
        Maintenance maintenance = new Maintenance(null,
                maintenanceDTO.name,
                maintenanceDTO.price, null);
        return maintenanceService.add(maintenance);
    }
    @DeleteMapping("/maintenance")
    public void deleteMaintenance(@RequestParam Long id){
        maintenanceService.deleteById(id);
    }

    @GetMapping("/")
    public String getAllMaintenances(Model model){
        model.addAttribute("maintenances", maintenanceService.findAll());
        return "home";
    }
}
