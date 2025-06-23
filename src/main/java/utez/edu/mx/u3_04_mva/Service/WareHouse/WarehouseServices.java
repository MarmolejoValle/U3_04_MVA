package utez.edu.mx.u3_04_mva.Service.WareHouse;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;
import utez.edu.mx.u3_04_mva.Entity.Transactions.TransactionsEntity;
import utez.edu.mx.u3_04_mva.Entity.Transactions.TransactionsRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WareHouseRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;
import utez.edu.mx.u3_04_mva.Service.Branch.BranchServices;

import java.util.List;

@Service
public class WarehouseServices {
    private final WareHouseRepository wareHouseRepository;
    private final BranchRepository branchRepository;
    private final TransactionsRepository transactionsRepository;


    public WarehouseServices(WareHouseRepository wareHouseRepository, BranchRepository branchRepository, TransactionsRepository transactionsRepository) {
        this.wareHouseRepository = wareHouseRepository;
        this.branchRepository = branchRepository;
        this.transactionsRepository = transactionsRepository;
    }
    public List<WarehouseEntity> getWarehouses(){
        return wareHouseRepository.findAll();
    }

    public WarehouseEntity add(WarehouseEntity warehouseEntity){
        warehouseEntity.setBranch(branchRepository.findById(warehouseEntity.getBranch().getId()).get());
        WarehouseEntity newWareHouse =  wareHouseRepository.save(warehouseEntity);
        newWareHouse.generateCode();
        return wareHouseRepository.save(newWareHouse);
    }
    public WarehouseEntity update(WarehouseEntity warehouseEntity){

        if (warehouseEntity.getStatus().name().equals("VENDIDO") || warehouseEntity.getStatus().name().equals("DISPONIBLE")){
            warehouseEntity.setClient(null);
        }
        WarehouseEntity newWareHouse =  wareHouseRepository.save(warehouseEntity);
        transactionsRepository.save(new TransactionsEntity(newWareHouse.moviment()));
        return newWareHouse;
    }
    public String delete(Long id){
        WarehouseEntity warehouse = wareHouseRepository.findById(id).get();
        wareHouseRepository.delete(warehouse);
        return "Deleted successfully";
    }

}
