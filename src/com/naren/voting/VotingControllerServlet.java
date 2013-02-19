package com.naren.voting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VotingControllerServlet
 */
public class VotingControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotingControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside of doGet method of VotingController");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside of doPost of VotingController");
		process(request, response);
	}
	
	
	

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		Model m = new Model();
		String uri = request.getRequestURI();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(true);
		if(uri.contains("/auth"))
		{
			System.out.println("Authentication working properly");
			AuthBean ab = (AuthBean)request.getAttribute("auth");
			System.out.println("Username"+" "+ab.getUsername()+" "+"Password"+ab.getPwd());
			String res = ab.authenticate();
			if(res.contains(Constants.SUCCESS))
			{
				System.out.println("Hello sir welcome");
				rd=request.getRequestDispatcher("VotingDetails.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("I think you are not Election Commissioner");
				request.setAttribute("errmsg", res);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		
		if(uri.contains("/Votingform"))
		{
			
			session.setAttribute("vote","voter");
			System.out.println(session.getAttribute("vote"));
			String redirect_url = "http://localhost:8080/VotingApp/VotingForm.html";
			response.sendRedirect(redirect_url);
													
		}
		
		
		if(uri.contains("/voting"))
		{
					
				System.out.println(session.getAttribute("vote"));
				if(session.getAttribute("vote")!=null)
				{
						VoteBean vb = (VoteBean)request.getAttribute("vote");
						System.out.println("Uid's are "+" "+vb.getUid1()+" "+vb.getUid2());
						String res = m.voteDetails(vb);
					if(res.contains(Constants.SUCCESS))
					{
						
						java.awt.Toolkit.getDefaultToolkit().beep();	
						rd = request.getRequestDispatcher("VotingSession.jsp");
						//String redirect_url = "http://localhost:8080/VotingApp/VotingSession.jsp";
						//session.removeAttribute("vote");
						//response.sendRedirect(redirect_url);
						
						rd.forward(request, response);
						
					}
					
				}
				else
				{
					System.out.println("Session had expired");
					rd=request.getRequestDispatcher("VotingSession.jsp");
					rd.forward(request, response);
				}
		}
		if(uri.contains("/results"))
		{
			System.out.println("This was going to show results");
			VoteBean vb = (VoteBean)request.getAttribute("pname");
			System.out.println(vb.getPname());
			String res = m.results(vb);
			request.setAttribute("msg", res);
			System.out.println(request.getAttribute("msg"));
			rd = request.getRequestDispatcher("ResultShow.jsp");
			rd.forward(request, response);
			/*String redirect_url = "http://localhost:8080/VotingApp/ResultShow.jsp";
			response.sendRedirect(redirect_url);*/
			
		}
	
	}

}
