package ru.lern.lab.Service.map;

import org.springframework.stereotype.Service;
import ru.lern.lab.Db.Entity.Achievement;
import ru.lern.lab.Db.Repository.StudentRepository;
import ru.lern.lab.View.AchievementView;
@Service
public class AchievementMapper {
    private  final StudentRepository studentRepository;

    public AchievementMapper(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Achievement mappedFromView(AchievementView achievementView){
        Achievement achievement = new Achievement();
        achievement.setId(achievementView.getId());
        achievement.setName(achievementView.getName());
        achievement.setType(achievementView.getType());
        achievement.setIdStudent(studentRepository.getReferenceById(achievementView.getIdUser()));
        return  achievement;
    }
    public AchievementView mappedToView(Achievement achievement){
        AchievementView achievementView = new AchievementView();
        achievementView.setName(achievement.getName());
        achievementView.setType(achievement.getType());
        achievementView.setId(achievement.getId());
        achievementView.setIdUser(achievement.getIdStudent().getId());
        return achievementView;
    }
}
