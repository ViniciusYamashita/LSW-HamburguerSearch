package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codFeedback")
	private long codFeedback;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codEmpresas", referencedColumnName="codEmpresa")
	private Empresa codEmpresa;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codItem", referencedColumnName="codItem")
	private Item codItem;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codCliente", referencedColumnName="codCliente")
	private Clientes codCliente;
	 
	@Column(name="dtFeedback", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFeedback;
	
	@NotEmpty(message="A 'Média' é obrigatória para o Feedback.")
	@Column(name="valorMedia", nullable=false)
	private float valorMedia;
	 
	@NotEmpty(message="Para realizar o Feedback não se esqueça de preencher o campo 'Comentario'.")
	@Size(min=3, message="Para que a empresa possa melhorar os comentarios devem ter no minimo 3 caracteres, ou seja apenas uma palavra.")
	@Column(name="comentario", length=500, nullable=false)
	private String comentario;

	public long getCodFeedback() {
		return codFeedback;
	}

	public void setCodFeedback(long codFeedback) {
		this.codFeedback = codFeedback;
	}

	public Empresa getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Empresa codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Item getCodItem() {
		return codItem;
	}

	public void setCodItem(Item codItem) {
		this.codItem = codItem;
	}

	public Clientes getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Clientes codCliente) {
		this.codCliente = codCliente;
	}

	public Date getDtFeedback() {
		return dtFeedback;
	}

	public void setDtFeedback(Date dtFeedback) {
		this.dtFeedback = dtFeedback;
	}

	public float getValorMedia() {
		return valorMedia;
	}

	public void setValorMedia(float valorMedia) {
		this.valorMedia = valorMedia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	 	 
}
 
