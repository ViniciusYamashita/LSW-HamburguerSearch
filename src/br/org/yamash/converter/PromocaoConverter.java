package br.org.yamash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.org.yamash.dao.PromocaoDAO;
import br.org.yamash.domain.Promocao;

@FacesConverter("promocaoConverter")
public class PromocaoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			
			PromocaoDAO PromoDAO = new PromocaoDAO();
			Promocao Promo = PromoDAO.ListarPorEntidade(codigo);
			return Promo;
			
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
		try {
			Promocao Promo = (Promocao) objeto;
			Long codigo = Promo.getCodPromocao();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
