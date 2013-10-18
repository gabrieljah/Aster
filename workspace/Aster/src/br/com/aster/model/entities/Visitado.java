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
/*    */ @Table(name="VISITADO")
/*    */ public class Visitado
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @GeneratedValue
/*    */   @Column(name="idVisitado")
/*    */   private Long idVisitado;
/*    */ 
/*    */   @Column(name="Nome", nullable=false, unique=true, length=50)
/*    */   private String nome;
/*    */ 
/*    */   @OneToMany(mappedBy="visitado", fetch=FetchType.LAZY)
/*    */   @ForeignKey(name="movimentoVisitado")
/*    */   private List<Movimento> movimentos;
/*    */ 
/*    */   public Visitado()
/*    */   {
/* 32 */     this.nome = new String();
/*    */   }
/*    */ 
/*    */   public Long getIdVisitado()
/*    */   {
/* 37 */     return this.idVisitado;
/*    */   }
/*    */ 
/*    */   public void setIdVisitado(Long idVisitado) {
/* 41 */     this.idVisitado = idVisitado;
/*    */   }
/*    */ 
/*    */   public String getNome() {
/* 45 */     return this.nome;
/*    */   }
/*    */ 
/*    */   public void setNome(String nome) {
/* 49 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   public List<Movimento> getMovimentos() {
/* 53 */     return this.movimentos;
/*    */   }
/*    */ 
/*    */   public void setMovimentos(List<Movimento> movimentos) {
/* 57 */     this.movimentos = movimentos;
/*    */   }
/*    */ 
/*    */   public Visitado(Long idVisitado) {
/* 61 */     this.idVisitado = idVisitado;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 66 */     if (obj == null) {
/* 67 */       return false;
/*    */     }
/* 69 */     if (getClass() != obj.getClass()) {
/* 70 */       return false;
/*    */     }
/* 72 */     Visitado other = (Visitado)obj;
/* 73 */     if ((this.idVisitado != other.idVisitado) && ((this.idVisitado == null) || (!this.idVisitado.equals(other.idVisitado)))) {
/* 74 */       return false;
/*    */     }
/*    */ 
/* 77 */     return this.nome == null ? other.nome == null : this.nome.equals(other.nome);
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 84 */     int hash = 7;
/* 85 */     hash = 17 * hash + (this.idVisitado != null ? this.idVisitado.hashCode() : 0);
/* 86 */     hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
/* 87 */     return hash;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Visitado
 * JD-Core Version:    0.6.0
 */