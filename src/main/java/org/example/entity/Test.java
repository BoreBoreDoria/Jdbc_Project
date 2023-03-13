package org.example.entity;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.Info;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@NoArgsConstructor
public class Test {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @Enumerated(EnumType.STRING)
  private Info info;

  @Enumerated(EnumType.ORDINAL)
  private Info infoOrdinal;

  @Temporal(value = TemporalType.DATE)
  private Date birthday;

  @ElementCollection
  private List<String> list;

  public Test(String name, Info info, Info infoOrdinal, Date birthday, List<String> list) {
    this.name = name;
    this.info = info;
    this.infoOrdinal = infoOrdinal;
    this.birthday = birthday;
    this.list = list;
  }
}
