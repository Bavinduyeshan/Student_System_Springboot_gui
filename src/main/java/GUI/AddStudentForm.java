package GUI;
import javax.swing.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class AddStudentForm extends JFrame {

    private JTextField nameField;
    private JTextField addressField;
    private JButton addButton;

    public AddStudentForm() {
        // Create a new JFrame for adding a student
        setTitle("Add Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        nameField = new JTextField(20);
        addressField = new JTextField(20);
        addButton = new JButton("Add Student");

        // Action for Add button
        addButton.addActionListener(e -> addStudent());

        // Layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Address:"));
        add(addressField);
        add(addButton);

        setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        String address = addressField.getText();

        // Create a RestTemplate to communicate with the Spring Boot backend
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/student/add";

        // Create the student object
        Student student = new Student(name, address);

        // Send the POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, student, String.class);

        if (response.getStatusCodeValue() == 200) {
            JOptionPane.showMessageDialog(this, "Student added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add student.");
        }
    }
}
