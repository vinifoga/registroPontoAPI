package br.com.fogaca.RegistroPonto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import br.com.fogaca.RegistroPonto.model.Usuario;
import br.com.fogaca.RegistroPonto.service.ColaboradorService;
import br.com.fogaca.RegistroPonto.service.RoleService;

public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String senha;
	@NotNull
	private Long colaboradorId;
	@NotNull
	private String roleId;
	
	@Type(type="true_false")
	private boolean ativo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getColaboradorId() {
		return colaboradorId;
	}
	public void setColaboradorId(Long colaboradorId) {
		this.colaboradorId = colaboradorId;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public Usuario converter(ColaboradorService colaboradorService, RoleService roleService) {
		return new Usuario(nome, email, senha, colaboradorService.findById(colaboradorId).get(), ativo, roleService.findById(roleId));
	}

}
