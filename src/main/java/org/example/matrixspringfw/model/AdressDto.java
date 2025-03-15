package org.example.matrixspringfw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdressDto {
    public Long id;
    public String city;
    public String street;

}
