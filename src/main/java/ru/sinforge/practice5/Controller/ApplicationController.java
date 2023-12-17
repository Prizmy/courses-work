package ru.sinforge.practice5.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sinforge.practice5.DTO.ApplicationDTO;
import ru.sinforge.practice5.Entity.Application;
import ru.sinforge.practice5.Entity.Maintenance;
import ru.sinforge.practice5.Service.ApplicationService;
import ru.sinforge.practice5.Service.MaintenanceService;
import ru.sinforge.practice5.Service.impl.EmailService;

import java.util.List;
import java.util.Objects;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;
    private final EmailService emailService;
    private final MaintenanceService maintenanceService;

    @Autowired
    public ApplicationController(ApplicationService applicationService,
                                 EmailService emailService,
                                 MaintenanceService maintenanceService) {
        this.applicationService = applicationService;
        this.emailService = emailService;
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("/application")
    public String createApplication(@ModelAttribute("application") ApplicationDTO applicationDTO) {

        Maintenance maintenance = maintenanceService.findById(applicationDTO.getId_maintenance());

        emailService.sendEmail(applicationDTO.getEmail(),
                "Заявка",
                "Уважаемый " + applicationDTO.getFirstName()
                        + " " + applicationDTO.getSecondName() +
                        ", ваша заявка на услугу " + maintenance.getName() +
                        " на следующую дату: " + applicationDTO.getDate() +
                        " была принята. Ожидаем вас в указанный день!");
        Application application = new Application(null,
                applicationDTO.date,
                applicationDTO.email,
                applicationDTO.firstName,
                applicationDTO.secondName,
                maintenance);
        applicationService.add(application);
        return "redirect:/application";
    }
    @GetMapping("/application")
    public String getApplicationPage(Model model, ApplicationDTO applicationDTO) {

        List<Maintenance> maintenances = maintenanceService.findAll();
        model.addAttribute("application", applicationDTO);
        model.addAttribute("maintenances", maintenances);
        return "applicationPage";
    }

}
