package org.example.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Person {
  private String phone;
  @Column(name = "client_name", length = 30)
  private String firstName;
  private String lastName;
  private String middleName;
}
