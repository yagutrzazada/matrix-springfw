package org.example.matrixspringfw.mapper;

import org.example.matrixspringfw.dao.StudentEntity;
import org.example.matrixspringfw.model.StudentDto;

public class StudentMapper {
    public static StudentEntity toSudentEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(null);
        studentEntity.setName(studentDto.getName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setAge(studentDto.getAge());
        AdressMapper adressMapper = new AdressMapper();
        studentEntity.setAdress(adressMapper.toAdressEntity(studentDto.getAdress()));

        return studentEntity;
    }

    public static StudentDto toStudentDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setAge(studentEntity.getAge());
        AdressMapper adressMapper = new AdressMapper();
        studentDto.setAdress(adressMapper.toAdressDto(studentEntity.getAdress()));
        return studentDto;
    }
}
