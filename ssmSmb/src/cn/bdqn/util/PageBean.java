package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {
	private int pageNo;// ��ǰҳ
	private int pageSize;// ÿҳ����
	private int totalCount;// �ܼ�¼��
	private int totalPages;// ��ҳ��
	private List<T> pageList;// ÿҳ��Ӧ�ļ���

	public int getPageNo() {
		return pageNo;
	}
       //��ǰҳ�治��С��1Ҳ���ܴ�����ҳ��
	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else if (totalPages>1&&pageNo > totalPages) {
			this.pageNo = totalPages;//���һҳ
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

	// ������ҳ��
	public void setTotalCount(int totalCount) {
		this.totalPages = (totalCount % pageSize == 0) ? totalCount / pageSize
				: totalCount / pageSize + 1;
	}

	// ֻ��
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