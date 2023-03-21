package com.Work.SampleProject.Service;

import com.Work.SampleProject.Model.Manager;
import com.Work.SampleProject.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService
{
    @Autowired
    private ManagerRepository managerRepository;

    public Manager addManager(Manager manager) {
        Manager data = managerRepository.save(manager);
        return data;
    }

    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }


    public Manager updateManager(Manager updateManager) {

        return managerRepository.save(updateManager);
    }

    public Manager findManagerById(int id) {
        Optional<Manager> optional = managerRepository.findById(id);
        if (optional.isPresent()) {
            // value is present inside Optional
            return optional.get();
        } else {
            return null;
        }
    }
}

