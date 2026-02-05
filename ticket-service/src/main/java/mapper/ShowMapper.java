package mapper;



import dto.CreateShowDto;
import entity.Show;
import entity.TicketKind;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = GlobalMapperConfig.class, uses = {TicketKindMapper.class})
public interface ShowMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ticketKinds", source = "ticketKind")
    Show createNewShow(CreateShowDto createShowDto);

    @AfterMapping
    default void linkTicketKindToShow(@MappingTarget Show show){

        if(show.getTicketKinds() != null){
            for(var ticketKind :  show.getTicketKinds()){
                ticketKind.setShow(show);
            }
        }

    }
}
