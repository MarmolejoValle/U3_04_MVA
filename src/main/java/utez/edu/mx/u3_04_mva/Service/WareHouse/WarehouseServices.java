package utez.edu.mx.u3_04_mva.Service.WareHouse;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WareHouseRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;
import utez.edu.mx.u3_04_mva.Service.Branch.BranchServices;

import java.util.List;

@Service
public class WarehouseServices {
    private final WareHouseRepository wareHouseRepository;
    private final BranchRepository branchRepository;


    public WarehouseServices(WareHouseRepository wareHouseRepository, BranchRepository branchRepository) {
        this.wareHouseRepository = wareHouseRepository;
        this.branchRepository = branchRepository;
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

        if (warehouseEntity.getStatus().name().equals("VENDIDO")){
            warehouseEntity.setClient(null);
        }
        return wareHouseRepository.save(warehouseEntity);
    }
    public String delete(Long id){
        WarehouseEntity warehouse = wareHouseRepository.findById(id).get();
        wareHouseRepository.delete(warehouse);
        return "Deleted successfully";
    }

}
