package br.org.yamash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.org.yamash.dao.ClientesDAO;
import br.org.yamash.domain.Clientes;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			
			ClientesDAO clienteDAO = new ClientesDAO();
			Clientes cliente = clienteDAO.ListarPorEntidade(codigo);
			return cliente;
			
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
		try {
			Clientes cliente = (Clientes) objeto;
			Long codigo = cliente.getCodCliente();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
