package utez.edu.mx.u3_04_mva.Entity.Client;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;

import java.time.LocalDate;
@Entity
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String fullName;
    @NotBlank
    @Size(min = 10, max = 12)
    private String phoneNumber;
    @NotBlank
    @Email
    private String email;


}
