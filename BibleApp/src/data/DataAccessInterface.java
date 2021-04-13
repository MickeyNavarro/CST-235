//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235 
package data;

import javax.ejb.Local;

import beans.Bible;

@Local 
public interface DataAccessInterface {

	//method to find the full verse given the book name, chapter number, and verse number 
	public Bible findFullVerse(String bookName, int chapterNo, int verseNo);
}
