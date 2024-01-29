package och01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuGu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트에서 전달된 "num" 파라미터를 가져와서 정수로 변환
		int num = Integer.parseInt(request.getParameter("num"));

		// HTTP 응답의 Content-Type을 설정하여 한글이 포함된 HTML을 제공
		response.setContentType("text/html;charset=utf-8");

		// HTTP 응답을 위한 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();

		// HTML 문서의 시작 부분 출력
		out.print("<html><body>");
		// 동적인 부분: 구구단 계산 및 출력
		out.print("<h1>구구단 " + num + " 단</h1>");
		for (int i = 1; i <= 9; i++) {
			out.printf("%d * %d = %d<br>", num, i, num * i);
		}
		// HTML 문서의 끝 부분 출력
		out.print("</body></html>");
		// PrintWriter 사용 후 반드시 close() 호출하여 자원을 정리
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
