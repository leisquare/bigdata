package Strategy3.Modulalization;

import Strategy3.component.*;

public class Staff extends Person1 {
	private String ban;
	public Staff(String id, String name, String ban) {
		super(id, name);
		this.ban=ban;
		setGet(new GetSalary());
		setJob(new JobMng());
	}

	@Override
	public void print() {
		System.out.println("===스탭");
	}
}
