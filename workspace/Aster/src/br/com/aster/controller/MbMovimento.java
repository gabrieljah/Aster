/*     */ package br.com.aster.controller;
/*     */ 
/*     */ import br.com.aster.model.dao.HibernateDAO;
/*     */ import br.com.aster.model.dao.InterfaceDAO;
/*     */ import br.com.aster.model.entities.Acesso;
/*     */ import br.com.aster.model.entities.Movimento;
/*     */ import br.com.aster.model.entities.Pessoa;
/*     */ import br.com.aster.model.entities.Usuario;
/*     */ import br.com.aster.model.entities.Visitado;
/*     */ import br.com.aster.suport.BbUsuarioLogado;
/*     */ import br.com.aster.util.FacesContextUtil;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.faces.context.FacesContext;
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class MbMovimento
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  31 */   private Pessoa pessoa = new Pessoa();
/*     */   private List<Pessoa> pessoas;
/*     */   private List<Pessoa> pessoasRG;
/*  34 */   private Movimento movimento = new Movimento();
/*     */   private List<Movimento> movimentos;
/*  36 */   private List<Movimento> movimentoEntrada = new ArrayList();
/*  37 */   private List<Movimento> movimentoSaida = new ArrayList();
/*  38 */   private String rg = new String();
/*  39 */   private Acesso acesso = new Acesso();
/*  40 */   private Usuario usuario = new Usuario();
/*  41 */   private Visitado visitado = new Visitado();
/*  42 */   private BbUsuarioLogado logado = new BbUsuarioLogado();
/*     */ 
/*     */   private InterfaceDAO<Movimento> movimentoDAO()
/*     */   {
/*  48 */     InterfaceDAO movimentoDAO = new HibernateDAO(Movimento.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  50 */     return movimentoDAO;
/*     */   }
/*     */ 
/*     */   private InterfaceDAO<Pessoa> pessoaDAO() {
/*  54 */     InterfaceDAO pessoaDAO = new HibernateDAO(Pessoa.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  56 */     return pessoaDAO;
/*     */   }
/*     */ 
/*     */   public String limpMovimento() {
/*  60 */     this.pessoas = new ArrayList();
/*  61 */     this.movimento = new Movimento();
/*  62 */     this.pessoasRG = new ArrayList();
/*  63 */     this.pessoa = new Pessoa();
/*  64 */     this.visitado = new Visitado();
/*  65 */     this.rg = new String();
/*  66 */     getMovimentoEntrada();
/*  67 */     return "/restrict/controlevisita";
/*     */   }
/*     */ 
/*     */   public String entradaMovimento(Pessoa pessoa) {
/*  71 */     this.movimento.setPessoa(pessoa);
/*  72 */     this.movimento.setStatus("1");
/*  73 */     System.out.println(this.movimentoEntrada.contains(this.movimento));
/*  74 */     if (this.movimentoEntrada.contains(this.movimento)) {
/*  75 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, " Pessoa já esta na Empresa", ""));
/*     */     }
/*     */     else {
/*  78 */       pessoaDAO().update(pessoa);
/*  79 */       insertMovimento();
/*     */     }
/*  81 */     return limpMovimento();
/*     */   }
/*     */ 
/*     */   private void insertMovimento()
/*     */   {
/*  86 */     Date date = new Date();
/*  87 */     this.movimento.setUsuario(this.logado.procuraPessoa());
/*  88 */     this.movimento.setHoraVisita(date);
/*  89 */     this.movimento.setDataVisita(date);
/*  90 */     movimentoDAO().save(this.movimento);
/*  91 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Entrada efetuada com sucesso!", ""));
/*     */   }
/*     */ 
/*     */   public String saidaMovimento()
/*     */   {
/*  98 */     updateMovimento();
/*  99 */     return limpMovimento();
/*     */   }
/*     */ 
/*     */   private void updateMovimento() {
/* 103 */     Date date = new Date();
/* 104 */     this.movimento.setDataSaida(date);
/* 105 */     this.movimento.setHoraSaida(date);
/* 106 */     this.movimento.setStatus("2");
/* 107 */     movimentoDAO().update(this.movimento);
/* 108 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Saida efetuada com sucesso", ""));
/*     */   }
/*     */ 
/*     */   public void consultarRG()
/*     */   {
/* 114 */     if (getRg().isEmpty()) {
/* 115 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " RG não Localizado", ""));
/*     */ 
/* 117 */       this.pessoas = new ArrayList();
/* 118 */       this.rg = new String();
/*     */     } else {
/*     */       try {
/* 121 */         this.pessoas = pessoaDAO().getListbyCriteriaDetail(getRg());
/* 122 */         if (this.pessoas.isEmpty()) {
/* 123 */           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Não Localizado", ""));
/*     */ 
/* 125 */           this.rg = new String();
/*     */         } else {
/* 127 */           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Visitante Encontrado", ""));
/*     */ 
/* 129 */           this.rg = new String();
/*     */         }
/*     */       } catch (Exception e) {
/* 132 */         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), ""));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getFormataHora()
/*     */   {
/* 141 */     String formato = "HH:mm:ss";
/* 142 */     SimpleDateFormat dataformatada = new SimpleDateFormat(formato);
/* 143 */     return dataformatada.format(this.movimento.getHoraVisita()).toString();
/*     */   }
/*     */ 
/*     */   public List<Movimento> getMovimentoEntrada()
/*     */   {
/* 149 */     this.movimentoEntrada = movimentoDAO().getListbyCriteriaStatusEntrada("1");
/* 150 */     System.out.println("Consulta atraves da lista de Movimento:" + this.movimentoEntrada.contains(this.movimento));
/* 151 */     return this.movimentoEntrada;
/*     */   }
/*     */ 
/*     */   public List<Movimento> getMovimentoSaida() {
/* 155 */     this.movimentoSaida = movimentoDAO().getListbyCriteriaStatusSaida("2");
/* 156 */     return this.movimentoSaida;
/*     */   }
/*     */ 
/*     */   public Movimento getMovimento()
/*     */   {
/* 161 */     return this.movimento;
/*     */   }
/*     */ 
/*     */   public void setMovimento(Movimento movimento) {
/* 165 */     this.movimento = movimento;
/*     */   }
/*     */ 
/*     */   public List<Movimento> getMovimentos()
/*     */   {
/* 170 */     return this.movimentos;
/*     */   }
/*     */ 
/*     */   public void setMovimentos(List<Movimento> movimentos) {
/* 174 */     this.movimentos = movimentos;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoa() {
/* 178 */     return this.pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoa(Pessoa pessoa) {
/* 182 */     this.pessoa = pessoa;
/*     */   }
/*     */ 
/*     */   public List<Pessoa> getPessoas()
/*     */   {
/* 187 */     return this.pessoas;
/*     */   }
/*     */ 
/*     */   public void setPessoas(List<Pessoa> pessoas) {
/* 191 */     this.pessoas = pessoas;
/*     */   }
/*     */ 
/*     */   public String getRg() {
/* 195 */     return this.rg;
/*     */   }
/*     */ 
/*     */   public void setRg(String rg) {
/* 199 */     this.rg = rg;
/*     */   }
/*     */ 
/*     */   public Usuario getUsuario() {
/* 203 */     return this.usuario;
/*     */   }
/*     */ 
/*     */   public void setUsuario(Usuario usuario) {
/* 207 */     this.usuario = usuario;
/*     */   }
/*     */ 
/*     */   public BbUsuarioLogado getLogado() {
/* 211 */     return this.logado;
/*     */   }
/*     */ 
/*     */   public void setLogado(BbUsuarioLogado logado) {
/* 215 */     this.logado = logado;
/*     */   }
/*     */ 
/*     */   public List<Pessoa> getPessoasRG() {
/* 219 */     this.pessoasRG = pessoaDAO().getEntities();
/* 220 */     return this.pessoasRG;
/*     */   }
/*     */ 
/*     */   public void setPessoasRG(List<Pessoa> pessoasRG) {
/* 224 */     this.pessoasRG = pessoasRG;
/*     */   }
/*     */ 
/*     */   public Acesso getAcesso() {
/* 228 */     return this.acesso;
/*     */   }
/*     */ 
/*     */   public void setAcesso(Acesso acesso) {
/* 232 */     this.acesso = acesso;
/*     */   }
/*     */ 
/*     */   public Visitado getVisitado() {
/* 236 */     return this.visitado;
/*     */   }
/*     */ 
/*     */   public void setVisitado(Visitado visitado) {
/* 240 */     this.visitado = visitado;
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbMovimento
 * JD-Core Version:    0.6.0
 */