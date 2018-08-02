package com.hechaojie.article.density;

import java.util.ArrayList;
import java.util.List;

import com.hechaojie.article.density.kit.ChineseKit;

/**
 * 文章密度提取入口
 * @author hecj
 *
 */
public class AritcleDensityKit {

	/**
	 * 获取正文
	 * @param text
	 * @return
	 */
	public static String getArticleBody(String text) {
		List<Section> sections = getSections(text);
		List<Density> densitys= calculateDensitys(text,sections);
		Density density = calculateMinDensitys(densitys);
		if(density == null) {
			return "";
		}
		return text.substring(density.getStartIndex(), density.getEndIndex()+1);
	}
	
	private static Density calculateMinDensitys(List<Density> densitys){
		if(densitys == null || densitys.size() == 0) {
			return null;
		}
		Density maxDensity = densitys.get(0);
		for(int i=1;i<densitys.size();i++) {
			Density m = densitys.get(i);
			if(maxDensity.getWeight() < m.getWeight()) {
				maxDensity = m;
			}
		}
		return maxDensity;
	}
	
	/**
	 * 计算文本密度权重
	 * @param sections
	 * @return
	 */
	private static List<Density> calculateDensitys(String text,List<Section> sections){
		List<Density> densitys = new ArrayList<Density>();
		for(int i=0 ;i<sections.size();i++) {
			for(int j=i;j<sections.size();j++) {
				densitys.add(calculateDensity(text,sections, i,j));
			}
		}
		return densitys;
	}
	
	/**
	 * 计算2个段之间的文字密度权重
	 * @param section
	 * @param sectionTarget
	 * @return
	 */
	private static Density calculateDensity(String text,List<Section> sections,int start,int end) {
		int chineseTotal = 0;
		for(int i=start;i<=end;i++) {
			Section section = sections.get(i);
			chineseTotal += (section.getEndIndex()-section.getStartIndex());
		}
		
		String content = text.substring(sections.get(start).getStartIndex(),sections.get(end).getEndIndex());
		int ignoreTotal = 0;
		ignoreTotal += content.length() - content.replaceAll(" ", "").length();
		ignoreTotal += content.length() - content.replaceAll("[0-9]", "").length();
		
		Density density = new Density();
		density.setStartIndex(sections.get(start).getStartIndex());
		density.setEndIndex(sections.get(end).getEndIndex());
		density.setCharTotal(density.getEndIndex()-density.getStartIndex());
		density.setChineseTotal(chineseTotal);
		double chineseWeight = (density.getChineseTotal()+ignoreTotal)*(density.getChineseTotal()+ignoreTotal);
		double weight = chineseWeight/density.getCharTotal();
		density.setWeight(weight);
		return density;
	}
	
	/**
	 * 提取文本段集合
	 * @param text
	 * @return
	 */
	private static List<Section> getSections(String text){
		List<Section> list = new ArrayList<Section>();
		int cursor = 0;
		while(true) {
			Section section = getSection(cursor, text);
			if(section != null) {
				cursor = section.getEndIndex()+1;
				list.add(section);
			} else {
				break;
			}
		}
		return list;
	}
	
	/**
	 * 获取正文段
	 * @param start
	 * @param text
	 * @return
	 */
	private static Section getSection(int start,String text) {
		Section section = null;
		for(int i=start;i<text.length(); i++) {
			if(ChineseKit.isChinese(text.charAt(i))) {
				if(section == null) {
					section = new Section(i,i);
				}
				section.setEndIndex(i);
			} else {
				if(section != null) {
					section.setContent(text.substring(section.getStartIndex(), section.getEndIndex()+1));
					return section;
				}
			}
		}
		return null;
	}
}
