package br.com.gvdexport.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;

@Named
@SessionScoped
public class ReportsJasper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//
	String pathreports;
	//
	@Inject
	private EntityManager em;
	
	private HttpServletResponse response;
	private FacesContext context;

	EntityManagerFactory emf = em.getEntityManagerFactory();
	
	
	public ReportsJasper(){
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) context.getExternalContext().getResponse();
	}
	public void getReportsJasper(){
		//		//Connection conexao = DataSource
		pathreports = null;
		DataTable tableMem=(DataTable) Faces.getViewRoot().findComponent("frmMain:tblEtiquetas");
// 		Map<String, Object> filtersMem=tableMem.getFilteredValue();
//		String mFabrica = (String) filtersMem.get("fabricanome");
//		String mCliente = (String) filtersMem.get("clientenome");
//		String mData = (String) filtersMem.get("inclusao");
//		String mAprovacao = (String) filtersMem.get("aprovacao");
//		String mMaterial = (String) filtersMem.get("material");
////		String mCor = (String) filtersMem.get("cor");
		String teste = "Amostra";
		//		String pathLogo = Faces.getRealPath("/resources/css/icons/logoGVD2018a.jpg");
		pathreports = Faces.getRealPath("/relatorios/etqPortugues.jasper");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("tipo_amostra", teste);
//		if (mFabrica == null){
//			parameters.put("ETQ_FABRICA","%%");
//		}else{
//			parameters.put("ETQ_FABRICA","%"+mFabrica+"%");
//		}
//		if (mCliente == null){
//			parameters.put("ETQ_CLIENTE","%%");
//		}else{
//			parameters.put("ETQ_CLIENTE","%"+mCliente+"%");
//		}
//		if(mData == null){
//			parameters.put("ETQ_DATA", "%%");
//		}else{
//			parameters.put("ETQ_DATA", "%"+mData+"%");
//		}
//		if(mAprovacao == null){
//			parameters.put("ETQ_APROVACAO","%%");
//		}else{
//			parameters.put("ETQ_APROVACAO","%"+mAprovacao+"%");
//		}
//		if(mMaterial == null){
//			parameters.put("ETQ_MATERIAL", "%%");
//		}else{
//			parameters.put("ETQ_MATERIAL", "%"+mMaterial+"%");
//		}

//		JasperPrint newPrint = new JasperPrint();
		
			
			parameters.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);
//			try {
////				newPrint = JasperFillManager.fillReport(pathreports, parameters);
//			} catch (JRException e) {
//				e.printStackTrace();
//			}
			
//			byte[] bytes =JasperExportManager.exportReportToPdf(newPrint);
		    response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			ServletOutputStream outputstream = response.getOutputStream();
//			outputstream.write(bytes, 0, bytes.length);
			response.setHeader("Content-Disposition", "attachment:JasperViewer.viewReport(newPrint)");
//			outputstream.flush();
//			outputstream.close();
			context.responseComplete();
			Messages.addGlobalInfo("Arquivo PDF gerado com Sucesso !!!");
    }	

}
