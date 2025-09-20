package it.si2001.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "birthday")
  private LocalDate birthDay;

  
  public User() {}

  public User(String firstName, String lastName, LocalDate birthDay) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDay = birthDay;
  }
  
  public User(Long id, String firstName, String lastName, LocalDate birthDay) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDay = birthDay;
  }
  
  public Long getId() {
      return id;
  }
  
  public void setId(Long id) {
      this.id = id;
  }
  
  public String getFirstName() {
      return firstName;
  }
  
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }
  
  public String getLastName() {
      return lastName;
  }
  
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }
  
  public LocalDate getBirthDay() {
      return birthDay;
  }
  
  public void setBirthDay(LocalDate birthDay) {
      this.birthDay = birthDay;
  }
  
}
