package br.com.marteleto.esporte.core.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.marteleto.esporte.core.model.abstracts.AModel;

@Entity
@Table(
		name="TB_EVENTO"
		,indexes={
				@Index(name="PK_EVEN",columnList="SQ_EVEN_EVENTO"),
				@Index(name="IX_FK_GRES_EVEN",columnList="SQ_GRES_GRUPO_ESPORTE")
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_EVEN_EVENTO",nullable=false,columnDefinition="INT"))
public class EventoModel extends AModel {
	private static final long serialVersionUID = 1L;
	@Column(name="NM_EVEN_EVENTO",nullable=false,columnDefinition="VARCHAR(45)")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="SQ_GRES_GRUPO_ESPORTE",nullable=false,foreignKey=@ForeignKey(name="FK_GRES_EVEN"))
	private GrupoEsporteModel grupoEsporte;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_EVEN_INICIO",nullable=false,columnDefinition="DATETIME")
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_EVEN_TERMINO",nullable=false,columnDefinition="DATETIME")
	private Date dataTermino;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public GrupoEsporteModel getGrupoEsporte() {
		return grupoEsporte;
	}
	public void setGrupoEsporte(GrupoEsporteModel grupoEsporte) {
		this.grupoEsporte = grupoEsporte;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
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
