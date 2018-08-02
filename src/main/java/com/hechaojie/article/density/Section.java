package com.hechaojie.article.density;

/**
 * 中文段对象
 * @author hecj
 */
public class Section {
	
	/**
	 * 中文段开始
	 */
	private Integer startIndex;
	/**
	 * 中文段结束
	 */
	private Integer endIndex;
	
	private String content;
	
	public Section(Integer startIndex, Integer endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
