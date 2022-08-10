package br.com.gvdexport.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.gvdexport.model.EtqDragDrop;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Named
@SessionScoped
public class RepJasperGeral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private FacesContext context;
	@Getter @Setter
 	private HttpServletResponse response;
		
		public RepJasperGeral() {
//			this.context = FacesContext.getCurrentInstance();
//			this.response = (HttpServletResponse) context.getExternalContext().getResponse();
		}

	public void getRepJaspddI(List<EtqDragDrop> listaEtiquetaJR ){
		try {
			String pathreports = null;
			pathreports = Faces.getRealPath("/Relatorios/land_Amos_jr.jasper");
			Map<String, Object> parameters = new HashMap<>();
			JRBeanCollectionDataSource colecaoGerada = new JRBeanCollectionDataSource(listaEtiquetaJR);
			JasperPrint newPrint = new JasperPrint();
			newPrint = JasperFillManager.fillReport(pathreports, parameters,colecaoGerada);
//			JasperExportManager.exportReportToPdfStream(newPrint, response.getOutputStream());
			context = FacesContext.getCurrentInstance();
			response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=JackRogers.pdf");
			ServletOutputStream servletOutputStream=response.getOutputStream(); 
			JasperExportManager.exportReportToPdfStream(newPrint,servletOutputStream);
			servletOutputStream.flush();
			servletOutputStream.close();
			context.renderResponse();
			context.responseComplete(); 		
		} catch (RuntimeException | JRException error) {	
			Messages.addGlobalError("Não foi possivel gerar PDF file JR-" + error.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
