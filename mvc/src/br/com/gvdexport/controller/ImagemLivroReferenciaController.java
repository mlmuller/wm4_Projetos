package br.com.gvdexport.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.output.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import br.com.gvdexport.dao.ImagemLivroReferenciaDao;
import br.com.gvdexport.facade.FacadeAcesso;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.TipoGrupoProduto;
import br.com.gvdexport.model.TipoImagem;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ImagemLivroReferenciaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private List<LivroReferencia> listaLivroReferencia;
	@Getter @Setter
	private List<ImagemReferencia> listaImagemReferencia;
	@Getter @Setter
	private ImagemReferencia imagemReferencia;
	@Getter @Setter
	private ImagemReferencia cloneImagemReferencia;
	@Getter @Setter
	private Integer referenciaSelecionada;
	@Getter @Setter
	private String informaReferencia;
	@Getter @Setter
	private Integer operacao;
	@Getter @Setter
	private Boolean Mstatus;
	@Getter @Setter
	private List<LivroReferencia> listaLivroReferenciaVersao;
	@Getter @Setter
 	private List<TipoImagem> tipoimagem = Arrays.asList(TipoImagem.values());
	@Getter @Setter
	private List<TipoGrupoProduto> tipogrupoimagem = Arrays.asList(TipoGrupoProduto.values());
	@Getter @Setter
	private String pfwidth;
	@Getter @Setter
	private String pfheight;
	@Getter @Setter
	private UploadedFile uploadedfile;
	@Getter @Setter
	private StreamedContent fileImagem;

	@Inject
	private FacadeAcesso facadeAcesso;
	@Inject
	private ImagemLivroReferenciaDao imagemLivroReferenciaDao;
	@Inject
	private UsuarioLogadoController usuarioLogado;

	private StreamedContent image;
	private StreamedContent imagens;
	private StreamedContent imagem;
	@Getter @Setter
	private StreamedContent streamedContent;
	@Getter @Setter
	private String caminho;
	@Getter @Setter
	private String caminhoFin;

