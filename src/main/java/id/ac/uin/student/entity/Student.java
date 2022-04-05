package id.ac.uin.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "First Name is required")
    @NotNull(message = "FirstName can not be null!!")
    @Column(nullable = false, name = "first_Name")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @NotNull(message = "LastName can not be null!!")
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotEmpty(message = "Phone is required")
    @NotNull(message = "Phone can not be null!!")
    @Size(max = 13, min = 10, message = "Mobile number should be of 10 digits")
    @Column(name = "phone_number", unique = true)
    private String phone;

    @NotEmpty(message = "Jurusan is required")
    @Column(nullable = false, unique = true)
    private String jurusan;

}
