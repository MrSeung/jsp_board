package domain;

public class PagingVO {
	
	private int pageStart; //게시물 시작점.
	private int qty; //한 페이지에 보여줄 게시글 수
	
	//검색 관련 변수
	private String type;
	private String keyword;
	
	
	
	public PagingVO() {
	}

	public PagingVO(String type, String keyword) {
		super();
		this.type = type;
		this.keyword = keyword;
	}

	public PagingVO(int pageStart, int qty) {
		super();
		this.pageStart = pageStart;
		this.qty = qty;
	}
	
	//이 부분 이해가 필요함..
	public String[] getTypeToArray() {
		return this.type==null? new String[] {} : this.type.split("");
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "PagingVO [pageStart=" + pageStart + ", qty=" + qty + ", type=" + type + ", keyword=" + keyword + "]";
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageStart() {
		return this.pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
