import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements Action{
    private int seconds;

    private JFrame frame;
    private JLabel questionDescription;
    private JPanel panel;
    private JButton button;

    public GUI(String question) {
        frame = new JFrame("USH Manhattan Project GUI");
        panel = new JPanel();
        questionDescription = new JLabel(question+"\nYou have infinite seconds");
        this.seconds = -1;
        JButton button = new JButton();

        frame.add(questionDescription);
    }

    public GUI(String question, int seconds) {
        frame = new JFrame("USH Manhattan Project GUI");
        panel = new JPanel();
        this.seconds = 6;
        questionDescription = new JLabel(question+"\nYou have "
        + this.seconds
        + " seconds");
        JButton button = new JButton();

        frame.add(questionDescription);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putValue'");
    }

    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEnabled'");
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPropertyChangeListener'");
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePropertyChangeListener'");
    }
    
}
