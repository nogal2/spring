package movie;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class CGVdata {
	
	public static List<MovieVo> getCGVdata() throws Exception{
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();	// 해당 사이트의 소스코드를 가져온 것
		
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		Elements titles = doc.select("div.box-contents strong.title");	// 위 사이트에 있는 타이틀 들만 다 가져오는 것.
		
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		for(int i=0; i<19; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			
			String t = title.text();
			String p = percent.text();
			
			double pv = Double.parseDouble(p.replace("%", "").trim());	// 특정 문자열을 없내는 것. trim은 문자열 좌우에 공백을 없애주는것.
			
			MovieVo vo = new MovieVo(t, pv);
			list.add(vo);
		}
		return list;
		
	}
}
