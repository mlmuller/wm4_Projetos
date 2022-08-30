package br.com.gvdexport.logs;

import java.io.Serializable;
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
import br.com.gvdexport.dao.LogAmostrasNovasDao;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.LogAmostrasNovas;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class logsControllerAmostras implements Serializable {


	//Capa Amostras
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private List<LogAmostrasNovas> logAmostraAux;
	@Getter @Setter
	private LogAmostrasNovas logAmostrasNovas;
	@Getter @Setter
	private LogAmostrasNovas cloneAmostrasNovas;
	@Getter @Setter
	private String descricaocampo;
	@Getter @Setter
	private String valoranterior;
	@Getter @Setter
	private String usuario;
	@Getter @Setter
	private LocalDateTime datastamp;
	@Getter @Setter
	private InetAddress ipLocal;
	@Getter @Setter
	private byte[] addip;
	@Getter @Setter
	private String hostName;
	@Getter @Setter
	private Boolean log;
	@Inject
	private UsuarioLogadoController usuarioLogado;
	@Inject
	private LogAmostrasNovasDao logAmostrasNovasdao;
	
	public Boolean logAmostrasNovasEdicao(Amostra amostranew, Amostra Amostraold ) {
		logAmostraAux = new ArrayList<LogAmostrasNovas>();
		logAmostrasNovas = new LogAmostrasNovas();
		cloneAmostrasNovas = new LogAmostrasNovas();
		log = false;
			try {
				if (amostranew!=Amostraold) {
					logAmostrasNovas.setAmostra(Amostraold);
					logAmostrasNovas.setDataStamp(LocalDateTime.now());
					buscaPorIpEstacao();
					logAmostrasNovas.setUsuarioStamp(usuarioLogado.getUsuariologado().getUsuario());
					logAmostrasNovas.setIp(addip);
					logAmostrasNovas.setNomedesktop(hostName);
					cloneAmostrasNovas = (LogAmostrasNovas) logAmostrasNovas.clone();
					logAmostrasNovas = cloneAmostrasNovas;
					if(amostranew.getAbreviacao() != Amostraold.getAbreviacao()) {
						log = true;
						logAmostrasNovas.setDescricaocampo("Abreviação");
						logAmostrasNovas.setValoranterior(Amostraold.getAbreviacao());
						amostranew.setLog(log);
						logAmostraAux.add(logAmostrasNovas);
					}
	
					if (amostranew.getReferencia() != Amostraold.getReferencia()) {
						logAmostrasNovas.setDescricaocampo("Referência");
						logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getReferencia()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
					}
					
					if (amostranew.getVersaoRefer() != Amostraold.getVersaoRefer()) {
						logAmostrasNovas.setDescricaocampo("Versão Ref");
						logAmostrasNovas.setValoranterior(Integer.toString(Amostraold.getVersaoRefer()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
	
					if (amostranew.getCliente() != Amostraold.getCliente()) {
						logAmostrasNovas.setDescricaocampo("Cliente");
						logAmostrasNovas.setValoranterior((Amostraold.getSucCliente()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if(amostranew.getComplementoSolado() != Amostraold.getComplementoSolado() ) {
						logAmostrasNovas.setDescricaocampo("Solado Complemento");
						logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getConstrucaoNome() != Amostraold.getConstrucaoNome()) {
						logAmostrasNovas.setDescricaocampo("Nome Construção");
						logAmostrasNovas.setValoranterior(Amostraold.getConstrucaoNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if ((amostranew.getVersao() != Amostraold.getVersao()) && (amostranew.getConstrucaoNome() == Amostraold.getConstrucaoNome())) {
						logAmostrasNovas.setDescricaocampo("Versão Construção");
						logAmostrasNovas.setValoranterior(Amostraold.getComplementoSolado());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if(amostranew.getDataEntrega() != Amostraold.getDataEntrega()) {
						logAmostrasNovas.setDescricaocampo("Data Entrega");
						logAmostrasNovas.setValoranterior(Amostraold.getDataEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if (amostranew.getDataLiberacaoProducao() != Amostraold.getDataLiberacaoProducao()) {
						logAmostrasNovas.setDescricaocampo("Liberação Produção");
						logAmostrasNovas.setValoranterior(Amostraold.getDataLiberacaoProducao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
	
					}
			
					if (amostranew.getDataSolicitacao() != Amostraold.getDataSolicitacao()) {
						logAmostrasNovas.setDescricaocampo("Data Solicitação");
						logAmostrasNovas.setValoranterior(Amostraold.getDataSolicitacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if (amostranew.getDestinoAmCf() != Amostraold.getDestinoAmCf()) {
						logAmostrasNovas.setDescricaocampo("Destino Amostra confirmação");
						logAmostrasNovas.setValoranterior(Amostraold.getDestinoAmCf().getDestino());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if (amostranew.getDtxfct() != Amostraold.getDtxfct()) {
						logAmostrasNovas.setDescricaocampo("Data Entrega");
						logAmostrasNovas.setValoranterior(Amostraold.getDtxfct().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getEstacao() != Amostraold.getEstacao()) {
						logAmostrasNovas.setDescricaocampo("Estação");
						logAmostrasNovas.setValoranterior(Amostraold.getEstacao().getNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
			
					if (amostranew.getFabrica() != Amostraold.getFabrica()) {
						logAmostrasNovas.setDescricaocampo("Fábrica");
						logAmostrasNovas.setValoranterior(Amostraold.getSucFabrica());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getMarcaCliente() != Amostraold.getMarcaCliente()) {
						logAmostrasNovas.setDescricaocampo("Marca Cliente");
						logAmostrasNovas.setValoranterior(Amostraold.getMarcaCliente().getNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getMercado() != Amostraold.getMercado()) {
						logAmostrasNovas.setDescricaocampo("Mercado");
						logAmostrasNovas.setValoranterior(Amostraold.getMercado().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
			
					if (amostranew.getObsBase() != Amostraold.getObsBase()) {
						logAmostrasNovas.setDescricaocampo("Observação Base");
						logAmostrasNovas.setValoranterior(Amostraold.getObsBase());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
	
					if (amostranew.getObsSolado() != Amostraold.getObsSolado()) {
						logAmostrasNovas.setDescricaocampo("Observação Solado");
						logAmostrasNovas.setValoranterior(Amostraold.getObsSolado());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getParCancelado() != Amostraold.getParCancelado()){
						logAmostrasNovas.setDescricaocampo("Par(es)Cancelado(s)");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getParCancelado().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getPares() != Amostraold.getPares()) {
						logAmostrasNovas.setDescricaocampo("Par(es) Amostra");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPares().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
				
					if (amostranew.getPargvd() != Amostraold.getPargvd()) {
						logAmostrasNovas.setDescricaocampo("Par(es)GVD");
						logAmostrasNovas.setValoranterior(String.valueOf(Amostraold.getPargvd().doubleValue()));
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
				
					if (amostranew.getPersonagem() != Amostraold.getPersonagem()) {
						logAmostrasNovas.setDescricaocampo("Personagem");
						logAmostrasNovas.setValoranterior(Amostraold.getPersonagem().getNome());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);

					}
					
					if (amostranew.getPrioridaDeProducao() != Amostraold.getPrioridaDeProducao()) {
						logAmostrasNovas.setDescricaocampo("Prioridade");
						logAmostrasNovas.setValoranterior(Amostraold.getPrioridaDeProducao().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
					}
	
					if (amostranew.getTipo() != Amostraold.getTipo()) {
						logAmostrasNovas.setDescricaocampo("Tipo Amostra");
						logAmostrasNovas.setValoranterior(Amostraold.getTipo().name());
						amostranew.setLog(true);
						logAmostraAux.add(logAmostrasNovas);
					}
					if (logAmostraAux.size() != 0) {
						logAmostrasNovasdao.updateLogAmostraNova(logAmostraAux);
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
			logAmostrasNovas.setValoranterior(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:SS")));
			amostranew.setLog(true);
			logAmostrasNovasdao.update(logAmostrasNovas);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void buscaPorIpEstacao() throws UnknownHostException {
		ipLocal = InetAddress.getLocalHost();
		addip = ipLocal.getAddress();
		hostName = ipLocal.getHostName();
		
	}
}
