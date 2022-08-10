package br.com.gvdexport.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@ViewScoped
@Named
public class BarraProgresso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Integer progresso;
	@Getter @Setter
	private String mensagem;
	@Getter @Setter
	private Integer acumulador;
	
	public void resetarProgresso() {
		progresso = 0;
		mensagem = "";
	}
	@PostConstruct
	public void init(){
		acumulador = 31;
	}
	public void criaMensagem(String texto) {
		FacesMessage msg = new FacesMessage(texto);
		FacesContext.getCurrentInstance().addMessage("", msg);
	}
	public void atualizaProgresso(Integer i) {
		progresso = (i*31) / acumulador;
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			criaMensagem("Erro no Processo de Progress�o");
		}
	}
	
}
