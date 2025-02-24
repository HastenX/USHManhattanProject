import transfer.Question;

public class Main {
    public static void main(String[] args) {
        // First question - should print true when button is pressed
        Question statementOne = new Question("Welcome to my USH Project, where you decide if events-- by which created the atomic bomb-- had happened. Press the button to continue");
        System.out.println(statementOne.getUserPressedButton());  // Should print true when button pressed

        // Second question - should print true when button is pressed independently of the first
        Question questionOne = new Question("e", 3);
        System.out.println(questionOne.getUserPressedButton());  // Should print true when button pressed

        // Third question - should behave independently
        Question statementTwo = new Question("q");
        System.out.println(statementTwo.getUserPressedButton());  // Should print true when button pressed
    }
}
