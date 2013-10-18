/*    */ package br.com.aster.controller;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Visitado;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.SessionScoped;
/*    */ import javax.faces.context.FacesContext;
/*    */ 
/*    */ @ManagedBean
/*    */ @SessionScoped
/*    */ public class MbVisitado
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private Visitado visitado = new Visitado();
/*    */   private List<Visitado> visitados;
/*    */ 
/*    */   private InterfaceDAO<Visitado> visitadoDAO()
/*    */   {
/* 34 */     InterfaceDAO visitadoDAO = new HibernateDAO(Visitado.class, FacesContextUtil.getRequestSession());
/*    */ 
/* 36 */     return visitadoDAO;
/*    */   }
/*    */ 
/*    */   public String limpVisitado() {
/* 40 */     this.visitado = new Visitado();
/* 41 */     return cadVisitado();
/*    */   }
/*    */ 
/*    */   private String cadVisitado() {
/* 45 */     return "/restrict/cadastrarvisitado.faces";
/*    */   }
/*    */ 
/*    */   public String addVisitado()
/*    */   {
/* 51 */     if ((this.visitado.getIdVisitado() == null) || (this.visitado.getIdVisitado().longValue() == 0L))
/* 52 */       insertVisitado();
/*    */     else {
/* 54 */       updateVisitado();
/*    */     }
/* 56 */     return limpVisitado();
/*    */   }
/*    */ 
/*    */   private void insertVisitado()
/*    */   {
/* 61 */     visitadoDAO().save(this.visitado);
/*    */ 
/* 63 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Gravação efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   private void updateVisitado()
/*    */   {
/* 68 */     visitadoDAO().update(this.visitado);
/*    */ 
/* 70 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Atualização efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   private void deleteVisitado()
/*    */   {
/* 75 */     visitadoDAO().remove(this.visitado);
/*    */ 
/* 77 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Remoção efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   public Visitado getVisitado()
/*    */   {
/* 82 */     return this.visitado;
/*    */   }
/*    */ 
/*    */   public void setVisitado(Visitado visitado) {
/* 86 */     this.visitado = visitado;
/*    */   }
/*    */ 
/*    */   public List<Visitado> getVisitados() {
/* 90 */     this.visitados = visitadoDAO().getListByCriteriaOrderAsc("nome");
/* 91 */     return this.visitados;
/*    */   }
/*    */ 
/*    */   public void setVisitados(List<Visitado> visitados) {
/* 95 */     this.visitados = visitados;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbVisitado
 * JD-Core Version:    0.6.0
 */