package br.com.gvdexport.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.DragDropEvent;

import br.com.gvdexport.dao.CrudDao;
import br.com.gvdexport.dao.EtqDragDropDao;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.Etiquetas;
import br.com.gvdexport.model.EtqDragDrop;
import br.com.gvdexport.model.Fabrica;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class EtiquetasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter	@Setter
	private Etiquetas detailEtiqueta;
	@Getter @Setter
	private EtqDragDrop newDragDrop;
	@Getter @Setter
	private boolean varTermica;
	@Getter	@Setter
	private Etiquetas etiquetaSelected;
	@Getter	@Setter
	private List<Etiquetas> listaEtiquetas;
	@Getter @Setter
	private List<Etiquetas> listaMultiplasEtiquetas;
	@Getter	@Setter
	private List<Etiquetas> listaSelectedEtiquetas;
	@Getter @Setter
	private List<Etiquetas> listaSelecionadaEtiquetas;
	@Getter @Setter
	private List<EtqDragDrop> listaFinalSelecionadas;
	@Getter @Setter
	private List<EtqDragDrop> listaFinalEtqTemp;
	@Getter	@Setter
	private List<Fabrica> listaFabricas;
	@Getter @Setter
	private List<Cliente> listaClientes;
//	@Getter	@Setter
//	private etFabqDragDrop detaildragDrop;
	@Getter	@Setter
	private List<EtqDragDrop> listaDragDrop;
	@Getter	@Setter
	private List<Etiquetas> listaSelectedDragDrop;
	@Getter	@Setter
	private List<Etiquetas> selectedDragDrop;
	@Getter	@Setter
	private Integer mCount = 0;
	@Getter	@Setter
	private Integer flagEdit = 0;
	@Getter	@Setter
	private Integer flagAdd = 0;
	@Getter	@Setter
	private Integer flagEditHeader = 0;
	@Getter @Setter
	private DataTable dataTable;
	@Getter @Setter
	private Integer geralEtiquetas;
	@Getter @Setter
	private Boolean varIdioma;
	@Getter @Setter
	private Boolean varTo;
	@Getter @Setter
	private String factory;
	@Getter @Setter
	private String customer;
	@Getter @Setter
	private Integer operacao;
	@Inject
	private CrudDao<Etiquetas, Long> etiquetaDao;
	
	@Inject
	private CrudDao<EtqDragDrop, Long> dragDropDao;
	
	@Inject
	private CrudDao<Cliente, Long> clientesDao;
	
	@Inject
	private RepJasperGeral repJasperGeral;

	@PostConstruct
	public void init() {
		varTermica = true;
		varIdioma = false;
		varTo = false;
		listaMultiplasEtiquetas = new ArrayList<Etiquetas>();
		listaEtiquetas = new ArrayList<>();
		customer="JACK ROGERS";
		factory="GVD IMP EXP Ltda";
		listaClientes = new ArrayList<Cliente>();
		listaClientes = clientesDao.findAll();
		refresh();
	}
	public String gettodayDate() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	public void novaEtiqueta() {
		detailEtiqueta = new Etiquetas();
//		listaFabricas = fabricasDao.findAll();
//		listaClientes = clientesDao.findAll();
		detailEtiqueta.setCopias(1);
		detailEtiqueta.setEscolha(false);
		detailEtiqueta.setFabricanome(factory);
		//---------------------------
		mCount = 1;
		flagEditHeader = 0;
		flagEdit = 0;
		operacao = 0;
	}

	public void novaEtiquetaPrepare() {
		detailEtiqueta = new Etiquetas();
//		listaFabricas = fabricasDao.findAll();
//		listaClientes = clientesDao.findAll();
		detailEtiqueta.setEscolha(false);
		refresh();
		//End of Components
		mCount = 0;
		flagEditHeader = 0;
	}
	
	public void chamaEtiqueta() {
		try {
//			if (varLaser) {
//				selectedDragDrop = new ArrayList<>();
//				listaSelectedDragDrop = new ArrayList<>();
//				listaSelecionadaEtiquetas = new ArrayList<>();
//				EtiquetasDao etiquetaDao = new EtiquetasDao();
//				listaEtiquetas = etiquetaDao.list();
//				etqDragDropDao dragDropDao = new etqDragDropDao();
//				listaDragDrop = dragDropDao.list();
//				mCount = 1;
//
//				for (int i = 0; i < listaDragDrop.size(); i++) {
//					dragDropDao.excluir(listaDragDrop.get(i));
//				}
//				listaFinalSelecionadas = new ArrayList<>()
//			}

			listaMultiplasEtiquetas = new ArrayList<Etiquetas>();
			for (int i = 0; i < listaEtiquetas.size(); i++ ) {
				if(listaEtiquetas.get(i).getEscolha() != null ) {
					if (listaEtiquetas.get(i).getEscolha().equals(true)) {
						listaMultiplasEtiquetas.add(listaEtiquetas.get(i));
					}
				}
			}
			if (listaMultiplasEtiquetas.size() == 0) {
				Messages.addGlobalError("Por favor, Selecione Etiqueta(s) para Impressao !");
				return;
			}
			sortedByIndexEtiqueta(listaMultiplasEtiquetas);
			} catch (RuntimeException ex) {
			Messages.addGlobalError("Nao foi possivel carregar Lista de etiquetas !");
			ex.printStackTrace();
		}
	}
	// Total of Colors
	public void save() {
		try {
			Etiquetas etqClone = new Etiquetas();
			try {
				etqClone = (Etiquetas) detailEtiqueta.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			etiquetaDao.update(detailEtiqueta);
		    detailEtiqueta = new Etiquetas();
		    detailEtiqueta = etqClone;
			factory="GVD IMP EXP Ltda";
			detailEtiqueta.setCopias(1);
			detailEtiqueta.setFabricanome(factory);
			detailEtiqueta.setClientenome(detailEtiqueta.getCliente().getNome());
			detailEtiqueta.setClientesucinto(detailEtiqueta.getCliente().getSucinto());
		    refresh();
			Messages.addGlobalInfo("Etiqueta operação realizada com Sucesso!");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel adicionar Etiqueta !!!" + ex.getMessage());
		}
	}
	public void deleteEtiqueta(Etiquetas etiqueta) {
		try {
			etiquetaDao.delete(etiqueta.getIdetiqueta());
			refresh();
			Messages.addGlobalInfo("Etiqueta Cancelada com  Sucesso !");
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel Cancelar Etiqueta !-" + ex.getMessage());

		}
	}
	public void editEtiqueta(Etiquetas etiqueta) {
		try {
			detailEtiqueta = etiquetaDao.find(etiqueta.getIdetiqueta());
			operacao = 1;
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel alterar Etiqueta!!!-" + ex.getMessage());
		}
	}
	// implementacao Drag and Drop Primefaces
		public void onEtiquetaDrop(DragDropEvent ddEvent) {
			Etiquetas detailEtiqueta = ((Etiquetas) ddEvent.getData());
			listaSelecionadaEtiquetas.add(detailEtiqueta);
			listaEtiquetas.remove(detailEtiqueta);
		}

		public void remakeDragDrop(List<Etiquetas> tblDragDrop) {
			listaDragDrop = new ArrayList<>();
			listaDragDrop = dragDropDao.findAll();
			for (int i = 0; i < listaDragDrop.size(); i++) {
				dragDropDao.delete(listaDragDrop.get(i).getIdetqdragdrop());
			}
			newDragDrop = new EtqDragDrop();
			for (int i = 0; i < tblDragDrop.size(); i++) {
				newDragDrop.setEtiqueta(tblDragDrop.get(i));
				dragDropDao.update(newDragDrop);
			}
		}
		public void removeDragDrop() {
			if (listaSelecionadaEtiquetas.isEmpty()) {
				Messages.addGlobalError("Selecione no minimo uma Etiqueta para Remover!!!");
				return;
			}
			listaSelecionadaEtiquetas.removeAll(listaSelectedDragDrop);
			listaEtiquetas.addAll(listaSelectedDragDrop);
			remakeDragDrop(listaSelecionadaEtiquetas);
			Messages.addGlobalError("Etiquetas Selecionadas removidas com sucesso!!!");
		}

		// ----------Finish Drag and Drop
	
		public void montaEtiquetas(){
			if(!varTermica) {
//			List<Etiquetas> listFiltradasEtiquetas;
//			listFiltradasEtiquetas = new ArrayList<>();
//			detailEtiqueta = new Etiquetas();
//			dataTable = (DataTable) Faces.getViewRoot().findComponent("frmMain:tblEtiquetas");
//			dataTable.getFilteredValue();
//			for (int index = 0; index < dataTable.getRowCount(); index++) {
//				dataTable.setRowIndex(index);
//				detailEtiqueta = (Etiquetas) dataTable.getRowData();
//				listFiltradasEtiquetas.add(detailEtiqueta);
//			 }
////			genDragActionPdf(listFiltradasEtiquetas);
			}else {

				//aqui onta arquivo para impressora termica

				try {
//					List<Etiquetas> listaDragDropTmp = new ArrayList<>();
					newDragDrop = new EtqDragDrop();
					listaDragDrop = new ArrayList<>();
					if (getListaMultiplasEtiquetas().size() != 0) {
//						clearDragDrop();
						Integer mVetor = listaMultiplasEtiquetas.size();
						for (int i = 0; i < mVetor; i++) {
							Long iId = listaMultiplasEtiquetas.get(i).getIdetiqueta();
							newDragDrop.setAprovacao(listaMultiplasEtiquetas.get(i).getAprovacao());
							newDragDrop.setFabricanome(listaMultiplasEtiquetas.get(i).getFabricanome());
							newDragDrop.setClientenome(listaMultiplasEtiquetas.get(i).getClientenome());
							newDragDrop.setMateriala(listaMultiplasEtiquetas.get(i).getMaterial());
							newDragDrop.setMaterialb(listaMultiplasEtiquetas.get(i).getMaterialb());
							newDragDrop.setCor(listaMultiplasEtiquetas.get(i).getCor());
							newDragDrop.setCora(listaMultiplasEtiquetas.get(i).getCora());
							newDragDrop.setFase(listaMultiplasEtiquetas.get(i).getFase());
							newDragDrop.setConstrucao(listaMultiplasEtiquetas.get(i).getConstrucao());
							newDragDrop.setStylename1(listaMultiplasEtiquetas.get(i).getStylename1());
							newDragDrop.setStylename2(listaMultiplasEtiquetas.get(i).getStylename2());
							newDragDrop.setForma(listaMultiplasEtiquetas.get(i).getForma());
							newDragDrop.setReferencia(listaMultiplasEtiquetas.get(i).getReferencia());
							newDragDrop.setEtiqueta(listaMultiplasEtiquetas.get(i));
							newDragDrop.setCodecustomer(listaMultiplasEtiquetas.get(i).getCodecustomer());	
							newDragDrop.setIdetqdragdrop(iId);
							for (int j = 0; j < (listaMultiplasEtiquetas.get(i).getCopias()); j++) {
							  listaDragDrop.add(getNewDragDrop());	
							}
							  newDragDrop = new EtqDragDrop();

						}
						 // dragDropDao.update(newDragDrop);

					} else {
						Messages.addGlobalError("Voce não possui Etiqueta para Impressao!!!");
					}
				} catch (RuntimeException ex) {
					Messages.addGlobalError("Não foi possivel gerar Preview PDF...!" + ex.getMessage());
					ex.printStackTrace();

				}
			}
				
		}
		public void printEtiqueta() {
			try {
				montaEtiquetas();
//				listaDragDrop = new ArrayList<>();
//				listaDragDrop = dragDropDao.findAll();
				if (listaDragDrop.size() == 0) {
					Messages.addGlobalWarn("Não há Etiquetas para imprimir !");
					return;
				}
				repJasperGeral.getRepJaspddI(listaDragDrop);
				for (int i = 0; i < listaEtiquetas.size(); i++ ) {
					if(listaEtiquetas.get(i).getEscolha() != null ) {
						if (listaEtiquetas.get(i).getEscolha().equals(true)) {
							listaEtiquetas.get(i).setEscolha(false);;
						}
					}
				}
			} catch (RuntimeException ex) {
				Messages.addGlobalError("Não foi possivel estabelecer conexão com a impressora!!!"+ex.getMessage());
				ex.printStackTrace();
			}
	}

	public void generateActionPdf(Boolean varIdm) {
		try {
//			jasperReportsfiltros.getRepJaspdd(varIdm);
		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel gerar Preview PDF" + ex.getMessage());
		}
	}
	// Qualquer Etiquetas
	public void generateActFilPdf(){
		try {
//			ReportsJasper reportsJasper = new ReportsJasper();
//			reportsJasper.getReportsJasper();

		} catch (Exception ex) {
			Messages.addGlobalError("Não foi possivel gerar arquivo PDF !!! " + ex.getMessage());
		}

	}
	@SuppressWarnings("unused")
	public void genDragActionPdf(List<Etiquetas> tblEtqDragDrop) {
		List<EtqDragDrop> listaDragDropTmp = new ArrayList<>();
		listaFinalEtqTemp = new ArrayList<>();

		try {
			listaDragDropTmp = dragDropDao.findAll();
			newDragDrop = new EtqDragDrop();
			Integer newPage,index,copiaRegistro,contaEtiqueta;
			Boolean mesmaPagina = true;
			Boolean manterLoop = true;
			newPage = 1;
			index = 0;
			copiaRegistro = 0;
			contaEtiqueta = 0;
			geralEtiquetas = 0;
			if (mCount > 1){
				contaEtiqueta=mCount;
				for (int j = 0; j < 1; j++) {
					
					if (mCount > 0){
						newDragDrop.setVazio1('X');
					}
					if (mCount > 1){
						newDragDrop.setVazio2('X');
					}
					if (mCount > 2){
						newDragDrop.setVazio3('X');
					}
					if (mCount > 3){
						newDragDrop.setVazio4('X');
					}
					if (mCount > 4){
						newDragDrop.setVazio5('X');
					}
					if (mCount > 5){
						newDragDrop.setVazio6('X');
					}
					if (mCount > 6){
						newDragDrop.setVazio7('X');
					}

				mesmaPagina = false;
				}	
			}
			if (!tblEtqDragDrop.isEmpty()) {
				//
				//clearDragDrop();
				do {
					if (newPage == 1){
					  if (mesmaPagina){	
						newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
						newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
						newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
						
						newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
						newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
						newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
						newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
						newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
						newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
						
						newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
						newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
						newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
						newDragDrop.setVazio1('U');
						copiaRegistro++;
						contaEtiqueta++;
						geralEtiquetas++;
						mesmaPagina = false;
					  }
					  newPage++;
					  //Inicio para etiquetas com copias maior quem 1
						if(tblEtqDragDrop.get(index).getCopias() > 1){
							if((newDragDrop.getVazio1() == null ) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio1('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio2() == null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio2('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio3()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio3('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio4()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio4('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio5()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio5('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio6()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));

								newDragDrop.setVazio6('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio7()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio7('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}

							if((newDragDrop.getVazio8()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));

								newDragDrop.setVazio8('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							//contador = 8 , pula situacao
							if (contaEtiqueta < 8){
								if (copiaRegistro.equals(tblEtqDragDrop.get(index).getCopias())){
									//
								   copiaRegistro = 0;
								   newPage = 1;
								   index++;
								   if (index == tblEtqDragDrop.size()){
										dragDropDao.update(newDragDrop);
								   }
								}else{
									newPage = 1;
								}
							}
							if (contaEtiqueta > 7){
								dragDropDao.update(newDragDrop);
								newDragDrop=new EtqDragDrop();
								contaEtiqueta = 0;
								newPage = 1;
								mesmaPagina = true;
								if (tblEtqDragDrop.size() < 2){
									index++;
								}
							}
						}else{
							mesmaPagina = true;
							newPage = 1;
							//newDragDrop=new etqDragDrop();
						    Long iId = tblEtqDragDrop.get(index).getIdetiqueta();
						    newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
						    newDragDrop.setIdetqdragdrop(iId);
							//
							// chama rotina para testar os vazios
							if((newDragDrop.getVazio1()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
			  				    newDragDrop.setVazio1('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;

							}
							if((newDragDrop.getVazio2()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio2('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio3()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));

								newDragDrop.setVazio3('U');
								geralEtiquetas++;
								copiaRegistro++;
								contaEtiqueta++;
							}
							if((newDragDrop.getVazio4()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio4('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio5()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
								newDragDrop.setVazio5('U');

								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio6()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));

								newDragDrop.setVazio6('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if((newDragDrop.getVazio7()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));

								newDragDrop.setVazio7('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}

							if((newDragDrop.getVazio8()== null) && (copiaRegistro < tblEtqDragDrop.get(index).getCopias())){
								newDragDrop.setFabricanome(tblEtqDragDrop.get(index).getFabricanome());
								newDragDrop.setClientenome(tblEtqDragDrop.get(index).getClientenome());
								newDragDrop.setMaterial(tblEtqDragDrop.get(index).getMaterial());
								
								newDragDrop.setStylename1(tblEtqDragDrop.get(index).getStylename1());
								newDragDrop.setStylename2(tblEtqDragDrop.get(index).getStylename2());
								newDragDrop.setConstrucao(tblEtqDragDrop.get(index).getConstrucao());
								newDragDrop.setForma(tblEtqDragDrop.get(index).getForma());
								newDragDrop.setCora(tblEtqDragDrop.get(index).getCora());
								newDragDrop.setAprovacao(tblEtqDragDrop.get(index).getInclusao());
								
								newDragDrop.setCor(tblEtqDragDrop.get(index).getCor());
								newDragDrop.setReferencia(tblEtqDragDrop.get(index).getReferencia());
								newDragDrop.setEtiqueta(tblEtqDragDrop.get(index));
			
								newDragDrop.setVazio8('U');
								copiaRegistro++;
								contaEtiqueta++;
								geralEtiquetas++;
							}
							if (contaEtiqueta < 8){
								if (copiaRegistro.equals(tblEtqDragDrop.get(index).getCopias())){
									//
								   copiaRegistro = 0;
								   newPage = 1;
								   index++;
								   if (index == tblEtqDragDrop.size()){
										dragDropDao.update(newDragDrop);
								   }
								}
							}
							if (contaEtiqueta > 7){
								dragDropDao.update(newDragDrop);
								newDragDrop=new EtqDragDrop();
								contaEtiqueta = 0;
								newPage = 1;
								mesmaPagina = true;
								index++;
							}
							
						}
						if (index == tblEtqDragDrop.size()){
							manterLoop = false;
							Integer numerodelinhas;
							//monta lista DragDrop resultante
//							EtqDragDropDao dropDao = new EtqDragDropDao();
//							listaFinalEtqTemp=dropDao.findAll();
							listaFinalSelecionadas = new ArrayList<>();
							numerodelinhas=listaFinalEtqTemp.size();
							newDragDrop=new EtqDragDrop();
							for (int i = 0; i < listaFinalEtqTemp.size(); i++) {
								newDragDrop=listaFinalEtqTemp.get(i);
								if (newDragDrop.getVazio1() != null){
									if(newDragDrop.getVazio1().equals('X')){
										newDragDrop.setVazio1(null);
									}
								}
								if (newDragDrop.getVazio2() != null){
									if(newDragDrop.getVazio2().equals('X')){
										newDragDrop.setVazio2(null);
									}
								}	
								if (newDragDrop.getVazio3() != null){
									if(newDragDrop.getVazio3().equals('X')){
										newDragDrop.setVazio3(null);
									}
								}	
								if (newDragDrop.getVazio4() != null){
									if(newDragDrop.getVazio4().equals('X')){
										newDragDrop.setVazio4(null);
									}
								}
								if (newDragDrop.getVazio5() != null){
									if(newDragDrop.getVazio5().equals('X')){
										newDragDrop.setVazio5(null);
									}
								}
								if (newDragDrop.getVazio6() != null){
									if(newDragDrop.getVazio6().equals('X')){
										newDragDrop.setVazio6(null);
									}
								}
								if (newDragDrop.getVazio7() != null){
									if(newDragDrop.getVazio7().equals('X')){
										newDragDrop.setVazio7(null);
									}
								}
								if (newDragDrop.getVazio8() != null){
									if(newDragDrop.getVazio8().equals('X')){
										newDragDrop.setVazio8(null);
									}
								}
								listaFinalSelecionadas.add(newDragDrop);
								dragDropDao.update(newDragDrop);	
							}
						}
					}
					
				}while (manterLoop);
			}else {
				Messages.addGlobalError("Não existe Etiqueta para Impressão !!!");
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel gerar Preview PDF...!" + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void clearDragDrop() {
		EtqDragDropDao etqDragDropDao = new EtqDragDropDao();
		 List<EtqDragDrop> listDragDropTmp = new ArrayList<>();
		listDragDropTmp = etqDragDropDao.findAll();
		for (int i = 0; i < listDragDropTmp.size(); i++) {
			etqDragDropDao.delete(listDragDropTmp.get(i).getIdetqdragdrop());
		}
		listaEtiquetas = new ArrayList<Etiquetas>();
		listaSelectedEtiquetas = new ArrayList<Etiquetas>();
//		EtiquetasDao etiquetasDao = new EtiquetasDao();
//		listaEtiquetas = etiquetasDao.findAll();
	}
	//Individual invoices
	public void tblDragDropI(Etiquetas detDDEtiquetas) {
		try {
//			List<Etiquetas> listaDragDropTmp = new ArrayList<Etiquetas>();
			newDragDrop = new EtqDragDrop();
			if (detDDEtiquetas.getFabricanome() != null ) {
				//clearDragDrop();
				for (int i = 0; i < 1; i++) {
					Long iId = detDDEtiquetas.getIdetiqueta();
					newDragDrop.setFabricanome(detDDEtiquetas.getFabricanome());
					newDragDrop.setClientenome(detDDEtiquetas.getClientenome());
					newDragDrop.setMaterial(detDDEtiquetas.getMaterial());
					newDragDrop.setCor(detDDEtiquetas.getCor());
					newDragDrop.setReferencia(detDDEtiquetas.getReferencia());

					newDragDrop.setStylename1(detDDEtiquetas.getStylename1());
					newDragDrop.setStylename2(detDDEtiquetas.getStylename2());
					newDragDrop.setConstrucao(detDDEtiquetas.getConstrucao());
					newDragDrop.setForma(detDDEtiquetas.getForma());
					newDragDrop.setCora(detDDEtiquetas.getCora());
					newDragDrop.setAprovacao(detDDEtiquetas.getInclusao());
					newDragDrop.setCodecustomer(detDDEtiquetas.getCodecustomer());
					
					newDragDrop.setEtiqueta(detDDEtiquetas);
					newDragDrop.setIdetqdragdrop(iId);
					dragDropDao.update(newDragDrop);
				}
			} else {
				Messages.addGlobalError("Voce não possui Etiqueta para Impressao!!!");
			}
		} catch (RuntimeException ex) {
			Messages.addGlobalError("Não foi possivel gerar Preview PDF...!" + ex.getMessage());
			ex.printStackTrace();

		}
	}

	public void refresh() {
		listaEtiquetas = new ArrayList<Etiquetas>();
		listaEtiquetas = etiquetaDao.findAll();
	}
	// Ordena por Sequencia Material
	public static void sortedByIndexEtiqueta(List<Etiquetas> listaEtiquetasMulti) {
		Collections.sort(listaEtiquetasMulti, CompareByIndexMat);
	}

	public static Comparator<Etiquetas> CompareByIndexMat = new Comparator<Etiquetas>() {
		@Override
		public int compare(Etiquetas iB1, Etiquetas iB2) {
			return iB1.getIdetiqueta() .compareTo(iB2.getIdetiqueta());
		}
	};

	
}
