package utez.edu.mx.u3_04_mva.Controller.Branch;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Service.Branch.BranchServices;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/branches/")
public class BranchContoller {
    private final BranchServices branchServices;

    public BranchContoller(BranchServices branchServices) {
        this.branchServices = branchServices;
    }

    @GetMapping()
    public ResponseEntity<List<BranchEntity>> getBranches(){
        return ResponseEntity.ok().body(branchServices.getBranches());
    }
    @PostMapping()
    public ResponseEntity<BranchEntity> addBranch(@RequestBody BranchEntity branchEntity){
        return ResponseEntity.ok().body(branchServices.add(branchEntity));
    }
    @PutMapping()
    public ResponseEntity<BranchEntity> updateBranch(@Validated @RequestBody BranchEntity branchEntity){
        return ResponseEntity.ok().body(branchServices.update(branchEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id){
        return ResponseEntity.ok().body(branchServices.delete(id));
    }

}
