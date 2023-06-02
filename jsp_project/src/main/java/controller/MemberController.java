package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;  //목적지로 보내기 위한 수단
	private MemberService msv;		//컨트롤러를 dao에게 보내주는 역할
	private int isOk;
	private String destPage;
	
	
    public MemberController() {
    	msv = new MemberServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String uri=request.getRequestURI(); //요청 경로
		log.info(">>> uri : "+uri);
		
		String path=uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : "+path);
		
		 switch(path) {
		 case "join":
			 destPage="/member/join.jsp";
			 break;
			 
		 case "register" :
			 String id = request.getParameter("id");
			 String password = request.getParameter("password");
			 String email = request.getParameter("email");
			 int age = Integer.parseInt(request.getParameter("age"));
			 
			 MemberVO mvo = new MemberVO(id, password, email, age);
			 isOk = msv.register(mvo);
			 log.info(">>> JOIN>"+ (isOk>0 ?"성공" : "실패"));
			 destPage="/index.jsp";
			 break;
			 
		 case "login" :
			 log.info(">>> login page 이동 ");
			 destPage="/member/login.jsp";
			 break;
			 
		 case "login_auth":
			 try {
			 String id2 =request.getParameter("id");
			 String password2=request.getParameter("password");
			 
			 MemberVO mvo2=new MemberVO(id2,password2);
			 log.info(">>> login 요청!");
			 MemberVO loginMvo=msv.login(mvo2);
			 //같은 정보가 있으면 객체에 저장
			 //객체를 세션에 저장해서 로그인 상태 유지
			 
			 if(loginMvo!=null) {
				 //세션 가져오기, 연결된 세션이 없다면 생성.
				 HttpSession ses=request.getSession();
				 ses.setAttribute("ses", loginMvo);
				 //로그인 유지 시간, (10*60) = 10분 유지하겠다.
				 ses.setMaxInactiveInterval(10*60);
			 }else {
				 request.setAttribute("msg_login", 0);
			 }
			 destPage="/index.jsp";
			 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 break;
			 
		 case "logout" : 
			 try {
				HttpSession ses = request.getSession(); 
				MemberVO mvo2=(MemberVO)ses.getAttribute("ses");
				String id2=mvo2.getId();
				log.info(">>> login id : "+id2);
				
				//로그인정보(id)를 주고 마지막 로그인 시간 기록(update)
				isOk=msv.lastLogin(id2);
				log.info(">>> logout>"+ (isOk>0 ?"성공" : "실패"));
				//세션 무효화, 현재 세션과 관련된 모든 데이터가 삭제되고 세션 ID도 무효화
				ses.invalidate();
				destPage="/index.jsp";
				
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 break;
			 
		 case "modify" :
			 try {
			 HttpSession ses = request.getSession();
			 MemberVO m=(MemberVO)ses.getAttribute("ses");
			 String id3=m.getId();
			 MemberVO mvo3=new MemberVO();
			 mvo3=msv.detail(id3);
			 request.setAttribute("mvo", mvo3);
			 destPage="/member/modify.jsp";
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 break;
			 
		 case "modifyDone":
			 String id4=request.getParameter("id");
			 String pw=request.getParameter("password");
			 String email2=request.getParameter("email");
			 int age2=Integer.parseInt(request.getParameter("age"));
			 
			 MemberVO vo=new MemberVO(id4, pw, email2, age2);
			 msv.modify(vo);
			 destPage="/index.jsp";
			 
			 break;
			 
		 case "delete":
			 try {
			 HttpSession ses=request.getSession();
			 String id5=((MemberVO)ses.getAttribute("ses")).getId();
			 isOk=msv.remove(id5);
			 log.info(">>> remove > "+(isOk>0 ? "성공" : "실퍠"));
			 destPage="/index.jsp";
			 ses.invalidate();
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 break;
			 
		 case "list":
			 List<MemberVO> list =new ArrayList<MemberVO>();
			 list=msv.list();
			 request.setAttribute("list", list);
			 destPage="/member/list.jsp";
			 break;
			 
		 }
		 
		 
		
		//이게 뭐야??
		rdp=request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		service(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
