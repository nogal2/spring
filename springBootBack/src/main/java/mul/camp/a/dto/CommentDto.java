package mul.camp.a.dto;

public class CommentDto {
	private int seq;
	private String id;
	private String wdate;
	private String content;
	
	public CommentDto() {}

	public CommentDto(int seq, String id, String wdate, String content) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentDto [seq=" + seq + ", id=" + id + ", wdate=" + wdate + ", content=" + content + "]";
	}
	
	
}
