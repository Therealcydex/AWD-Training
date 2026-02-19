package esprit.canditature.feignClient;

import esprit.canditature.dto.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="JOB")
public interface JobClient {
    @RequestMapping("/mic2/job")
    public List<Job> getAll();

    @RequestMapping("/mic2/job/{id}")
    public Job getById(@PathVariable int id);

}
