/*     */ package br.com.aster.model.entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.ForeignKey;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="USUARIO")
/*     */ public class Usuario
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue
/*     */   @Column(name="IdUsuario", nullable=false)
/*     */   private Integer idUsuario;
/*     */ 
/*     */   @Column(name="Nome", nullable=false, length=80)
/*     */   private String nome;
/*     */ 
/*     */   @Column(name="Data_de_Cadastro", nullable=false)
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dataDeCadastro;
/*     */ 
/*     */   @Column(name="Login", unique=true, length=25)
/*     */   private String login;
/*     */ 
/*     */   @Column(name="Senha", length=40)
/*     */   private String senha;
/*     */ 
/*     */   @Column(name="Permissao", length=36)
/*     */   private String permissao;
/*     */ 
/*     */   @OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
/*     */   @ForeignKey(name="UsuarioMovimento")
/*     */   private List<Movimento> movimentos;
/*     */ 
/*     */   public Date getDataDeCadastro()
/*     */   {
/*  48 */     return this.dataDeCadastro;
/*     */   }
/*     */ 
/*     */   public void setDataDeCadastro(Date dataDeCadastro) {
/*  52 */     this.dataDeCadastro = dataDeCadastro;
/*     */   }
/*     */ 
/*     */   public Integer getIdUsuario()
/*     */   {
/*  57 */     return this.idUsuario;
/*     */   }
/*     */ 
/*     */   public void setIdUsuario(Integer idUsuario) {
/*  61 */     this.idUsuario = idUsuario;
/*     */   }
/*     */ 
/*     */   public String getLogin() {
/*  65 */     return this.login;
/*     */   }
/*     */ 
/*     */   public void setLogin(String login) {
/*  69 */     this.login = login;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  73 */     return this.nome;
/*     */   }
/*     */ 
/*     */   public void setNome(String nome) {
/*  77 */     this.nome = nome;
/*     */   }
/*     */ 
/*     */   public String getPermissao() {
/*  81 */     return this.permissao;
/*     */   }
/*     */ 
/*     */   public void setPermissao(String permissao) {
/*  85 */     this.permissao = permissao;
/*     */   }
/*     */ 
/*     */   public String getSenha() {
/*  89 */     return this.senha;
/*     */   }
/*     */ 
/*     */   public void setSenha(String senha) {
/*  93 */     this.senha = senha;
/*     */   }
/*     */ 
/*     */   public String getFormataData() {
/*  97 */     String formato = "dd/MM/yyyy";
/*  98 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/*  99 */     return dataformatada.format(getDataDeCadastro()).toString();
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 104 */     if (obj == null) {
/* 105 */       return false;
/*     */     }
/* 107 */     if (getClass() != obj.getClass()) {
/* 108 */       return false;
/*     */     }
/* 110 */     Usuario other = (Usuario)obj;
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 116 */     int hash = 7;
/* 117 */     hash = 71 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
/* 118 */     return hash;
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Usuario
 * JD-Core Version:    0.6.0
 */