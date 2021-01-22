package Strategy3.Modulalization;

import Strategy3.component.*;

public class Lecturer extends Person1 {	
	
	private String ban;
	public Lecturer(String id, String name, String ban) {
		super(id, name);
		this.ban=ban;
		setGet(new GetSalary());
		setJob(new JobLec());
	}

	@Override
	public void print() {
		System.out.println("===강사");
	}

}
