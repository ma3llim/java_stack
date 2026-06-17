package CollectionsPrograms.GroupStudentsByGrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStudents {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", "A"));
        studentList.add(new Student("Bob", "B"));
        studentList.add(new Student("Charlie", "A"));
        studentList.add(new Student("David", "C"));
        studentList.add(new Student("Emma", "B"));
        studentList.add(new Student("Frank", "A"));
        studentList.add(new Student("Grace", "C"));

        Map<String, List<Student>> groupByGrade = new HashMap<>();

        for(Student student: studentList){
            String grade = student.getGrade();

            if(groupByGrade.containsKey(grade)){
                List<Student> existingList =  groupByGrade.get(grade);
                existingList.add(student);
            } else {
                List<Student> newList = new ArrayList<>();
                newList.add(student);

                groupByGrade.put(grade, newList);
            }
        }

        System.out.println("Students Grouped by Grade: ");
        for(Map.Entry<String, List<Student>> entry : groupByGrade.entrySet()){
            System.out.println("Grade " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
