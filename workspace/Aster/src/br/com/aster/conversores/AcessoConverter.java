/*    */ package br.com.aster.conversores;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Acesso;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ 
/*    */ @FacesConverter(value="acessoConverter", forClass=Acesso.class)
/*    */ public class AcessoConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext context, UIComponent component, String value)
/*    */   {
/* 26 */     Acesso acesso = null;
/* 27 */     if ((value != null) && (!value.equals(""))) {
/* 28 */       acesso = (Acesso)acessoDAO().getEntity(new Integer(value));
/*    */     }
/* 30 */     return acesso;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext context, UIComponent component, Object value)
/*    */   {
/* 35 */     String retorno = "";
/* 36 */     if (!value.equals("")) {
/* 37 */       Acesso acesso = (Acesso)value;
/* 38 */       if (acesso.getIdAcesso() != null) {
/* 39 */         retorno = acesso.getIdAcesso().toString();
/*    */       }
/*    */     }
/* 42 */     return retorno;
/*    */   }
/*    */ 
/*    */   private InterfaceDAO<Acesso> acessoDAO() {
/* 46 */     InterfaceDAO acessoDAO = new HibernateDAO(Acesso.class, FacesContextUtil.getRequestSession());
/*    */ 
/* 48 */     return acessoDAO;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.conversores.AcessoConverter
 * JD-Core Version:    0.6.0
 */