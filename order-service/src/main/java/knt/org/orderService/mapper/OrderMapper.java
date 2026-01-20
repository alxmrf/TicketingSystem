package knt.org.orderService.mapper;

import knt.org.orderService.dto.input.OrderRequest;
import knt.org.orderService.entity.Client;
import knt.org.orderService.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = ProjectMapperConfig.class)
public interface OrderMapper {

    @Mapping(target = "buyer",source="client")
    Order createOrder(OrderRequest newOrderDTO, Client client);

}
