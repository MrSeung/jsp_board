package domain;

public class ReplyVO {
	
	private int rno;
	private String user_id;
	private int board_bno;
	private String content;
	private String reg_date;
	
	public ReplyVO() {}
	
	public ReplyVO(int rno, String user_id, int board_bno, String content, String reg_date) {
		super();
		this.rno = rno;
		this.user_id = user_id;
		this.board_bno = board_bno;
		this.content = content;
		this.reg_date = reg_date;
	}

	public ReplyVO(int board_bno,String user_id, String content) {
		super();
		this.user_id = user_id;
		this.board_bno = board_bno;
		this.content = content;
	}
	
	public ReplyVO(String user_id,int rno, String content) {
		super();
		this.rno = rno;
		this.user_id = user_id;
		this.content = content;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", user_id=" + user_id + ", board_bno=" + board_bno + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}
	
	
}
