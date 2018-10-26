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
		name="TB_ESPORTE"
		,uniqueConstraints={
				@UniqueConstraint(name="UN_ESPO_CHAVE_CANDIDATA",columnNames={"NM_ESPO_ESPORTE"})
		}
		,indexes={
				@Index(name="PK_ESPO",columnList="SQ_ESPO_ESPORTE"),
				@Index(name="IX_ESPO_CHAVE_CANDIDATA",columnList="NM_ESPO_ESPORTE")
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_ESPO_ESPORTE",nullable=false,columnDefinition="INT"))
public class EsporteModel extends AModel {
	private static final long serialVersionUID = 1L;
	@Column(name="NM_ESPO_ESPORTE",nullable=false,columnDefinition="VARCHAR(45)")
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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