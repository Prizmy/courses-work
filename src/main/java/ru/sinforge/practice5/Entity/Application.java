package ru.sinforge.practice5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @SequenceGenerator(name = "apps_seq", sequenceName =
            "apps_sequence", allocationSize = 1)
    @GeneratedValue(generator = "apps_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String email;
    private String firstName;
    private String secondName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    public Maintenance maintenance;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", date=" + date +
                ", email=" + email +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
