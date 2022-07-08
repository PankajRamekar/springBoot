package com.te.learnspringsecurity2.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.learnspringsecurity2.entity.AppUser;
import com.te.learnspringsecurity2.repository.AppUserRepository;
import com.te.learnspringsecurity2.service.AppService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService, UserDetailsService {

	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> optional = appUserRepository.findByUsername(username);
		if (optional.isPresent()) {
			AppUser appUser = optional.get();

			List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(r -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r.getRoleName());
				return simpleGrantedAuthority;
			}).collect(Collectors.toList());

			return new User(appUser.getUsername(), appUser.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("user not in DB");
	}

}
