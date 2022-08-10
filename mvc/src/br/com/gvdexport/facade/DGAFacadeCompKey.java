package br.com.gvdexport.facade;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.gvdexport.model.Cotacao;
import br.com.gvdexport.model.DGAMenu;
import br.com.gvdexport.model.DGAModulo;
import br.com.gvdexport.model.DGAPrivilegio;
import br.com.gvdexport.model.DGASistema;
import br.com.gvdexport.model.DGAUsuarioNivel;
import br.com.gvdexport.model.EnderecoCliente;
import br.com.gvdexport.model.Usuario;

@Named
@ViewScoped
public class DGAFacadeCompKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	//Retorna Menu ja estiver cadastrado
	public DGAMenu existedgaMenu(Integer dgaordemMenu, String dgamenuNome,Long dgaIdSistema) {
		try {
			TypedQuery<DGAMenu> q = em.createQuery("SELECT m " + 
					   "FROM DGAMenu m " +
					   "WHERE m.nome = :nomeMenu and m.ordem = :ordemMenu and m.dgasistema.dgasistemaid = :idSistema",DGAMenu.class);
						q.setParameter("nomeMenu",dgamenuNome);
						q.setParameter("ordemMenu",dgaordemMenu);
						q.setParameter("idSistema", dgaIdSistema);
						return q.getSingleResult();
			
		} catch (NoResultException ne) {
			return null;
		}
	}
	//Retorna Sistema ja estiver cadastrado
	public DGASistema existedgaSistema(String dgasistemaNome) {
		try {
			TypedQuery<DGASistema> q = em.createQuery("SELECT s " + 
					   "FROM DGASistema s " +
					   "WHERE s.nome = :nomeSistema",DGASistema.class);
						q.setParameter("nomeSistema",dgasistemaNome);
						return q.getSingleResult();
			
		} catch (NoResultException ne) {
			return null;
		}
	}
	//Retorna Privilegio ja estiver cadastrado
	public DGAPrivilegio findPrivilegio(Long usuario, Long modulo) {
		try {
			TypedQuery<DGAPrivilegio> q = em.createQuery("SELECT p " + 
					   "FROM DGAPrivilegio p " +
					   "WHERE p.dgausuarioid = :idUsuario and p.dgamoduloid = :idModulo",DGAPrivilegio.class);
						q.setParameter("idUsuario",usuario);
						q.setParameter("idModulo", modulo);
						return q.getSingleResult();
			
		} catch (NoResultException ne) {
			return null;
		}
	}

	public DGAModulo existeDGAModulo(Integer dgaOrdemModulo, String DGAModuloNome,Long dgaIdMenu) {
		try {
			TypedQuery<DGAModulo> q = em.createQuery("SELECT m " + 
					   "FROM DGAModulo m " +
					   "WHERE m.nome = :nomeModulo and m.ordem = :ordemModulo and m.dgamenu.dgamenuid = :idMenu",DGAModulo.class);
						q.setParameter("nomeModulo",DGAModuloNome);
						q.setParameter("ordemModulo",dgaOrdemModulo);
						q.setParameter("idMenu", dgaIdMenu);
						return q.getSingleResult();
			
		} catch (RuntimeException re) {
		}
		return null;

	}

	//Retorna um usuario caso exista
	public Usuario existeUsuario(String nomeUsuario,String senhaUsuario) {
		try {
			TypedQuery<Usuario> q = em.createQuery("SELECT u " + 
					   "FROM Usuario u " +
					   "WHERE u.usuario = :nomeUser and u.senha = :senhaUser",Usuario.class);
						q.setParameter("nomeUser", nomeUsuario);
						q.setParameter("senhaUser", senhaUsuario);
						return q.getSingleResult();
			
		} catch (NoResultException ne) {
			return null;
		}
	}
	public Boolean checaAutenticidade(String nameUser,String password){
		Boolean mResult=true;
		try{
			Usuario aux = existeUsuario(nameUser, password);
			if (aux == null){
				mResult = false;
			}
			return mResult;
		}catch (RuntimeException ex){
			throw ex;
		} finally {
			em.close();
		}
	}
	//Buscar todos 
	public List<Usuario> getUsuarios(){
		try {
			TypedQuery<Usuario> q = em.createQuery("SELECT u " + 
												   "FROM Usuario u " +
												   "ORDER BY u.nome",Usuario.class);
			return q.getResultList();}
		catch (RuntimeException ex) {
			return null;
		}
	}
	public List<DGASistema> getSistemas() {
		try {
		
			TypedQuery<DGASistema> q = em.createQuery("SELECT s " + 
												"FROM DGASistema s " + 
												"ORDER BY dgasistema_pk", DGASistema.class);
		return q.getResultList();}
		catch (Exception e) {
			return null;
		}
	}
	public List<DGAModulo> getModulos() {
		try {
		TypedQuery<DGAModulo> q = em.createQuery("SELECT m " + 
											"FROM DGAModulo m " + 
											"ORDER BY m.dgamenu.dgasistema.dgasistemaid,m.dgamenu.ordem,dgamodulo_pk", DGAModulo.class);
			return q.getResultList();
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public List<DGAMenu> getMenus() {
		try {
		TypedQuery<DGAMenu> q = em.createQuery("SELECT m " + 
											"FROM DGAMenu m " + 
											"ORDER BY dgamen_dgasis_fk,m.ordem,m.nome", DGAMenu.class);
		return q.getResultList();}
		catch (RuntimeException ex) {
			return null;
		}
	}
	public Timestamp gettimeStamp(){
		return new Timestamp(System.currentTimeMillis());
	}

	public List<DGAPrivilegio> getPrivilegios(){
		try {
		TypedQuery<DGAPrivilegio> q = em.createQuery("SELECT p " + 
											   "FROM DGAPrivilegio p ",DGAPrivilegio.class);
		return q.getResultList();
		}catch (RuntimeException ex) {
			return null;
		}
	}
	//Retorna um usuario com as permissoes
	public List<DGAPrivilegio> getUsuarioPermissoes(Long idUsuario) {
		try {
			TypedQuery<DGAPrivilegio> q = em.createQuery("SELECT p " + 
					   "FROM DGAPrivilegio p " +
					   "WHERE p.dgausuarioid = :idUser ORDER BY p.dgasistema.dgasistemaid,p.dgamenu.dgamenuid,p.dgamodulo.dgamoduloid",DGAPrivilegio.class);
						q.setParameter("idUser", idUsuario);
						return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}
	public List<DGAUsuarioNivel> getUsuarioPermissoesNivel(Long idUsuario) {
		try {
			TypedQuery<DGAUsuarioNivel> q = em.createQuery("SELECT u " + 
					   "FROM DGAUsuarioNivel u " +
					   "WHERE u.usuario.usuarioid = :idUser ORDER BY u.nivelbarra,u.nivelsubmenu,u.nivelsubitem",DGAUsuarioNivel.class);
						q.setParameter("idUser", idUsuario);
						return q.getResultList();
		} catch (NoResultException ne) {
			return null;
		}
	}
	
	public DGAUsuarioNivel buscaChaveCompostaUnica(Long idusuario,Long idmodulo) {
		try {
			TypedQuery<DGAUsuarioNivel> q = em.createQuery("SELECT u " + 
					   "FROM DGAUsuarioNivel u " +
					   "WHERE u.dgausuarioid =: sId and u.dgamoduloid =: pId",DGAUsuarioNivel.class);
						q.setParameter("sId", idusuario);
						q.setParameter("pId", idmodulo);
						return q.getSingleResult();
			
		} catch (RuntimeException ex) {
			return null;
		}
	}
	public DGAUsuarioNivel buscarChaveCompPrivilegioUnica(Long idusuario,Long idmodulo) {
		DGAUsuarioNivel aux = new DGAUsuarioNivel();
		try {
			 Query q = em.createQuery("SELECT u " + 
					   "FROM DGAUsuarioNivel u " +
					   "WHERE u.dgausuarioid =: sId and u.dgamoduloid =: pId",DGAUsuarioNivel.class);
						q.setParameter("sId", idusuario);
						q.setParameter("pId", idmodulo);
						aux = (DGAUsuarioNivel) q.getSingleResult();	
						return aux;
		} catch (RuntimeException ex) {
			return aux;
		}
	}
	
	public List<Cotacao> getBuscaTaxa(String moeda,Integer ano,String mes,java.sql.Date Inicial,java.sql.Date Fim) {
		String hql ;
		hql="SELECT c FROM Cotacao c WHERE 1=1 ";
		try {
			if(moeda != null) {
				hql += "and trim(c.moedas.sigla) like :Moeda ";
			}
			if(ano != null) {
				hql += "and c.ano = :Ano ";
			}
			if(mes != null) {
				hql += "and trim(c.mes) like :Mes ";
			}
//			hql += "ORDER BY c.moedas,c.ano,c.mesnumeral desc";
			if(Inicial != null) {
				hql="Select c FROM Cotacao c WHERE c.datacotacao >= :Inicio and c.datacotacao <= :Fim and trim(c.moedas.sigla) = :Moeda";
				TypedQuery<Cotacao> q = em.createQuery(hql,Cotacao.class);
				q.setParameter("Inicio", Inicial,TemporalType.DATE);
				q.setParameter("Fim", Fim, TemporalType.DATE);
				q.setParameter("Moeda", moeda);
				return q.getResultList();
				
			}else {
				TypedQuery<Cotacao> q = em.createQuery(hql,Cotacao.class);
				q.setParameter("Moeda", moeda);
				q.setParameter("Ano",ano );
				q.setParameter("Mes", mes);
				return q.getResultList();
			}
		} catch (NoResultException ne) {
			return null;
		}
	}
	
	public EnderecoCliente buscarChaveCompEndCliUni(Long idgrpinv,Integer idsedquencia) {
		EnderecoCliente aux = new EnderecoCliente();
		try {
			 Query q = em.createQuery("SELECT e " + 
					   "FROM EnderecoCliente e " +
					   "WHERE e.grpcliinvid =: kId and e.sequenciaendereco =: sId",EnderecoCliente.class);
						q.setParameter("kId", idgrpinv);
						q.setParameter("sId", idsedquencia);
						aux = (EnderecoCliente) q.getSingleResult();	
						return aux;
		} catch (RuntimeException ex) {
			return aux;
		}
	}



}
