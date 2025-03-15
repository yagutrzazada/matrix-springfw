package org.example.matrixspringfw.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.matrixspringfw.dao.StudentEntity;
import org.example.matrixspringfw.dao.StudentRepository;
import org.example.matrixspringfw.error.NotFoundException;
import org.example.matrixspringfw.mapper.StudentMapper;
import org.example.matrixspringfw.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
  public final   StudentRepository studentRepository;
  public final   AdressService adressService;


    public void createStudent(StudentDto studentDto) {
        log.info("ActionLog.createStudent.start for name: {} ", studentDto.getName());
        StudentEntity studentEntity = StudentMapper.toSudentEntity(studentDto);
        adressService.createAddress(studentDto.getAdress());
        studentRepository.save(studentEntity);
        log.info("ActionLog.createStudent.end for name: {} ", studentDto.getName());

    }

    public StudentDto getStudentById(Long id) {
        log.info("ActionLog.getStudentById.start for id: {} ", id);
        var studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("ActionLog.getStudentById.error for id :{}", id);
                    throw new NotFoundException("Cant find student with this id");
                });

        log.info("ActionLog.getStudentById.end for id: {} ", id);

        return StudentMapper.toStudentDto(studentEntity);
    }

    public List<StudentDto> getStudents() {
        List<StudentDto> students = studentRepository.findAll().stream()
                .map(StudentMapper::toStudentDto)
                .toList();
        return students;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
