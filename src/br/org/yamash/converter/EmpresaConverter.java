package br.org.yamash.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.org.yamash.dao.EmpresaDAO;
import br.org.yamash.domain.Empresa;

@FacesConverter("empresaConverter")
public class EmpresaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent componente, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			Empresa empresa = empresaDAO.ListarPorEntidade(codigo);
			return empresa;
			
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object objeto) {
		try {
			Empresa empresa = (Empresa) objeto;
			Long codigo = empresa.getCodEmpresa();
			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}

	
}
