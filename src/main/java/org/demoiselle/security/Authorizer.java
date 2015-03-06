package org.demoiselle.security;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import org.demoiselle.entity.User;

public class Authorizer implements br.gov.frameworkdemoiselle.security.Authorizer {

    private static final long serialVersionUID = 1L;

    @Inject
    private SecurityContext securityContext;

    @Override
    public boolean hasRole(String role) throws Exception {
        if (securityContext.isLoggedIn()) {
            User user = (User) securityContext.getUser();
        }
        return false;
    }

    @Override
    public boolean hasPermission(String resource, String operation) throws Exception {
        return false;
    }

}
