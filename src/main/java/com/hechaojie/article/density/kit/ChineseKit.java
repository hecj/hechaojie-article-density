package com.hechaojie.article.density.kit;

/**
 * 中文处理工具类
 * @author hecj
 */
public class ChineseKit {

	/**
	 * 是否是中文字符<br>
	 * 包含中文标点符号<br>
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C) {
			return true;
		} else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D) {
			return true;
		} else if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		} else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}
}
