import java.util.Scanner;

public class QuestionService {
        Question[] questions = new Question[5];

        public QuestionService() {
                questions[0] = new Question(
                                1,
                                "Which keyword is used to inherit a class in Java?",
                                "this",
                                "super",
                                "extends",
                                "implements",
                                "extends");

                questions[1] = new Question(
                                2,
                                "Which method is the entry point of a Java program?",
                                "start()",
                                "main()",
                                "run()",
                                "init()",
                                "main()");

                questions[2] = new Question(
                                3,
                                "Which access modifier makes members accessible only within the same class?",
                                "public",
                                "protected",
                                "default",
                                "private",
                                "private");

                questions[3] = new Question(
                                4,
                                "Which concept allows one interface to be used for different data types?",
                                "Encapsulation",
                                "Polymorphism",
                                "Inheritance",
                                "Abstraction",
                                "Polymorphism");

                questions[4] = new Question(
                                5,
                                "Which of these is not a primitive data type in Java?",
                                "int",
                                "float",
                                "String",
                                "boolean",
                                "String");
        }

        public void playQuiz() {
                int userScore = 0;
                Scanner userAnswer = new Scanner(System.in);

                for (Question question : questions) {
                        System.out.print(question.getId() + ". " + question.getQuestion() + "\n");
                        System.out.printf("A. %-10s\tB. %-10s\tC. %-10s\tD. %-10s%n",
                                        question.getOption1(),
                                        question.getOption2(),
                                        question.getOption3(),
                                        question.getOption4());
                        System.out.print("Enter your answer (A/B/C/D): ");
                        String answer = userAnswer.nextLine().toUpperCase();
                        String selectedOption = "";

                        switch (answer) {
                                case "A":
                                        selectedOption = question.getOption1();
                                        break;
                                case "B":
                                        selectedOption = question.getOption2();
                                        break;
                                case "C":
                                        selectedOption = question.getOption3();
                                        break;
                                case "D":
                                        selectedOption = question.getOption4();
                                        break;
                                default:
                                        System.out.println("Invalid Choice");
                                        break;
                        }
                        if (selectedOption.equals(question.getAnswer())) {
                                System.out.println("Correct \n");
                                userScore++;
                        } else {
                                System.out.println("Wrong Correct answer: " + question.getAnswer() + "\n");
                        }
                }
                System.out.println("Final Score: " + userScore + "/" + questions.length);
                userAnswer.close();
        }
}
