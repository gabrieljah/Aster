/*    */ package br.com.aster.util;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import org.hibernate.Session;
/*    */ 
/*    */ public class FacesContextUtil
/*    */ {
/*    */   private static final String HIBERNATE_SESSION = "hibernate_session";
/*    */ 
/*    */   public static void setRequestSession(Session session)
/*    */   {
/* 15 */     FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("hibernate_session", session);
/*    */   }
/*    */ 
/*    */   public static Session getRequestSession() {
/* 19 */     return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("hibernate_session");
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.util.FacesContextUtil
 * JD-Core Version:    0.6.0
 */