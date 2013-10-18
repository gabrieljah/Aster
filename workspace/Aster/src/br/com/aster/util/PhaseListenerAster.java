/*    */ package br.com.aster.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.event.PhaseEvent;
/*    */ import javax.faces.event.PhaseId;
/*    */ import javax.faces.event.PhaseListener;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class PhaseListenerAster
/*    */   implements PhaseListener
/*    */ {
/*    */   public void beforePhase(PhaseEvent fase)
/*    */   {
/* 17 */     System.out.println("Antes da fase: " + fase.getPhaseId());
/* 18 */     if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
/* 19 */       Session session = HibernateUtil.getSessionFactory().openSession();
/* 20 */       session.beginTransaction();
/* 21 */       FacesContextUtil.setRequestSession(session);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void afterPhase(PhaseEvent fase)
/*    */   {
/* 28 */     System.out.println("Depois da fase: " + fase.getPhaseId());
/* 29 */     if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
/* 30 */       Session session = FacesContextUtil.getRequestSession();
/*    */       try {
/* 32 */         session.getTransaction().commit();
/*    */       } catch (Exception e) {
/* 34 */         if (session.getTransaction().isActive())
/* 35 */           session.getTransaction().rollback();
/*    */       }
/*    */       finally {
/* 38 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public PhaseId getPhaseId()
/*    */   {
/* 45 */     return PhaseId.ANY_PHASE;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.util.PhaseListenerAster
 * JD-Core Version:    0.6.0
 */