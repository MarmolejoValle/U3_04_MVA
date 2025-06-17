package utez.edu.mx.u3_04_mva.Controller.WareHouse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;
import utez.edu.mx.u3_04_mva.Entity.WareHouse.WarehouseEntity;
import utez.edu.mx.u3_04_mva.Service.WareHouse.WarehouseServices;

import java.util.List;

@RestController
@RequestMapping(("/api/warehouses/"))
public class WarehouseController {
    private final WarehouseServices warehouseServices;

    public WarehouseController(WarehouseServices warehouseServices) {
        this.warehouseServices = warehouseServices;
    }

    @GetMapping()
    public ResponseEntity<List<WarehouseEntity>>  getAllWarehouses(){
        return ResponseEntity.ok(warehouseServices.getWarehouses());
    }
    @PostMapping()
    public ResponseEntity<WarehouseEntity>  addWarehouse(@Valid @RequestBody WarehouseEntity warehouseEntity){
        return ResponseEntity.ok().body(warehouseServices.add(warehouseEntity));
    }
}
