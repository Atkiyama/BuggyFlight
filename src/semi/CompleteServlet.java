package semi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardJsp = "complete.jsp";
		/*
		String flight_date_param = request.getParameter("date");
		//出発地
		String flight_Number = request.getParameter("no");
		String name_param = request.getParameter("name");
		//出発地
		String number_of_people = request.getParameter("number_of_people");
		String card_number = request.getParameter("card_number");


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

//				String sql = "INSERT INTO D_予約 " +
//						"(予約番号,予約者氏名,クレジットカード番号,搭乗者,搭乗者数,単価,フライト日付,フライト番号,料金区分)"
//						+""
			}
		} catch (Exception ex) {

		}

*/
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
