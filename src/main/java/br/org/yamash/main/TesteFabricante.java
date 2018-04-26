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
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Administrador admin = new Administrador();
		admin.setCpf("43735656798");
		admin.setDtNascimento(format.parse("1998-08-09"));
		admin.setEmail("vinicius.yamashita@hotmail.com.br");
		admin.setNomeCompleto("Vinicius Yamashita");
		admin.setStatusAdmin(1);
		admin.setSenha(null);
		admin.setTelefone("997332307");
		testeSalvarFabricante(admin);
		
		
//		Fabricante f = new Fabricante();
//		f.setCodigo(5L);
//		f.setDescricao("Orkut");
//		testeDeletarFabricante(f);
//		
	}
	
	private static void testeSalvarFabricante (Administrador admin) {
		
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
	}
	
	private static void testeAlterarFabricante (Fabricante f) {
		
		FabricanteDAO fd = new FabricanteDAO();
		fd.alterar(f);
		
	}
	
	private static void testeDeletarFabricante (Fabricante f) {
		
		FabricanteDAO fd = new FabricanteDAO();
		fd.deletar(f);
		
	}*/
	
}
