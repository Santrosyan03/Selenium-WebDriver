package database.management.system.databasemanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "nation")
    private String nation;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "freeDay")
    private String freeDay;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "specialization")
    private String specialization;
}
