package aptechph.com.studentApp.repository;

import aptechph.com.studentApp.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean findByName(String name);
}
