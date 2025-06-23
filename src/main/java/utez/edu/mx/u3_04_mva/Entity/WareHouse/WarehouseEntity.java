package utez.edu.mx.u3_04_mva.Entity.WareHouse;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Entity.Client.ClientEntity;

import java.time.LocalDate;

@Entity
@Data
public class WarehouseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String code;
    private LocalDate registrationDate;

    @NotNull
    private double salePrice;
    @NotNull
    private double rentalPrice;

    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne
    private BranchEntity branch;
    @ManyToOne(optional = false)
    private ClientEntity owner;
    @ManyToOne
    private ClientEntity client;

    @Enumerated(EnumType.STRING)
    @NotNull
    private WarehouseStatus status;

    public enum Size {
        G, M, P
    }
    public enum WarehouseStatus {
        DISPONIBLE,
        RENTADO,
        VENDIDO
    }
    public void generateCode() {
        this.registrationDate = LocalDate.now();
        this.code = branch.getCode() + "-A" + id;
    }

    public String moviment() {
        StringBuilder sb = new StringBuilder("Movement log → ");

        sb.append("Warehouse [").append(code != null ? code : "UNASSIGNED").append("] ");
        sb.append("is currently ").append(status);

        if (status == WarehouseStatus.RENTADO && client != null) {
            sb.append(" by client: ").append(client.getFullName());
        } else if (status == WarehouseStatus.VENDIDO && owner != null) {
            sb.append(" and owned by: ").append(owner.getFullName());
        }

        sb.append(" | Registered on: ").append(registrationDate != null ? registrationDate : "N/A");

        return sb.toString();
    }

}
