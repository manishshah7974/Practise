package com.Work.SampleProject.Controller;
import com.Work.SampleProject.Model.Intern;
import com.Work.SampleProject.Repository.InternRepository;
import com.Work.SampleProject.Service.InternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/intern")
public class InternController {
    Logger logger = LoggerFactory.getLogger(InternController.class);

    @Autowired
    private InternRepository internRepository;
    @Autowired
    private InternService internService;

    @RequestMapping("/check")
    public String check() {
        return "home";
    }
        @RequestMapping("/getAllData")
        public List<Intern> getAllData()
        {
            logger.info(" API Call Hit - /getAllData");
            logger.info("All Course List - {}",internService.getAllManager());
            return internService.getAllManager();
        }
        @PostMapping("/addIntern")
        Intern newIntern(@RequestBody Intern newIntern) {
            logger.info("API Call  - /addManager ");
            logger.info("New Course Added {}",newIntern);

            return internService.addIntern(newIntern);
        }

        @RequestMapping("/find/{id}")
        public Optional<Intern> getAllData(@PathVariable int id)
        {
            logger.info(" API Call Hit - /find{}",id);
            logger.info("All Course List - {}",internService.findInternById(id));
            return Optional.ofNullable(internService.findInternById(id));
        }



        @PutMapping("/update/{id}")
        Intern updateData(@RequestBody Intern updatedIntern, @PathVariable int id) throws Exception {
            Intern fromdb = internService.findInternById(id);
            if(fromdb!=null) {
                if(updatedIntern.getEmail()!=null)
                    fromdb.setEmail(updatedIntern.getEmail());
                if(updatedIntern.getMobile()!=null)
                    fromdb.setMobile(updatedIntern.getMobile());
                if(updatedIntern.getName()!=null)
                    fromdb.setName(updatedIntern.getName());
                if(updatedIntern.getManager_id()!=null)
                    fromdb.setManager_id(updatedIntern.getManager_id());
                if(updatedIntern.getCourse_id()!=null)
                    fromdb.setCourse_id(updatedIntern.getCourse_id());
                return internRepository.save(fromdb);
            }
            else {
                throw new Exception("Manager Not Present In DataBase");

            }
        }
    }