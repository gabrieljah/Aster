/*    */ package br.com.aster.conversores;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Visitado;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ 
/*    */ @FacesConverter(value="visitadoConverter", forClass=Visitado.class)
/*    */ public class VisitadoConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext context, UIComponent component, String value)
/*    */   {
/* 27 */     Visitado visitado = null;
/* 28 */     if ((value != null) && (!value.equals(""))) {
/* 29 */       visitado = (Visitado)visitadoDAO().getEntity(new Integer(value));
/*    */     }
/* 31 */     return visitado;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext context, UIComponent component, Object value)
/*    */   {
/* 36 */     String retorno = "";
/* 37 */     if (!value.equals("")) {
/* 38 */       Visitado visitado = (Visitado)value;
/* 39 */       if (visitado.getIdVisitado() != null) {
/* 40 */         retorno = visitado.getIdVisitado().toString();
/*    */       }
/*    */     }
/* 43 */     return retorno;
/*    */   }
/*    */ 
/*    */   private InterfaceDAO<Visitado> visitadoDAO() {
/* 47 */     InterfaceDAO visitadoDAO = new HibernateDAO(Visitado.class, FacesContextUtil.getRequestSession());
/*    */ 
/* 49 */     return visitadoDAO;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.conversores.VisitadoConverter
 * JD-Core Version:    0.6.0
 */