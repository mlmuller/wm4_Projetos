package br.com.gvdexport.util;



import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class SelecionarArquivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Inject
//	private CotacoesController cotacaoController;
	@Getter @Setter
	private String caminho;

	public void upload(FileUploadEvent evento)  {
		System.out.println("Chegou aqui!!!!!");
//		try {
//			UploadedFile arquivo = evento.getFile();
//			Path arquivoTemp = Files.createTempFile(null, null);
//			Files.copy(arquivo.getInputstream(), arquivoTemp,StandardCopyOption.REPLACE_EXISTING);
//			cotacaoController.getCotacaomesnovo().setCaminho(arquivoTemp.toString());
//			Messages.addGlobalInfo(cotacaoController.getCotacaomesnovo().getCaminho());
//			
//		} catch (IOException ex) {
//			Messages.addGlobalInfo("N�o foi possivel criar Arquivo Tempor�rio !");
//			ex.printStackTrace();
//		}
	}
}
