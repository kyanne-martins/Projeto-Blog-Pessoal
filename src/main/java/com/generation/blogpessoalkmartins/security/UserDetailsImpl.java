package com.generation.blogpessoalkmartins.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoalkmartins.model.Usuario;

public class UserDetailsImpl  implements UserDetails{
	
private static final long serialVersionUID =1L;
	
	private String userName;
	private String password;
	
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl (Usuario user){
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl (){ }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
	
		return password;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {//Indica se a conta do usuário expirou. Uma conta expirada não pode ser autenticada (return false).
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {//Indica se o usuário está bloqueado ou desbloqueado. Um usuário bloqueado não pode ser autenticado (return false).
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //Indica se as credenciais do usuário (senha) expiraram. Senha expirada impede a autenticação (return false).
		
		return true;
	}

    @Override
	public boolean isEnabled() {//Indica se o usuário está habilitado ou desabilitado. Um usuário desabilitado não pode ser autenticado (return false).
		
		return true;
	}
	
	

}
