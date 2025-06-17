package utez.edu.mx.u3_04_mva.Service.WareHouse;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WareHouseRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;

import java.util.List;

@Service
public class WarehouseServices {
    private final WareHouseRepository wareHouseRepository;


    public WarehouseServices(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }
    public List<WarehouseEntity> getWarehouses(){
        return wareHouseRepository.findAll();
    }

    public WarehouseEntity add(WarehouseEntity warehouseEntity){
        return wareHouseRepository.save(warehouseEntity);
    }

}
