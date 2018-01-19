package eurekademo;

import eurekademo.Entities.Visit;
import eurekademo.Repositories.VisitRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;
import java.time.LocalDateTime;

@RestController
public class ApiController {
    private final VisitRepository visitsRepository;

    public ApiController(VisitRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }
@RequestMapping("/create")
    public String test(){
    Visit visit = new Visit();
    visit.description = String.format("Visited at %s", LocalDateTime.now());
    visitsRepository.save(visit);
    return String.format("Visited at %s", LocalDateTime.now());
}
@RequestMapping("/getvisits")
    public Iterable<Visit> getVisits(){ return visitsRepository.findAll();    }

    @RequestMapping("/getById")
    public Visit getById(@DefaultValue("1") String id){
        long val = Long.parseLong(id);
        return visitsRepository.findOne(val);
    }
}
