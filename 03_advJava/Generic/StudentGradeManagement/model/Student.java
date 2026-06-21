package Generic.StudentGradeManagement.model;

import java.util.List;

public class Student implements Comparable<Student>{
    private String name;
    private List<Integer> marks;
    private double average;
    private int highest;
    private int lowest;

    public Student(String name, List<Integer> marks){
        this.name = name;
        this.marks = marks;
        calculateMetric();
    }

    private void calculateMetric() {
        if (marks == null || marks.isEmpty()){
            this.average = 0.0;
            this.highest = 0;
            this.lowest = 0;
            return;
        }

        int sum = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for(int mark : marks){
            sum += mark;

            if(mark > max){
                max = mark;
            }
            if(mark < min){
                min = mark;
            }
        }
        this.average = (double) sum / marks.size();
        this.highest = max;
        this.lowest = min;
    }

    @Override
    public int compareTo(Student other){
        int compare = Double.compare(other.average, this.average);
        if (compare == 0){
            return this.name.compareTo(other.name);
        }
        return  compare;
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", average=" + average +
                ", highest=" + highest +
                ", lowest=" + lowest +
                '}';
    }

    public String getName() {
        return name;
    }
    public double getAverage() {
        return average;
    }
}
