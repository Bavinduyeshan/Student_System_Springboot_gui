package GUI;

import com.StudentSystem.StudentSysLogin.model.Student;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class StudentAPIClient {
    private static final String BASE_URL = "http://localhost:8080/student"; // Spring Boot API base URL

    private RestTemplate restTemplate;

    public StudentAPIClient() {
        this.restTemplate = new RestTemplate();
    }

    // Method to add a student
    public String addStudent(Student student) {
        String url = BASE_URL + "/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Student> entity = new HttpEntity<>(student, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    // Method to view all students
    public String viewAllStudents() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
