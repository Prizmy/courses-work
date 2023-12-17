package ru.sinforge.practice5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sinforge.practice5.DTO.MaintenanceDTO;
import ru.sinforge.practice5.Entity.Maintenance;
import ru.sinforge.practice5.Service.ApplicationService;
import ru.sinforge.practice5.Service.MaintenanceService;

@Controller
@RequestMapping("/admin/panel")
public class AdminController {
    private final MaintenanceService maintenanceService;
    private final ApplicationService applicationService;

    @Autowired
    public AdminController(MaintenanceService maintenanceService,
                           ApplicationService applicationService) {
        this.maintenanceService = maintenanceService;
        this.applicationService = applicationService;
    }

    @GetMapping("")
    public String getAllData(Model model) {
        model.addAttribute("maintenances", maintenanceService.findAll());
        model.addAttribute("applications", applicationService.findAll());
        model.addAttribute("newMaintenance", new MaintenanceDTO());
        return "admin/panel";
    }
    @PostMapping("")
    public String addMaintenance(@ModelAttribute("newMaintenance") MaintenanceDTO maintenanceDTO){
        Maintenance maintenance = new Maintenance(null,
                maintenanceDTO.name,
                maintenanceDTO.price, null);
        maintenanceService.add(maintenance);
        return "redirect:/admin/panel";
    }
}
