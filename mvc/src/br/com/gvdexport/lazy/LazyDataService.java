package br.com.gvdexport.lazy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.gvdexport.model.Amostra;
import br.com.gvdexport.model.Construcao;
import br.com.gvdexport.model.Cor;
import br.com.gvdexport.model.FichaProducao;
import br.com.gvdexport.model.ImagemReferencia;
import br.com.gvdexport.model.LivroReferencia;
import br.com.gvdexport.model.Material;
import lombok.Getter;
import lombok.Setter;

@Named("services")
@SessionScoped
public class LazyDataService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private List<Amostra> amostras;

	@Getter @Setter
	private List<FichaProducao> amostrasProducao;

	@Getter @Setter
	private List<ImagemReferencia> livroImagem;
	
	@Setter
	private List<LivroReferencia> livroReferencia;

	@Getter @Setter
	private List<Construcao> construcao;

	@Setter
	private List<Cor> cor;

	@Setter
	private List<Material> material;
	@Inject
	private EntityManager em;
	//    private EntityManager getEntityManager() {
//		return CDI.current().select(EntityManager.class).get();
//	}
    
    public List<Amostra> getAmostra() {
   	  amostras = new ArrayList<Amostra>();
   	  CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Amostra> q = cb.createQuery(Amostra.class);
      Root<Amostra> root = q.from(Amostra.class);
      CriteriaQuery<Amostra> select = q.select(root);
      TypedQuery<Amostra> query = em.createQuery(select);
      amostras = query.getResultList();
      return amostras;
    }
	public int getAmostraTotalCount() {
		try {
			TypedQuery<Long> query = em.createQuery("Select count(*) From Amostra", Long.class);
			return query.getSingleResult().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;

		}
	}

	public int getFilteredRowCountAmostra(Map<String, Object> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
		Root<Amostra> root = criteriaQuery.from(Amostra.class);
		CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

		if (filters != null && filters.size() > 0) {
			List<Predicate> predicates = new ArrayList<>();
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				if (value == null) {
					continue;
				}
				Expression<String> expr = root.get(field).as(String.class);
				Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
				predicates.add(p);
			}
			if (predicates.size() > 0) {
				criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
			}
		}
		Long count = em.createQuery(select).getSingleResult();
		return count.intValue();
	}
	
	/*
	 * Final Lazy Amostra
	 */
	
	/*
	 * Inicial Lazy FichaProducao
	 */

	public List<FichaProducao> getAmostraProducao() {
	   	    amostrasProducao = new ArrayList<FichaProducao>();
	    	CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<FichaProducao> q = cb.createQuery(FichaProducao.class);
	        Root<FichaProducao> root = q.from(FichaProducao.class);
	        CriteriaQuery<FichaProducao> select = q.select(root);
	        TypedQuery<FichaProducao> query = em.createQuery(select);
	        amostrasProducao = query.getResultList();
	        return amostrasProducao;
	    }
		public int getAmostraProducaoTotalCount() {
			try {
				TypedQuery<Long> query = em.createQuery("Select count(*) From AmostraProducao", Long.class);
				return query.getSingleResult().intValue();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;

			}
		}

		public int getFilteredRowCountAmostraProducao(Map<String, Object> filters) {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
			Root<FichaProducao> root = criteriaQuery.from(FichaProducao.class);
			CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

			if (filters != null && filters.size() > 0) {
				List<Predicate> predicates = new ArrayList<>();
				for (Map.Entry<String, Object> entry : filters.entrySet()) {
					String field = entry.getKey();
					Object value = entry.getValue();
					if (value == null) {
						continue;
					}
					Expression<String> expr = root.get(field).as(String.class);
					Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
					predicates.add(p);
				}
				if (predicates.size() > 0) {
					criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
				}
			}
			Long count = em.createQuery(select).getSingleResult();
			return count.intValue();
		}	

		/*
		 * Fim Lazy Amostra Producao
		*/

		/*
		 * Inicio Lazy Imagem Referencia
		*/

		   public List<ImagemReferencia> getImagemreferencia() {
		   	    livroImagem = new ArrayList<ImagemReferencia>();
		    	CriteriaBuilder cb = em.getCriteriaBuilder();
		        CriteriaQuery<ImagemReferencia> q = cb.createQuery(ImagemReferencia.class);
		        Root<ImagemReferencia> root = q.from(ImagemReferencia.class);
		        CriteriaQuery<ImagemReferencia> select = q.select(root);
		        TypedQuery<ImagemReferencia> query = em.createQuery(select);
		        livroImagem = query.getResultList();
		        return livroImagem;
		    }
			public int getImagemReferenciaTotalCount() {
				try {
					TypedQuery<Long> query = em.createQuery("Select count(*) From ImagemReferencia", Long.class);
					return query.getSingleResult().intValue();
				} catch (Exception e) {
					e.printStackTrace();
					return 0;

				}
			}

			public int getFilteredRowCountImagemReferencia(Map<String, Object> filters) {
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
				Root<ImagemReferencia> root = criteriaQuery.from(ImagemReferencia.class);
				CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

				if (filters != null && filters.size() > 0) {
					List<Predicate> predicates = new ArrayList<>();
					for (Map.Entry<String, Object> entry : filters.entrySet()) {
						String field = entry.getKey();
						Object value = entry.getValue();
						if (value == null) {
							continue;
						}
						Expression<String> expr = root.get(field).as(String.class);
						Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
						predicates.add(p);
					}
					if (predicates.size() > 0) {
						criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
					}
				}
				Long count = em.createQuery(select).getSingleResult();
				return count.intValue();
			}	


			/*
			 * Fim Lazy Imagem de Referencias
			 *
		    */

			/*
			 * Inicio Lazy Referencias
			 *
		    */
			
			   public List<LivroReferencia> getlivroReferencia() {
			   	    livroReferencia = new ArrayList<LivroReferencia>();
			    	CriteriaBuilder cb = em.getCriteriaBuilder();
			        CriteriaQuery<LivroReferencia> q = cb.createQuery(LivroReferencia.class);
			        Root<LivroReferencia> root = q.from(LivroReferencia.class);
			        CriteriaQuery<LivroReferencia> select = q.select(root);
			        TypedQuery<LivroReferencia> query = em.createQuery(select);
			        livroReferencia = query.getResultList();
			        return livroReferencia;
			    }
				public int getLivroReferenciaTotalCount() {
					try {
						TypedQuery<Long> query = em.createQuery("Select count(*) From LivroReferencia", Long.class);
						return query.getSingleResult().intValue();
					} catch (Exception e) {
						e.printStackTrace();
						return 0;

					}
				}

				public int getFilteredRowCountLivroReferencia(Map<String, Object> filters) {
					CriteriaBuilder cb = em.getCriteriaBuilder();
					CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
					Root<LivroReferencia> root = criteriaQuery.from(LivroReferencia.class);
					CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

					if (filters != null && filters.size() > 0) {
						List<Predicate> predicates = new ArrayList<>();
						for (Map.Entry<String, Object> entry : filters.entrySet()) {
							String field = entry.getKey();
							Object value = entry.getValue();
							if (value == null) {
								continue;
							}
							Expression<String> expr = root.get(field).as(String.class);
							Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
							predicates.add(p);
						}
						if (predicates.size() > 0) {
							criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
						}
					}
					Long count = em.createQuery(select).getSingleResult();
					return count.intValue();
				}	

				/*
				 * Fim Lazy Referencias
				 *
			    */

				   public List<Cor> getCor() {
				   	    cor = new ArrayList<Cor>();
				    	CriteriaBuilder cb = em.getCriteriaBuilder();
				        CriteriaQuery<Cor> q = cb.createQuery(Cor.class);
				        Root<Cor> root = q.from(Cor.class);
				        CriteriaQuery<Cor> select = q.select(root);
				        TypedQuery<Cor> query = em.createQuery(select);
				        cor = query.getResultList();
				        return cor;
				    }
					public int getCorTotalCount() {
						try {
							TypedQuery<Long> query = em.createQuery("Select count(*) From Cor", Long.class);
							return query.getSingleResult().intValue();
						} catch (Exception e) {
							e.printStackTrace();
							return 0;

						}
					}

					public int getFilteredRowCountCor(Map<String, Object> filters) {
						CriteriaBuilder cb = em.getCriteriaBuilder();
						CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
						Root<Cor> root = criteriaQuery.from(Cor.class);
						CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

						if (filters != null && filters.size() > 0) {
							List<Predicate> predicates = new ArrayList<>();
							for (Map.Entry<String, Object> entry : filters.entrySet()) {
								String field = entry.getKey();
								Object value = entry.getValue();
								if (value == null) {
									continue;
								}
								Expression<String> expr = root.get(field).as(String.class);
								Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
								predicates.add(p);
							}
							if (predicates.size() > 0) {
								criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
							}
						}
						Long count = em.createQuery(select).getSingleResult();
						return count.intValue();
					}
					
					//
					// Fim Lazy Cor
					//
					   public List<Material> getMaterial() {
					   	    material = new ArrayList<Material>();
					    	CriteriaBuilder cb = em.getCriteriaBuilder();
					        CriteriaQuery<Material> q = cb.createQuery(Material.class);
					        Root<Material> root = q.from(Material.class);
					        CriteriaQuery<Material> select = q.select(root);
					        TypedQuery<Material> query = em.createQuery(select);
					        material = query.getResultList();
					        return material;
					    }
						public int getMaterialTotalCount() {
							try {
								TypedQuery<Long> query = em.createQuery("Select count(*) From Material", Long.class);
								return query.getSingleResult().intValue();
							} catch (Exception e) {
								e.printStackTrace();
								return 0;

							}
						}

						public int getFilteredRowCountMaterial(Map<String, Object> filters) {
							CriteriaBuilder cb = em.getCriteriaBuilder();
							CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
							Root<Material> root = criteriaQuery.from(Material.class);
							CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

							if (filters != null && filters.size() > 0) {
								List<Predicate> predicates = new ArrayList<>();
								for (Map.Entry<String, Object> entry : filters.entrySet()) {
									String field = entry.getKey();
									Object value = entry.getValue();
									if (value == null) {
										continue;
									}
									Expression<String> expr = root.get(field).as(String.class);
									Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
									predicates.add(p);
								}
								if (predicates.size() > 0) {
									criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
								}
							}
							Long count = em.createQuery(select).getSingleResult();
							return count.intValue();
						}
						//
						// Fim  Lazy Material
						//
						// Inicio Lazy Construcao
						//
						   public List<Construcao> getConstrucao() {
						   	    construcao = new ArrayList<Construcao>();
						    	CriteriaBuilder cb = em.getCriteriaBuilder();
						        CriteriaQuery<Construcao> q = cb.createQuery(Construcao.class);
						        Root<Construcao> root = q.from(Construcao.class);
						        CriteriaQuery<Construcao> select = q.select(root);
						        TypedQuery<Construcao> query = em.createQuery(select);
						        construcao = query.getResultList();
						        return construcao;
						    }
							public int getConstrucaoTotalCount() {
								try {
									TypedQuery<Long> query = em.createQuery("Select count(*) From Construcao", Long.class);
									return query.getSingleResult().intValue();
								} catch (Exception e) {
									e.printStackTrace();
									return 0;

								}
							}

							public int getFilteredRowConstrucao(Map<String, Object> filters) {
								CriteriaBuilder cb = em.getCriteriaBuilder();
								CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
								Root<Construcao> root = criteriaQuery.from(Construcao.class);
								CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));

								if (filters != null && filters.size() > 0) {
									List<Predicate> predicates = new ArrayList<>();
									for (Map.Entry<String, Object> entry : filters.entrySet()) {
										String field = entry.getKey();
										Object value = entry.getValue();
										if (value == null) {
											continue;
										}
										Expression<String> expr = root.get(field).as(String.class);
										Predicate p = cb.like(cb.lower(expr), "%" + value.toString().toLowerCase() + "%");
										predicates.add(p);
									}
									if (predicates.size() > 0) {
										criteriaQuery.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
									}
								}
								Long count = em.createQuery(select).getSingleResult();
								return count.intValue();
							}	
						//Fim Lazy Construcao	
}
