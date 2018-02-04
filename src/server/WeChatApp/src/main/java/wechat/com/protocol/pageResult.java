package wechat.com.protocol;

import java.util.List;

public class pageResult<T> {
	private Integer total;
	private List<T> resultList;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
