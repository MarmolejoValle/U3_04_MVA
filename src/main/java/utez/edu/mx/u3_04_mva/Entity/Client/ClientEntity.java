package utez.edu.mx.u3_04_mva.Entity.Client;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    private String fullName;
    private String phoneNumber;
    private String email;


}
