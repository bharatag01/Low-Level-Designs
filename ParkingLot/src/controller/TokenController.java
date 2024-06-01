package controller;

import dto.IssueTokenRequestDTO;
import dto.IssueTokenResponseDTO;
import dto.ResponseStatus;
import models.Token;
import services.TokenService;

public class TokenController {

	private TokenService tokenService;

	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO) {
		IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();

		try {
			Token token = tokenService.createToken(issueTokenRequestDTO.getGateId(),
					issueTokenRequestDTO.getVechicleType(), issueTokenRequestDTO.getVechicleNumber(),
					issueTokenRequestDTO.getOwnerName());

			issueTokenResponseDTO.setToken(token);
			issueTokenResponseDTO.setResponseMessage(ResponseStatus.SUCCESS);
			System.out.print("success");

		} catch (Exception e) {
			issueTokenResponseDTO.setResponseMessage(ResponseStatus.FAILURE);
			System.out.print("error");
		}

		return issueTokenResponseDTO;

	}

}
