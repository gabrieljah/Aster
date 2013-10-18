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
/*    */ @Table(name="SEXO")
/*    */ public class Sexo
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue
/*    */   @Column(name="IdSexo")
/*    */   private Integer idSexo;
/*    */ 
/*    */   @Column(name="Nome", nullable=false, unique=true, length=9)
/*    */   private String Nome;
/*    */ 
/*    */   @OneToMany(mappedBy="sexo", fetch=FetchType.LAZY)
/*    */   @ForeignKey(name="PessoaSexo")
/*    */   private List<Pessoa> pessoas;
/*    */ 
/*    */   public String getNome()
/*    */   {
/* 37 */     return this.Nome;
/*    */   }
/*    */ 
/*    */   public void setNome(String Nome) {
/* 41 */     this.Nome = Nome;
/*    */   }
/*    */ 
/*    */   public Integer getIdSexo() {
/* 45 */     return this.idSexo;
/*    */   }
/*    */ 
/*    */   public void setIdSexo(Integer idSexo) {
/* 49 */     this.idSexo = idSexo;
/*    */   }
/*    */ 
/*    */   public List<Pessoa> getPessoas() {
/* 53 */     return this.pessoas;
/*    */   }
/*    */ 
/*    */   public void setPessoas(List<Pessoa> pessoas) {
/* 57 */     this.pessoas = pessoas;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 62 */     if (obj == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     if (getClass() != obj.getClass()) {
/* 66 */       return false;
/*    */     }
/* 68 */     Sexo other = (Sexo)obj;
/*    */ 
/* 70 */     return (this.idSexo == other.idSexo) || ((this.idSexo != null) && (this.idSexo.equals(other.idSexo)));
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 77 */     int hash = 5;
/* 78 */     hash = 53 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
/* 79 */     return hash;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Sexo
 * JD-Core Version:    0.6.0
 */