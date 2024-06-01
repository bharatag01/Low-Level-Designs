package dto;

import models.VechicleType;

public class IssueTokenRequestDTO {
	
	private Long gateId=1l;
	private VechicleType vechicleType=VechicleType.CAR;
	private String vechicleNumber="HR26DZ6585";

	private String ownerName="bharat";

	public Long getGateId() {
		return gateId;
	}
	public void setGateId(Long gateId) {
		this.gateId = gateId;
	}
	public VechicleType getVechicleType() {
		return vechicleType;
	}
	public void setVechicleType(VechicleType vechicleType) {
		this.vechicleType = vechicleType;
	}
	public String getVechicleNumber() {
		return vechicleNumber;
	}
	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

}
