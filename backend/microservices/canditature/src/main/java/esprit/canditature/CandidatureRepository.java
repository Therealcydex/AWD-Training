package esprit.canditature;
import esprit.canditature.entity.Candidature;
import esprit.canditature.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {

    // Recherche par Job
    List<Candidature> findByJobId(int jobId);

    // Recherche par Candidat
    List<Candidature> findByCandidatId(int candidatId);

    // Recherche par Status
    List<Candidature> findByStatus(Status status);
}
