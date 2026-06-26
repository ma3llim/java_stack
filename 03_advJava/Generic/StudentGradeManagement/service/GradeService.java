package Generic.StudentGradeManagement.service;

import Generic.StudentGradeManagement.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class GradeService {
    // Converts HashMap data into a List of Student objects
    public List<Student> processRawGrades(Map<String, List<Integer>> rawGrades){
        return rawGrades.entrySet().stream().map(
                entry -> new Student(entry.getKey(), entry.getValue())
        ).toList();
    }

    // Ranks students using a TreeMap based on their natural sorting order
    public TreeMap<Student, String> rankStudents(List<Student> students){
        TreeMap<Student, String> rankedMap = new TreeMap<>();
        for(Student s: students){
            rankedMap.put(s, s.getName());
        }
        return rankedMap;
    }

    // Filters students using streams based on a passing threshold
    public List<Student> getFailedStudents(List<Student> students, double threehold){
        return students.stream().filter(s -> s.getAverage()< threehold).collect(Collectors.toList());
    }

    // Uses a PriorityQueue to extract the top N students (Max-Heap logic)
    public List<Student> getTopStudents(List<Student> students, int limit){
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>((s1, s2) ->
                Double.compare(s2.getAverage(), s1.getAverage())
        );

        priorityQueue.addAll(students);
        List<Student> topStudent = new ArrayList<>();
        int count = 0;
        while (!priorityQueue.isEmpty() && count < limit){
            topStudent.add(priorityQueue.poll());
            count++;
        }
        return topStudent;
    }

    public List<String> getStudentList(List<Student> students) {
        return students.stream().map(entry -> entry.getName()).toList();
    }

    public Optional<Student> getTopScore(List<Student> students){
        return students.stream().max(Comparator.comparing(Student::getAverage));
    }

    public Map<String, List<Student>> groupByStudents(List<Student> students){
        return students.stream().collect(Collectors.groupingBy(s -> s.getAverage() >= 35 ? "Pass" : "Fail"));
    }
}
