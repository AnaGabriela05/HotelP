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
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

		edu.pe.idat.model.Usuario appUser = 
				userRepository.findByUsuario(usuario).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

		List grantList = new ArrayList();
		for (TipoUsuario tipousuario : appUser.getTipousuario()) {
			GrantedAuthority grantedTipoU = new SimpleGrantedAuthority(tipousuario.getNomtipo());
			grantList.add(grantedTipoU);
		}
	
		UserDetails user = (UserDetails) new User(appUser.getUsuario(), appUser.getPassword(), grantList);
		return user;
	}
}
