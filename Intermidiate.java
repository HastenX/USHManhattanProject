import java.util.Scanner;

public class Intermidiate {
    
    private String question;

    private Scanner scan;

    public Intermidiate(String question) {
        this.question = question;

        this.scan = new Scanner(System.in);
        path();
    }

    public Intermidiate(String plausibilityTrue, String plausibilityFalse, boolean entered) {
        if(entered) this.question = plausibilityTrue;
        if(!entered) this.question = plausibilityFalse;

        this.scan = new Scanner(System.in);
        path();
    }

    public void path() {
        System.out.println(this.question);
        userResponse();
    }

    private boolean userResponse() {
        if((scan.nextLine()).equals("")) return true;
        System.out.println("press the Enter key");
        return userResponse();
    }
}
