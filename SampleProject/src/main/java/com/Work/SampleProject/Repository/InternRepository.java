package com.Work.SampleProject.Repository;

import com.Work.SampleProject.Model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern,Integer>
{

}