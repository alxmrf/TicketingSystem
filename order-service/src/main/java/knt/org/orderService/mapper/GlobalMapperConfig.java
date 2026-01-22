package knt.org.orderService.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = MappingConstants.ComponentModel.JAKARTA,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface GlobalMapperConfig {
}