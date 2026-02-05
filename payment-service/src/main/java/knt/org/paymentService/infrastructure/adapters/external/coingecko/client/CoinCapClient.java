package knt.org.paymentService.infrastructure.adapters.external.coingecko.client;

import jakarta.ws.rs.*;
import knt.org.paymentService.infrastructure.adapters.external.coingecko.dto.CoinCapResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "coincap-api")
public interface CoinCapClient {



    @GET
    @Path("/assets/{slug}")
    CoinCapResponse getBitcoinRate(
        @PathParam("slug") String slug,
        @HeaderParam("authentication") String apiKey);


}
