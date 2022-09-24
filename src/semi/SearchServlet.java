package semi;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
 * Servlet implementation class Servlet4
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/**
		 * それぞれ入力されたパラメータがnullでないか判定
		 * nullなら空文字を入れてぬるぽを防ぐ
		 */
		//フライト日
		String flight_date_param = request.getParameter("flight_date");
		if (flight_date_param == null) {
			flight_date_param = "";
		}
		//出発地
		String origin_code_param = request.getParameter("origin_code");
		if (origin_code_param == null) {
			origin_code_param = "";
		}
		//目的地
		String destination_code_param = request.getParameter("destination_code");
		if (destination_code_param == null) {
			destination_code_param = "";
		}

		//jspファイルを定義
		String forwardJsp = "search.jsp";
		//フライトのリスト　検索結果に合致するものをaddしていく
		ArrayList<DFlight> flightList = new ArrayList<>();
		try (Connection conn = DbUty.getConnection()) {
			if (!(flight_date_param.equals("") || origin_code_param.equals("") || destination_code_param.contentEquals(""))) {
				//SQL文　D＿フライトから日図家、出発地、目的地が合致するデータを抽出
				String sql = "SELECT * FROM D_フライト " +
						" WHERE " +
						" フライト日付 =? " +
						" AND " +
						" 出発地コード =? " +
						" AND " +
						"　目的地コード =? ";

				//データの変換
				LocalDate flight_date_ppst = LocalDate.parse(flight_date_param);
				//toUpperCaseメソッドは小文字をすべて大文字にする
				String origin_code_ppst = origin_code_param.toUpperCase();
				String destination_code_ppst = destination_code_param.toUpperCase();
				//SQLの結果をｐｐｓｔに抽出
				PreparedStatement ppst = conn.prepareStatement(sql);
				//結果の見出しをセット
				ppst.setDate(1, Date.valueOf(flight_date_ppst));
				ppst.setString(2, origin_code_ppst);
				ppst.setString(3, destination_code_ppst);
				//
				ResultSet rs = ppst.executeQuery();
				//一データずつフォーマットしながら検索結果をリストにaddする
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
				//conn.close();
			}
		} catch (Exception ex) {
			//例外処理
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			//forwardJsp = "error.jsp";
			request.setAttribute("errorMessage", ex.getMessage());
			request.setAttribute("errorDetail", sw.toString());

		}
		//検索結果をリクエストに加える
		request.setAttribute("title", "飛行機予約検索結果");
		request.setAttribute("flights", flightList);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + forwardJsp);
		rd.forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());

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
