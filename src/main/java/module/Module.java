package module;

public class Module {
	protected String title;
	protected String content;
	protected int id;
	protected int published;
	protected int index;

	public Module(String title, String content, int id, int index, int published) {
		this.title = title;
		this.content = content;
		this.id = id;
		this.published = published;
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int isPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Module [title=" + title + ", id=" + id + "]";
	}
	
}
