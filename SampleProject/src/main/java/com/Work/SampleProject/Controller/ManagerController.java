package com.Work.SampleProject.Controller;

import com.Work.SampleProject.Model.Manager;
import com.Work.SampleProject.Repository.ManagerRepository;
import com.Work.SampleProject.Service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    Logger logger = LoggerFactory.getLogger(InternController.class);

    @Autowired
    private ManagerService managerService;
    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping("/check")
    public String check() {
        return "home";
    }
        @RequestMapping("/getAllData")
        public List<Manager> getAllData()
        {
            logger.info(" API Call Hit - /getAllData");
            logger.info("All Course List - {}",managerService.getAllManager());
            return managerService.getAllManager();
        }
        @PostMapping("/addManager")
        Manager newManager(@RequestBody Manager newManager) {
            logger.info("API Call  - /addManager ");
            logger.info("New Course Added {}",newManager);

            return managerService.addManager(newManager);
        }

        @RequestMapping("/find/{id}")
        public Optional<Manager> getAllData(@PathVariable int id)
        {
            logger.info(" API Call Hit - /find{}",id);
            logger.info("All Course List - {}",managerService.findManagerById(id));
            return Optional.ofNullable(managerService.findManagerById(id));
        }

        @PutMapping("/update/{id}")
        Manager updateData(@RequestBody Manager updatedManager, @PathVariable int id) throws Exception {
            Manager fromdb = managerService.findManagerById(id);
            if(fromdb!=null) {
                if(updatedManager.getEmail()!=null)
                    fromdb.setEmail(updatedManager.getEmail());
                if(updatedManager.getMobile()!=null)
                    fromdb.setMobile(updatedManager.getMobile());
                if(updatedManager.getName()!=null)
                    fromdb.setName(updatedManager.getName());
                return managerRepository.save(fromdb);
            }
            else {
                throw new Exception("Manager Not Present In DataBase");

            }
        }
    }

