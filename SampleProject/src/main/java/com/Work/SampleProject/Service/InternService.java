package com.Work.SampleProject.Service;

import com.Work.SampleProject.Model.Intern;
import com.Work.SampleProject.Model.Manager;
import com.Work.SampleProject.Repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternService
{
    @Autowired
    private InternRepository internRepository;

    public Intern addIntern(Intern intern) {
        Intern data = internRepository.save(intern);
        return data;
    }

    public List<Intern> getAllManager() {
        return internRepository.findAll();
    }


    public Intern updateIntern(Intern updateIntern) {

        return internRepository.save(updateIntern);
    }

    public Intern findInternById(int id) {
        Optional<Intern> optional = internRepository.findById(id);
        if (optional.isPresent()) {
            // value is present inside Optional
            return optional.get();
        } else {
            return null;
        }
    }
}

