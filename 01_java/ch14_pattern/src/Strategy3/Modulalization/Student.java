package Strategy3.Modulalization;

import Strategy3.component.*;

public class Student extends Person1 {
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban=ban;
		setGet(new GetStudentPay());
		setJob(new JobStudy());
	}

	@Override
	public void print() {
		System.out.println("===학생");

	}
	
	@Override
	public String toString() {
		return super.toString()+"\t[반]"+ban;
	}
}
