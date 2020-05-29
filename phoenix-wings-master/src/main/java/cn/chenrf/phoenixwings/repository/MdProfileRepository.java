package cn.chenrf.phoenixwings.repository;

import cn.chenrf.phoenixwings.entity.MdProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MdProfileRepository extends PagingAndSortingRepository<MdProfileEntity, String> {

  MdProfileEntity findByProfileCode(final String profileCode);

  void deleteByProfileCode(final String profileCode);

  Page<MdProfileEntity> findByProfileCodeLikeAndProfileNameLikeAndDataSourceNameLike(
      final String profileCode,
      final String profileName,
      final String dataSourceName,
      Pageable pageable
  );
}
