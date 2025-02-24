package gui;

import javax.swing.*;
import java.awt.Color;
import timer.GuiTimer;

public class GUI {
    public static boolean ending;
    private JFrame frame;
    private JTextArea area;
    private JButton button;
    private GuiTimer time;
    private boolean isButtonPressed = false;  
    private boolean isTimerActive = false;  

    public GUI(String txt, int seconds) {
        if(ending) {
            System.exit(0);
        }
        this.frame = new JFrame("USH Manhattan Project");
        this.frame.setSize(400, 400);
        this.frame.setLocation(750, 200);
        this.frame.setLayout(null);

        this.area = new JTextArea(txt);
        this.area.setBounds(0, 10, 400, 120);
        this.area.setLineWrap(true);
        this.area.setEditable(false);

        this.button = new JButton();
        this.button.setBackground(Color.RED);
        this.button.setBounds(130, 140, 125, 125);
        this.button.setText(""); 
        this.button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.frame.setBackground(Color.WHITE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.time = new GuiTimer(seconds); 

        this.button.addActionListener(e -> {
            isButtonPressed = true;  
            frame.setVisible(false); 
        });
    }


    public GUI(String txt) {
        this(txt, 0);
    }

    public boolean startGuiWithTimer() {
        if (isTimerActive) {
            time.startTimer(() -> {
                button.setText(String.valueOf(time.getTimeRemaining()));  
            }, () -> {
                isButtonPressed = true; 
                frame.setVisible(false); 
            });
        }

        SwingUtilities.invokeLater(() -> {
            frame.add(area);
            frame.add(button);
            frame.setVisible(true);
        });

        while (!isButtonPressed) {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!time.isRunning() && time.getTimeRemaining() == 0) {
                return false;  
            }
        }

        return isButtonPressed;
    }

    public boolean startGuiWithTimer(String txt, int seconds) {
        area.setText(txt);
        this.isTimerActive = true;  
        time.resetTimer(seconds);  
        return startGuiWithTimer();
    }

    public boolean startGui() {
        SwingUtilities.invokeLater(() -> {
            frame.add(area);
            frame.add(button);
            frame.setVisible(true);
        });

        while (!isButtonPressed) {
            try {
                Thread.sleep(100);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return isButtonPressed;
    }
}
