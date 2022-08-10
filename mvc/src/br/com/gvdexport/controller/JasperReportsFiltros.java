package br.com.gvdexport.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Named
@SessionScoped
public class JasperReportsFiltros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	String pathreports;
	//
	private HttpServletResponse response;
	private FacesContext context;

	public JasperReportsFiltros() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}

	public void getRepJaspdd(Boolean varIdioma) throws JRException {
		try {
			pathreports = null;
//			DataTable tableMem = (DataTable) Faces.getViewRoot().findComponent("frmEtqGerar:tblEtqGerar");
//			Map<String, Object> filtersMem = tableMem.getFilters();
			String pathLogo = Faces.getRealPath("/resources/css/icons/logoGVD2018a.jpg");
			pathreports = Faces.getRealPath("/relatorios/etqPortFiltros.jasper");
			pathreports = Faces.getRealPath("/relatorios/etqPortFiltros.jasper");
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("PATH_LOGO", pathLogo);
//			Connection conection = HibernateUtil.getConection();
			JasperPrint newPrint = new JasperPrint();
//			newPrint = JasperFillManager.fillReport(pathreports, parameters, conection);
			byte[] bytes = JasperExportManager.exportReportToPdf(newPrint);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outputstream = response.getOutputStream();
			outputstream.write(bytes, 0, bytes.length);
			response.setHeader("Content-Disposition", "attachment:JasperViewer.viewReport(newPrint)");
			outputstream.flush();
			outputstream.close();
			context.responseComplete();
			Messages.addGlobalInfo("File created with Sucess,please to check Directory!!!");
		} catch (IOException error) {
			error.printStackTrace();
			Messages.addGlobalError("Não foi possivel Gerar Arquivo PDF " + error.getMessage());
		}
	}
	public void getRepPortFiltros(Boolean varIdm,Boolean varTo){
		try {
			pathreports = null;
//			DataTable tableMem = (DataTable) Faces.getViewRoot().findComponent("frmEtqGerar:tblEtqGerar");
//			Map<String, Object> filtersMem = tableMem.getFilters();
			String pathLogo = Faces.getRealPath("/resources/css/icons/logoGVD2018a.jpg");
			if ((!varIdm) && (!varTo)){
				pathreports = Faces.getRealPath("/relatorios/etqPortugues.jasper");
			}
			if ((varIdm) && !varTo) {
				pathreports = Faces.getRealPath("/relatorios/etqIngles.jasper");
			}
			if(varTo) {
				pathreports = Faces.getRealPath("/relatorios/etqCustomer.jasper");
				
			}
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("PATH_LOGO", pathLogo);
//			Connection conection = HibernateUtil.getConection();
			JasperPrint newPrint = new JasperPrint();
//			newPrint = JasperFillManager.fillReport(pathreports, parameters, conection);
			byte[] bytes = JasperExportManager.exportReportToPdf(newPrint);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outputstream = response.getOutputStream();
			outputstream.write(bytes, 0, bytes.length);
			response.setHeader("Content-Disposition", "attachment:JasperViewer.viewReport(newPrint)");
			outputstream.flush();
			outputstream.close();
			context.responseComplete();
			Messages.addGlobalInfo("PDF criado com sucesso,Verifique diretorios Downloads!!");
		} catch (JRException | IOException error) {
			error.printStackTrace();
			Messages.addGlobalError("Não foi possivel gerar arquivo PDF" + error.getMessage());
		}

	}
	
	
}
