package aptechph.com.studentApp.controllers;

import aptechph.com.studentApp.dtos.RegisterDTO;
import aptechph.com.studentApp.dtos.RegisterResponseDTO;
import aptechph.com.studentApp.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(summary = "auth")
    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO, BindingResult result){
        RegisterResponseDTO regStud = studentService.registerStudent(registerDTO);
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().map(error ->error.getField()+ ": "+ error.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseEntity<>(Map.of("errors", errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(regStud, HttpStatus.CREATED);
    }
}
