package com.klu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
  @NotBlank(message = "Name is required")
  private String name;
  @Email(message = "Email must have proper format")
  private String email;
  @NotBlank(message = "Branch is required")
  private String branch;
  @NotBlank(message = "Course is required")
  private String course;
  @NotNull(message="Fees is required")
  @Positive(message = "Fees must be positive")
  private double fees;
}