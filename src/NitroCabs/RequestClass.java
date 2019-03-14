package NitroCabs;

import java.util.Date;

public class RequestClass {

	public RequestClass(String rbrId, Integer pickUpLoc, Integer dropLoc,
			Date pickUpTime,Double priceAsk) {
		super();
		this.rbrId = rbrId;
		this.pickUpLoc = pickUpLoc;
		this.dropLoc = dropLoc;
		this.pickUpTime = pickUpTime;
		this.priceAsk = priceAsk;
	}
	

	private String rbrId;
	private Integer pickUpLoc;
	private Integer dropLoc;
	private Date pickUpTime;
	private Double priceAsk;
	
	
	public String getRbrId() {
		return rbrId;
	}
	public void setRbrId(String rbrId) {
		this.rbrId = rbrId;
	}
	public Integer getPickUpLoc() {
		return pickUpLoc;
	}
	public void setPickUpLoc(Integer pickUpLoc) {
		this.pickUpLoc = pickUpLoc;
	}
	public Integer getDropLoc() {
		return dropLoc;
	}
	public void setDropLoc(Integer dropLoc) {
		this.dropLoc = dropLoc;
	}
	public Date getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	} 
	public void setPriceAsk(Double priceAsk) {
		this.priceAsk = priceAsk;
	}
	public Double getPriceAsk() {
		return priceAsk;
	}
}
