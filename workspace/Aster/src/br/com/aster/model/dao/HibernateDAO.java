/*     */ package br.com.aster.model.dao;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.hibernate.Criteria;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.criterion.DetachedCriteria;
/*     */ import org.hibernate.criterion.MatchMode;
/*     */ import org.hibernate.criterion.Order;
/*     */ import org.hibernate.criterion.Restrictions;
/*     */ 
/*     */ public class HibernateDAO<T>
/*     */   implements InterfaceDAO<T>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Class<T> classe;
/*     */   private Session session;
/*     */ 
/*     */   public HibernateDAO(Class<T> classe, Session session)
/*     */   {
/*  29 */     this.classe = classe;
/*  30 */     this.session = session;
/*     */   }
/*     */ 
/*     */   public void save(T entity)
/*     */   {
/*  35 */     this.session.save(entity);
/*     */   }
/*     */ 
/*     */   public void update(T entity)
/*     */   {
/*  40 */     this.session.update(entity);
/*     */   }
/*     */ 
/*     */   public void remove(T entity)
/*     */   {
/*  45 */     this.session.delete(entity);
/*     */   }
/*     */ 
/*     */   public void merge(T entity)
/*     */   {
/*  50 */     this.session.merge(entity);
/*     */   }
/*     */ 
/*     */   public T getEntity(Serializable id)
/*     */   {
/*  55 */     Object entity = this.session.get(this.classe, id);
/*  56 */     return (T) entity;
/*     */   }
/*     */ 
/*     */   public T getEntityByDetachedCriteria(DetachedCriteria criteria)
/*     */   {
/*  61 */     Object entity = criteria.getExecutableCriteria(this.session).uniqueResult();
/*  62 */     return (T) entity;
/*     */   }
/*     */ 
/*     */   public List<T> getEntities()
/*     */   {
/*  67 */     List entities = this.session.createCriteria(this.classe).list();
/*  68 */     return entities;
/*     */   }
/*     */ 
/*     */   public List<T> getListByDetachedCriteria(DetachedCriteria criteria)
/*     */   {
/*  74 */     return criteria.getExecutableCriteria(this.session).list();
/*     */   }
/*     */ 
/*     */   public List<T> getListByCriteriaOrderAsc(String value)
/*     */   {
/*  79 */     List lista = new ArrayList();
/*  80 */     Criteria crit = this.session.createCriteria(this.classe);
/*  81 */     crit.addOrder(Order.asc(value));
/*  82 */     lista = crit.list();
/*  83 */     System.out.println("Listado Com Sucesso!");
/*  84 */     return lista;
/*     */   }
/*     */ 
/*     */   public List<T> getListByCriteriaOrderDesc(String value)
/*     */   {
/*  90 */     List lista = new ArrayList();
/*  91 */     Criteria crit = this.session.createCriteria(this.classe);
/*  92 */     crit.addOrder(Order.desc(value));
/*  93 */     lista = crit.list();
/*  94 */     System.out.println("Listado Com Sucesso!");
/*  95 */     return lista;
/*     */   }
/*     */ 
/*     */   public List<T> getListbyCriteriaDetail(String value)
/*     */   {
/* 102 */     List lista = new ArrayList();
/* 103 */     Criteria criteria = this.session.createCriteria(this.classe);
/* 104 */     criteria.add(Restrictions.ilike("rg", value));
/*     */ 
/* 106 */     criteria.uniqueResult();
/* 107 */     List listar = criteria.list();
/* 108 */     System.out.println("Consulta por RG Feita com sucesso!");
/* 109 */     return listar;
/*     */   }
/*     */ 
/*     */   public List<T> getListbyCriteriaCompleteCargo(String value)
/*     */   {
/* 114 */     List lista = new ArrayList();
/* 115 */     Criteria criteria = this.session.createCriteria(this.classe);
/* 116 */     criteria.add(Restrictions.ilike("cargo", value));
/* 117 */     criteria.addOrder(Order.desc("cargo"));
/* 118 */     List listar = criteria.list();
/* 119 */     return listar;
/*     */   }
/*     */ 
/*     */   public List<T> getListbyCriteriaBetween(Date of, Date to, String rg, String empresa, Long acesso, Long visitado)
/*     */   {
/* 124 */     List lista = new ArrayList();
/* 125 */     Criteria criteria = this.session.createCriteria(this.classe);
/* 126 */     criteria.createAlias("pessoa", "pessoa", 0, Restrictions.ilike("pessoa.rg", rg, MatchMode.ANYWHERE));
/* 127 */     criteria.createAlias("pessoa.acesso", "acesso", 0);
/* 128 */     if (visitado.longValue() != 0L)
/* 129 */       criteria.createAlias("visitado", "visitado", 0, Restrictions.eq("visitado.idVisitado", visitado));
/*     */     else {
/* 131 */       criteria.add(Restrictions.ilike("pessoa.empresa", empresa + "%", MatchMode.ANYWHERE));
/*     */     }
/* 133 */     if (acesso.longValue() != 0L)
/* 134 */       criteria.add(Restrictions.eq("acesso.idAcesso", acesso));
/*     */     else {
/* 136 */       criteria.add(Restrictions.between("dataVisita", of, to));
/*     */     }
/* 138 */     criteria.addOrder(Order.desc("idMovimento"));
/* 139 */     lista = criteria.list();
/* 140 */     return lista;
/*     */   }
/*     */ 
/*     */   public List<T> getListbyCriteriaStatusEntrada(String value)
/*     */   {
/* 146 */     List lista = new ArrayList();
/* 147 */     Criteria criteria = this.session.createCriteria(this.classe);
/* 148 */     criteria.add(Restrictions.ilike("status", value));
/* 149 */     criteria.addOrder(Order.desc("dataVisita"));
/* 150 */     criteria.addOrder(Order.desc("horaVisita"));
/*     */ 
/* 152 */     lista = criteria.list();
/* 153 */     System.out.println("Consulta por Status Feita com sucesso!");
/* 154 */     return lista;
/*     */   }
/*     */ 
/*     */   public List<T> getListbyCriteriaStatusSaida(String value)
/*     */   {
/* 159 */     List lista = new ArrayList();
/* 160 */     Criteria criteria = this.session.createCriteria(this.classe);
/* 161 */     criteria.add(Restrictions.ilike("status", value));
/* 162 */     criteria.addOrder(Order.desc("dataSaida"));
/* 163 */     criteria.addOrder(Order.desc("horaSaida"));
/*     */ 
/* 165 */     lista = criteria.list();
/* 166 */     System.out.println("Consulta por Status Feita com sucesso!");
/* 167 */     return lista;
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.dao.HibernateDAO
 * JD-Core Version:    0.6.0
 */