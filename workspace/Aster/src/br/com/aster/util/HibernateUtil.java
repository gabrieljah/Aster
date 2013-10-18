/*    */ package br.com.aster.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.cfg.Configuration;
/*    */ import org.hibernate.service.ServiceRegistry;
/*    */ import org.hibernate.service.ServiceRegistryBuilder;
/*    */ 
/*    */ public class HibernateUtil
/*    */ {
/*    */   private static final SessionFactory sessionFactory;
/*    */   public static final String HIBERNATE_SESSION = "hibernate_session";
/*    */ 
/*    */   public static SessionFactory getSessionFactory()
/*    */   {
/* 38 */     return sessionFactory;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/*    */     try
/*    */     {
/* 20 */       System.out.println("Tentando iniciar uma Session Factory");
/*    */ 
/* 22 */       Configuration configuration = new Configuration().configure();
/* 23 */       ServiceRegistry serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
/*    */ 
/* 25 */       sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder);
/*    */ 
/* 27 */       System.out.println("Session Factory iniciada com sucesso!");
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 31 */       System.out.println("Ocorreu um erro ao iniciar a Session Factory" + ex);
/* 32 */       throw new ExceptionInInitializerError(ex);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.util.HibernateUtil
 * JD-Core Version:    0.6.0
 */