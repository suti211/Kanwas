package module;

public class Module {
	protected String title;
	protected String content;
	protected int id;
	protected boolean published;

	public Module(String title, String content, int id, boolean published) {
		this.title = title;
		this.content = content;
		this.id = id;
		this.published = published;
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
}
