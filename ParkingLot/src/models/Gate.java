package models;

public class Gate {

	private GateType gateType;
	private Operator operator;
	private int gateNumber;
	//private GateStatus gatestatus;
	private ParkingLot parkingLot;
	public GateType getGateType() {
		return gateType;
	}
	public void setGateType(GateType gateType) {
		this.gateType = gateType;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public int getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(int gateNumber) {
		this.gateNumber = gateNumber;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

}
