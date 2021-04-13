//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235 
package business;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import beans.Bible;
import data.BibleDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(BibleBusinessInterface.class)
@Alternative
public class BibleBusinessService implements BibleBusinessInterface {

	@Inject
	BibleDataService service;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
	
	/**
     * Default constructor. 
     */
	public BibleBusinessService() {}

	@Override
	public Bible findFullVerse(String bookName, int chapterNo, int verseNo) {
		return service.findFullVerse(bookName, chapterNo, verseNo);
	}

}
