package mul.camp.a.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
CREATE TABLE BBS(
	    SEQ INT PRIMARY KEY,
	    ID VARCHAR(50) NOT NULL,    
	    REF INT NOT NULL,
	    STEP INT NOT NULL,
	    DEPTH INT NOT NULL,    
	    TITLE VARCHAR(200) NOT NULL,
	    CONTENT VARCHAR(4000) NOT NULL,
	    WDATE DATETIME NOT NULL,    
	    DEL TINYINT NOT NULL,
	    READCOUNT INT NOT NULL
	);
	ALTER TABLE BBS
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
	*/

public class BbsDto {
	private int seq;
	
	@JsonProperty("userid") // => 넘겨줄 때 키값을 id가 아니라 userid 로 보내라는 것. 웹,앱에서 적용됨.
	private String  id;
	
	private int ref;	// 게시글 번호
	private int step;	// 게시글 위치(세로)
	private int depth;	// 답글 위치(가로)
	
	private String title;
	private String content;
	private String wdate;
	
	private int del;
	private int readcount;
	
	public BbsDto() {}

	public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int del,
			int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
	}
	
	// 외부에서 들어오는 것들 초기화
	public BbsDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", content=" + content + ", wdate=" + wdate + ", del=" + del + ", readcount=" + readcount
				+ "]";
	}
	
	
	
}