//	LazyImagemReferenciaDataModel dataModel = new LazyImagemReferenciaDataModel();
//
//	public LazyDataModel<ImagemReferencia> getModel(){
//		return dataModel;
//	}
	@PostConstruct
	public void init() {
    	Mstatus = true;
    	operacao = 0;
    	listaLivroReferencia = new ArrayList<LivroReferencia>();
    	imagemReferencia = new ImagemReferencia();
//    	pfwidth = "30%";
//   	pfheight = "15%";
   }
	public void upload(FileUploadEvent event) {
		try {
			String nome,extensao;
			Mstatus = true;
			UploadedFile  uploadedFile = event.getFile();
			File file = new File(uploadedFile.getFileName());
			nome = file.getName();
			extensao = nome.substring((nome.lastIndexOf('.')+1), nome.length());
			OutputStream stream = new FileOutputStream(file);
			stream.write(uploadedFile.getContent());
			stream.close();
			byte[] imageCalc = uploadedFile.getContent();
			BufferedImage bi = ImageIO.read(new ByteArrayInputStream(imageCalc));
			if(bi.getWidth() > bi.getHeight()) {
			  if (imagemReferencia.getTipogrupoimagem().name().equals("C")) {
				  imagemReferencia.setImheight("100");
				  imagemReferencia.setImwidth("70");
			  }else {
				   imagemReferencia.setImwidth("100");
				   imagemReferencia.setImheight("80");
			  }
			}else {
				imagemReferencia.setImwidth("70");
				imagemReferencia.setImheight("135");
			}
			byte[] fileEmpty = null;
			if(event != null) {
				imagemReferencia.setFoto(fileEmpty);
			}
			imagemReferencia.setFoto(event.getFile().getContent());
			//primefaces 11.0
			//imagemReferencia.setFoto(event.getFile().getContent() );
			imagemReferencia.setExtensao(extensao);
			imagemReferencia.setNomearquivo(nome);
			Messages.addGlobalInfo("UpLoad OK :"+uploadedFile.getFileName()+" Pronto Para Salvar !");
			return;
		} catch (IOException ex) {
			Messages.addGlobalError("Não foi possivel Salvar Imagem!");

		}
	}	

	//Extrair imagem do banco
	public void setImage(StreamedContent image) {
			this.image = image;
	}
	
	public StreamedContent getImage() throws IOException,SQLException {
    	String id = "";
    	FacesContext context = FacesContext.getCurrentInstance();
    	if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
    		return new DefaultStreamedContent();
    		
    	}else {
    		id = context.getExternalContext().getRequestParameterMap().get("id_imagem");
    	}
    	
    	if(id != null) {
    		Long idImagem = Long.parseLong(id);
    		ImagemReferencia aux = imagemLivroReferenciaDao.find(idImagem);
    		String mime = "image/"+aux.getExtensao();
    		String name = aux.getNomearquivo();
    		byte[] foto = aux.getFoto();
  //  		return new DefaultStreamedContent(new ByteArrayInputStream(foto),mime);
			//primefaces 11.0
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
			.name(name)
			.contentType(mime).stream(()->new ByteArrayInputStream(foto))
			.build();
			return streamedcontent;
    	}else {
    		return new DefaultStreamedContent();

    	}
    }


	
	public void add() {
		imagemReferencia = new ImagemReferencia();
		listaLivroReferenciaVersao = new ArrayList<LivroReferencia>();
		referenciaSelecionada = 0;
		informaReferencia = "";
		operacao = 0;
		Mstatus = false;
	}

	public void edit(ImagemReferencia imagemEdit) throws CloneNotSupportedException {
		cloneImagemReferencia = new ImagemReferencia();
		cloneImagemReferencia = (ImagemReferencia) imagemEdit.clone();
		imagemReferencia = imagemEdit;
		operacao = 1;
		Mstatus = false;
		informaReferencia = imagemEdit.getReferencia().toString().trim();
	}

	public void save() {
		try {
			if(imagemReferencia.getLivroreferencia() == null) {
				imagemReferencia.setLivroreferencia(cloneImagemReferencia.getLivroreferencia());
			}
			if ((cloneImagemReferencia != null) && (imagemReferencia.getLivroreferencia().equals(cloneImagemReferencia.getLivroreferencia()))){
				operacao = 9;
			}
			if((operacao == 0) || (operacao == 1)) {
			  List<ImagemReferencia> aux = facadeAcesso.existeImagemCadastrada(imagemReferencia);
				if (aux.size() != 0) {
					Messages.addGlobalError("Esta Combinação ja existe Cadastro Imagem Produto !");
					return;
				}
				if (operacao == 1) {
					imagemReferencia.setAbreviacao(aux.get(0).getAbreviacao());
					imagemReferencia.setVersaorefer(aux.get(0).getLivroreferencia().getVersaorefer());
					imagemReferencia.setReferencia(aux.get(0).getLivroreferencia().getReferencia());
					imagemReferencia.setConstrucaonome(aux.get(0).getLivroreferencia().getConstrucaonome());
					imagemReferencia.setVersao(aux.get(0).getLivroreferencia().getVersao());
					imagemReferencia.setReferenciaforma(aux.get(0).getReferenciaforma());
					imagemReferencia.setLivroreferencia(aux.get(0).getLivroreferencia());
				}
			}
			if (imagemReferencia.getTipogrupoimagem() == null) {
				Messages.addGlobalError("Selecione Grupo para esta Imagem!");
				return;
			}
			imagemReferencia.setDatastamp(imagemLivroReferenciaDao.gettimeStamp());
			imagemReferencia.setUsuariostamp(usuarioLogado.getUsuariologado().getUsuario());
			imagemLivroReferenciaDao.update(imagemReferencia);
			operacao = 0;
			Messages.addGlobalInfo("Operação realizada com Sucesso !");
//			getModel();
			} catch (Exception ex) {
				Messages.addGlobalError("Não foi possivel Executar Operação com a Imagem ! ");
				ex.printStackTrace();
		}
	}

	public void delete(ImagemReferencia imagemCancelar) {
		try {
			imagemLivroReferenciaDao.delete(imagemCancelar.getImagemlivroreferenciaid());
			Messages.addGlobalInfo("Imagem/Referencia Removida com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel remover Forma!");
		}
	}

	public void buscaReferencia(){
		referenciaSelecionada = Integer.parseInt(informaReferencia);
		if (referenciaSelecionada != 0 ) {
			listaLivroReferencia = facadeAcesso.existeLivroReferencia(referenciaSelecionada);
		}
		if (listaLivroReferencia.size() == 0) {
   		    Messages.addGlobalError("Referência informada não existente,verifique!");
   		    Mstatus = false;
   		    return;
		}
	}
	public void verVersoesLivroReferencia(){
	    if ((imagemReferencia.getReferencia() == null) || imagemReferencia.getReferencia() == 0) {
	    	Messages.addGlobalError("Informe Referência para verificação das Versão(ões) !");
	    	return;
	    }
	    listaLivroReferenciaVersao = facadeAcesso.existeLivroReferenciaVersoes(imagemReferencia.getReferencia(),imagemReferencia.getAbreviacao().trim());
	    if (listaLivroReferenciaVersao.size() == 0){
	    	Messages.addGlobalInfo("Não há Cadastro para esta Referência!");
	    	return;
	    }
	}

	public void carregaCarrocel(ImagemReferencia referencia) {
		listaImagemReferencia = new ArrayList<>();
		listaImagemReferencia = facadeAcesso.existeReferenciaImagem(referencia.getReferencia(), referencia.getAbreviacao());
		if(listaImagemReferencia.size() == 0) {
	    	Messages.addGlobalInfo("Não há Imagens para esta Referência!");
	    	return;
		}
	}
	
	public void carregaPdf(ImagemReferencia referencia) {
		listaImagemReferencia = new ArrayList<>();
		listaImagemReferencia = facadeAcesso.existeReferenciaImagem(referencia.getReferencia(), referencia.getAbreviacao());
		if(listaImagemReferencia.size() == 0) {
	    	Messages.addGlobalInfo("Não há Imagens para esta Referência!");
	    	return;
		}
	}
	
	  public StreamedContent getImagem() throws IOException{

	    	String id = "";
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	    		return new DefaultStreamedContent();
	    		
	    	}else {
	    		id = context.getExternalContext().getRequestParameterMap().get("idimagem");
	    		if (id != null) {
	    		Long idImtbl = Long.parseLong(id);
	    		ImagemReferencia aux = imagemLivroReferenciaDao.find(idImtbl);
	    		return aux.getImagem(); 
	    		}else {
	    			return new DefaultStreamedContent();
	    		}
	    	}
	}
 
	  public StreamedContent getImagens() {
    	String id = "";
    	FacesContext context = FacesContext.getCurrentInstance();
    	if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
    		return new DefaultStreamedContent();
    		
    	}else {
    		id = context.getExternalContext().getRequestParameterMap().get("id_imagem");
    		Long idImagem = Long.parseLong(id);
    		ImagemReferencia aux = imagemLivroReferenciaDao.find(idImagem);
    		String mime = "image/"+aux.getExtensao();
    		String name = aux.getNomearquivo();
    		byte[] foto = aux.getFoto();

//    		return new DefaultStreamedContent(new ByteArrayInputStream(aux.getFoto()));
			//primefaces 11.0
    		StreamedContent streamedcontent = DefaultStreamedContent.builder()
			    				.name(name)
			    				.contentType(mime).stream(()->new ByteArrayInputStream(foto))
			    				.build();

    		return streamedcontent;
    	}
    }
    

	  
	  public void Pdfs(ImagemReferencia referencia) throws FileNotFoundException {
	     
	     ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

	     caminhoFin = context.getRealPath("c:///resources//"+"BaseTeste.pdf");
	     try {
	            final ByteArrayOutputStream out = new ByteArrayOutputStream();

  	             final Document document = new Document();
	            PdfWriter.getInstance(document, out);
	            document.open();

//	            for (int i = 0; i < 50; i++) {
//	                document.add(new Paragraph("All work and no play makes Jack a dull boy"));
//	            }

	            document.close();
	            streamedContent = DefaultStreamedContent.builder().stream(() -> new ByteArrayInputStream(out.toByteArray()))
	                        .contentType("application/pdf").build();
	        }
	        catch (final Exception e) {

	        }
  }
    public void complementaImagemLivroReferencia() {
		if(operacao == 0) {
		  imagemReferencia.setAbreviacao(imagemReferencia.getLivroreferencia().getAbreviacao());
		  imagemReferencia.setReferencia(imagemReferencia.getLivroreferencia().getReferencia());
		  imagemReferencia.setVersaorefer(imagemReferencia.getLivroreferencia().getVersaorefer());
		  imagemReferencia.setConstrucaonome(imagemReferencia.getLivroreferencia().getConstrucaonome());
		  imagemReferencia.setVersao(imagemReferencia.getLivroreferencia().getVersao());
		  imagemReferencia.setReferenciaforma(imagemReferencia.getLivroreferencia().getReferenciaforma());
		  
		  List<ImagemReferencia> aux = facadeAcesso.existeImagemCadastrada(imagemReferencia);
		  if(aux.size() != 0) {
		    	Messages.addGlobalError("Já existe Cadastro para esta Combinacao,Verifique!");
		    	return;
		  }
		  
		}
	}
	
	
	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}
	public void setImagens(StreamedContent imagens) {
		this.imagens = imagens;
	}
	
}
