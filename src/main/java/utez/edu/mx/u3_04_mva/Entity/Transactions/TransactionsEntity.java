package utez.edu.mx.u3_04_mva.Entity.Transactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String moviment;
    public TransactionsEntity(String moviment) {
        this.moviment = moviment;
    }

    public TransactionsEntity() {

    }
}
