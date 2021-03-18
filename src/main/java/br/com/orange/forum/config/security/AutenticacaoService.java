package br.com.orange.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.orange.forum.modelo.Usuario;
import br.com.orange.forum.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	/*
	 * essa service serve para mostrar para o spring security qual o serviço
	 * que vai cuidar da autenticação no sistema
	 * 
	 * */

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos");
	}

	
}
