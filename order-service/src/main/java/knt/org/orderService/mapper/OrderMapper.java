    package knt.org.orderService.mapper;

    import jakarta.enterprise.context.ApplicationScoped;
    import knt.org.orderService.dto.input.OrderRequest;
    import knt.org.orderService.entity.Client;
    import knt.org.orderService.entity.Order;
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;

    @Mapper(config = GlobalMapperConfig.class)
    public interface OrderMapper {
        @Mapping(target = "buyer",source="client")
        @Mapping(target = "status", ignore = true)
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "createdAt", ignore = true)
        Order createOrder(OrderRequest newOrderDTO, Client client);
    }
