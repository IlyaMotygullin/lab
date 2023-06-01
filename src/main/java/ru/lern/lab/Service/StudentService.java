package ru.lern.lab.Service;

import org.springframework.stereotype.Service;
import ru.lern.lab.Db.Entity.Student;
import ru.lern.lab.Db.Repository.StudentRepository;
import ru.lern.lab.Service.map.StudentMapper;
import ru.lern.lab.View.StudentView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public  void addStudent(StudentView studentView){

        studentRepository.save(studentMapper.mappedFromView(studentView));
    }
    public void renameStudent(String name,Long id){
       Student student= studentRepository.getReferenceById(id);
       student.setFio(name);
       studentRepository.save(student);
    }
    public StudentView getStudentById(Long id){
       Student student= studentRepository.getReferenceById(id);
       return studentMapper.mappedToView(student);
    }
    public List<StudentView> getAllStudent(){
     return    studentRepository.findAll().stream().map(studentMapper::mappedToView)
             .collect(Collectors.toList());
    }


}
