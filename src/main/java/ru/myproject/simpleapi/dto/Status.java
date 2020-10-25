package ru.myproject.simpleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Status {
    private  String hostName;
    private  String helloWorld;
}
