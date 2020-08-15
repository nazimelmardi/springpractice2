package com.wup.librarystats.adapter.mapper;

import com.wup.librarystats.domain.entity.BookStats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryStatsMapper {

    BookStats toEntity(org.openapitools.model.StatInfoForPort model);

    org.openapitools.model.StatInfoForPort toModel(BookStats entity);
}
