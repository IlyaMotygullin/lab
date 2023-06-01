package ru.lern.lab.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lern.lab.Db.Repository.AchievementRepository;
import ru.lern.lab.Db.Repository.StudentRepository;
import ru.lern.lab.Service.map.AchievementMapper;
import ru.lern.lab.View.AchievementView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AchievementService {
    private final AchievementRepository achievementRepository;
    private final AchievementMapper achievementMapper;
    private final StudentRepository studentRepository;

    public AchievementService(AchievementRepository achievementRepository,
                              AchievementMapper achievementMapper,
                              StudentRepository studentRepository) {
        this.achievementRepository = achievementRepository;
        this.achievementMapper = achievementMapper;
        this.studentRepository = studentRepository;
    }
    public AchievementView getAchievementById(Long id){
        return achievementMapper.mappedToView(achievementRepository.getReferenceById(id));

    }
    public List<AchievementView> getAllAchievementByIdStudent(Long id){
       return achievementRepository.findAchievementsByIdStudent(studentRepository.getReferenceById(id))
                .stream()
                .map(achievementMapper::mappedToView).collect(Collectors.toList());
    }
    @Transactional
    public void addAchievement(AchievementView achievementView){
        achievementRepository.save(achievementMapper.mappedFromView(achievementView));
    }


}
