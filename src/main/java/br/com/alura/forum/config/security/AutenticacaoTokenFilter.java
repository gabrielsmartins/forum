package br.com.alura.forum.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.service.UsuarioService;

public class AutenticacaoTokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	
	private UsuarioService usuarioService;
	
	public AutenticacaoTokenFilter(TokenService tokenService, UsuarioService usuarioService) {
		this.tokenService = tokenService;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = recuperaToken(request);
		boolean isValido = tokenService.isTokenValido(token);
		if(isValido) {
			autenticaCliente(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticaCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Optional<Usuario> optionalUsuario = usuarioService.findById(idUsuario);
		optionalUsuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		Usuario usuario = optionalUsuario.get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperaToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer "))
			return null;
		return token.replace("Bearer ", "");
	}

}
