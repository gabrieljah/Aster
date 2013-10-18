/*     */ package br.com.aster.model.entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.ForeignKey;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="PESSOA")
/*     */ public class Pessoa
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue
/*     */   @Column(name="IdPessoa", nullable=false)
/*     */   private Integer idPessoa;
/*     */ 
/*     */   @Column(name="Nome", nullable=false, length=80)
/*     */   private String nome;
/*     */ 
/*     */   @Column(name="RG", unique=true, nullable=false, length=9)
/*     */   private String rg;
/*     */ 
/*     */   @Column(name="Empresa", length=60)
/*     */   private String empresa;
/*     */ 
/*     */   @Column(name="Cargo", length=40)
/*     */   private String cargo;
/*     */ 
/*     */   @Column(name="Telefone", length=15)
/*     */   private String telefone;
/*     */ 
/*     */   @Column(name="Data_de_Cadastro", nullable=false)
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dataDeCadastro;
/*     */ 
/*     */   @Column(name="Foto")
/*     */   private String foto;
/*     */ 
/*     */   @Column(name="Observacao")
/*     */   private String observacao;
/*     */ 
/*     */   @OneToMany(mappedBy="pessoa", fetch=FetchType.LAZY)
/*     */   @ForeignKey(name="PessoaMovimento")
/*     */   private List<Movimento> movimentos;
/*     */ 
/*     */   @ManyToOne(optional=false)
/*     */   @ForeignKey(name="PessoaSexo")
/*     */   @JoinColumn(name="Sexo", referencedColumnName="Idsexo")
/*     */   private Sexo sexo;
/*     */ 
/*     */   @ManyToOne(optional=false)
/*     */   @ForeignKey(name="PessoaAcesso")
/*     */   @JoinColumn(name="Acesso", referencedColumnName="IdAcesso")
/*     */   private Acesso acesso;
/*     */ 
/*     */   public Pessoa()
/*     */   {
/*  53 */     this.sexo = new Sexo();
/*  54 */     this.acesso = new Acesso();
/*     */   }
/*     */ 
/*     */   public List<Movimento> getMovimentos()
/*     */   {
/*  60 */     return this.movimentos;
/*     */   }
/*     */ 
/*     */   public void setMovimentos(List<Movimento> movimentos) {
/*  64 */     this.movimentos = movimentos;
/*     */   }
/*     */ 
/*     */   public Acesso getAcesso() {
/*  68 */     return this.acesso;
/*     */   }
/*     */ 
/*     */   public void setAcesso(Acesso acesso) {
/*  72 */     this.acesso = acesso;
/*     */   }
/*     */ 
/*     */   public String getCargo() {
/*  76 */     return this.cargo;
/*     */   }
/*     */ 
/*     */   public void setCargo(String cargo) {
/*  80 */     this.cargo = cargo;
/*     */   }
/*     */ 
/*     */   public Date getDataDeCadastro() {
/*  84 */     return this.dataDeCadastro;
/*     */   }
/*     */ 
/*     */   public void setDataDeCadastro(Date dataDeCadastro) {
/*  88 */     this.dataDeCadastro = dataDeCadastro;
/*     */   }
/*     */ 
/*     */   public String getEmpresa() {
/*  92 */     return this.empresa;
/*     */   }
/*     */ 
/*     */   public void setEmpresa(String empresa) {
/*  96 */     this.empresa = empresa;
/*     */   }
/*     */ 
/*     */   public String getFoto() {
/* 100 */     return this.foto;
/*     */   }
/*     */ 
/*     */   public void setFoto(String foto) {
/* 104 */     this.foto = foto;
/*     */   }
/*     */ 
/*     */   public Integer getIdPessoa() {
/* 108 */     return this.idPessoa;
/*     */   }
/*     */ 
/*     */   public void setIdPessoa(Integer idPessoa) {
/* 112 */     this.idPessoa = idPessoa;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/* 116 */     return this.nome;
/*     */   }
/*     */ 
/*     */   public void setNome(String nome) {
/* 120 */     this.nome = nome;
/*     */   }
/*     */ 
/*     */   public String getObservacao() {
/* 124 */     return this.observacao;
/*     */   }
/*     */ 
/*     */   public void setObservacao(String observacao) {
/* 128 */     this.observacao = observacao;
/*     */   }
/*     */ 
/*     */   public String getRg() {
/* 132 */     return this.rg;
/*     */   }
/*     */ 
/*     */   public void setRg(String rg) {
/* 136 */     this.rg = rg;
/*     */   }
/*     */ 
/*     */   public Sexo getSexo() {
/* 140 */     return this.sexo;
/*     */   }
/*     */ 
/*     */   public void setSexo(Sexo sexo) {
/* 144 */     this.sexo = sexo;
/*     */   }
/*     */ 
/*     */   public String getTelefone() {
/* 148 */     return this.telefone;
/*     */   }
/*     */ 
/*     */   public void setTelefone(String telefone) {
/* 152 */     this.telefone = telefone;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 157 */     int prime = 31;
/* 158 */     int result = 1;
/* 159 */     result = 31 * result + (this.idPessoa == null ? 0 : this.idPessoa.hashCode());
/* 160 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 165 */     if (this == obj) {
/* 166 */       return true;
/*     */     }
/* 168 */     if (obj == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (!(obj instanceof Pessoa)) {
/* 172 */       return false;
/*     */     }
/* 174 */     Pessoa other = (Pessoa)obj;
/*     */ 
/* 178 */     return (this.idPessoa != null) && 
/* 177 */       (this.idPessoa.equals(other.getIdPessoa()));
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Pessoa
 * JD-Core Version:    0.6.0
 */