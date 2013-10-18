/*    */ package br.com.aster.suport;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Sexo;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.RequestScoped;
/*    */ 
/*    */ @ManagedBean(name="bbSexo")
/*    */ @RequestScoped
/*    */ public class BbSexo
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public List<Sexo> getSexos()
/*    */   {
/* 25 */     InterfaceDAO sexoDAO = new HibernateDAO(Sexo.class, FacesContextUtil.getRequestSession());
/* 26 */     return sexoDAO.getEntities();
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.suport.BbSexo
 * JD-Core Version:    0.6.0
 */