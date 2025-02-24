package timer;

import javax.swing.Timer;

public class GuiTimer {
    private int timeRemaining;  // Time remaining in seconds
    private Timer timer;  // Swing Timer for updating countdown every second
    private boolean isRunning;  // Flag to check if the timer is running

    // Constructor to initialize the timer with a given number of seconds
    public GuiTimer(int seconds) {
        this.timeRemaining = seconds;
        this.isRunning = false;
    }

    // Start the countdown timer
    public void startTimer(Runnable onTimeUpdate, Runnable onTimeExpire) {
        if (isRunning) return;  // Don't start the timer if it's already running

        isRunning = true;

        // Timer will update every second (1000 milliseconds)
        timer = new Timer(1000, e -> {
            if (timeRemaining > 0) {
                timeRemaining--;  // Decrease the time by 1 second
                onTimeUpdate.run();  // Notify the GUI to update the button
            } else {
                isRunning = false;
                onTimeExpire.run();  // Notify the GUI that time has expired
            }
        });

        timer.start();  // Start the timer
    }

    // Stop the timer
    public void stopTimer() {
        if (isRunning) {
            timer.stop();
            isRunning = false;
        }
    }

    // Get the current remaining time
    public int getTimeRemaining() {
        return timeRemaining;
    }

    // Check if the timer is running
    public boolean isRunning() {
        return isRunning;
    }

    // Reset the timer to a specific number of seconds
    public void resetTimer(int seconds) {
        this.timeRemaining = seconds;
    }
}
