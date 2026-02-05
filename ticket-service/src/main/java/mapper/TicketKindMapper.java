package mapper;

import dto.CreateTicketKindDto;
import entity.TicketKind;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalMapperConfig.class)
public interface TicketKindMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "show",ignore = true)
    TicketKind toEntity(CreateTicketKindDto dto);
}
