package br.org.yamash.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;

import br.org.yamash.dao.AdministradorDAO;
import br.org.yamash.domain.Administrador;

public class TesteFabricante {

	public static void main (String[] args) throws ParseException {
		System.out.println("################################################################################");
		System.out.println("## Bateria de teste da classe Fabricantes DAO:");
		System.out.println("## Teste salvar Administrador");
		
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Administrador admin = new Administrador();
//		admin.setCpf("45678978909");
//		admin.setDtNascimento(format.parse("1984-12-03"));
//		admin.setEmail("vinicius.yamashita@hotmail.com.br");
//		admin.setNomeCompleto("Vinicius Yamashita");
//		admin.setStatusAdmin(1);
//		admin.setSenha("123456");
//		admin.setTelefone("996765678");
//		//testeSalvar(admin);
//		
//		admin.setCodAdmin(1l);
//		testeAlterar(admin);
		
		autenticar();
		
		
	}
	
	private static void testeSalvar (Administrador admin) {
		
		AdministradorDAO fd = new AdministradorDAO();
		fd.salvar(admin);
		
	}
	
	/*private static void testeListarFabricante() {
		FabricanteDAO fd = new FabricanteDAO();
		List<Fabricante> listagem = fd.Listar();
		
		for (Fabricante f : listagem) {
			System.out.println("################################################################################");
			System.out.println("Codigo: " + f.getCodigo() + "\nFabricante: " + f.getDescricao() + "\n");
		}
	}
	
	private static void testeListarFabricantePorEntidade() {
		FabricanteDAO fd = new FabricanteDAO();
		List<Fabricante> listagem = fd.Listar();
		
		for (Fabricante f : listagem) {
			System.out.println("################################################################################");
			System.out.println("Codigo: " + f.getCodigo() + "\nFabricante: " + f.getDescricao() + "\n");
		}
	}*/
	
	private static void testeAlterar (Administrador admin) {
		
		AdministradorDAO adminD = new AdministradorDAO();
		adminD.alterar(admin);
		
	}
	
	
	private static void testeDeletar (Administrador admin) {
		
		AdministradorDAO adminD = new AdministradorDAO();
		adminD.deletar(admin);
		
	}
	
	public static void autenticar() {
		AdministradorDAO adminD = new AdministradorDAO();
		
		Administrador admin = AdministradorDAO.autenticar("123123121", "123456");
		
		System.out.println("Administrador: " + admin);
	}
	
}
