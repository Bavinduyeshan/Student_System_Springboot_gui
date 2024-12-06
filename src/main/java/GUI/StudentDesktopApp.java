package GUI;
import com.StudentSystem.StudentSysLogin.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDesktopApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Management");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create Buttons
            JButton addStudentButton = new JButton("Add Student");
            JButton viewStudentsButton = new JButton("View Students");

            // Add action listeners
            addStudentButton.addActionListener(e -> new AddStudentForm());
            viewStudentsButton.addActionListener(e -> new ViewStudentsForm());

            // Layout
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1, 10, 10));
            panel.add(addStudentButton);
            panel.add(viewStudentsButton);

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
