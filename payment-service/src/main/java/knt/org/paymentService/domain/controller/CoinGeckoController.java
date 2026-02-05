package knt.org.paymentService.domain.controller;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@ApplicationScoped
@Path("coinGecko")
public class CoinGeckoController {



    @Path("bitcoin-rating")
    public Response getBitcoinInfo(){

    }



}


