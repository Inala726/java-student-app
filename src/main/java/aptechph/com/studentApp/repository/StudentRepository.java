package aptechph.com.studentApp.repository;

import aptechph.com.studentApp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}
