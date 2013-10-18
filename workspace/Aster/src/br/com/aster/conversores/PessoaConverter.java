/*    */ package br.com.aster.conversores;
/*    */ 
/*    */ import br.com.aster.model.dao.HibernateDAO;
/*    */ import br.com.aster.model.dao.InterfaceDAO;
/*    */ import br.com.aster.model.entities.Pessoa;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ 
/*    */ @FacesConverter("pessoaConverter")
/*    */ public class PessoaConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext fc, UIComponent uic, String string)
/*    */   {
/* 26 */     Pessoa pessoa = (Pessoa)pessoaDAO().getEntity(string);
/* 27 */     return pessoa;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext fc, UIComponent uic, Object o)
/*    */   {
/* 32 */     Pessoa pessoa = new Pessoa();
/* 33 */     pessoa = (Pessoa)o;
/* 34 */     return pessoa.getCargo();
/*    */   }
/*    */ 
/*    */   private InterfaceDAO<Pessoa> pessoaDAO() {
/* 38 */     InterfaceDAO pessoaDAO = new HibernateDAO(Pessoa.class, FacesContextUtil.getRequestSession());
/*    */ 
/* 40 */     return pessoaDAO;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.conversores.PessoaConverter
 * JD-Core Version:    0.6.0
 */