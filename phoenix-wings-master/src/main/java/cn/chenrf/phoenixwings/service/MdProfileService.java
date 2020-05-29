package cn.chenrf.phoenixwings.service;

import cn.chenrf.phoenixwings.bo.MdProfileBo;
import cn.chenrf.phoenixwings.entity.MdProfileEntity;
import cn.chenrf.phoenixwings.exception.MdProfileException;
import cn.chenrf.phoenixwings.repository.MdProfileRepository;
import cn.chenrf.phoenixwings.util.MdObjectParser;
import cn.chenrf.pyramid.bean.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MdProfileService {

  @Resource(name = "mdProfileRepository")
  private MdProfileRepository mdProfileRepository;

  public MdProfileBo save(MdProfileBo mdProfileBo) {
    MdProfileEntity mdProfileEntity = MdObjectParser.from(mdProfileBo);
    mdProfileRepository.save(mdProfileEntity);
    return mdProfileBo;
  }

  public void delete(final String profileCode) {
    MdProfileEntity mdProfileEntity = mdProfileRepository.findByProfileCode(profileCode);
    if (mdProfileEntity == null && !mdProfileEntity.getEnabled()) {
      log.warn("该Profile: [{}]不存在/已经删除", profileCode);
      throw new MdProfileException("PROFILE_NOT_EXISTS", "该Profile不存在/已经删除");
    } else {
      mdProfileEntity.setEnabled(false);
      mdProfileRepository.save(mdProfileEntity);
    }
  }

  public PageBean<MdProfileBo> query(final String profileCode,
                                     final String profileName,
                                     final String dataSourceName,
                                     final int pageId,
                                     final int rows) {
    Page<MdProfileEntity> mdProfileEntityPage = mdProfileRepository
        .findByProfileCodeLikeAndProfileNameLikeAndDataSourceNameLike(
            profileCode,
            profileName,
            dataSourceName,
            new PageRequest(pageId, rows)
        );
    List<MdProfileBo> mdProfileBoList = MdObjectParser.from(
        mdProfileEntityPage.getContent(),
        MdObjectParser::to);
    return new PageBean<>(
        mdProfileEntityPage.getTotalElements(),
        mdProfileBoList);
  }
}
