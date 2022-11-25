package br.com.gvdexport.logs;

import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.SerializationUtils;

import br.com.gvdexport.controller.UsuarioLogadoController;
import br.com.gvdexport.dao.LogAmostraFichaProducaoDao;
import br.com.gvdexport.dao.LogAmostrasNovasDao;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.LogAmostraFichaProducao;
import br.com.gvdexport.model.LogAmostrasNovas;
import br.com.gvdexport.model.PrioridadeProducao;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class logsControllerAmostras implements Serializable {

	// Capa Amostras

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<LogAmostrasNovas> logAmostraAux;
	@Getter @Setter
	private List<LogAmostraFichaProducao> logAmostraFichaProducaoAux;
	@Getter
	@Setter
	private LogAmostrasNovas logAmostrasNovas;
	@Getter
	@Setter
	private LogAmostrasNovas cloneAmostrasNovas;
	@Getter
	@Setter
	private String descricaocampo;
	@Getter
	@Setter
	private String valoranterior;
	@Getter
	@Setter
	private String usuario;
	@Getter
	@Setter
	private LocalDateTime datastamp;
	@Getter
	@Setter
	private InetAddress ipLocal;
	@Getter
	@Setter
	private byte[] addip;
	@Getter
	@Setter
	private String hostName;
	@Getter
	@Setter
	private String ipmask;
	@Getter
	@Setter
	private Boolean log;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private LogAmostrasNovasDao logAmostrasNovasdao;
	@Inject
	private LogAmostraFichaProducaoDao logAmostraFichaProducaoDao;

	@SuppressWarnings("unchecked")
	public Boolean logAmostrasNovasEdicao(Amostra amostranew, Amostra Amostraold) throws CloneNotSupportedException {
		logAmostraAux = (List<LogAmostrasNovas>) new ArrayList<LogAmostrasNovas>().clone();
		logAmostrasNovas = new LogAmostrasNovas();
//		LogAmostrasNovas cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
		LogAmostrasNovas cloneAuxAmostra = SerializationUtils.clone(logAmostrasNovas);
		log = false;
		 try {
			if (amostranew != Amostraold) {
				logAmostrasNovas.setAmostra(Amostraold);
				ipmask = "";
				buscaPorIpEstacao();
				logAmostrasNovas.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
				logAmostrasNovas.setIp(addip);
				logAmostrasNovas.setIpmask(ipmask);
				logAmostrasNovas.setNomedesktop(hostName);
				logAmostrasNovas.setDataStamp(LocalDateTime.now());
				cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
				if (!amostranew.getAbreviacao().equals(Amostraold.getAbreviacao().trim())) {
					log = true;
					cloneAuxAmostra.setDescricaocampo("Abreviação");
					cloneAuxAmostra.setValoranterior(Amostraold.getAbreviacao());
					amostranew.setLog(true);
					logAmostraAux.add(cloneAuxAmostra);
				}
				if (!amostranew.getReferencia().equals(Amostraold.getReferencia())) {
					logAmostrasNovas.setDescricaocampo("Referência");
					logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getReferencia()));
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if (!amostranew.getVersaoRefer().equals(Amostraold.getVersaoRefer())) {
					logAmostrasNovas.setDescricaocampo("Versão Ref");
					logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getVersaoRefer()));
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if (!amostranew.getCliente().equals(Amostraold.getCliente())) {
					logAmostrasNovas.setDescricaocampo("Cliente");
					logAmostrasNovas.setValoranterior((Amostraold.getSucCliente()));
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if (amostranew.getComplementoSolado() != Amostraold.getComplementoSolado()) {
					logAmostrasNovas.setDescricaocampo("Solado Complemento");
					logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if (!amostranew.getConstrucaoNome().equals(Amostraold.getConstrucaoNome())) {
					logAmostrasNovas.setDescricaocampo("Nome Construção");
					logAmostrasNovas.setValoranterior(Amostraold.getConstrucaoNome());
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if ((!amostranew.getVersao().equals(Amostraold.getVersao()))
						&& (amostranew.getConstrucaoNome() == Amostraold.getConstrucaoNome())) {
					logAmostrasNovas.setDescricaocampo("Versão Construção");
					logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}
				if (Amostraold.getDataEntrega() != null) {
					if (!amostranew.getDataEntrega().equals(Amostraold.getDataEntrega())) {
						logAmostrasNovas.setDescricaocampo("Data Entrega");
						String valor = "";
						valor = Amostraold.getDataEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add((LogAmostrasNovas) cloneAuxAmostra.clone());
						
					}
				}
				if (Amostraold.getDataSolicitacao() != null) {
					if (!amostranew.getDataSolicitacao().equals(Amostraold.getDataSolicitacao())) {
						logAmostrasNovas.setDescricaocampo("Data Solicitação");
						String valor = "";
						valor = Amostraold.getDataSolicitacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add((LogAmostrasNovas) cloneAuxAmostra.clone());
					}
				}
				if (Amostraold.getDestinoAmCf() != null) {
					if (!amostranew.getDestinoAmCf().equals(Amostraold.getDestinoAmCf())) {
						logAmostrasNovas.setDescricaocampo("Destino Amostra confirmação");
						logAmostrasNovas.setValoranterior(Amostraold.getDestinoAmCf().getDestino());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add((LogAmostrasNovas) cloneAuxAmostra.clone());
					}
				}
				if (Amostraold.getDtxfct() != null) {
					if (!amostranew.getDtxfct().equals(Amostraold.getDtxfct())) {
						logAmostrasNovas.setDescricaocampo("Amostra Para");
						String valor = "";
						valor = Amostraold.getDtxfct().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						amostranew.setLog(true);
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (!amostranew.getEstacao().equals(Amostraold.getEstacao())) {
					logAmostrasNovas.setDescricaocampo("Estação");
					logAmostrasNovas.setValoranterior(Amostraold.getEstacao().getNome());
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}

				if (!amostranew.getFabrica().equals(Amostraold.getFabrica())) {
					logAmostrasNovas.setDescricaocampo("Fábrica");
					logAmostrasNovas.setValoranterior(Amostraold.getSucFabrica());
					amostranew.setLog(true);
					cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
					cloneAuxAmostra = logAmostrasNovas;
					logAmostraAux.add(cloneAuxAmostra);
				}
				if (Amostraold.getMarcaCliente() != null) {
					if (!amostranew.getMarcaCliente().equals(Amostraold.getMarcaCliente())) {
						logAmostrasNovas.setDescricaocampo("Marca Cliente");
						logAmostrasNovas.setValoranterior(Amostraold.getMarcaCliente().getNome());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getMercado() != null) {
					if (!amostranew.getMercado().equals(Amostraold.getMercado())) {
						logAmostrasNovas.setDescricaocampo("Mercado");
						logAmostrasNovas.setValoranterior(Amostraold.getMercado().name());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getObsBase() != null) {
					if (!amostranew.getObsBase().equals(Amostraold.getObsBase())) {
						logAmostrasNovas.setDescricaocampo("Observação Base");
						logAmostrasNovas.setValoranterior(Amostraold.getObsBase());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getObsSolado() != null) {
					if (!amostranew.getObsSolado().equals(Amostraold.getObsSolado())) {
						logAmostrasNovas.setDescricaocampo("Observação Solado");
						logAmostrasNovas.setValoranterior(Amostraold.getObsSolado());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getPares() != null) {
					if (!amostranew.getParCancelado().equals(Amostraold.getParCancelado())) {
						logAmostrasNovas.setDescricaocampo("Par(es)Cancelado(s)");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getParCancelado().doubleValue()));
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getPares() != null) {
					if (!amostranew.getPares().equals(Amostraold.getPares())) {
						logAmostrasNovas.setDescricaocampo("Par(es) Amostra");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPares().doubleValue()));
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getPargvd() != null) {
					if (!amostranew.getPargvd().equals(Amostraold.getPargvd())) {
						logAmostrasNovas.setDescricaocampo("Par(es)GVD");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPargvd().doubleValue()));
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getPersonagem() != null) {
					if (!amostranew.getPersonagem().equals(Amostraold.getPersonagem())) {
						logAmostrasNovas.setDescricaocampo("Personagem");
						logAmostrasNovas.setValoranterior(Amostraold.getPersonagem().getNome());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getPrioridadeProducao() != null) {
					if (!amostranew.getPrioridadeProducao().equals(Amostraold.getPrioridadeProducao())) {
						logAmostrasNovas.setDescricaocampo("Prioridade");
						logAmostrasNovas.setValoranterior(Amostraold.getPrioridadeProducao().name());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				if (Amostraold.getTipo() != null) {
					if (!amostranew.getTipo().equals(Amostraold.getTipo())) {
						logAmostrasNovas.setDescricaocampo("Tipo Amostra");
						logAmostrasNovas.setValoranterior(Amostraold.getTipo().name());
						amostranew.setLog(true);
						cloneAuxAmostra = (LogAmostrasNovas) new LogAmostrasNovas().clone();
						cloneAuxAmostra = logAmostrasNovas;
						logAmostraAux.add(cloneAuxAmostra);
					}
				}
				//Aqui grava em dois pontos, para termos situacao de historico direto
				//e Tambem a importancia,caso haja alteracao indevida,a principio sistema nao permiti
				if (logAmostraAux.size() != 0) {
					logAmostrasNovasdao.updateLogAmostraNova(logAmostraAux);
					logAmostraFichaProducaoAux = (List<LogAmostraFichaProducao>) new ArrayList<LogAmostraFichaProducao>().clone();
					if (Amostraold.getPrioridadeProducao().equals(PrioridadeProducao.T)) {
						LogAmostraFichaProducao aux = (LogAmostraFichaProducao) new LogAmostraFichaProducao().clone();
						for (int i = 0; i < logAmostraAux.size(); i++) {
							aux.setAmostra(logAmostraAux.get(i).getAmostra());
							aux.setDataStamp(logAmostraAux.get(i).getDataStamp());
							aux.setDescricaocampo(logAmostraAux.get(i).getDescricaocampo());
							aux.setHorario(logAmostraAux.get(i).getHorario());
							aux.setIp(logAmostraAux.get(i).getIp());
							aux.setIpmask(logAmostraAux.get(i).getIpmask());
							aux.setNomedesktop(logAmostraAux.get(i).getNomedesktop());
							aux.setUsuarioStamp(logAmostraAux.get(i).getUsuarioStamp());
							aux.setValoranterior(logAmostraAux.get(i).getValoranterior());
							logAmostraFichaProducaoAux.add(aux);
							aux = new LogAmostraFichaProducao();
						}
						// logAmostraFichaProducaoDao - pós e durante producao
						logAmostraFichaProducaoDao.updateLogAmostraFichaProducao(logAmostraFichaProducaoAux);
					}
					}
				}
		} catch (CloneNotSupportedException | UnknownHostException e) {
			e.printStackTrace();
		}

		return log;
	}

	public void logAmostrasNovasDelecao(Amostra amostranew, Amostra Amostraold) {

		try {
			logAmostrasNovas = new LogAmostrasNovas();
			buscaPorIpEstacao();
			logAmostrasNovas.setAmostra(Amostraold);
			logAmostrasNovas.setDataStamp(LocalDateTime.now());
			logAmostrasNovas.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
			logAmostrasNovas.setIp(addip);
			logAmostrasNovas.setNomedesktop(hostName);
			logAmostrasNovas.setDescricaocampo("Deleção");
			logAmostrasNovas
					.setValoranterior(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:SS")));
			amostranew.setLog(true);
			logAmostrasNovasdao.update(logAmostrasNovas);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void buscaPorIpEstacao() throws UnknownHostException {
		ipLocal = Inet4Address.getLocalHost();
		addip = ipLocal.getAddress();
		ipmask = Inet4Address.getLocalHost().getHostAddress();
		hostName = ipLocal.getHostName();

	}
}
