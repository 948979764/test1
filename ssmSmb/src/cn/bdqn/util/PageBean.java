package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {
	private int pageNo;// 当前页
	private int pageSize;// 每页数量
	private int totalCount;// 总记录数
	private int totalPages;// 总页数
	private List<T> pageList;// 每页对应的集合

	public int getPageNo() {
		return pageNo;
	}
       //当前页面不能小于1也不能大于总页数
	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else if (totalPages>1&&pageNo > totalPages) {
			this.pageNo = totalPages;//最后一页
		} else {
			this.pageNo = pageNo;
		}

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	// 计算总页数
	public void setTotalCount(int totalCount) {
		this.totalPages = (totalCount % pageSize == 0) ? totalCount / pageSize
				: totalCount / pageSize + 1;
	}

	// 只读
	public int getTotalPages() {
		return totalPages;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}