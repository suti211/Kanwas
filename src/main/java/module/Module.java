package module;

public class Module {
	protected int id;
	protected String title;
	protected String content;
	protected String type;
	private int MaxScore;
	protected int published;
	protected int index;

	public Module(int id, String title, String content, String type, int maxScore, int published, int index) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
		MaxScore = maxScore;
		this.published = published;
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getMaxScore() {
		return MaxScore;
	}

	public int isPublished() {
		return published;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Module{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", id=" + id + ", published="
				+ published + ", index=" + index + '}';
	}
}
