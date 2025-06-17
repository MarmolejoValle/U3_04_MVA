package utez.edu.mx.u3_04_mva.Service.Branch;

import org.springframework.stereotype.Service;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchEntity;
import utez.edu.mx.u3_04_mva.Entity.Branch.BranchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public BranchEntity update(BranchEntity branch){
        BranchEntity branchEntity = branchRepository.findById(branch.getId()).get();
        branch.generateCode();
        branchEntity.setCode(branch.getCode());
        branchEntity.setMunicipality(branch.getMunicipality());
        branchEntity.setState(branch.getState());
        return branchRepository.saveAndFlush(branchEntity);

    }
    public String delete(Long id){
        BranchEntity branchEntity = branchRepository.findById(id).get();
        branchRepository.delete(branchEntity);
        return "Deleted successfully";
    }
}
