package Strategy3.Modulalization;

import Strategy3.component.*;

public class Person1 {

	private GetImpl get;
	private JobImpl job;

	private Str
	ing id;
	private String name;

	public Person1(String id, String name) {
	this.id = id;
	this. name = name;
	}

	public void print() {
		System.out.printf("[id]"+id+"\t[이름]"+name);
	}

	public void isGet() {
		get.get();
	}

	public void isJob() {
		job.job();
	}

	public GetImpl getGet() {
		return get;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}

	public JobImpl getJob() {
		return job;
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}

}
