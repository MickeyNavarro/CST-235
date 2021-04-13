//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235 

package business;

import javax.ejb.Local;

import beans.Bible;

@Local
public interface BibleBusinessInterface {

	//method to find the verse 
	public Bible findFullVerse(String bookName, int chapterNo, int verseNo);

}
