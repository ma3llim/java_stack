package com.sameer.spring_boot_rest.repositories;

import com.sameer.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}

//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Java Developer", "2026‑04‑01", 3, List.of("Java", "Spring Boot", "JSP", "Maven"), "Develop and maintain backend Java applications using Spring Boot and JSP"),
//            new JobPost(2, "Frontend Developer", "2026‑03‑28", 2, List.of("HTML", "CSS", "JavaScript", "React"), "Build responsive and interactive user interfaces using modern frontend technologies"),
//            new JobPost(3, "Data Analyst", "2026‑03‑25", 4, List.of("Python", "SQL", "Pandas", "Excel"), "Analyze datasets and create reports to support business decisions"),
//            new JobPost(4, "DevOps Engineer", "2026‑03‑20", 5, List.of("Docker", "Kubernetes", "AWS", "Jenkins"), "Implement and manage CI/CD pipelines and cloud infrastructure"),
//            new JobPost(5, "UI/UX Designer", "2026‑03‑18", 2, List.of("Figma", "Adobe XD", "Sketch", "Prototyping"), "Design user‑friendly interfaces and user experiences for web and mobile apps")
//    ));
//
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    public void addJob(JobPost newJob) {
//        jobs.add(newJob);
//    }
//
//    public JobPost getJobs(int postId) {
//        for (JobPost job : jobs) {
//            if (job.getPostId() == postId) {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for (JobPost jobPost1 : jobs) {
//            if (jobPost1.getPostId() == jobPost.getPostId()) {
//                jobPost1.setPostId(jobPost.getPostId());
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//                jobPost1.setPostDate(jobPost.getPostDate());
//                jobPost1.setReqExperience(jobPost.getReqExperience());
//                jobPost1.setPostTechStack(jobPost.getPostTechStack());
//                jobPost1.setPostDesc(jobPost.getPostDesc());
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
//        for (JobPost job3 : jobs) {
//            if (job3.getPostId() == postId) {
//                jobs.remove(postId);
//            }
//        }
//    }