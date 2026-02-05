package knt.org.orderService.security;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import knt.org.orderService.entity.Client;

@Produces
@RequestScoped
public class ClientIdentityProducer {

    @Inject
    SecurityIdentity identity;

    @RequestScoped
    @Produces
    public ClientIdentity produceClientIdentity(){

        if(identity instanceof ClientIdentity clientIdentity){
            return clientIdentity;
        }
        throw new IllegalStateException("Ocorreu um erro na autenticacao do usuario");


    }



}
