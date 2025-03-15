package org.example.matrixspringfw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    public Long id;
    public String name;
    public String lastName;
    public  int age;
    public AdressDto adress;
}
