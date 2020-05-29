package cn.chenrf.phoenixwings.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdLinkBo {

  private String linkCode;
  private String linkName;
  private String linkType;
  private String linkTarget;

}
