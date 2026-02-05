package knt.org.orderService.security;

import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.SecurityIdentityAugmentor;
import io.smallrye.mutiny.Uni;
import knt.org.orderService.dto.input.ClientInputDto;
import org.eclipse.microprofile.jwt.JsonWebToken;

public class ClientSecurityIdentityAugmentor implements SecurityIdentityAugmentor {
    @Override
    public Uni<SecurityIdentity> augment(SecurityIdentity securityIdentity, AuthenticationRequestContext authenticationRequestContext) {
        if(securityIdentity.isAnonymous() || !(securityIdentity.getPrincipal() instanceof JsonWebToken jwt) ){
            return Uni.createFrom().item(securityIdentity);
        }
        return Uni.createFrom().item(()->{
            var client = new ClientInputDto();


            client.setCpf(jwt.getClaim("cpf"));
            client.setEmail(jwt.getClaim("email"));
            client.setName(jwt.getClaim("name"));
            client.setIdade(jwt.getClaim("idade"));
            return new ClientIdentity(securityIdentity,client);
        });


    }
}
