package module;

public class Module {
	protected String title;
	protected String content;
	protected int id;
	protected boolean published;
	protected int index;

	public Module(String title, String content, int id, int index, boolean published) {
		this.title = title;
		this.content = content;
		this.id = id;
		this.published = published;
		this.index = index;
	}
	
	
	

	public Module(String title, String content, int id, boolean published) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
		this.published = published;
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Module [title=" + title + ", id=" + id + "]";
	}
	
}
