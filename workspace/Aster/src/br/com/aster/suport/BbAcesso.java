/*    */ package br.com.aster.suport;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Acesso;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.RequestScoped;
/*    */ 
/*    */ @ManagedBean(name="bbAcesso")
/*    */ @RequestScoped
/*    */ public class BbAcesso
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public List<Acesso> getAcessos()
/*    */   {
/* 26 */     InterfaceDAO acessoDAO = new HibernateDAO(Acesso.class, FacesContextUtil.getRequestSession());
/* 27 */     return acessoDAO.getEntities();
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.suport.BbAcesso
 * JD-Core Version:    0.6.0
 */