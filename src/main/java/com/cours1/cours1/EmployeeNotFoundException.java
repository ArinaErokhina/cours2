package com.cours1.cours1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Сотрудник не найден")
public class EmployeeNotFoundException extends RuntimeException {
}
