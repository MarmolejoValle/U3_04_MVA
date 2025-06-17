package utez.edu.mx.u3_04_mva.Service.Branch;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServices {
    private final BranchRepository branchRepository;

    public BranchServices(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<BranchEntity> getBranches(){
      return  branchRepository.findAll();
    }

    public BranchEntity add(BranchEntity branch){
        return branchRepository.save(branch);
    }
}
