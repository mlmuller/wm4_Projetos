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

import br.com.gvdexport.controller.UsuarioLogadoController;
import br.com.gvdexport.dao.LogAmostraFichaProducaoDao;
import br.com.gvdexport.dao.LogAmostrasNovasDao;
import br.com.gvdexport.model.Amostra;
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

	public Boolean logAmostrasNovasEdicao(Amostra amostranew, Amostra Amostraold) {
		logAmostraAux = new ArrayList<LogAmostrasNovas>();
		logAmostrasNovas = new LogAmostrasNovas();
		cloneAmostrasNovas = new LogAmostrasNovas();
		log = false;
		try {
			if (amostranew != Amostraold) {
				logAmostrasNovas.setAmostra(Amostraold);
				logAmostrasNovas.setDataStamp(LocalDateTime.now());
				ipmask = "";
				buscaPorIpEstacao();
				logAmostrasNovas.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
				logAmostrasNovas.setIp(addip);
				logAmostrasNovas.setIpmask(ipmask);
				logAmostrasNovas.setNomedesktop(hostName);
				cloneAmostrasNovas = (LogAmostrasNovas) logAmostrasNovas.clone();
				logAmostrasNovas = cloneAmostrasNovas;
				if (!amostranew.getAbreviacao().equals(Amostraold.getAbreviacao().trim())) {
					log = true;
					logAmostrasNovas.setDescricaocampo("Abreviação");
					logAmostrasNovas.setValoranterior(Amostraold.getAbreviacao());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (!amostranew.getReferencia().equals(Amostraold.getReferencia())) {
					logAmostrasNovas.setDescricaocampo("Referência");
					logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getReferencia()));
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (!amostranew.getVersaoRefer().equals(Amostraold.getVersaoRefer())) {
					logAmostrasNovas.setDescricaocampo("Versão Ref");
					logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getVersaoRefer()));
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (!amostranew.getCliente().equals(Amostraold.getCliente())) {
					logAmostrasNovas.setDescricaocampo("Cliente");
					logAmostrasNovas.setValoranterior((Amostraold.getSucCliente()));
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (amostranew.getComplementoSolado() != Amostraold.getComplementoSolado()) {
					logAmostrasNovas.setDescricaocampo("Solado Complemento");
					logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (!amostranew.getConstrucaoNome().equals(Amostraold.getConstrucaoNome())) {
					logAmostrasNovas.setDescricaocampo("Nome Construção");
					logAmostrasNovas.setValoranterior(Amostraold.getConstrucaoNome());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if ((!amostranew.getVersao().equals(Amostraold.getVersao()))
						&& (amostranew.getConstrucaoNome() == Amostraold.getConstrucaoNome())) {
					logAmostrasNovas.setDescricaocampo("Versão Construção");
					logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}
				if (Amostraold.getDataEntrega() != null) {
					if (!amostranew.getDataEntrega().equals(Amostraold.getDataEntrega())) {
						logAmostrasNovas.setDescricaocampo("Data Entrega");
						String valor = "";
						valor = Amostraold.getDataEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getDataLiberacaoProducao() != null) {
					if (!amostranew.getDataLiberacaoProducao().equals(Amostraold.getDataLiberacaoProducao())) {
						logAmostrasNovas.setDescricaocampo("Liberação Produção");
						String dataformatada = "";
						LocalDateTime currentLocalDateTime = Amostraold.getDataLiberacaoProducao();
						DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						dataformatada = currentLocalDateTime.format(dateTimeFormatter);
						logAmostrasNovas.setValoranterior(dataformatada);
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getDataSolicitacao() != null) {
					if (!amostranew.getDataSolicitacao().equals(Amostraold.getDataSolicitacao())) {
						logAmostrasNovas.setDescricaocampo("Data Solicitação");
						String valor = "";
						valor = Amostraold.getDataSolicitacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getDestinoAmCf() != null) {
					if (!amostranew.getDestinoAmCf().equals(Amostraold.getDestinoAmCf())) {
						logAmostrasNovas.setDescricaocampo("Destino Amostra confirmação");
						logAmostrasNovas.setValoranterior(Amostraold.getDestinoAmCf().getDestino());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getDtxfct() != null) {
					if (!amostranew.getDtxfct().equals(Amostraold.getDtxfct())) {
						logAmostrasNovas.setDescricaocampo("Data Entrega");
						String valor = "";
						valor = Amostraold.getDtxfct().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						logAmostrasNovas.setValoranterior(valor);
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (!amostranew.getEstacao().equals(Amostraold.getEstacao())) {
					logAmostrasNovas.setDescricaocampo("Estação");
					logAmostrasNovas.setValoranterior(Amostraold.getEstacao().getNome());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}

				if (!amostranew.getFabrica().equals(Amostraold.getFabrica())) {
					logAmostrasNovas.setDescricaocampo("Fábrica");
					logAmostrasNovas.setValoranterior(Amostraold.getSucFabrica());
					amostranew.setLog(true);
					logAmostraAux.add(logAmostrasNovas);
					logAmostrasNovas = new LogAmostrasNovas();
				}
				if (Amostraold.getMarcaCliente() != null) {
					if (!amostranew.getMarcaCliente().equals(Amostraold.getMarcaCliente())) {
						logAmostrasNovas.setDescricaocampo("Marca Cliente");
						logAmostrasNovas.setValoranterior(Amostraold.getMarcaCliente().getNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getMercado() != null) {
					if (!amostranew.getMercado().equals(Amostraold.getMercado())) {
						logAmostrasNovas.setDescricaocampo("Mercado");
						logAmostrasNovas.setValoranterior(Amostraold.getMercado().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getObsBase() != null) {
					if (!amostranew.getObsBase().equals(Amostraold.getObsBase())) {
						logAmostrasNovas.setDescricaocampo("Observação Base");
						logAmostrasNovas.setValoranterior(Amostraold.getObsBase());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getObsSolado() != null) {
					if (!amostranew.getObsSolado().equals(Amostraold.getObsSolado())) {
						logAmostrasNovas.setDescricaocampo("Observação Solado");
						logAmostrasNovas.setValoranterior(Amostraold.getObsSolado());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getPares() != null) {
					if (!amostranew.getParCancelado().equals(Amostraold.getParCancelado())) {
						logAmostrasNovas.setDescricaocampo("Par(es)Cancelado(s)");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getParCancelado().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getPares() != null) {
					if (!amostranew.getPares().equals(Amostraold.getPares())) {
						logAmostrasNovas.setDescricaocampo("Par(es) Amostra");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPares().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getPargvd() != null) {
					if (!amostranew.getPargvd().equals(Amostraold.getPargvd())) {
						logAmostrasNovas.setDescricaocampo("Par(es)GVD");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPargvd().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getPersonagem() != null) {
					if (!amostranew.getPersonagem().equals(Amostraold.getPersonagem())) {
						logAmostrasNovas.setDescricaocampo("Personagem");
						logAmostrasNovas.setValoranterior(Amostraold.getPersonagem().getNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getPrioridadeProducao() != null) {
					if (!amostranew.getPrioridadeProducao().equals(Amostraold.getPrioridadeProducao())) {
						logAmostrasNovas.setDescricaocampo("Prioridade");
						logAmostrasNovas.setValoranterior(Amostraold.getPrioridadeProducao().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (Amostraold.getTipo() != null) {
					if (!amostranew.getTipo().equals(Amostraold.getTipo())) {
						logAmostrasNovas.setDescricaocampo("Tipo Amostra");
						logAmostrasNovas.setValoranterior(Amostraold.getTipo().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
						logAmostrasNovas = new LogAmostrasNovas();
					}
				}
				if (logAmostraAux.size() != 0) {
					if (!Amostraold.getPrioridadeProducao().equals(PrioridadeProducao.T)) {
						logAmostrasNovasdao.updateLogAmostraNova(logAmostraAux);
					} else {
						// logAmostraFichaProducaoDao - pós e durante producao
						logAmostraFichaProducaoDao.update(logAmostrasNovas);
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
			// TODO Auto-generated catch block
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
