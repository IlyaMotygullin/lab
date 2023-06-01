package ru.lern.lab.Db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lern.lab.Db.Entity.Achievement;
import ru.lern.lab.Db.Entity.Student;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Long> {
    List<Achievement> findAchievementsByIdStudent(Student student);
}
