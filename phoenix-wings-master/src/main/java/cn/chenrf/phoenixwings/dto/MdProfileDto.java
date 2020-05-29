package cn.chenrf.phoenixwings.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdProfileDto {

  @NotNull(message = "Profile Code 不能为空")
  @Size(min = 5, max = 100, message = "Profile Code 长度应在5 - 100之间")
  private String profileCode;
  @NotNull(message = "Profile Name 不能为空")
  @Size(min = 5, max = 100, message = "Profile Name 长度应在5 - 1000之间")
  private String profileName;
  @NotNull(message = "Profile Type 不能为空")
  @Size(max = 100, message = "Profile Type 长度不能超过100")
  private String profileType;
  @NotNull(message = "DataSource Name 不能为空")
  @Size(max = 100, message = "DataSource Name 长度不能超过100")
  private String dataSourceName;
  @NotNull(message = "Table Names 不能为空")
  @Size(max = 100, message = "Table Names 长度不能超过500")
  private String tableNames;
  private Boolean enabled;

}
