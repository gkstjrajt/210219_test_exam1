package ncs_java_yhs2.dto;

public class Sale {
	private int custNo;
	private String custName;
	private String grade;
	private int sale;

	public Sale() {
	}

	public Sale(int custNo, String custName, String grade, int sale) {
		super();
		this.custNo = custNo;
		this.custName = custName;
		this.grade = grade;
		this.sale = sale;
	}

	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "Sale [custNo=" + custNo + ", custName=" + custName + ", grade=" + grade + ", sale=" + sale + "]";
	}

}
