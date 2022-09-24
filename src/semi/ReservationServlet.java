package semi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DFlight;
import db.DbUty;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardJsp = "reservation.jsp";
		ArrayList<DFlight> flightList = new ArrayList<>();
		String flight_date_param = request.getParameter("date");
		//出発地
		String flight_Number = request.getParameter("no");
		//目的地
		String sql = "SELECT * FROM D_フライト " +
				" WHERE " +
				" フライト日付 =" + flight_date_param +
				" AND " +
				"フライト番号=" + flight_Number;
		try (Connection conn = DbUty.getConnection()) {
			LocalDate flight_date_ppst = LocalDate.parse(flight_date_param);
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.setDate(1, Date.valueOf(flight_date_ppst));
			ppst.setString(2, flight_Number);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				LocalDate flight_date_rs = rs.getDate("フライト日付").toLocalDate();
				String flight_no_rs = rs.getString("フライト番号");
				String origin_code_rs = rs.getString("出発地コード");
				LocalTime departure_time_rs = rs.getTime("出発時間").toLocalTime();
				String destination_code_rs = rs.getString("目的地コード");
				LocalTime arrival_time_rs = rs.getTime("到着時間").toLocalTime();
				String body_code_rs = rs.getString("機体コード");
				DFlight dflight = new DFlight();
				System.out.println(departure_time_rs);
				dflight.setFlightDate(flight_date_rs);
				dflight.setFlightNo(flight_no_rs);
				dflight.setOriginCode(origin_code_rs);
				dflight.setDepartureTime(departure_time_rs);
				dflight.setDestinationCode(destination_code_rs);
				dflight.setArrivalTime(arrival_time_rs);
				dflight.setBodyCode(body_code_rs);

				flightList.add(dflight);
			}
		} catch (Exception ex) {

		}

		request.setAttribute("flights", flightList);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + forwardJsp);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
