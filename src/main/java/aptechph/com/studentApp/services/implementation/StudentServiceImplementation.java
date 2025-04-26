package aptechph.com.studentApp.services.implementation;

import aptechph.com.studentApp.dtos.RegisterDTO;
import aptechph.com.studentApp.dtos.RegisterResponseDTO;
import aptechph.com.studentApp.models.Student;
import aptechph.com.studentApp.repository.StudentRepository;
import aptechph.com.studentApp.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public RegisterResponseDTO registerStudent(RegisterDTO regDTO) {
        if(studentRepository.existsByEmail(regDTO.getEmail())){
            throw new RuntimeException("Student with email "+regDTO.getEmail() +"already exists");
        }
        Student student = new Student();
        student.setFirstName(regDTO.getFirstName());
        student.setLastName(regDTO.getLastName());
        student.setEmail(regDTO.getEmail());
        student.setPassword(regDTO.getPassword());

        Student saveRecord = studentRepository.save(student);
        return new RegisterResponseDTO("Registration successful", saveRecord.getId());

    }
}
