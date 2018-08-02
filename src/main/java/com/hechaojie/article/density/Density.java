package com.hechaojie.article.density;

/**
 * 文本索引之间密度
 * @author hecj
 */
public class Density {
	
	/**
	 * 开始位置
	 */
	private int startIndex;
	/**
	 * 结束位置
	 */
	private int endIndex;
	/**
	 * 中文字符个数
	 */
	private long chineseTotal;
	/**
	 * 字符个数
	 */
	private long charTotal;
	/**
	 * 权重
	 */
	private double weight;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public long getChineseTotal() {
		return chineseTotal;
	}
	public void setChineseTotal(long chineseTotal) {
		this.chineseTotal = chineseTotal;
	}
	public long getCharTotal() {
		return charTotal;
	}
	public void setCharTotal(long charTotal) {
		this.charTotal = charTotal;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
