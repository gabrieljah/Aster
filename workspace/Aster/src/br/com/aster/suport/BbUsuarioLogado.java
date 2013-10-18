/*    */ package br.com.aster.suport;
/*    */ 
/*    */ import br.com.aster.model.entities.Usuario;
/*    */ import br.com.aster.util.FacesContextUtil;
/*    */ import java.io.Serializable;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.SessionScoped;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ 
/*    */ @ManagedBean(name="bbUsuarioLogado")
/*    */ @SessionScoped
/*    */ public class BbUsuarioLogado
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String login;
/* 28 */   SecurityContext context = SecurityContextHolder.getContext();
/*    */ 
/*    */   public Usuario procuraPessoa()
/*    */   {
/* 35 */     if ((this.context instanceof SecurityContext)) {
/* 36 */       Authentication authentication = this.context.getAuthentication();
/* 37 */       if ((authentication instanceof Authentication)) {
/* 38 */         this.login = ((User)authentication.getPrincipal()).getUsername();
/*    */       }
/*    */     }
/* 41 */     Session session = FacesContextUtil.getRequestSession();
/* 42 */     Query query = session.createQuery("from Usuario user where user.login like ?");
/* 43 */     query.setString(0, this.login);
/* 44 */     return (Usuario)query.uniqueResult();
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.suport.BbUsuarioLogado
 * JD-Core Version:    0.6.0
 */