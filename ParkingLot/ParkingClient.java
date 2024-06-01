import controller.TokenController;
import repositories.GateRepository;
import repositories.TokenRepository;
import repositories.VechicleRepository;
import services.TokenService;

public class ParkingClient {
	
	public static void main(String[] args)
	{
		 VechicleRepository vechicleRepository=new VechicleRepository();
		 GateRepository gateRepository=new GateRepository();
		 TokenRepository tokenRepository=new TokenRepository();
		
		TokenService tokenService=new TokenService(vechicleRepository,gateRepository,tokenRepository);
		
		TokenController tokenController=new TokenController(tokenService);
		dto.IssueTokenRequestDTO issueTokenRequestDTO=new dto.IssueTokenRequestDTO();
		tokenController.issueToken(issueTokenRequestDTO);
		
	}

}