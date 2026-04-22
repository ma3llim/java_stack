package com.sameer.spring_data_rest.repo;

import com.sameer.spring_data_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    //List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
