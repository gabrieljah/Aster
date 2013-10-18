/*    */ package br.com.aster.controller;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Acesso;
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
/*    */ public class MbAcesso
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 27 */   private Acesso acesso = new Acesso();
/*    */   private List<Acesso> acessos;
/*    */ 
/*    */   private InterfaceDAO<Acesso> acessoDAO()
/*    */   {
/* 34 */     InterfaceDAO acessoDAO = new HibernateDAO(Acesso.class, FacesContextUtil.getRequestSession());
/*    */ 
/* 36 */     return acessoDAO;
/*    */   }
/*    */ 
/*    */   public String limpAcesso() {
/* 40 */     this.acesso = new Acesso();
/* 41 */     return cadAcesso();
/*    */   }
/*    */ 
/*    */   private String cadAcesso() {
/* 45 */     return "/restrict/cadastraracesso.faces";
/*    */   }
/*    */ 
/*    */   public String addAcesso()
/*    */   {
/* 51 */     if ((this.acesso.getIdAcesso() == null) || (this.acesso.getIdAcesso().longValue() == 0L))
/* 52 */       insertAcesso();
/*    */     else {
/* 54 */       updateAcesso();
/*    */     }
/* 56 */     return limpAcesso();
/*    */   }
/*    */ 
/*    */   private void insertAcesso()
/*    */   {
/* 61 */     acessoDAO().save(this.acesso);
/*    */ 
/* 63 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Gravação efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   private void updateAcesso()
/*    */   {
/* 68 */     acessoDAO().update(this.acesso);
/*    */ 
/* 70 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Atualização efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   private void deleteAcesso()
/*    */   {
/* 75 */     acessoDAO().remove(this.acesso);
/*    */ 
/* 77 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Remoção efetuada com sucesso", ""));
/*    */   }
/*    */ 
/*    */   public Acesso getAcesso()
/*    */   {
/* 82 */     return this.acesso;
/*    */   }
/*    */ 
/*    */   public void setAcesso(Acesso acesso) {
/* 86 */     this.acesso = acesso;
/*    */   }
/*    */ 
/*    */   public List<Acesso> getAcessos() {
/* 90 */     this.acessos = acessoDAO().getListByCriteriaOrderAsc("nome");
/* 91 */     return this.acessos;
/*    */   }
/*    */ 
/*    */   public void setAcessos(List<Acesso> acessos) {
/* 95 */     this.acessos = acessos;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbAcesso
 * JD-Core Version:    0.6.0
 */