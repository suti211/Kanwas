package module;

public class Module {
	protected String title;
	protected String content;
	protected int id;

	public Module(String title, String content, int id) {
		this.title = title;
		this.content = content;
		this.id = id;
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

}
