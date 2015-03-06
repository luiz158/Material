package org.demoiselle.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import org.demoiselle.business.BookmarkBC;
import org.demoiselle.entity.Bookmark;

@Path("bookmark")
public class BookmarkREST {

    @Inject
    private BookmarkBC bc;

    @GET
    @Produces("application/json")
    public List<Bookmark> find(@QueryParam("q") String query) throws Exception {

        return bc.load();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Bookmark load(@PathParam("id") Long id) throws Exception {
        Bookmark result = bc.load(id);

        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    @POST
    @Transactional
    @ValidatePayload
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Bookmark entity, @Context UriInfo uriInfo) throws Exception {
        checkId(entity);

        String id = bc.insert(entity).getId().toString();
        URI location = uriInfo.getRequestUriBuilder().path(id).build();

        return Response.created(location).entity(id).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @ValidatePayload
    @Produces("application/json")
    @Consumes("application/json")
    public void update(@PathParam("id") Long id, Bookmark entity) throws Exception {
        checkId(entity);
        load(id);

        entity.setId(id);
        bc.update(entity);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) throws Exception {
        load(id);
        bc.delete(id);
    }

    @DELETE
    @Transactional
    public void delete(List<Long> ids) throws Exception {
        bc.delete(ids);
    }

    private void checkId(Bookmark entity) throws Exception {
        if (entity.getId() != null) {
            throw new BadRequestException();
        }
    }
}
