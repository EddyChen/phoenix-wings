package cn.chenrf.phoenixwings.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdButtonBo {

  private String buttonCode;
  private String buttonName;
  private String buttonIcon;
  private String buttonType;
  private String buttonLogic;

}
