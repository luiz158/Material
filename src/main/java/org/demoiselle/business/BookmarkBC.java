package org.demoiselle.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import java.util.ArrayList;
import java.util.Random;
import org.demoiselle.entity.Bookmark;
import org.demoiselle.persistence.BookmarkDAO;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {

    private static final long serialVersionUID = 1L;

    public List<Bookmark> load() {
        Random r = new Random();
        List<Bookmark> lista = new ArrayList<Bookmark>();

        for (long i = 1; i <= 10; i++) {

            Bookmark bookmark = new Bookmark();
            bookmark.setId(r.nextLong());
            bookmark.setActors("setActors" + i + r.nextLong());
            bookmark.setAwards("setAwards" + i + r.nextLong());
            bookmark.setCountry("setCountry" + i + r.nextLong());
            bookmark.setDirector("setDirector" + i + r.nextLong());
            bookmark.setGenre("setGenre" + i + r.nextLong());
            bookmark.setImdbrating("setImdbrating" + i + r.nextLong());
            bookmark.setImdbvotes("setImdbvotes" + i + r.nextLong());
            bookmark.setLanguage("setLanguage" + i + r.nextLong());
            bookmark.setMetascore("setMetascore" + i + r.nextLong());
            bookmark.setPlot("setPlot" + i + r.nextLong());
            bookmark.setPoster("setPoster" + i + r.nextLong());
            bookmark.setRated("setRated" + i + r.nextLong());
            bookmark.setReleased("setReleased" + i + r.nextLong());
            bookmark.setResponse("setResponse" + i + r.nextLong());
            bookmark.setRuntime("setRuntime" + i + r.nextLong());
            bookmark.setTitle("setTitle" + i + r.nextLong());
            bookmark.setYear("setYear" + i + r.nextLong());
            bookmark.setWriter("setWriter" + i + r.nextLong());
            bookmark.setType("setType" + i + r.nextLong());
            lista.add(bookmark);
        }

        return lista;
    }
}
