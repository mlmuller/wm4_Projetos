package br.com.gvdexport.facade;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.gvdexport.model.AcabamentoAmostra;
import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Banco;
import br.com.gvdexport.model.Cidade;
import br.com.gvdexport.model.Cliente;
import br.com.gvdexport.model.ClienteProjecao;
import br.com.gvdexport.model.Componente;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Conversao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.CorAcabamentoAm;
import br.com.gvdexport.model.CorAmostra;
import br.com.gvdexport.model.CorAmostraMulti;
import br.com.gvdexport.model.CorCabedalAm;
import br.com.gvdexport.model.CorConstrucaoAm;
import br.com.gvdexport.model.CorCorteAm;
import br.com.gvdexport.model.CorCosturaAm;
import br.com.gvdexport.model.CorteAmostra;
import br.com.gvdexport.model.CosturaAmostra;
import br.com.gvdexport.model.Cotacao;
import br.com.gvdexport.model.DGAGlobal;
import br.com.gvdexport.model.Despachante;
import br.com.gvdexport.model.DestinoAmCf;
import br.com.gvdexport.model.EmTransicao;
import br.com.gvdexport.model.Estacao;
import br.com.gvdexport.model.Estado;
import br.com.gvdexport.model.Etiquetas;
import br.com.gvdexport.model.Fabrica;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.Forma;
import br.com.gvdexport.model.GrupoCliente;
import br.com.gvdexport.model.GrupoClienteInvoice;
import br.com.gvdexport.model.GrupoFabrica;
import br.com.gvdexport.model.Hts;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.Importador;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.LogAmostraFichaProducao;
import br.com.gvdexport.model.LogAmostrasNovas;
import br.com.gvdexport.model.MarcaCliente;
import br.com.gvdexport.model.Material;
import br.com.gvdexport.model.Modelo;
import br.com.gvdexport.model.Moeda;
import br.com.gvdexport.model.Navio;
import br.com.gvdexport.model.Nbm;
import br.com.gvdexport.model.Pais;
import br.com.gvdexport.model.Personagem;
import br.com.gvdexport.model.PrazoPagamento;
import br.com.gvdexport.model.PrioridadeProducao;
import br.com.gvdexport.model.RazaoAlteracao;
import br.com.gvdexport.model.Regiao;
import br.com.gvdexport.model.TipoCalcado;
import br.com.gvdexport.model.Transportador;

