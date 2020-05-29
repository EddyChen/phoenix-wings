package cn.chenrf.phoenixwings.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdStructBo {

  private String structCode;
  private String structName;
  private String structAlias;
  private String structType;
  private String structSize;
  private Boolean isPrimaryKey;

}
