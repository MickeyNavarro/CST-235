//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235
package business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Bible;


@RequestScoped
@Path("/bible")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class BibleRestService {

	@Inject
	BibleBusinessService service;

	// returns JSON data based on book, chapter, and verse number entered
	@GET
	@Path("/verseRest/{book}/{chapter}/{verse}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bible getFullVerse(@PathParam("book") String bookName, @PathParam("chapter") int chapterNo,
			@PathParam("verse") int verseNo) {

		Bible fullVerse = service.findFullVerse(bookName, chapterNo, verseNo);

		// error is shown if no verse was found
		if (fullVerse == null) {
			throw new RuntimeException("Verse was not found");
		}

		return service.findFullVerse(bookName, chapterNo, verseNo);
	}
}
