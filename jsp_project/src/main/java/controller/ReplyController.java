package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ReplyVO;
import service.ReplyService;
import service.ReplyServiceImpl;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("/re/*")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ReplyController.class);
	private ReplyService rsv;
	private int isOk;

	// 비동기 통신으로 요청이 온 곳으로 자동으로 돌려보냄.
	// private RequestDispatcher rdp;
	// private String destPage;

	public ReplyController() {
		rsv = new ReplyServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// contentType 사용하지 않음
		// response.setContentType("text/html; charset=utf-8");

		// REST API 방식??
		// re/post/1 이런 식으로 uri를 받을 예정.
		String uri = request.getRequestURI();
		String pathUri = uri.substring("/re/".length());
		String path = pathUri;
		log.info(">> path > " + path);
		String pathVar = "";
		if (pathUri.contains("/")) {
			path = pathUri.substring(0, pathUri.lastIndexOf("/"));
			pathVar = pathUri.substring(pathUri.lastIndexOf("/") + 1);
		}

		switch (path) {

		case "post":
			try {
				StringBuffer sb = new StringBuffer();
				String line = "";
				
				//getReader을 해줌으로 써 request의 body만 가져온다.
				BufferedReader br = request.getReader(); // 댓글 객체

				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> sb : " + sb.toString());

				// 객체로 생성
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				log.info(">>> jsonObj : " + jsonObj);

				int bno = Integer.parseInt(jsonObj.get("bno").toString());
				String id = jsonObj.get("user_id").toString();
				String content = jsonObj.get("content").toString();
				ReplyVO rvo = new ReplyVO(bno, id, content);
				isOk = rsv.post(rvo);
				log.info(isOk > 0 ? "댓글 저장 완료" : "댓글 저장 실패");

				// 이건 왜 해준 것인가요??
				PrintWriter out = response.getWriter();
				out.print(isOk);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "list":
			try {
				int bno = Integer.parseInt(pathVar);
				List<ReplyVO> list = new ArrayList<ReplyVO>();
				list = rsv.list(bno);
				log.info(">>> replyList 가져오기 성공!");

				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject();
					jsonObjArr[i].put("rno", list.get(i).getRno());
					jsonObjArr[i].put("user_id", list.get(i).getUser_id());
					jsonObjArr[i].put("board_bno", list.get(i).getBoard_bno());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("reg_date", list.get(i).getReg_date());

					jsonObjList.add(jsonObjArr[i]);
				}

				String jsonData = jsonObjList.toJSONString();

				PrintWriter out = response.getWriter();
				out.print(jsonData);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
			int rno=Integer.parseInt(request.getParameter("rnoVal"));
			log.info(">>>> rno : "+rno);
			isOk=rsv.remove(rno);
			log.info(isOk > 0 ? "댓글 삭제 완료" : "댓글 삭제 실패");

			PrintWriter out=response.getWriter();
			out.print(isOk);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "modify" :
			try {
				StringBuffer sb=new StringBuffer();
				String line="";
				BufferedReader br=request.getReader();
				
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				log.info(">>> sb : " + sb.toString());
				
				JSONParser parser=new JSONParser();
				JSONObject jsonObject=(JSONObject)parser.parse(sb.toString());
				
				int rno=Integer.parseInt(jsonObject.get("rno").toString());
				log.info(">>> rno > "+rno);
				
				//object로 반환해주기 때문에 toString으로 변환해야됨.
				String user_id=jsonObject.get("user_id").toString();
				log.info(">>> writer"+user_id);
				String content=jsonObject.get("content").toString();
				
				
				ReplyVO rvo=new ReplyVO(user_id,rno,content);
				isOk=rsv.modify(rvo);
				log.info(isOk > 0 ? "댓글 수정 완료" : "댓글 수정 실패");
				
				PrintWriter out =response.getWriter();
				out.print(isOk);

			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
//		case "register":
//			String id=request.getParameter("id");
//			int bno=Integer.parseInt(request.getParameter("bno"));
//			String content=request.getParameter("content");		
//			
//			ReplyVO rvo=new ReplyVO(id,bno,content);
//			isOk=rsv.register(rvo);
//			log.info(isOk>0 ? "성공" :"실패");
//			
//			break;
//		
//			
//		case "remove":
//			int rno=Integer.parseInt(request.getParameter("rno"));
//			isOk=rsv.remove(rno);
//			log.info(isOk>0 ? "reply 삭제 성공" :"reply 삭제 실패");
//			break;

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
