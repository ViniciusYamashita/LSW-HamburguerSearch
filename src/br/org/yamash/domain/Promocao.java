package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Promocao")
public class Promocao {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPromocao")
	private long codPromocao;
	 
	@NotEmpty(message="O campo 'Tipo de Promoção' é obrigatório.")
	@Column(name="tipoPromocao", nullable=false)
	private int tipoPromocao;
	 
	@NotEmpty(message="O campo 'Data início' é obrigatório.")
	@Column(name="dtInicio", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
	
	@NotEmpty(message="O campo 'Data Fim' é obrigatório.")
	@Column(name="dtFim", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFim;
	 
	@NotEmpty(message="O campo 'Valor da promoção' é obrigatório.")
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
 
