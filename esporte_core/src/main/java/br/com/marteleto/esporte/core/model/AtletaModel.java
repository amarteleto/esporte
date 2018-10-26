package br.com.marteleto.esporte.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.marteleto.esporte.core.model.abstracts.AModel;

@Entity
@Table(
		name="TB_ATLETA"
		,uniqueConstraints={
				@UniqueConstraint(name="UN_ATLE_CHAVE_CANDIDATA",columnNames={"NM_ATLE_EMAIL"})
		}
		,indexes={
				@Index(name="PK_ATLE",columnList="SQ_ATLE_ATLETA"),
				@Index(name="IX_ATLE_CHAVE_CANDIDATA",columnList="NM_ATLE_EMAIL")
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_ATLE_ATLETA",nullable=false,columnDefinition="INT"))
public class AtletaModel extends AModel {
	private static final long serialVersionUID = 1L;
	@Column(name="NM_ATLE_ATLETA",nullable=false,columnDefinition="VARCHAR(45)")
	private String nome;
	@Column(name="NM_ATLE_EMAIL",nullable=false,columnDefinition="VARCHAR(45)")
	private String email;
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
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
