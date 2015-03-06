package org.demoiselle.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import java.util.List;
import org.demoiselle.entity.Bookmark;

@PersistenceController
public class BookmarkDAO extends JPACrud<Bookmark, Long> {

    private static final long serialVersionUID = 1L;

    public List<Bookmark> find(String filter) {
//		StringBuffer ql = new StringBuffer();
//		ql.append("  from Bookmark b ");
//		ql.append(" where lower(b.description) like :description ");
//		ql.append("    or lower(b.link) like :link ");
//
//		TypedQuery<Bookmark> query = getEntityManager().createQuery(ql.toString(), Bookmark.class);
//		query.setParameter("description", "%" + filter.toLowerCase() + "%");
//		query.setParameter("link", "%" + filter.toLowerCase() + "%");

        return null;//query.getResultList();
    }
}
