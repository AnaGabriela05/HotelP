package edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.TipoUsuario;
import edu.pe.idat.repository.UserRepository;

@Service
public class UserDetailsServicelmpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		edu.pe.idat.model.Usuario appUser = 
				userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

		List grantList = new ArrayList();
		for (TipoUsuario tipousuario : appUser.getTipousuario()) {
			GrantedAuthority grantedTipoUsuario = new SimpleGrantedAuthority(tipousuario.getNomtipo());
			grantList.add(grantedTipoUsuario);
		}
	
		UserDetails usuario = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		return usuario;
	}
}
