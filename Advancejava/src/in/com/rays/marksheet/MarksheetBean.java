package in.com.rays.marksheet;

public class MarksheetBean {
	private int Id;
	private int Rollno;
	private String Name;
	private int phy;
	private int chem;
	private int maths;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getRollno() {
		return Rollno;
	}
	public void setRollno(int Rollno) {
		Rollno = Rollno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhy() {
		return phy;
	}
	public void setPhy(int phy) {
		this.phy = phy;
	}
	public int getChem() {
		return chem;
	}
	public void setChem(int chem) {
		this.chem = chem;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	

}
