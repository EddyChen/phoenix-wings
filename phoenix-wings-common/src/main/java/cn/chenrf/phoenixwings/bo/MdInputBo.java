package cn.chenrf.phoenixwings.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdInputBo {

  private String inputCode;
  private String inputName;
  private String inputType;
  private Boolean forAdd;
  private Boolean forEdit;
  private String autoGenerateType;
  private String autoGenerateLogic;

}
