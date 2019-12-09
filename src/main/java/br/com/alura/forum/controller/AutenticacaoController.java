package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.controller.dto.TokenDto;
import br.com.alura.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authMananger;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dataUser = form.converter();
		Authentication authentication = authMananger.authenticate(dataUser);
		String token = tokenService.gerarToken(authentication);
		return new ResponseEntity<TokenDto>(new TokenDto(token,"Bearer"), HttpStatus.OK);
	}

}
