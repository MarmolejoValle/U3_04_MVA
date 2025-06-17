package utez.edu.mx.u3_04_mva.Entity.Branch;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private String state;
    @NotBlank
    private String municipality;

    @PrePersist
    public void generateCode() {
        String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String randomDigits = String.format("%04d", new Random().nextInt(10000));
        this.code = "C"+ "-" + date + "-" + randomDigits;
    }
}
