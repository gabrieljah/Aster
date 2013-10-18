/*     */ package br.com.aster.model.entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.ForeignKey;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="MOVIMENTO")
/*     */ public class Movimento
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue
/*     */   @Column(name="IdMovimento", nullable=false)
/*     */   private Integer idMovimento;
/*     */ 
/*     */   @Column(name="Status", nullable=false, length=1)
/*     */   private String status;
/*     */ 
/*     */   @Column(name="Data_Visita", nullable=false)
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dataVisita;
/*     */ 
/*     */   @Column(name="Hora_Visita", nullable=false)
/*     */   @Temporal(TemporalType.TIME)
/*     */   private Date horaVisita;
/*     */ 
/*     */   @Column(name="Data_Saida")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dataSaida;
/*     */ 
/*     */   @Column(name="Hora_Saida")
/*     */   @Temporal(TemporalType.TIME)
/*     */   private Date horaSaida;
/*     */ 
/*     */   @Column(name="Cracha", length=4)
/*     */   private String cracha;
/*     */ 
/*     */   @ManyToOne(optional=false, fetch=FetchType.LAZY)
/*     */   @ForeignKey(name="MovimentoPessoa")
/*     */   @JoinColumn(name="IdPessoa", referencedColumnName="IdPessoa")
/*     */   private Pessoa pessoa;
/*     */ 
/*     */   @ManyToOne(optional=false, fetch=FetchType.LAZY)
/*     */   @ForeignKey(name="MovimentoUsuario")
/*     */   @JoinColumn(name="IdUsuario", referencedColumnName="IdUsuario")
/*     */   private Usuario usuario;
/*     */ 
/*     */   @ManyToOne(optional=false)
/*     */   @ForeignKey(name="movimentoVisitado")
/*     */   @JoinColumn(name="visitado", referencedColumnName="idVisitado")
/*     */   private Visitado visitado;
/*     */ 
/*     */   public Movimento()
/*     */   {
/*  58 */     this.visitado = new Visitado();
/*     */   }
/*     */ 
/*     */   public Movimento(Pessoa pessoa, String status) {
/*  62 */     this.pessoa = pessoa;
/*  63 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getDataVisita()
/*     */   {
/*  69 */     return this.dataVisita;
/*     */   }
/*     */ 
/*     */   public String getFormataDataEntrada() {
/*  73 */     String formato = "dd/MM/yyyy";
/*  74 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/*  75 */     return dataformatada.format(getDataVisita()).toString();
/*     */   }
/*     */ 
/*     */   public String getFormataDataSaida() {
/*  79 */     String formato = "dd/MM/yyyy";
/*  80 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/*  81 */     return dataformatada.format(getDataSaida()).toString();
/*     */   }
/*     */ 
/*     */   public void setDataVisita(Date dataVisita) {
/*  85 */     this.dataVisita = dataVisita;
/*     */   }
/*     */ 
/*     */   public Date getHoraVisita() {
/*  89 */     return this.horaVisita;
/*     */   }
/*     */ 
/*     */   public String getFormataHoraSaida() {
/*  93 */     String formato = "HH:mm:ss";
/*  94 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/*  95 */     return dataformatada.format(getHoraSaida()).toString();
/*     */   }
/*     */ 
/*     */   public String getFormataHoraEntrada() {
/*  99 */     String formato = "HH:mm:ss";
/* 100 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/* 101 */     return dataformatada.format(getHoraVisita()).toString();
/*     */   }
/*     */ 
/*     */   public void setHoraVisita(Date horaVisita) {
/* 105 */     this.horaVisita = horaVisita;
/*     */   }
/*     */ 
/*     */   public Integer getIdMovimento() {
/* 109 */     return this.idMovimento;
/*     */   }
/*     */ 
/*     */   public void setIdMovimento(Integer idMovimento) {
/* 113 */     this.idMovimento = idMovimento;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoa() {
/* 117 */     return this.pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoa(Pessoa pessoa) {
/* 121 */     this.pessoa = pessoa;
/*     */   }
/*     */ 
/*     */   public Usuario getUsuario() {
/* 125 */     return this.usuario;
/*     */   }
/*     */ 
/*     */   public void setUsuario(Usuario usuario) {
/* 129 */     this.usuario = usuario;
/*     */   }
/*     */ 
/*     */   public Date getDataSaida() {
/* 133 */     return this.dataSaida;
/*     */   }
/*     */ 
/*     */   public void setDataSaida(Date dataSaida) {
/* 137 */     this.dataSaida = dataSaida;
/*     */   }
/*     */ 
/*     */   public Date getHoraSaida() {
/* 141 */     return this.horaSaida;
/*     */   }
/*     */ 
/*     */   public void setHoraSaida(Date horaSaida) {
/* 145 */     this.horaSaida = horaSaida;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 149 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 153 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCracha() {
/* 157 */     return this.cracha;
/*     */   }
/*     */ 
/*     */   public void setCracha(String cracha) {
/* 161 */     this.cracha = cracha;
/*     */   }
/*     */ 
/*     */   public Visitado getVisitado() {
/* 165 */     return this.visitado;
/*     */   }
/*     */ 
/*     */   public void setVisitado(Visitado visitado) {
/* 169 */     this.visitado = visitado;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 175 */     int prime = 31;
/* 176 */     int result = 1;
/* 177 */     result = 31 * result + (this.idMovimento == null ? 0 : this.idMovimento.hashCode());
/* 178 */     result = 31 * result + (this.pessoa == null ? 0 : this.pessoa.hashCode());
/* 179 */     result = 31 * result + (this.status == null ? 0 : this.status.hashCode());
/* 180 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 185 */     if (this == obj) {
/* 186 */       return true;
/*     */     }
/* 188 */     if (obj == null) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (!(obj instanceof Movimento)) {
/* 192 */       return false;
/*     */     }
/*     */ 
/* 195 */     Movimento other = (Movimento)obj;
/*     */ 
/* 197 */     if ((this.idMovimento != null) && 
/* 198 */       (this.idMovimento.equals(other.idMovimento))) {
/* 199 */       return true;
/*     */     }
/*     */ 
/* 205 */     return (this.pessoa != null) && (this.status != null) && 
/* 204 */       (this.pessoa.equals(other.pessoa)) && (this.status.equals(other.status));
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.model.entities.Movimento
 * JD-Core Version:    0.6.0
 */