package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDepo test = new ListDepo();
		test.read("Depo.txt");
		ArrayList<DepoBase> list = test.getList();
		String lday = (String)request.getParameter("lday");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.print("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.print("<title>Deposits</title>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Depo.css\" />");
		
		out.print("</head><body>");		
		out.print("<h1>Deposit List</h1>");
		if (!(lday == null)){
		    out.print("<h3>deposits longer then " + lday + " days</h3>");
		    int dd = Integer.valueOf(lday);
		    out.print("<table>");
		    out.print("<tr><td>Start<td>Long<td>Sum<td>Interest 	Rate</tr>");
		    for(DepoBase d : list){
	    		if (d.dayLong > dd){
		    		out.print(d.getDataForWeb());
	    		}
	    }
	    out.print("</table>");
	}
	out.print("</body></html>");




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
