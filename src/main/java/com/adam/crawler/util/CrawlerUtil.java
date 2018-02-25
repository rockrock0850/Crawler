package com.adam.crawler.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerUtil {
	
	public static List<String> getHrefs (String target) throws IOException {
		Document doc = Jsoup.connect(target).get();
		Elements elements = doc.getElementsByAttribute("href");

		List<String> hrefs = new ArrayList<String>();
		for (Element element : elements) {
			String href = element.attr("href");
			
			if (!StringUtils.startsWith(href, "http")) {continue;}
			
			hrefs.add(href);
		}
		
		return hrefs;
	}
	
}