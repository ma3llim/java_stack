package Generic.StudentGradeManagement;

import Generic.StudentGradeManagement.model.Student;
import Generic.StudentGradeManagement.service.GradeService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GradeService gradeService = new GradeService();
        Map<String, List<Integer>> rawGrades = new HashMap<>();
        rawGrades.put("Alice", Arrays.asList(85, 90, 92));
        rawGrades.put("Bob", Arrays.asList(45, 52, 38));
        rawGrades.put("Charlie", Arrays.asList(95, 98, 100));
        rawGrades.put("David", Arrays.asList(70, 68, 75));
        rawGrades.put("Emma", Arrays.asList(30, 40, 35));
        rawGrades.put("Frank", Arrays.asList(85, 90, 92));

        List<Student> students = gradeService.processRawGrades(rawGrades);

        System.out.println("--- Student Grade Metrics ---");
        for(Student s : students){
            System.out.println(s);
        }


        System.out.println("\n --- Leaderboard Rankings (TreeMap) ---");
        TreeMap<Student, String> rankings = gradeService.rankStudents(students);

        int rank = 1;
        for(Student s : rankings.keySet()){
            System.out.printf("Rank %d: %s (Average: %.2f)\n", rank, s.getName(), s.getAverage());
            rank++;
        }

        System.out.println("\n --- Failed Students (Average < 50.0) ---");
        double passingThreshold = 50.0;
        List<Student> failures = gradeService.getFailedStudents(students, passingThreshold);

        if(failures.isEmpty()){
            System.out.println("No students failed.");
        } else {
            for(Student s : failures){
                System.out.printf("%s failed with an average of %.2f\n", s.getName(), s.getAverage());
            }
        }

        System.out.println("\n --- Top 3 Students (PriorityQueue) ---");
        List<Student> topThree = gradeService.getTopStudents(students, 3);
        for (int i = 0; i < topThree.size(); i++){
            Student s = topThree.get(i);
            System.out.printf("#%d: %s with Average: %.2f\n", (i+1), s.getName(), s.getAverage());
        }

        System.out.println("\n --- Get Student Name ---");
        List<String> getStudentsName = gradeService.getStudentList(students);
        System.out.println(getStudentsName);

        System.out.println("\n --- Top Scorer ---");
        Optional<Student> getTopScoretResult = gradeService.getTopScore(students);
        System.out.println(getTopScoretResult);
    }
}