@Named
@SessionScoped
public class FacadeAcesso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	// Retorna Acesso/Pais ja estiver cadastrado
	public List<Pais> existePais(String nomepais, String abreviacao) {
		try {
			TypedQuery<Pais> q = em.createQuery(
					"SELECT p " + "FROM Pais p " + "WHERE p.nome = : nomePais or p.sigla = :abrPais", Pais.class);
			q.setParameter("nomePais", nomepais.toUpperCase());
			q.setParameter("abrPais", abreviacao.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Personagem ja estiver cadastrado
	public List<Personagem> existePersonagem(String nomepersonagem) {
		try {
			TypedQuery<Personagem> q = em.createQuery(
					"SELECT p " + "FROM Personagem p " + "WHERE p.nome = : nomePersonagem", Personagem.class);
			q.setParameter("nomePersonagem", nomepersonagem.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Acesso/Pais ja estiver cadastrado
	public List<Regiao> existeRegiao(String nomeregiao) {
		try {
			TypedQuery<Regiao> q = em.createQuery("SELECT r " + "FROM Regiao r " + "WHERE r.nome = : nomeRegiao",
					Regiao.class);
			q.setParameter("nomeRegiao", nomeregiao.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Acesso/Pais ja estiver cadastrado
	public List<Estado> existeEstado(String nomeEstado, String abreviacao) {
		try {
			TypedQuery<Estado> q = em.createQuery(
					"SELECT e " + "FROM Estado e " + "WHERE e.nome = : nomeEstado or e.sigla = :abrEstado",
					Estado.class);
			q.setParameter("nomeEstado", nomeEstado.toUpperCase());
			q.setParameter("abrEstado", abreviacao.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Acesso Cidade ja estiver cadastrado
	public List<Cidade> existeCidade(String nomecidade) {
		try {
			TypedQuery<Cidade> q = em.createQuery("SELECT c " + "FROM Cidade c " + "WHERE c.nome = : nomeCidade",
					Cidade.class);
			q.setParameter("nomeCidade", nomecidade.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Acesso Despachante ja estiver cadastrado
	public List<Despachante> existeDespachante(String nomedespachante) {
		try {
			TypedQuery<Despachante> q = em.createQuery(
					"SELECT d " + "FROM Despachante d " + "WHERE d.nome = : nomeDespachante", Despachante.class);
			q.setParameter("nomeDespachante", nomedespachante.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Acesso Navio ja estiver cadastrado
	public List<Navio> existeNavio(String nomenavio) {
		try {
			TypedQuery<Navio> q = em.createQuery("SELECT n " + "FROM Navio n " + "WHERE n.nome = : nomeNavio",
					Navio.class);
			q.setParameter("nomeNavio", nomenavio.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Nbm> existeNBM(String nbm) {
		try {
			TypedQuery<Nbm> q = em.createQuery("SELECT n " + "FROM Nbm n " + "WHERE n.nbm = : Nbm", Nbm.class);
			q.setParameter("Nbm", nbm);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Hts> existeHTS(String hts) {
		try {
			TypedQuery<Hts> q = em.createQuery("SELECT h " + "FROM Hts h " + "WHERE h.hts = : Hts", Hts.class);
			q.setParameter("Hts", hts);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Banco> existeBanco(String nomebanco) {
		try {
			TypedQuery<Banco> q = em.createQuery("SELECT b " + "FROM Banco b " + "WHERE b.nome = : nomeBanco",
					Banco.class);
			q.setParameter("nomeBanco", nomebanco);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<RazaoAlteracao> existeRazaoAlteracao(String nomeRazao) {
		try {
			TypedQuery<RazaoAlteracao> q = em.createQuery(
					"SELECT r " + "FROM RazaoAlteracao r " + "WHERE r.descricao = : nomerazao", RazaoAlteracao.class);
			q.setParameter("nomerazao", nomeRazao.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<TipoCalcado> existeTipoCalcado(String nomePortugues) {
		try {
			TypedQuery<TipoCalcado> q = em.createQuery(
					"SELECT t " + "FROM TipoCalcado t " + "WHERE t.nomeport = : nomePort", TipoCalcado.class);
			q.setParameter("nomePort", nomePortugues.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Pesquisar se existe Cadastro Grupo Cliente
	public List<GrupoCliente> existeGrupoCliente(String nome) {
		try {
			TypedQuery<GrupoCliente> q = em.createQuery("SELECT g " + "FROM GrupoCliente g " + "WHERE g.nome = : nome",
					GrupoCliente.class);
			q.setParameter("nome", nome.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Pesquisar se existe Sigla moeda
	public List<Moeda> existeMoeda(String nomesigla) {
		try {
			TypedQuery<Moeda> q = em.createQuery("SELECT m " + "FROM Moeda m " + "WHERE m.sigla = : nomeMoeda",
					Moeda.class);
			q.setParameter("nomeMoeda", nomesigla);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Pesquisar se existe data cotacao e moeda
	public List<Cotacao> existeCotacao(Date datacotacao, String moeda) {
		try {
			TypedQuery<Cotacao> q = em.createQuery("SELECT c " + "FROM Cotacao c "
					+ "WHERE c.datacotacao =: dataCompara and c.moedas.descricao =: Moeda", Cotacao.class);
			q.setParameter("dataCompara", datacotacao, TemporalType.DATE);
			q.setParameter("Moeda", moeda);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Cotacao> ultimoLancamentoCotacao() {
		try {
			TypedQuery<Cotacao> q = em.createQuery(
					"SELECT c " + "FROM Cotacao c  ORDER BY c.datacotacao DESC,c.moedas DESC", Cotacao.class);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Pesquisar se existe unica cotacao
	public Cotacao existeUnicoDiaCotacao(Date datacotacao, String moeda) {
		try {
			TypedQuery<Cotacao> q = em.createQuery(
					"SELECT c " + "FROM Cotacao c " + "WHERE c.datacotacao =: dataCompara and c.moedas.sigla =: Moeda",
					Cotacao.class);
			q.setParameter("dataCompara", datacotacao, TemporalType.DATE);
			q.setParameter("Moeda", moeda);
			return q.getSingleResult();
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Cotacao> anoLancamentoCotacao(Integer mano) {
		try {
			TypedQuery<Cotacao> q = em.createQuery("SELECT c "
					+ "FROM Cotacao c WHERE c.ano =: Ano  ORDER BY c.datacotacao DESC,c.mesnumeral DESC,c.moedas DESC",
					Cotacao.class);
			q.setParameter("Ano", mano);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Componente ja estiver cadastrado
	public List<Componente> existeComponente(String grupo, String definicao) {
		try {
			TypedQuery<Componente> q = em.createQuery("SELECT c " + "FROM Componente c "
					+ "WHERE c.grupocomponente = : Grupo and trim(c.def1) LIKE :Definicao", Componente.class);
			q.setParameter("Grupo", grupo);
			q.setParameter("Definicao", "%" + definicao.toUpperCase() + "%");
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Grupo Componente
	public List<Componente> buscaComponente(String grupo) {
		try {
			TypedQuery<Componente> q = em.createQuery(
					"SELECT c " + "FROM Componente c " + "WHERE c.grupocomponente = : Grupo", Componente.class);
			q.setParameter("Grupo", grupo);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Retorna Parametro ja estiver cadastrado
	public List<DGAGlobal> existeGlobalParametro(String parametro) {
		try {
			TypedQuery<DGAGlobal> q = em.createQuery(
					"SELECT g " + "FROM DGAGlobal g " + "WHERE g.parametro = : Parametro", DGAGlobal.class);
			q.setParameter("Parametro", parametro);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Se existe numeracao de conversao
	public List<Conversao> existeConversaoNome(String nomeconversao) {
		try {
			TypedQuery<Conversao> q = em
					.createQuery("SELECT c " + "FROM Conversao c " + "WHERE c.nome = : nomeConversao", Conversao.class);
			q.setParameter("nomeConversao", nomeconversao);
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Se existe Importador
	public List<Importador> existeImportador(String nomeimportador) {
		try {
			TypedQuery<Importador> q = em.createQuery("SELECT i " + "FROM Importador i " + "WHERE i.nome = : nome",
					Importador.class);
			q.setParameter("nome", nomeimportador.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Se existe Descricao Prazo Pgto
	public List<PrazoPagamento> existePrazoPgto(String descricao) {
		try {
			TypedQuery<PrazoPagamento> q = em.createQuery(
					"SELECT pp " + "FROM PrazoPagamento pp " + "WHERE pp.descricao = : Descricao",
					PrazoPagamento.class);
			q.setParameter("Descricao", descricao.toUpperCase());
			return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}

	// Se existe Descricao Transportador
	public List<Transportador> existeTransportadora(String nome) {
		try {
			TypedQuery<Transportador> q = em
					.createQuery("SELECT t " + "FROM Transportador t " + "WHERE t.nome = : Nome", Transportador.class);
			q.setParameter("Nome", nome.toUpperCase());
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe este cliente Projecao Cadastrado
	public List<ClienteProjecao> existeGrupoClienteProjecao(String nome) {
		try {
			TypedQuery<ClienteProjecao> q = em.createQuery(
					"SELECT c " + "FROM ClienteProjecao c " + "WHERE c.nome = : Nome", ClienteProjecao.class);
			q.setParameter("Nome", nome.toUpperCase());
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Nome para este GrupClienteInvoices(consignatarios)
	public List<GrupoClienteInvoice> existeGrupoClienteInvoice(String nome) {
		try {
			TypedQuery<GrupoClienteInvoice> q = em.createQuery(
					"SELECT g " + "FROM GrupoClienteInvoice g " + "WHERE g.nome = : Nome", GrupoClienteInvoice.class);
			q.setParameter("Nome", nome.toUpperCase());
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Nome para este Cliente
	public List<Cliente> existeCliNome(String nome) {
		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT c " + "FROM Cliente c " + "WHERE c.nome = : Nome",
					Cliente.class);
			q.setParameter("Nome", nome.toUpperCase());
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Bloco de pesquisas referente aos filtros
	// Busca Cliente por qualquer conteudo informado
	public List<Cliente> buscaCliente(String nomecliente) {
		try {
			TypedQuery<Cliente> q = em.createQuery(
					"SELECT c " + "FROM Cliente c " + "WHERE " + "UPPER(c.sucinto) LIKE :Sucinto", Cliente.class);
//						q.setParameter("Sucinto","%"+nomecliente.toUpperCase()+"%");
			q.setParameter("Sucinto", "%" + nomecliente + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// --------Busca fabrica por qualquer conteudo informado
	public List<Fabrica> buscaFabrica(String nomefabrica) {
		try {
			TypedQuery<Fabrica> q = em.createQuery(
					"SELECT f " + "FROM Fabrica f " + "WHERE " + "UPPER(f.sucinto) LIKE :Sucinto", Fabrica.class);
			q.setParameter("Sucinto", "%" + nomefabrica + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Implementar
	public void MontaFiltroAmostra() {

	}

	// Implementar
	@SuppressWarnings({ "unchecked" })
	public List<Object[]> listaAmostraFiltro() {
		try {
			List<Object[]> result = em.createQuery("SELECT a.amostraid,ca.cor,ca.corprincipal FROM Amostra a "
					+ "LEFT JOIN CorAmostra ca " + "ON a.amostraid = ca.amostraid").getResultList();
			return result;
		} catch (Exception ne) {
			return null;
		}

	}

	// ---------Fim do Bloco de Pesquisa filtro
	//
	// Se existe Sucinto para este Cliente
	public List<Cliente> existeCliSucinto(String nome) {
		nome = nome.toUpperCase().trim();
		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT c " + "FROM Cliente c " + "WHERE c.sucinto LIKE :Sucinto",
					Cliente.class);
			q.setParameter("Sucinto", '%' + nome + '%');
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Nome para este Grupo Fabrica
	public List<GrupoFabrica> existeGrupoFabrica(String nome) {
		try {
			TypedQuery<GrupoFabrica> q = em
					.createQuery("SELECT f " + "FROM GrupoFabrica f " + "WHERE f.nome LIKE :Nome", GrupoFabrica.class);
			q.setParameter("Nome", "%" + nome + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Referencia para esta forma
	public List<Forma> existeFormaReferencia(String referencia) {
		try {
			TypedQuery<Forma> q = em
					.createQuery("SELECT f " + "FROM Forma f " + "WHERE f.referenciaforma = : Referencia", Forma.class);
			q.setParameter("Referencia", referencia);
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Nome para este Grupo Fabrica
	public List<Fabrica> existeFabNome(String nome, String sucinto, String abreviado) {
		String Selecao;
		Selecao = "";
		try {
			if (nome != null) {
				Selecao = "Select f FROM Fabrica f " + "WHERE " + "f.nome = : Nome";
			}
			if (sucinto != null) {
				nome = sucinto;
				Selecao = "Select f FROM Fabrica f " + "WHERE " + "f.sucinto = : Nome";
			}
			if (abreviado != null) {
				nome = abreviado;
				Selecao = "Select f FROM Fabrica f " + "WHERE " + "f.abreviacao = : Nome ";

			}
			TypedQuery<Fabrica> q = em.createQuery(Selecao, Fabrica.class);
			q.setParameter("Nome", nome);

			return q.getResultList();

		} catch (Exception ne) {
			return null;
		}
	}

	public List<Componente> existeNumeracaoProduz(String nomesucinto, String nomeconversao) {
		try {
			TypedQuery<Componente> q = em.createQuery(
					"SELECT c " + "FROM Componente c "
							+ "WHERE c.nomesucinto = : nomeSucinto and c.nomeconversao = :nomeConversao",
					Componente.class);
			q.setParameter("nomeSucinto", nomesucinto);
			q.setParameter("nomeConversao", nomeconversao);
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Estacao
	public List<Estacao> existeEstacao(String nome) {
		try {
			TypedQuery<Estacao> q = em.createQuery("SELECT e " + "FROM Estacao e " + "WHERE e.nome LIKE :Nome",
					Estacao.class);
			q.setParameter("Nome", "%" + nome.toUpperCase() + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Existe Construcao+Versao
	public List<Construcao> existeConstrucaoVersao(String construcao, Integer versao) {
		try {
			TypedQuery<Construcao> q = em.createQuery(
					"SELECT c " + "FROM Construcao c "
							+ "WHERE c.construcao=:Construcao and c.versao=:Versao ORDER BY c.construcao ,c.versao ASC",
					Construcao.class);
			q.setParameter("Construcao", construcao);
			q.setParameter("Versao", versao);
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Existe Referencia+Versao
	public LivroReferencia existeLivroReferenciaVersao(String abreviacao, Integer referencia, Integer versao,
			Long construcao) {
		try {

			TypedQuery<LivroReferencia> q = em.createQuery("SELECT lv FROM LivroReferencia lv "
					+ "WHERE trim(lv.abreviacao)=:Abreviacao AND "
					+ "lv.referencia=:Referencia AND lv.versaorefer=:Versao AND lv.construcao.construcaoid=:ConstrucaoId",
					LivroReferencia.class);
			q.setParameter("Abreviacao", abreviacao);
			q.setParameter("Referencia", referencia);
			q.setParameter("Versao", versao);
			q.setParameter("ConstrucaoId", construcao);
			return q.getSingleResult();

		} catch (NoResultException ne) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Existe construcao
	public List<Construcao> existeConstrucoes(String construcao) {
		try {
			TypedQuery<Construcao> q = em.createQuery("SELECT c " + "FROM Construcao c "
					+ "WHERE c.construcao LIKE :Construcao ORDER BY c.construcao,c.versao", Construcao.class);
			q.setParameter("Construcao", "%" + construcao + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Pegar parcial com ordem default definida pelo usuario
	public List<Construcao> parcialConstrucoesPorOrdem() {
		TypedQuery<Construcao> q = em.createQuery("SELECT c " + "FROM Construcao c", Construcao.class);
		return q.getResultList();
	}

	// Existe construcao
	public List<Construcao> todasConstrucoesPorOrdem() {
		try {
			TypedQuery<Construcao> q = em.createQuery(
					"SELECT c " + "FROM Construcao c WHERE 1 = 1 ORDER BY c.construcao,c.versao ASC", Construcao.class);
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	public Timestamp gettimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	// Se existe Referencia para esta forma
	public List<Forma> existeFormaPre(String referencia) {
		try {
			TypedQuery<Forma> q = em.createQuery(
					"SELECT f " + "FROM Forma f " + "WHERE " + "f.referenciaforma LIKE :Referencia", Forma.class);
			q.setParameter("Referencia", "%" + referencia + "%");
			return q.getResultList();
		} catch (Exception ne) {
			return null;
		}
	}

	// Se existe Referencia com construcao a ser alterada
	public List<LivroReferencia> existeConstrucaoReferencia(Long construcao) {
		try {
			TypedQuery<LivroReferencia> q = em.createQuery("SELECT l " + "FROM LivroReferencia l,Forma f " + "WHERE "
					+ "l.construcao.construcaoid = :IdConstrucao", LivroReferencia.class);
			q.setParameter("IdConstrucao", construcao);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Se existe Referencia para esta forma
	public List<LivroReferencia> existeLivroReferencia(Integer lreferencia) {
		try {
			TypedQuery<LivroReferencia> q = em.createQuery(
					"SELECT l " + "FROM LivroReferencia l " + "WHERE " + "l.referencia = :Referencia",
					LivroReferencia.class);
			q.setParameter("Referencia", lreferencia);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Se existe Attn Consignatario
	public List<DestinoAmCf> existeDestinoAmCf(Long idGrupoClienteInvoice, String destino) {
		try {
			TypedQuery<DestinoAmCf> q = em.createQuery("SELECT d " + "FROM DestinoAmCf d "
					+ "WHERE d.destino = :Destino AND d.gruposclientesinvoices.grupoclienteinvoiceid = :Id ORDER BY d.destino,d.gruposclientesinvoices",
					DestinoAmCf.class);
			q.setParameter("Id", idGrupoClienteInvoice);
			q.setParameter("Destino", destino);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca todos Attn referente ao Grupo
	public List<DestinoAmCf> buscaDestinoAmCf(Long idGrupoClienteInvoice) {
		try {
			TypedQuery<DestinoAmCf> q = em.createQuery("SELECT d " + "FROM DestinoAmCf d "
					+ "WHERE d.gruposclientesinvoices.grupoclienteinvoiceid = :Id ORDER BY d.gruposclientesinvoices",
					DestinoAmCf.class);
			q.setParameter("Id", idGrupoClienteInvoice);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

//Se existe Referencia para duplicação
	public List<LivroReferencia> existeLivroReferenciaVersoes(Integer lreferencia, String abreviacao) {
		try {
			TypedQuery<LivroReferencia> q = em.createQuery("SELECT l " + "FROM LivroReferencia l "
					+ "WHERE l.abreviacao = :Abreviacao AND l.referencia = :Referencia ORDER BY l.abreviacao,l.referencia,l.versaorefer",
					LivroReferencia.class);
			q.setParameter("Referencia", lreferencia);
			q.setParameter("Abreviacao", abreviacao);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Obter ultimo registro de referenca criado,para verificacao da numeracao
	public LivroReferencia getBuscaUltimo(int n) {
		return em.createQuery("SELECT l from LivroReferencia l " + "ORDER BY referencia DESC", LivroReferencia.class)
				.setMaxResults(n).getSingleResult();
	}

	// Referencia/Abreviacao imagem
	public List<ImagemReferencia> existeReferenciaImagem(Integer lreferencia, String abreviacao) {
		try {
			TypedQuery<ImagemReferencia> q = em.createQuery("SELECT l " + "FROM ImagemReferencia l "
					+ "WHERE l.abreviacao = :Abreviacao AND l.referencia = :Referencia ORDER BY l.abreviacao,l.referencia,l.versaorefer",
					ImagemReferencia.class);
			q.setParameter("Referencia", lreferencia);
			q.setParameter("Abreviacao", abreviacao);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca imagem cfe Livro Referencia
	public List<ImagemReferencia> existeImagem(Long idLivroReferencia) {
		try {
			TypedQuery<ImagemReferencia> q = em.createQuery("SELECT l " + "FROM ImagemReferencia l "
					+ "WHERE l.livroreferencia.livroreferenciaid =:LivroReferencia", ImagemReferencia.class);
			q.setParameter("LivroReferencia", idLivroReferencia);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Referencia/Versao/Abreviacao imagem
	public List<ImagemReferencia> existeImagemCadastrada(ImagemReferencia imagem) {
		try {
			TypedQuery<ImagemReferencia> q = em.createQuery("SELECT l " + "FROM ImagemReferencia l "
					+ "WHERE l.abreviacao = :Abreviacao AND l.referencia = :Referencia AND l.versaorefer = :Versao  ORDER BY l.abreviacao,l.referencia,l.versaorefer",
					ImagemReferencia.class);
			q.setParameter("Abreviacao", imagem.getAbreviacao());
			q.setParameter("Referencia", imagem.getReferencia());
			q.setParameter("Versao", imagem.getVersaorefer());
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe o nome em algum modelo cadastrado
	public List<Modelo> existeModeloCliente(Modelo modelocliente) {
		try {
			TypedQuery<Modelo> q = em.createQuery("SELECT m " + "FROM Modelo m "
					+ "WHERE m.livroreferencia = :Referencia AND m.cliente = :Cliente AND m.estacao = :Estacao AND m.nome = :Nome",
					Modelo.class);
			q.setParameter("Referencia", modelocliente.getLivroreferencia());
			q.setParameter("Cliente", modelocliente.getCliente());
			q.setParameter("Estacao", modelocliente.getEstacao());
			q.setParameter("Nome", modelocliente.getNome());
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe o Modelo Cadastrado
	public List<Modelo> existeModelo(Modelo modelo) {
		try {
			TypedQuery<Modelo> q = em.createQuery("SELECT m " + "FROM Modelo m "
					+ "WHERE m.livroreferencia = :Referencia AND m.cliente = :Cliente AND m.estacao = :Estacao ",
					Modelo.class);
			q.setParameter("Referencia", modelo.getLivroreferencia());
			q.setParameter("Cliente", modelo.getCliente());
			q.setParameter("Estacao", modelo.getEstacao());
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe o nome Modelo Cadastrado
	public List<Modelo> existeNomeModelo(String modelo) {
		try {
			TypedQuery<Modelo> q = em.createQuery("SELECT m " + "FROM Modelo m " + "WHERE m.nome LIKE :NomeModelo",
					Modelo.class);
			q.setParameter("NomeModelo", "%" + modelo + "%");
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe Marca Modelo
	public List<MarcaCliente> existeMarcaCliente(String marcacliente) {
		try {
			TypedQuery<MarcaCliente> q = em.createQuery(
					"SELECT mc " + "FROM MarcaCliente mc " + "WHERE mc.nome LIKE :MarcaCliente", MarcaCliente.class);
			q.setParameter("MarcaCliente", "%" + marcacliente + "%");
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe Cor
	public List<Cor> existeCor(String cor) {
		try {
			TypedQuery<Cor> q = em.createQuery("SELECT c " + "FROM Cor c " + "WHERE c.nome LIKE :Cor", Cor.class);
			q.setParameter("Cor", "%" + cor.toUpperCase() + "%");
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Existe Material
	public List<Material> existeMaterial(String material) {
		try {
			TypedQuery<Material> q = em.createQuery("SELECT m " + "FROM Material m " + "WHERE m.nome LIKE :Material",
					Material.class);
			q.setParameter("Material", "%" + material.toUpperCase() + "%");
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca proxima sequencia para amostra - chave primaria
	public int getNextSequence() {
		try {
			Query q = em.createNativeQuery("SELECT nextval('serial') as num");
			BigInteger result = (BigInteger) q.getSingleResult();
			return result.intValue();
		} catch (Exception ne) {
			ne.printStackTrace();
			return 0;

		}
	}

	// Verifica a existencia de construcao em mais Fichas de amostras
	public Integer getExisteFichaAmostra(Construcao construcao) {
		try {
			TypedQuery<Long> q = em.createQuery(
					"SELECT Count(*) " + "FROM Amostra am " + "WHERE am.construcao.construcaoid=:Construcao",
					Long.class);
			q.setParameter("Construcao", construcao.getConstrucaoid());
			Long result = q.getSingleResult();
			return result.intValue();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	// Verifica a existencia de construcao em mais Fichas de amostras
	public List<Amostra> getExisteListaFichaAmostra(Long construcaoid) {
		try {
			TypedQuery<Amostra> q = em.createQuery(
					"FROM Amostra amostra " + "WHERE amostra.construcao.construcaoid=:Construcao", Amostra.class);
			q.setParameter("Construcao", construcaoid);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Verifica a existencia de Fichas nao liberadas
	public List<FichaProducao> getExisteFichaALProducao() {
		try {
			TypedQuery<FichaProducao> q = em.createQuery("FROM FichaProducao fa " + 
					"WHERE fa.liberadoalteraramostra =: transito"+
					" OR "+ "fa.liberadoalteraramostra =: bloqueio"+
					" OR "+ "fa.liberadoalteraramostra =: liberada",
					FichaProducao.class);
			q.setParameter("transito", EmTransicao.T);
			q.setParameter("liberada", EmTransicao.L);
			q.setParameter("bloqueio", EmTransicao.W);
			
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Verifica a existencia de Fichas nao liberadas
	public List<FichaProducao> getExisteFichaNLProducao(Long amostraid) {
		try {
			TypedQuery<FichaProducao> q = em.createQuery("FROM FichaProducao fa " + "WHERE fa.amostra.amostraId=:amostraId",
					FichaProducao.class);
			q.setParameter("amostraId", amostraid);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	// Verifica a existencia de Fichas nao liberadas
	public List<Amostra> getExisteFichaNLAmostra() {
		try {
			TypedQuery<Amostra> q = em.createQuery("FROM Amostra am " + "WHERE am.gerada = false" + " and "
		                                                              + "am.temcor = true " + " and "
		                                                              +	"am.prioridadeProducao = :prioridade "
		                                                              + "Order BY " + "am.amostraId Desc ",Amostra.class);
			q.setParameter("prioridade",PrioridadeProducao.X);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca todas as cores da amostra
	public List<CorAmostra> getBuscaCoresAmostra(Long amostraNova) {
		try {
			TypedQuery<CorAmostra> q = em.createQuery("SELECT cm " + "FROM CorAmostra cm "
					+ "WHERE cm.amostraId = :amostraId Order BY cm.amostra,cm.Id ASC", CorAmostra.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca todas os complementos de Cabedais Amostra
	public List<CorCabedalAm> getBuscaTodosCabedaisAmostra(Long amostraNova) {
		try {
			TypedQuery<CorCabedalAm> q = em.createQuery(
					"SELECT cb " + "FROM CorCabedalAm cb "
							+ "WHERE cb.amostra.amostraId = :amostraId Order BY cb.amostra,cb.coramostra",
					CorCabedalAm.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// Busca todas as cores da amostra
	public CorAmostra getBuscaCorAmostra(Long corAmostra) {
		try {
			TypedQuery<CorAmostra> q = em.createQuery(
					"SELECT cm " + "FROM CorAmostra cm " + "WHERE cm.Id = : corAmostraId ", CorAmostra.class);
			q.setParameter("corAmostraId", corAmostra);
			return q.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public CorAmostra getBuscaCorAmostra(Long amostraNova, Integer sequencial) {
		try {
			TypedQuery<CorAmostra> q = em.createQuery(
					"SELECT cm " + "FROM CorAmostra cm "
							+ "WHERE cm.amostraId=:amostraId and cm.sequenciaCorAmostra=:sequencialCor",
					CorAmostra.class);
			q.setParameter("amostraId", amostraNova);
			q.setParameter("sequencialCor", sequencial);
			return q.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public CorCabedalAm getBuscaCorAmostraCabedal(Long amostraNova, Long amostraCor) {
		try {
			TypedQuery<CorCabedalAm> q = em.createQuery(
					"SELECT cc " + "FROM CorCabedalAm cc "
							+ "WHERE cc.amostra.amostraId=:amostraId and cc.coramostra.Id=:corcabId",
					CorCabedalAm.class);
			q.setParameter("amostraId", amostraNova);
			q.setParameter("corcabId", amostraCor);
			return q.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	public List<CorCabedalAm> getBuscaAmostraCabedais(Long amostraNova, Long amostraCor) {
		try {
			TypedQuery<CorCabedalAm> q = em.createQuery(
					"SELECT cc " + "FROM CorCabedalAm cc "
							+ "WHERE cc.amostra.amostraId=:amostraId and cc.coramostra.Id=:corcabId",
					CorCabedalAm.class);
			q.setParameter("amostraId", amostraNova);
			q.setParameter("corcabId", amostraCor);
			return q.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
	}

	// busca item pespecifico Cores Multi
	public List<CorAmostraMulti> getBuscaCorAmostraMulti(Long amostraNova, Integer amostraSeqCor) {
		try {
			TypedQuery<CorAmostraMulti> q = em.createQuery(
					"SELECT cm " + "FROM CorAmostraMulti cm "
							+ "WHERE cm.amostra.amostraId=:amostraId and cm.seqCorAmostra=:coramostraseq",
					CorAmostraMulti.class);
			q.setParameter("amostraId", amostraNova);
			q.setParameter("coramostraseq", amostraSeqCor);
			return q.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
	}

	// busca todos Cores Multi da Amostra
	public List<CorAmostraMulti> getBuscaTodosCorAmostraMulti(Long amostraNova) {
		try {
			TypedQuery<CorAmostraMulti> q = em.createQuery(
					"SELECT cm " + "FROM CorAmostraMulti cm "
							+ "WHERE cm.amostra.amostraId=:amostraId ORDER BY cm.amostra,cm.corAmostra",
					CorAmostraMulti.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
	}

	// Corte
	public CorteAmostra getBuscaCorteAmostra(Long amostraNova) {
		try {
			TypedQuery<CorteAmostra> q = em.createQuery(
					"SELECT ca " + "FROM CorteAmostra ca " + "WHERE ca.amostra.amostraId=:amostraId",
					CorteAmostra.class);
			q.setParameter("amostraId", amostraNova);
			return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	//Busca Cores Corte por Numero Amostra
	public List<CorCorteAm> getBuscaCorCorteAmostra(Long amostraNova){
		try {
			TypedQuery<CorCorteAm> q = em.createQuery("SELECT ca " + 
					   "FROM CorCorteAm ca " +
					   "WHERE ca.amostra.amostraId=:amostraId",CorCorteAm.class);
						q.setParameter("amostraId",amostraNova);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	// Costura
	public CosturaAmostra getBuscaCosturaAmostra(Long amostraNova) {
		try {
			TypedQuery<CosturaAmostra> q = em.createQuery(
					"SELECT ca " + "FROM CosturaAmostra ca " + "WHERE ca.amostra.amostraId=:amostraId",
					CosturaAmostra.class);
			q.setParameter("amostraId", amostraNova);
			return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	public List<CorCosturaAm> getBuscaCorCosturaAmostra(Long amostraNova) {
		try {
			TypedQuery<CorCosturaAm> q = em.createQuery(
					"SELECT co "
					+ "FROM CorCosturaAm co " 
					+ "WHERE co.amostra.amostraId =:amostraId",
					CorCosturaAm.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	//Cor Unica
	public List<CorCosturaAm> getBuscaUmaCorCosturaAmostra(Long corCosturaAmostra){
		try {
			TypedQuery<CorCosturaAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorCosturaAm cca " +
					   "WHERE cca.coramostra.Id=:id",CorCosturaAm.class);
						q.setParameter("id",corCosturaAmostra);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	
	// Solado
	public Construcao getBuscaConstrucaoAmostra(Long idconstrucao) {
		try {
			TypedQuery<Construcao> q = em.createQuery(
					"SELECT co " + "FROM Construcao co " + "WHERE co.construcaoid=:construcaoId",
					Construcao.class);
			q.setParameter("construcaoId", idconstrucao);
			return q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// Busca Cor Unica Solado IdAmostra/Idcor
	public List<CorConstrucaoAm> getBuscaCorSoladoAmostra(Long amostraNova) {
		try {
			TypedQuery<CorConstrucaoAm> q = em.createQuery(
					"SELECT ca " + 
					"FROM CorConstrucaoAm ca " + 
					"WHERE ca.amostra.amostraId=:amostraId",
					CorConstrucaoAm.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	// Acabamento
	public AcabamentoAmostra getBuscaAcabamentoAmostra(Long amostraNova) {
		try {
			TypedQuery<AcabamentoAmostra> q = em.createQuery(
					"SELECT aa " + "FROM AcabamentoAmostra aa " + "WHERE aa.amostra.amostraId=:amostraId",
					AcabamentoAmostra.class);
			q.setParameter("amostraId", amostraNova);
			return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	public List<CorAcabamentoAm> getBuscaCorAcabamentoAmostra(Long amostraNova) {
		try {
			TypedQuery<CorAcabamentoAm> q = em.createQuery(
					"SELECT ca " + "FROM CorAcabamentoAm ca " + "WHERE ca.amostra.amostraId =: amostraId",
					CorAcabamentoAm.class);
			q.setParameter("amostraId", amostraNova);
			return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	// Busca formato de Lista apenas uma cor, para usar mesmos dialogs
	public List<CorCorteAm> getBuscaUmaCorCorteAmostra(Long corCorteAmostra){
		try {
			TypedQuery<CorCorteAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorCorteAm cca " +
					   "WHERE cca.coramostra.Id=:corAmostraId",CorCorteAm.class);
						q.setParameter("corAmostraId",corCorteAmostra);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public List<CorConstrucaoAm> getBuscaUmaCorSoladoAmostra(Long corConstrucaoAmostra){
		try {
			TypedQuery<CorConstrucaoAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorConstrucaoAm cca " +
					   "WHERE cca.coramostra.Id=:corAmostraId",CorConstrucaoAm.class);
						q.setParameter("corAmostraId",corConstrucaoAmostra);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public List<CorAcabamentoAm> getBuscaUmaCorAcabamentoAmostra(Long corAcabamentoAmostra){
		try {
			TypedQuery<CorAcabamentoAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorAcabamentoAm cca " +
					   "WHERE cca.coramostra.Id=:corAmostraId",CorAcabamentoAm.class);
						q.setParameter("corAmostraId",corAcabamentoAmostra);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	
	//Busca unica com resultado simples
	public CorCorteAm getBuscaPosicaoCorCorteAmostra(Long corCorteAmostra){
		try {
			TypedQuery<CorCorteAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorCorteAm cca " +
					   "WHERE cca.id=:Id ",CorCorteAm.class);
						q.setParameter("Id",corCorteAmostra);
						return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public CorCosturaAm getBuscaCorPosicaoCosturaAmostra(Long corCosturaAmostra){
		try {
			TypedQuery<CorCosturaAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorCosturaAm cca " +
					   "WHERE cca.id=:Id ",CorCosturaAm.class);
						q.setParameter("Id",corCosturaAmostra);
						return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public CorConstrucaoAm getBuscaPosicaoCorConstrucaoAmostra(Long corConstrucaoAmostra){
		try {
			TypedQuery<CorConstrucaoAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorConstrucaoAm cca " +
					   "WHERE cca.id=:Id ",CorConstrucaoAm.class);
						q.setParameter("Id",corConstrucaoAmostra);
						return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public CorAcabamentoAm getBuscaPosicaoCorAcabamentoAmostra(Long corAcabamentoAmostra){
		try {
			TypedQuery<CorAcabamentoAm> q = em.createQuery("SELECT cca " + 
					   "FROM CorAcabamentoAm cca " +
					   "WHERE cca.id=:Id ",CorAcabamentoAm.class);
						q.setParameter("Id",corAcabamentoAmostra);
						return q.getSingleResult();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	//Verificacao da existencia cor de amostra na producao
	public FichaProducao buscaCoramostraProducao(Long corAmostraProducao) {
		try {
			TypedQuery<FichaProducao> q = em.createQuery("SELECT fcp " + 
						"FROM FichaProducao fcp " +
						"WHERE fcp.coramostra.Id=:Id",FichaProducao.class);
						q.setParameter("Id",corAmostraProducao);
						return q.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	//Logs Amostras Novas
	public List<LogAmostrasNovas> getBuscaLogsAmostraNova(Long amostraid){
		try {
			TypedQuery<LogAmostrasNovas> q = em.createQuery("SELECT lan " + 
					   "FROM  LogAmostrasNovas lan " +
					   "WHERE lan.amostra.amostraId=:Id ",LogAmostrasNovas.class);
						q.setParameter("Id",amostraid);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	//Logs Amostras Fichas Producao-alterações pós-liberações
	public List<LogAmostraFichaProducao> getBuscaLogsFihaProducao(Long amostraid){
		try {
			TypedQuery<LogAmostraFichaProducao> q = em.createQuery("SELECT lfp " + 
					   "FROM  LogAmostraFichaProducao lfp " +
					   "WHERE lfp.amostra.amostraId=:Id ",LogAmostraFichaProducao.class);
						q.setParameter("Id",amostraid);
						return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}

	
	// Etiquetas pegar apenas Jack Rogers
	public List<Etiquetas> findJackRogers(String customer) {
		try {
			TypedQuery<Etiquetas> q = em.createQuery("SELECT et " + "FROM Etiquetas et "
					+ "WHERE et.clientenome LIKE :cliente and et.fase is not null " + "ORDER BY et.inclusao DESC",
					Etiquetas.class);
			q.setParameter("cliente", customer);
			return q.getResultList();

		} catch (RuntimeException ex) {
			return null;
		}
	}

}
