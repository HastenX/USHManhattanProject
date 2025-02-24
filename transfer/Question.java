package transfer;
import gui.GUI;

public class Question {
    private boolean userPressedButton; 
    private String txt;
    private int seconds;

    public Question(String txt) {
        this.txt = txt;
        this.seconds = 0;
        path();
    }

    public Question(String txt, int seconds) {
        this.txt = txt;
        this.seconds = seconds;
        path();
    }

    private void path() {
        GUI gui;
        if (this.seconds != 0) {
            gui = new GUI(txt, seconds);
            userPressedButton = gui.startGuiWithTimer(txt, seconds);  
        } else {
            gui = new GUI(txt);
            userPressedButton = gui.startGui();  
        }
    }

    public boolean getUserPressedButton() {
        return userPressedButton;
    }
}
