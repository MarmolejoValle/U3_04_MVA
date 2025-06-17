package utez.edu.mx.u3_04_mva.Entity.WareHouse;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Entity
@Data
public class WarehouseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private LocalDate registrationDate;
    @NotBlank
    private double salePrice;
    @NotBlank
    private double rentalPrice;

    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne
    private BranchEntity branch;
    @ManyToOne
    private ClientEntity client;

    public enum Size {
        G, M, P
    }

    @PrePersist
    public void generateCode() {
        this.registrationDate = LocalDate.now();
        this.code = branch.getCode() + "-A" + id;
    }

}
