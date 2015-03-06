package org.demoiselle.persistence;

import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import org.demoiselle.entity.User;

@PersistenceController
public class UserDAO extends JPACrud<User, Long> {

    private static final long serialVersionUID = 1L;

}
