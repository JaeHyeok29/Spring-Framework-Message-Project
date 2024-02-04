package com.nhnacademy.edu.springframework;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MonitorExecutionTime {
}
