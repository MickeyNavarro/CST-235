//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235 

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Bible")

@ManagedBean
@ViewScoped
public class Bible {

	//attributes
	@NotNull(message = "Please enter a book name. This is a required field.")
	@Size(min=2, max=10)
	String bookName = "";
	
	@NotNull(message = "Please enter a chapter number. This is a required field.")
	int chapterNo = 0;
	
	@NotNull(message = "Please enter a verse number. This is a required field.")
	int verseNo = 0;

	String fullVerse = "";
	
	//default constructor
	public Bible() {}
	
	
	//non-default constructor
	public Bible(String bookName, int chapterNo, int verseNo, String fullVerse) {
		super();
		this.bookName = bookName;
		this.chapterNo = chapterNo;
		this.verseNo = verseNo;
		this.fullVerse = fullVerse;
	}

	
	//setters & getters
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}

	public int getVerseNo() {
		return verseNo;
	}

	public void setVerseNo(int verseNo) {
		this.verseNo = verseNo;
	}

	public String getFullVerse() {
		return fullVerse;
	}

	public void setFullVerse(String fullVerse) {
		this.fullVerse = fullVerse;
	}
}

