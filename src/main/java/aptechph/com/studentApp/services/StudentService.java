package aptechph.com.studentApp.services;

import aptechph.com.studentApp.dtos.RegisterDTO;
import aptechph.com.studentApp.dtos.RegisterResponseDTO;
import org.springframework.stereotype.Service;

public interface StudentService {
    public RegisterResponseDTO registerStudent(RegisterDTO regDTO);
}
