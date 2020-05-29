package cn.chenrf.phoenixwings.util;

import cn.chenrf.phoenixwings.bo.MdProfileBo;
import cn.chenrf.phoenixwings.dto.MdProfileDto;
import cn.chenrf.phoenixwings.entity.MdProfileEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class MdObjectParser {

  public static MdProfileBo from(MdProfileDto mdProfileDto) {
    return MdProfileBo.builder()
        .profileCode(mdProfileDto.getProfileCode())
        .profileName(mdProfileDto.getProfileName())
        .profileType(mdProfileDto.getProfileType())
        .dataSourceName(mdProfileDto.getDataSourceName())
        .tableNames(mdProfileDto.getTableNames())
        .enabled(mdProfileDto.getEnabled())
        .build();
  }

  public static MdProfileBo to(MdProfileEntity mdProfileEntity) {
    return MdProfileBo.builder()
        .profileCode(mdProfileEntity.getProfileCode())
        .profileName(mdProfileEntity.getProfileName())
        .profileType(mdProfileEntity.getProfileType())
        .dataSourceName(mdProfileEntity.getDataSourceName())
        .tableNames(mdProfileEntity.getTableNames())
        .enabled(mdProfileEntity.getEnabled())
        .build();
  }

  public static MdProfileEntity from(MdProfileBo mdProfileBo) {
    return MdProfileEntity.builder()
        .profileCode(mdProfileBo.getProfileCode())
        .profileName(mdProfileBo.getProfileName())
        .profileType(mdProfileBo.getProfileType())
        .dataSourceName(mdProfileBo.getDataSourceName())
        .tableNames(mdProfileBo.getTableNames())
        .enabled(mdProfileBo.getEnabled())
        .build();
  }

  public static MdProfileDto to(MdProfileBo mdProfileBo) {
    return MdProfileDto.builder()
        .profileCode(mdProfileBo.getProfileCode())
        .profileName(mdProfileBo.getProfileName())
        .profileType(mdProfileBo.getProfileType())
        .dataSourceName(mdProfileBo.getDataSourceName())
        .tableNames(mdProfileBo.getTableNames())
        .enabled(mdProfileBo.getEnabled())
        .build();
  }

  public static <T, R> List<R> from(Iterable<T> sourceList,
                                    MdObjectConverter<T, R> mdObjectConverter) {
    List<R> resultList = new ArrayList<R>();
    R result = null;
    for (T source : sourceList) {
      result = mdObjectConverter.from(source);
      resultList.add(result);
    }
    return resultList;
  }


}
