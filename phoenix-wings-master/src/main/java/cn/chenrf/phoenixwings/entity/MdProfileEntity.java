package cn.chenrf.phoenixwings.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MD_PROFILE")
public class MdProfileEntity {

  @Id
  @Column(length = 100)
  private String profileCode;
  @Column(length = 1000)
  private String profileName;
  @Column(length = 100)
  private String profileType;
  @Column(length = 100)
  private String dataSourceName;
  @Column(length = 500)
  private String tableNames;
  @Column
  private Boolean enabled;
}
