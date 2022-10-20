package br.com.gvdexport.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Getter;
import lombok.Setter;
@SessionScoped
@Named
public class PdfsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String caminho;
	@Getter @Setter
	private StreamedContent streamedContent;
	public void getPdfDownload() throws IOException, ServletException {
		//Este caminho vira do banco de dados,abaixo exemplo
		caminho = "c://Base//BaseTeste1.pdf";
		//definir variavel que recebera nome e extensao do arquivo e
		//substituir no BaseTeste1.pdf
		FileInputStream fis = new FileInputStream(caminho);
		streamedContent =  DefaultStreamedContent.builder()
	                .name("BaseTeste1.pdf")
	                .contentType("application/pdf")
	                .stream(() -> fis)
	                .build();
    }
	
}


