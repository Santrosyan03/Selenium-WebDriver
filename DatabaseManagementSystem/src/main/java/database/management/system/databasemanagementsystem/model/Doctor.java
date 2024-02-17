package database.management.system.databasemanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "nation")
    private String nation;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "free_day")
    private String free_day;
}