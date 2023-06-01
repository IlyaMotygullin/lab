package ru.lern.lab.Db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lern.lab.Db.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
