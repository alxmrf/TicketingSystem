package knt.org.orderService.security;


import io.quarkus.security.credential.Credential;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import knt.org.orderService.dto.input.ClientInputDto;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import java.security.Permission;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

public class ClientIdentity implements SecurityIdentity {

    private SecurityIdentity delegate;
    private ClientInputDto client;

    public ClientIdentity(SecurityIdentity delegate, ClientInputDto entity){
        this.delegate  =  delegate;
        this.client = entity;
    }

    public String getCpf(){
        return this.client.getCpf();
    }


    public String getName(){
        return this.client.getName();
    };


    public String  getEmail(){
        return this.client.getEmail();
    };
    public Integer getIdade(){
        return this.client.getIdade();
    };


    @Override
    public Principal getPrincipal() {
        // Retorna o Principal original (o JWT Caller Principal)
        return delegate.getPrincipal();
    }

    @Override
    public boolean isAnonymous() {
        return delegate.isAnonymous();
    }

    @Override
    public Set<String> getRoles() {
        // Mantém as roles originais do token (ex: "admin", "user")
        return delegate.getRoles();
    }

    @Override
    public boolean hasRole(String role) {
        return delegate.hasRole(role);
    }

    @Override
    public <T extends Credential> T getCredential(Class<T> credentialType) {
        return delegate.getCredential(credentialType);
    }

    @Override
    public Set<Credential> getCredentials() {
        return delegate.getCredentials();
    }

    @Override
    public <T> T getAttribute(String name) {
        return delegate.getAttribute(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return delegate.getAttributes();
    }

    @Override
    public Uni<Boolean> checkPermission(Permission permission) {
        return delegate.checkPermission(permission);
    }

    @Override
    public boolean checkPermissionBlocking(Permission permission) {
        return delegate.checkPermissionBlocking(permission);
    }       
}
