package module;

import java.util.List;

import user.Student;

public class Assignment extends Module {
	private String answer;
	private int maxScore;
	private List<Student> answeredStudents;
	
	public Assignment(String title, String content, int id, int index, String answer, int maxScore, boolean published, List<Student> answeredUsers) {
		super(title, content, id, index, published);
		this.answer = answer;
		this.maxScore = maxScore;
		this.answeredStudents = answeredUsers;
		this.published = published;
	}
	public Assignment(String title, String content, int id, int maxScore, boolean published)
	{
		super(title, content, id, maxScore, published);
		this.maxScore = maxScore;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public void setAnsweredStudents(List<Student> answeredStudents) {
		this.answeredStudents = answeredStudents;
	}
	
}
