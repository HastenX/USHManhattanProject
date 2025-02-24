package transfer;
import gui.GUI;

public class Question {
    private boolean userPressedButton; // Instance-level flag for button press
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
            userPressedButton = gui.startGuiWithTimer(txt, seconds);  // Run GUI with timer
        } else {
            gui = new GUI(txt);
            userPressedButton = gui.startGui();  // Run GUI without timer
        }
    }

    public boolean getUserPressedButton() {
        return userPressedButton;
    }
}
