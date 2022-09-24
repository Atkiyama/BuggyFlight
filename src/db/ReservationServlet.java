package db;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardJsp = "reservetion.jsp";
		String flight_date_param = request.getParameter("flight_date");
		//出発地
		String departure_time_param = request.getParameter("departure_time");
		String flight_param = request.getParameter("flight_name");
		String seat_param = request.getParameter("origin_name");
		String leftover__param = request.getParameter("origin_name");
		String origin_code_param = request.getParameter("origin_name");
		String origin_code_param = request.getParameter("origin_name");
		//目的地
		String destination_code_param = request.getParameter("destination_name");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
