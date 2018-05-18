package br.org.yamash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.org.yamash.dao.ItemDAO;
import br.org.yamash.domain.Item;

@FacesConverter("itemConverter")
public class ItemConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			
			ItemDAO itemDAO = new ItemDAO();
			Item item = itemDAO.ListarPorEntidade(codigo);
			return item;
			
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
		try {
			Item item = (Item) objeto;
			Long codigo = item.getCodItem();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
