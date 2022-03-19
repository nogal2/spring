import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import movie.CGVdata;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		// Jsoup: 각종 사이트(HTML)에서 데이터를 취합할 수 있는 Library
		Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();	// 해당 사이트의 소스코드를 가져온 것
		/*
			 
                    <div class="box-contents">
                        <a href="/movies/detail-view/?midx=85632">
                            <strong class="title">더 배트맨</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">예매율<span>40.6%</span></strong>

		*/
		
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		
		Elements titles = doc.select("div.box-contents strong.title");	// 위 사이트에 있는 타이틀 들만 다 가져오는 것.
		
		for(int i=0; i<19; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			
			System.out.println(title.text());
			System.out.println(percent.text());
		}
		
		CGVdata.getCGVdata();

	}

}
