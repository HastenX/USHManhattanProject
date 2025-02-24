package timer;

import javax.swing.Timer;

public class GuiTimer {
    private int timeRemaining; 
    private Timer timer; 
    private boolean isRunning;  

    public GuiTimer(int seconds) {
        this.timeRemaining = seconds;
        this.isRunning = false;
    }

    public void startTimer(Runnable onTimeUpdate, Runnable onTimeExpire) {
        if (isRunning) return;  

        isRunning = true;

        timer = new Timer(1000, e -> {
            if (timeRemaining > 0) {
                timeRemaining--; 
                onTimeUpdate.run();  
            } else {
                isRunning = false;
                onTimeExpire.run();  
            }
        });

        timer.start();  
    }

    public void stopTimer() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void resetTimer(int seconds) {
        this.timeRemaining = seconds;
    }
}
