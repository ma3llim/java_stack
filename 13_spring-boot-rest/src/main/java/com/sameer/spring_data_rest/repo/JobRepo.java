package com.sameer.spring_data_rest.repo;

import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    //List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
