package de.memozone.employeeapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
}