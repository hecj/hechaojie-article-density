package test.hechaojie.article;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.hechaojie.article.density.AritcleDensityKit;

public class TestArticle {

	public static void main(String[] args) throws IOException {
		String text = FileUtils.readFileToString(new File("/Users/hecj/Desktop/3.txt"),"utf-8");
		text = StringEscapeUtils.unescapeHtml(text);
		text = filterIgnore(text);
		long time = System.currentTimeMillis();
		String body = AritcleDensityKit.getArticleBody(text);
		System.out.println("耗时:"+(System.currentTimeMillis()-time));
		System.out.println(body);
		// body中 超过50个非中文字符 则解析失败
	}
	
	private static String filterIgnore(String text) {
		text = text.replaceAll("<!--.+-->", "");
		text = text.replaceAll("</div>", "\n");
		text = text.replaceAll("</p>", "\n");
		text = text.replaceAll("<.+>", "");
		return text;
	}
	
	
}
