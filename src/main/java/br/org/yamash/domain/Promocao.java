package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Promocao")
public class Promocao {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPromocao")
	private long codPromocao;
	 
	@Column(name="tipoPromocao", nullable=false)
	private int tipoPromocao;
	 
	@Column(name="dtInicio", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
	 
	@Column(name="dtFim", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFim;
	 
	@Column(name="valorPromcao", nullable=false)
	private float valorPromocao;

	
	
	public long getCodPromocao() {
		return codPromocao;
	}

	public void setCodPromocao(long codPromocao) {
		this.codPromocao = codPromocao;
	}

	public int getTipoPromocao() {
		return tipoPromocao;
	}

	public void setTipoPromocao(int tipoPromocao) {
		this.tipoPromocao = tipoPromocao;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public float getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(float valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	 
}
 
