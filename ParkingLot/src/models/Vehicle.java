package models;

public class Vehicle extends BaseModel{
	private String number;
	private VechicleType vechicleType;
	private String ownerName;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public VechicleType getVechicleType() {
		return vechicleType;
	}
	public void setVechicleType(VechicleType vechicleType) {
		this.vechicleType = vechicleType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
