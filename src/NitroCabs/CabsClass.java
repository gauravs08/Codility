package NitroCabs;

public class CabsClass {

	public CabsClass(String regNo, Integer currLoc) {
		super();
		RegNo = regNo;
		this.currLoc = currLoc;
	}
	
	private String RegNo;
	private Integer currLoc;
	
	
	public String getRegNo() {
		return RegNo;
	}
	public void setRegNo(String regNo) {
		RegNo = regNo;
	}
	public Integer getCurrLoc() {
		return currLoc;
	}
	public void setCurrLoc(Integer currLoc) {
		this.currLoc = currLoc;
	}
}
