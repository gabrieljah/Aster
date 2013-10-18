/*     */ package br.com.aster.controller;
/*     */ 
/*     */ import br.com.aster.conversores.ConverterSHA1;
/*     */ import br.com.aster.model.dao.HibernateDAO;
/*     */ import br.com.aster.model.dao.InterfaceDAO;
/*     */ import br.com.aster.model.entities.Usuario;
/*     */ import br.com.aster.util.FacesContextUtil;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.faces.context.FacesContext;
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class MbUsuario
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  29 */   private Usuario usuario = new Usuario();
/*     */   private List<Usuario> usuarios;
/*     */   private String confereSenha;
/*     */ 
/*     */   private InterfaceDAO<Usuario> usuarioDAO()
/*     */   {
/*  37 */     InterfaceDAO usuarioDAO = new HibernateDAO(Usuario.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  39 */     return usuarioDAO;
/*     */   }
/*     */ 
/*     */   public String editUsuario()
/*     */   {
/*  44 */     return "/admin/cadastrarusuario.faces";
/*     */   }
/*     */ 
/*     */   public String limpUsuario() {
/*  48 */     this.usuario = new Usuario();
/*  49 */     return editUsuario();
/*     */   }
/*     */ 
/*     */   public String addUsuario() {
/*  53 */     Date date = new Date();
/*  54 */     if ((this.usuario.getIdUsuario() == null) || (this.usuario.getIdUsuario().intValue() == 0)) {
/*  55 */       this.usuario.setDataDeCadastro(date);
/*  56 */       insertUsuario();
/*     */     } else {
/*  58 */       updateUsuario();
/*     */     }
/*  60 */     return limpUsuario();
/*     */   }
/*     */ 
/*     */   private void insertUsuario() {
/*  64 */     this.usuario.setSenha(ConverterSHA1.cipher(this.usuario.getSenha()));
/*  65 */     if (this.usuario.getSenha() == null ? this.confereSenha == null : this.usuario.getSenha().equals(ConverterSHA1.cipher(this.confereSenha)))
/*     */     {
/*  67 */       usuarioDAO().save(this.usuario);
/*     */ 
/*  69 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Gravação efetuada com sucesso", ""));
/*     */     }
/*     */     else {
/*  72 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " As Senhas não conferem.", ""));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void updateUsuario()
/*     */   {
/*  79 */     this.usuario.setSenha(ConverterSHA1.cipher(this.usuario.getSenha()));
/*  80 */     if (this.usuario.getSenha() == null ? this.confereSenha == null : this.usuario.getSenha().equals(ConverterSHA1.cipher(this.confereSenha))) {
/*  81 */       usuarioDAO().update(this.usuario);
/*     */ 
/*  83 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Atualização efetuada com sucesso", ""));
/*     */     }
/*     */     else {
/*  86 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " As Senhas não conferem.", ""));
/*     */     }
/*     */   }
/*     */ 
/*     */   public String deleteUsuario()
/*     */   {
/*  93 */     usuarioDAO().remove(this.usuario);
/*  94 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Remoção efetuada com sucesso", ""));
/*     */ 
/*  96 */     return limpUsuario();
/*     */   }
/*     */ 
/*     */   public Usuario getUsuario() {
/* 100 */     return this.usuario;
/*     */   }
/*     */ 
/*     */   public void setUsuario(Usuario usuario) {
/* 104 */     this.usuario = usuario;
/*     */   }
/*     */ 
/*     */   public List<Usuario> getUsuarios() {
/* 108 */     this.usuarios = usuarioDAO().getListByCriteriaOrderAsc("nome");
/* 109 */     return this.usuarios;
/*     */   }
/*     */ 
/*     */   public void setUsuarios(List<Usuario> usuarios) {
/* 113 */     this.usuarios = usuarios;
/*     */   }
/*     */ 
/*     */   public String getConfereSenha() {
/* 117 */     return this.confereSenha;
/*     */   }
/*     */ 
/*     */   public void setConfereSenha(String confereSenha) {
/* 121 */     this.confereSenha = confereSenha;
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbUsuario
 * JD-Core Version:    0.6.0
 */