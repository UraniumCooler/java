import java.time.LocalTime;

import javax.swing.JOptionPane;

public class clock {
    
    public static void main(String[] args) {
        LocalTime Clock = LocalTime.now();
        JOptionPane.showMessageDialog(null, "klockan är nu " + Clock);
    }
}
