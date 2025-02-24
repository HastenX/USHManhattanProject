package gui;

import javax.swing.*;
import java.awt.Color;
import timer.GuiTimer;

public class GUI {
    private JFrame frame;
    private JTextArea area;
    private JButton button;
    private GuiTimer time;
    private boolean isButtonPressed = false;  // Track button press for this specific GUI instance
    private boolean isTimerActive = false;  // Flag to track whether the timer is running

    // Constructor for questions with or without a timer
    public GUI(String txt, int seconds) {
        this.frame = new JFrame("USH Manhattan Project");
        this.frame.setSize(400, 400);
        this.frame.setLayout(null);

        this.area = new JTextArea(txt);
        this.area.setBounds(10, 50, 400, 30);
        this.area.setLineWrap(true);
        this.area.setEditable(false);

        this.button = new JButton();
        this.button.setBackground(Color.RED);
        this.button.setBounds(130, 140, 125, 125);
        this.button.setText("");  // Initially no text, will show timer if active
        this.button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.frame.setBackground(Color.WHITE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.time = new GuiTimer(seconds); // Initialize the timer with the given seconds

        this.button.addActionListener(e -> {
            isButtonPressed = true;  // Mark button as pressed
            frame.setVisible(false);  // Hide the frame when the button is pressed
        });
    }

    // Constructor for questions without timers
    public GUI(String txt) {
        this(txt, 0);
    }

    // Method to start GUI with a timer
    public boolean startGuiWithTimer() {
        if (isTimerActive) {
            // Start the timer countdown
            time.startTimer(() -> {
                button.setText(String.valueOf(time.getTimeRemaining()));  // Update button text with remaining time
            }, () -> {
                isButtonPressed = true;  // Time has expired
                frame.setVisible(false);  // Close the frame
            });
        }

        // Start the GUI
        SwingUtilities.invokeLater(() -> {
            frame.add(area);
            frame.add(button);
            frame.setVisible(true);
        });

        // Wait until button is pressed or time expires
        while (!isButtonPressed) {
            try {
                Thread.sleep(100);  // Wait for button press or timer expiry
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // If the timer runs out, return false (button not pressed)
            if (!time.isRunning() && time.getTimeRemaining() == 0) {
                return false;  // User didn't press the button before the timer expired
            }
        }

        // Return true if button is pressed
        return isButtonPressed;
    }

    // Method to set the text and timer for GUI
    public boolean startGuiWithTimer(String txt, int seconds) {
        area.setText(txt);
        this.isTimerActive = true;  // Enable timer for this GUI
        time.resetTimer(seconds);  // Set the initial countdown time
        return startGuiWithTimer();
    }

    // Method to start GUI for questions without a timer
    public boolean startGui() {
        // Start the GUI
        SwingUtilities.invokeLater(() -> {
            frame.add(area);
            frame.add(button);
            frame.setVisible(true);
        });

        // Wait until button is pressed
        while (!isButtonPressed) {
            try {
                Thread.sleep(100);  // Wait for button press
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Return false if the button is never pressed
        return isButtonPressed;
    }
}
