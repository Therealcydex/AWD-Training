package esprit.canditature;

import esprit.canditature.entity.Candidature;
import esprit.canditature.entity.Status;
import esprit.canditature.feignClient.CandidatClient;
import esprit.canditature.feignClient.JobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepository repository;

    @Autowired
    private JobClient jobClient;

    @Autowired
    private CandidatClient candidatClient;

    // CREATE
    public Candidature create(Candidature candidature) {

        // Vérification que Job existe
        jobClient.getById(candidature.getJobId());

        // Vérification que Candidat existe
        candidatClient.getCandidat(candidature.getCandidatId());

        return repository.save(candidature);
    }

    // READ ALL
    public List<Candidature> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Candidature getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidature not found"));
    }

    // UPDATE STATUS
    public Candidature updateStatus(int id, Status status) {
        Candidature c = getById(id);
        c.setStatus(status);
        return repository.save(c);
    }

    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }

    // SEARCH
    public List<Candidature> getByJob(int jobId) {
        return repository.findByJobId(jobId);
    }

    public List<Candidature> getByCandidat(int candidatId) {
        return repository.findByCandidatId(candidatId);
    }
}
