package org.demoiselle.rest;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import java.security.Principal;
import javax.ws.rs.DELETE;

@Path("auth")
public class AuthREST {

    @Inject
    private SecurityContext securityContext;

    @POST
    @ValidatePayload
    @Produces("application/json")
    @Consumes("application/json")
    public Principal login(CredentialsData data) {
        Credentials credentials = Beans.getReference(Credentials.class);
        credentials.setUsername(data.username);
        credentials.setPassword(data.password);

        securityContext.login();

        return getLoggedInUser();
    }

    @GET
    @LoggedIn
    @Produces("application/json")
    public Principal getLoggedInUser() {
        return securityContext.getUser();
    }

    @DELETE
    @LoggedIn
    public void logout() {
        securityContext.logout();
    }

    public static class CredentialsData {

        @NotNull(message = "{required.field}")
        @Size(min = 1, message = "{required.field}")
        public String username;

        @NotNull(message = "{required.field}")
        @Size(min = 1, message = "{required.field}")
        public String password;
    }
}
