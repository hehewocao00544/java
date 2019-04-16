package CreateException;

public class Sorce {

	private int sorce;

	public Sorce() {

	}

	public Sorce(int sorce) {
		this.sorce = sorce;
	}

	public void check(int sorce) throws SorceException {
		if (sorce > 100 || sorce < 0) {
			throw new SorceException("分数必须在0-100之间！");
		} else {
			System.out.println("输入无异常！");
		}
	}

	public int getSorce() {
		return sorce;
	}

	public void setSorce(int sorce) {
		this.sorce = sorce;
	}

}
