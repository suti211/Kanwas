package module;

import java.util.List;

import user.Student;

public class TextPage extends Module {

	public TextPage(String title, String content, int id, boolean published) {
		super(title, content, id, published);
		this.published = published;
	}

}
