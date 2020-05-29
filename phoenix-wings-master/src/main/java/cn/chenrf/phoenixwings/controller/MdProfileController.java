package cn.chenrf.phoenixwings.controller;

import cn.chenrf.phoenixwings.bo.MdProfileBo;
import cn.chenrf.phoenixwings.dto.MdProfileDto;
import cn.chenrf.phoenixwings.exception.MdProfileException;
import cn.chenrf.phoenixwings.service.MdProfileService;
import cn.chenrf.phoenixwings.util.MdObjectParser;
import cn.chenrf.pyramid.bean.PageBean;
import cn.chenrf.pyramid.util.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/md/profile")
public class MdProfileController {

  @Resource(name = "mdProfileService")
  private MdProfileService mdProfileService;

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public MdProfileDto addProfile(@RequestBody MdProfileDto mdProfileDto) {
    ValidateUtils.validate(mdProfileDto);
    if (mdProfileDto.getEnabled() == null) {
      mdProfileDto.setEnabled(true);
    }
    MdProfileBo mdProfileBo = MdObjectParser.from(mdProfileDto);
    mdProfileBo = mdProfileService.save(mdProfileBo);
    return MdObjectParser.to(mdProfileBo);
  }

  @DeleteMapping("/{profileCode}/")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProfile(@PathVariable String profileCode) {
    mdProfileService.delete(profileCode);
  }

  @PutMapping("/{profileCode}/")
  @ResponseStatus(HttpStatus.CREATED)
  public MdProfileDto updateProfile(@PathVariable String profileCode,
                                    @RequestBody MdProfileDto mdProfileDto) {
    if (StringUtils.equals(profileCode, mdProfileDto.getProfileCode())) {
      throw new MdProfileException("PROFILE_CODE_NOT_MATCH", "参数的 Profile Code 不一致");
    }
    ValidateUtils.validate(mdProfileDto);
    MdProfileBo mdProfileBo = MdObjectParser.from(mdProfileDto);
    mdProfileBo = mdProfileService.save(mdProfileBo);
    return MdObjectParser.to(mdProfileBo);
  }

  @GetMapping("/")
  public PageBean<MdProfileDto> getProfileListBy(@RequestAttribute(required = false) MdProfileDto mdProfileDto,
                                                 @RequestParam(defaultValue = "1") int pageId,
                                                 @RequestParam(defaultValue = "10") int rows) {
    PageBean<MdProfileBo> mdProfileBoPage = mdProfileService.query(
        mdProfileDto.getProfileCode(),
        mdProfileDto.getProfileName(),
        mdProfileDto.getDataSourceName(),
        pageId,
        rows);
    List<MdProfileDto> mdProfileDtoList = MdObjectParser.from(
        mdProfileBoPage.getDataList(),
        MdObjectParser::to);
    return new PageBean<>(mdProfileBoPage.getTotal(), mdProfileDtoList);
  }
}
