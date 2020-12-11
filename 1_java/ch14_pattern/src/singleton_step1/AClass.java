package singleton_step1;

public class AClass {
	private int intVar;
	private static AClass INSTANCE;

	public static AClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AClass();
		}
		return INSTANCE;
	}

	public AClass() {
	}

	public int getIntVar() {
		return intVar;
	}

	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
}