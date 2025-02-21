import java.util.Optional;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Questions {
    private int seconds;

    private String question;

    private Timer time;
    private ExecutorService execute;

    private static Optional<Boolean> response;

    public Questions(String question) {
        this.question = question;

        this.execute = Executors.newFixedThreadPool(1);
        this.time = new Timer();
        this.seconds = 6;
        response = Optional.empty();
        path();
    }

    public int getSeconds() {
        return seconds;
    }

    private void path() {
        System.out.println(this.question);
        time.schedule(startTimer(), 1000); 
        response = Optional.of(openGUI());
    }

    private TimerTask startTimer() {
        return new TimerTask() {
            public void run() {
                if (response.isPresent()) {
                    time.cancel(); 
                    return;
                }
                if (seconds == 1) {
                    time.cancel(); 
                    response = Optional.of(false); 
                    execute.shutdownNow(); 
                    return;
                }
                seconds--;
                System.out.println(seconds); 
                time.schedule(startTimer(), 1000); 
            }
        };
    }
}