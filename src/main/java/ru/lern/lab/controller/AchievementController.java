package ru.lern.lab.controller;

import org.springframework.web.bind.annotation.*;
import ru.lern.lab.Service.AchievementService;
import ru.lern.lab.View.AchievementView;

import java.util.List;

@RestController
public class AchievementController {
    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/achievement/get/{id}")
    public AchievementView getAchievement(@PathVariable(name = "id") Long id){
        return achievementService.getAchievementById(id);
    }
    @GetMapping("/achievement/{idStudent}")
    public List<AchievementView> getAchievementByStudent(@PathVariable(name = "idStudent") Long id){
        return achievementService.getAllAchievementByIdStudent(id);
    }
    @PostMapping("/achievement")
    public void addAchievement(@RequestBody AchievementView achievementView){
        achievementService.addAchievement(achievementView);
    }
}
