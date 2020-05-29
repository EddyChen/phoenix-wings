package cn.chenrf.phoenixwings.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MdProfileBo {

  private String profileCode;
  private String profileName;
  private String profileType;
  private String dataSourceName;
  private String tableNames;
  private Boolean enabled;

}
