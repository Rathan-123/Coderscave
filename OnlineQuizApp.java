import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter your choice: ");
            int selectedOption = scanner.nextInt();

            if (question.isCorrect(selectedOption)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct option is: " + (question.getCorrectOption()) + ". " );
            }
            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        // Creating questions
        Question question1 = new Question("What is the capital of France?",
                new String[]{"Paris", "Rome", "Berlin", "London"}, 1);
        Question question2 = new Question("Is Java platform-independent?",
                new String[]{"True", "False"}, 1);
        Question question3 = new Question("What is the largest planet in our solar system?",
                new String[]{"Jupiter", "Mars", "Saturn", "Venus"}, 1);
        Question question4 = new Question("Which programming language is known as the 'mother of all languages'?",
                new String[]{"C", "Java", "Assembly", "Python"}, 3);
        Question question5 = new Question("Who is the author of 'To Kill a Mockingbird'?",
                new String[]{"Harper Lee", "J.K. Rowling", "George Orwell", "Charles Dickens"}, 1);

        // Creating a quiz
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);

        // Conducting the quiz
        quiz.conductQuiz();
    }
}