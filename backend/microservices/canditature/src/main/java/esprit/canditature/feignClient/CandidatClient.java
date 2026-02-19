package esprit.canditature.feignClient;

import esprit.canditature.dto.Candidat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CANDIDAT")
public interface CandidatClient {

    @GetMapping("/mic1/candidats/{id}")
    Candidat getCandidat(@PathVariable int id);
}
