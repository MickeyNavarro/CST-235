//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235
package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Bible;
import business.BibleBusinessInterface;

@ManagedBean 
@ViewScoped
public class BibleController {
	
	@Inject 
	BibleBusinessInterface service; 
	
	//method to search for bible verse in the db
	public String onSubmit(Bible bible) {
		
		//call the findFullVerse() method to get the specific verse from the db 
		bible = service.findFullVerse(bible.getBookName(), bible.getChapterNo(), bible.getVerseNo());
			
		//put the bible object into the get request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("bible", bible);

		//returns view
		return "VerseResponse.xhtml";
	}
		
}
