package org.demoiselle.business;

import br.gov.frameworkdemoiselle.annotation.Priority;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import javax.inject.Inject;
import org.demoiselle.entity.User;
import org.demoiselle.persistence.UserDAO;

@BusinessController
public class UsuarioBC extends DelegateCrud<User, Long, UserDAO> {

    private static final long serialVersionUID = -7801407214303725321L;

    @Transactional
    public void iniciarUsuario() {
        if (getDelegate().findAll().isEmpty()) {
            User admin = new User();
            admin.setCPF("admin");
            admin.setEmail("admin@serpro");
            admin.setName("ADMIN");
            admin.setSetor("");
            admin.setTelephoneNumber("");
            this.insert(admin);
        }
    }

}
