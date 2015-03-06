package org.demoiselle.rest;

import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.demoiselle.business.UsuarioBC;
import org.demoiselle.entity.User;

@Path("/usuario")
public class UsuarioREST implements Serializable {

    @Inject
    private UsuarioBC bc;

    @GET
    @Produces("application/json")
    public List<User> find() throws Exception {
        return bc.findAll();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public User load(@PathParam("id") Long id) throws NotFoundException {
        User result = bc.load(id);

        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    @PUT
    @Consumes("application/json")
    @ValidatePayload
    @Transactional
    public void update(User entity) throws BadRequestException, NotFoundException {
        if (entity == null || entity.getId() == null) {
            throw new BadRequestException();
        }
        load(entity.getId());

        bc.update(entity);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) throws NotFoundException {
        load(id);
        bc.delete(id);
    }

    private void checkId(User entity) throws BadRequestException {
        if (entity.getId() != null) {
            throw new BadRequestException();
        }
    }

    @GET
    @Path("{id}")
    public User carregar(@NotNull @PathParam("id") Long id) {
        return bc.load(id);
    }

    @GET
    @Path("ok")
    public void criar() {
        bc.iniciarUsuario();
    }

}
