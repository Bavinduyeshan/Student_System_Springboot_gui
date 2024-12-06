package GUI;
import javax.swing.*;
import java.awt.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class ViewStudentsForm extends JFrame {

    private JTextArea textArea;

    public ViewStudentsForm() {
        // Create a new JFrame to display the list of students
        setTitle("View Students");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        // Load students when the form is created
        loadStudents();

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);
    }

    private void loadStudents() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/student/getAll";

        // Send the GET request to fetch students
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);

        if (response.getStatusCodeValue() == 200) {
            Student[] students = response.getBody();
            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append("Name: ").append(student.getName()).append("\n");
                sb.append("Address: ").append(student.getAddress()).append("\n");
                sb.append("---------------\n");
            }
            textArea.setText(sb.toString());
        } else {
            textArea.setText("Failed to load students.");
        }
    }
}
