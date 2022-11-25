package br.com.gvdexport.util;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;

import br.com.gvdexport.model.ImagemReferencia;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Resizer {

	private byte[] fotomenor;
	private byte[] fotomaior;
	private String referencia;
	private String construcao;
	private String versao_r;
	private String versao_c;
	private String width;
	private String height;
	private Long id;
	

	public Resizer() {
		
	}


	public Resizer(byte[] fotomenor, byte[] fotomaior, String referencia, String construcao, String versao_r,
			String versao_c, String width, String height, Long id) {
		super();
		this.fotomenor = fotomenor;
		this.fotomaior = fotomaior;
		this.referencia = referencia;
		this.construcao = construcao;
		this.versao_r = versao_r;
		this.versao_c = versao_c;
		this.width = width;
		this.height = height;
		this.id = id;
	}


	public byte[] getFotomenor() {
		return fotomenor;
	}


	public void setFotomenor(byte[] fotomenor) {
		this.fotomenor = fotomenor;
	}


	public byte[] getFotomaior() {
		return fotomaior;
	}


	public void setFotomaior(byte[] fotomaior) {
		this.fotomaior = fotomaior;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getConstrucao() {
		return construcao;
	}


	public void setConstrucao(String construcao) {
		this.construcao = construcao;
	}


	public String getVersao_r() {
		return versao_r;
	}


	public void setVersao_r(String versao_r) {
		this.versao_r = versao_r;
	}


	public String getVersao_c() {
		return versao_c;
	}


	public void setVersao_c(String versao_c) {
		this.versao_c = versao_c;
	}


	public String getWidth() {
		return width;
	}


	public void setWidth(String width) {
		this.width = width;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



}
