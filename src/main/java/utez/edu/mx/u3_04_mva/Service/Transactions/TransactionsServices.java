package utez.edu.mx.u3_04_mva.Service.Transactions;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Transactions.TransactionsEntity;
import utez.edu.mx.u3_04_mva.Entity.Transactions.TransactionsRepository;
import java.util.List;

@Service
public class TransactionsServices {
    private final TransactionsRepository transactionsRepository;

    public TransactionsServices(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<TransactionsEntity> all(){
        return transactionsRepository.findAll();
    }
}
