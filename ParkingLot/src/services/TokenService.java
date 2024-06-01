package services;

import java.util.Date;
import java.util.Optional;

import models.Gate;
import models.Token;
import models.VechicleType;
import models.Vehicle;
import repositories.GateRepository;
import repositories.TokenRepository;
import repositories.VechicleRepository;

public class TokenService {
	
	private VechicleRepository vechicleRepository;
	private GateRepository gateRepository;
	private TokenRepository tokenRepository;
	
	public Token createToken(Long gateId, VechicleType vechicleType, String vechicleNumber, String ownerName) {
		//1) create a Token. using the gateId , fetch the gate object from db
		Token token =new Token();
		token.setEntryTime(new Date());
		Optional<Gate> gateOptional =gateRepository.findObjectById(gateId);
		
		
		
		//2) fill the fields of token
		//3) check the vechicle exist
		Optional<Vehicle> vechicleOptional=vechicleRepository.findByNumber(vechicleNumber);
		Vehicle savedVechicle;
		if(!vechicleOptional.isPresent())
		{
			//4) otherwise make an entry of vehicle
			Vehicle vehicle = new Vehicle();
			vehicle.setNumber(vechicleNumber);
			vehicle.setVechicleType(vechicleType);	
			vehicle.setOwnerName(ownerName);
			savedVechicle=vechicleRepository.save(vehicle);
		}
		else
		{
			savedVechicle=vechicleOptional.get();
		}
		token.setVechicle(savedVechicle);
		
       Token savedToken=tokenRepository.save(token);
		//5) assign a slot
		return savedToken;
	}

	public TokenService(VechicleRepository vechicleRepository, GateRepository gateRepository,
			TokenRepository tokenRepository) {
		super();
		this.vechicleRepository = vechicleRepository;
		this.gateRepository = gateRepository;
		this.tokenRepository = tokenRepository;
	}

}