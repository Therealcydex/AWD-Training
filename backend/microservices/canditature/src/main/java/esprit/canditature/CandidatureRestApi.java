package esprit.canditature;
import esprit.canditature.dto.Candidat;
import esprit.canditature.dto.CandidatureResponse;
import esprit.canditature.dto.Job;
import esprit.canditature.entity.Candidature;
import esprit.canditature.entity.Status;
import esprit.canditature.feignClient.CandidatClient;
import esprit.canditature.feignClient.JobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mic3/candidature")
public class CandidatureRestApi {

    @GetMapping ("/hello")
    public String sayHello() {

        return "Hello Im microservice 3!";
    }
    @Autowired
    private CandidatureService service;

    @Autowired
    private JobClient jobClient;

    @Autowired
    private CandidatClient candidatClient;

    // CREATE
    @PostMapping
    public Candidature create(@RequestBody Candidature c) {
        return service.create(c);
    }

    // GET ALL
    @GetMapping
    public List<Candidature> getAll() {
        return service.getAll();
    }

    // GET BY JOB
    @GetMapping("/job/{jobId}")
    public List<Candidature> getByJob(@PathVariable int jobId) {
        return service.getByJob(jobId);
    }


    // Full get
    @GetMapping(value = "/{id}/details", produces = "application/json")
    public CandidatureResponse getDetails(@PathVariable int id) {

        Candidature c = service.getById(id);

        Job job = jobClient.getById(c.getJobId());
        Candidat candidat = candidatClient.getCandidat(c.getCandidatId());

        return new CandidatureResponse(c, job, candidat);
    }

    // UPDATE STATUS
    @PutMapping("/{id}/{status}")
    public Candidature updateStatus(@PathVariable int id,
                                    @PathVariable Status status) {
        return service.updateStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}


