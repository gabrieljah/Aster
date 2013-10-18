/*    */ package br.com.aster.suport;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Visitado;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.RequestScoped;
/*    */ 
/*    */ @ManagedBean(name="bbVisitado")
/*    */ @RequestScoped
/*    */ public class BbVisitado
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public List<Visitado> getVisitados()
/*    */   {
/* 26 */     InterfaceDAO visitadoDAO = new HibernateDAO(Visitado.class, FacesContextUtil.getRequestSession());
/* 27 */     return visitadoDAO.getEntities();
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.suport.BbVisitado
 * JD-Core Version:    0.6.0
 */