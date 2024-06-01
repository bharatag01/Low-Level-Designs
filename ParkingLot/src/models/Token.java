package models;

import java.util.Date;

public class Token extends BaseModel {

	private String number;
	private Gate generatedAt;
	private Operator generatedBy;

	public Gate getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(Gate generatedAt) {
		this.generatedAt = generatedAt;
	}

	public Operator getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(Operator generatedBy) {
		this.generatedBy = generatedBy;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Vehicle getVechicle() {
		return vechicle;
	}

	public void setVechicle(Vehicle vechicle) {
		this.vechicle = vechicle;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	private Date entryTime;
	private Vehicle vechicle;
	private ParkingSlot parkingSlot;
}
