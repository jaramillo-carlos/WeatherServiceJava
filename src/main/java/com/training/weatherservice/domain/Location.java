package com.training.weatherservice.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="location")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private double lat;

  private double lon;

  private String city;

  private String state;
}
