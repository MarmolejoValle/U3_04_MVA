package utez.edu.mx.u3_04_mva.Controller.Transactions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.u3_04_mva.Entity.Transactions.TransactionsEntity;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;
import utez.edu.mx.u3_04_mva.Service.Transactions.TransactionsServices;

import java.util.List;

@RestController
@RequestMapping(("/api/transactions/"))
public class TransactionsControllers {
    private final TransactionsServices  transactionsServices;

    public TransactionsControllers(TransactionsServices transactionsServices) {
        this.transactionsServices = transactionsServices;
    }

    @GetMapping
    public ResponseEntity<List<TransactionsEntity>> getTransactions() {
        return ResponseEntity.ok().body(transactionsServices.all());
    }
}
