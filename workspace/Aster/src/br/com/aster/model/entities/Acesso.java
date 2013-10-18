/*    */ package br.com.aster.model.entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.ForeignKey;
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ACESSO")
/*    */ public class Acesso
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue
/*    */   @Column(name="IdAcesso")
/*    */   private Long idAcesso;
/*    */ 
/*    */   @Column(name="Nome", nullable=false, unique=true, length=50)
/*    */   private String nome;
/*    */ 
/*    */   @OneToMany(mappedBy="acesso", fetch=FetchType.LAZY)
/*    */   @ForeignKey(name="PessoaAcesso")
/*    */   private List<Pessoa> pessoas;
/*    */ 
/*    */   public Acesso()
/*    */   {
/* 32 */     this.nome = new String();
/*    */   }
/*    */ 
/*    */   public List<Pessoa> getPessoas() {
/* 36 */     return this.pessoas;
/*    */   }
/*    */ 
/*    */   public void setPessoas(List<Pessoa> pessoas) {
/* 40 */     this.pessoas = pessoas;
/*    */   }
/*    */ 
/*    */   public String getNome() {
/* 44 */     return this.nome;
/*    */   }
/*    */ 
/*    */   public void setNome(String Nome) {
/* 48 */     this.nome = Nome;
/*    */   }
/*    */ 
/*    */   public Long getIdAcesso() {
/* 52 */     return this.idAcesso;
/*    */   }
/*    */ 
/*    */   public void setIdAcesso(Long idAcesso) {
/* 56 */     this.idAcesso = idAcesso;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 61 */     int prime = 31;
/* 62 */     int result = 1;
/* 63 */     result = 31 * result + (this.nome == null ? 0 : this.nome.hashCode());
/* 64 */     result = 31 * result + (this.idAcesso == null ? 0 : this.idAcesso.hashCode());
/*    */ 
/* 66 */     return result;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 71 */     if (this == obj) {
/* 72 */       return true;
/*    */     }
/* 74 */     if (obj == null) {
/* 75 */       return false;
/*    */     }
/* 77 */     if (getClass() != obj.getClass()) {
/* 78 */       return false;
/*    */     }
/* 80 */     Acesso other = (Acesso)obj;
/* 81 */     if (this.nome == null) {
/* 82 */       if (other.nome != null)
/* 83 */         return false;
/*    */     }
/* 85 */     else if (!this.nome.equals(other.nome)) {
/* 86 */       return false;
/*    */     }
/* 88 */     if (this.idAcesso == null) {
/* 89 */       if (other.idAcesso != null)
/* 90 */         return false;
/*    */     }
/* 92 */     else if (!this.idAcesso.equals(other.idAcesso)) {
/* 93 */       return false;
/*    */     }
/* 95 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Acesso
 * JD-Core Version:    0.6.0
 */