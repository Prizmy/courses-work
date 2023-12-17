package ru.sinforge.practice5.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Maintenance {
    @Id
    @SequenceGenerator(name = "maintenance_seq", sequenceName =
            "maintenance_sequence", allocationSize = 1)
    @GeneratedValue(generator = "maintenance_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "maintenance")
    @JsonIgnore
    private List<Application> applications;

    @Override
    public String toString() {
        return name;
    }
}
