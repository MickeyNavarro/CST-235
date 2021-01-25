package assignment;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
    	//print message to the console
    	System.out.println("Hello from the init() method");
	}

	/**
	 * @see Servlet#destroy()
	 */
    @Override
	public void destroy() {
    	//print message to the console
    	System.out.println("Hello from the destroy() method");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//print message to the console
    	System.out.println("Hello from the doGet() method");
    	
    	//get the parameters of request 
    	String firstName = request.getParameter("firstName"); 
    	String lastName = request.getParameter("lastName"); 
		
		//output message with first & last name to the browser
		//response.getWriter().append("The name you have entered is ").append(firstName + " " + lastName);
    	
    	//check if parameters have been sent
    	if (firstName != null || lastName != null || !firstName.isEmpty() || !lastName.isEmpty()) {
    		//set the attributes & send it to TestReponse.jsp
    		request.setAttribute("firstName", firstName);
    		request.setAttribute("lastName", lastName);
    		request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
    	}
    	else { 
    		//return to error page 
    		request.getRequestDispatcher("TestError.jsp").forward(request, response);
    		
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
