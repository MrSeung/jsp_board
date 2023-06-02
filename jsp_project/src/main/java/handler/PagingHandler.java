package handler;

import domain.PagingVO;

public class PagingHandler {
	
	private int pageNo; //페이지네이션 크기(페이지목록 번호 범위)
	private int currentPage ; // 현재 페이지 번호
	private int totalPages ; // 전체 페이지 수
	private int startPage; // 시작 페이지 번호
	private int endPage;// 끝 페이지 번호
	private int prevPage ; // 이전 버튼 클릭 시의 페이지 번호
	private int nextPage ; // 다음 버튼 클릭 시의 페이지 번호
	private PagingVO pvo;
	
	public PagingHandler() {}
	
	public PagingHandler(PagingVO pvo,int pageNo,int currentPage,int totalPages) {
		this.pvo=pvo;
		this.pageNo=pageNo;
		this.currentPage=currentPage;
		this.totalPages=totalPages;
		this.startPage=(currentPage / pageNo) * pageNo; // 시작 페이지 번호
		this.endPage = Math.min(startPage + pageNo-1, totalPages-1); // 끝 페이지 번호
		this.prevPage = startPage - pageNo; // 이전 버튼 클릭 시의 페이지 번호
		this.nextPage = startPage + pageNo; // 다음 버튼 클릭 시의 페이지 번호
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	};
	
	
}
