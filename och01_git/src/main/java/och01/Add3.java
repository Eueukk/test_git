package och01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L; // 내부에서 관리하는 버전정보
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 콘솔에 메시지 출력: 서블릿이 GET 요청을 받았을 때 로깅 목적으로 사용
		System.out.println("Add3 Get Sart...");
		
		// 목표 : 1부터 누적값 전달
		
		// // 클라이언트에서 전달된 "num"파라미터를 가져와서 정수로 변환
		// HTML에서 전송된 "num"은 문자열 형태이므로 parseInt 메서드를 사용하여 정수로 변환
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		
		System.out.println("Add num->"+num);
		
	    int sum = 0; // 누적값을 저장할 변수 초기화
	    for (int i = 1; i <= num; i++) {
	        sum += i; // 1부터 'num'까지의 숫자를 더하여 'sum'에 누적
		}
	    // 콘솔에 최종 누적값 sum 출력
		System.out.println("Add3 sum->"+sum);
		
		// 요청과 응답의 문자 인코딩을 설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 공식 --> 사용자 'Browser'에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // HTML 문서 시작
		// 형식지정자 %d = 숫자(decimal) %s = 문자(string)
		// % = 해당위치에 값을 넣음
		out.printf("<h1>1부터 %d까지 합계 %s</h1>", num, loc); // 동적으로 생성된 제목 출력
		//out.printf("<h4>LOC--> %s<h4>",loc); // 주석 처리된 부분은 현재 사용되지 않는 코드
		out.println(sum); // 누적값 출력
		out.println("</body></html>"); // HTML 문서 끝
		out.close(); // 출력 스트림 닫기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Add3 Post Sart...");
		doGet(request, response);
	}

}
