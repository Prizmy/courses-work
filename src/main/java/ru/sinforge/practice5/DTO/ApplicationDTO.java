package ru.sinforge.practice5.DTO;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ApplicationDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date date;
    public Long id_maintenance;
    public String email;
    public String firstName;
    public String secondName;
}
