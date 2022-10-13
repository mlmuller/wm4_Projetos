package br.com.gvdexport.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.itextpdf.text.pdf.PdfReader;

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
		FileInputStream fis = new FileInputStream(caminho);
		streamedContent =  DefaultStreamedContent.builder()
	                .name("BaseTeste1.pdf")
	                .contentType("application/pdf")
	                .stream(() -> fis)
	                .build();
    }
	
}


