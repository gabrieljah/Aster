/*     */ package br.com.aster.controller;
/*     */ 
/*     */ import br.com.aster.model.dao.HibernateDAO;
/*     */ import br.com.aster.model.dao.InterfaceDAO;
/*     */ import br.com.aster.model.entities.Acesso;
/*     */ import br.com.aster.model.entities.Pessoa;
/*     */ import br.com.aster.util.FacesContextUtil;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.faces.FacesException;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.SessionScoped;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.imageio.stream.FileImageOutputStream;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.primefaces.event.CaptureEvent;
/*     */ 
/*     */ @ManagedBean
/*     */ @SessionScoped
/*     */ public class MbPessoa
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   private Pessoa pessoa = new Pessoa();
/*     */   private List<Pessoa> pessoas;
/*  41 */   private String foto = new String();
/*  42 */   private Acesso acesso = new Acesso();
/*     */   private MbMovimento mbMovimento;
/*     */   private Pessoa pessoaSelecionada;
/*     */ 
/*     */   private InterfaceDAO<Pessoa> pessoaDAO()
/*     */   {
/*  49 */     InterfaceDAO pessoaDAO = new HibernateDAO(Pessoa.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  51 */     return pessoaDAO;
/*     */   }
/*     */ 
/*     */   public void oncapture(CaptureEvent captureEvent)
/*     */   {
/*  56 */     byte[] datos = captureEvent.getData();
/*  57 */     ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
/*  58 */     this.foto = (new Date().getTime() + ".jpg");
/*  59 */     String fileFoto = servletContext.getRealPath("") + File.separator + this.foto;
/*     */ 
/*  61 */     this.pessoa.setFoto(this.foto);
/*  62 */     FileImageOutputStream outputStream = null;
/*     */     try {
/*  64 */       outputStream = new FileImageOutputStream(new File(fileFoto));
/*  65 */       outputStream.write(datos, 0, datos.length);
/*     */     } catch (IOException e) {
/*  67 */       throw new FacesException("Erro ao salvar a foto", e);
/*     */     } finally {
/*     */       try {
/*  70 */         outputStream.close();
/*     */       } catch (IOException e) {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String limpPessoa() {
/*  77 */     this.pessoa = new Pessoa();
/*  78 */     return cadPessoa();
/*     */   }
/*     */ 
/*     */   private String cadPessoa() {
/*  82 */     return "/restrict/cadastrarpessoa.faces";
/*     */   }
/*     */ 
/*     */   public String editPessoa() {
/*  86 */     return "/restrict/editarpessoa.faces";
/*     */   }
/*     */ 
/*     */   public void addPessoa() throws Exception {
/*  90 */     Date date = new Date();
/*  91 */     this.pessoa.setDataDeCadastro(date);
/*  92 */     insertPessoa();
/*     */   }
/*     */ 
/*     */   public String addMovimento(Pessoa pessoa)
/*     */   {
/*  97 */     this.mbMovimento.entradaMovimento(pessoa);
/*  98 */     return this.mbMovimento.limpMovimento();
/*     */   }
/*     */ 
/*     */   private void insertPessoa() {
/* 102 */     pessoaDAO().save(this.pessoa);
/*     */ 
/* 104 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Gravação efetuada com sucesso", ""));
/*     */   }
/*     */ 
/*     */   public String atualizaPessoa()
/*     */   {
/* 109 */     updatePessoa();
/* 110 */     this.pessoa = new Pessoa();
/* 111 */     return "/restrict/consultarpessoas.faces";
/*     */   }
/*     */ 
/*     */   private void updatePessoa() {
/* 115 */     pessoaDAO().update(this.pessoa);
/* 116 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Atualização efetuada com sucesso", ""));
/*     */   }
/*     */ 
/*     */   public void deletePessoa()
/*     */   {
/* 121 */     pessoaDAO().remove(this.pessoa);
/* 122 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Remoção efetuada com sucesso", ""));
/*     */   }
/*     */ 
/*     */   public List<Pessoa> getPessoas()
/*     */   {
/* 128 */     this.pessoas = pessoaDAO().getListByCriteriaOrderAsc("nome");
/* 129 */     return this.pessoas;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoa() {
/* 133 */     return this.pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoa(Pessoa pessoa) {
/* 137 */     this.pessoa = pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoas(List<Pessoa> pessoas) {
/* 141 */     this.pessoas = pessoas;
/*     */   }
/*     */ 
/*     */   public String getFoto() {
/* 145 */     return this.foto;
/*     */   }
/*     */ 
/*     */   public void setFoto(String foto) {
/* 149 */     this.foto = foto;
/*     */   }
/*     */ 
/*     */   public Acesso getAcesso() {
/* 153 */     return this.acesso;
/*     */   }
/*     */ 
/*     */   public void setAcesso(Acesso acesso) {
/* 157 */     this.acesso = acesso;
/*     */   }
/*     */ 
/*     */   public MbMovimento getMbMovimento() {
/* 161 */     return this.mbMovimento;
/*     */   }
/*     */ 
/*     */   public void setMbMovimento(MbMovimento mbMovimento) {
/* 165 */     this.mbMovimento = mbMovimento;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoaSelecionada() {
/* 169 */     return this.pessoaSelecionada;
/*     */   }
/*     */ 
/*     */   public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
/* 173 */     this.pessoaSelecionada = pessoaSelecionada;
/*     */   }
/*     */ 
/*     */   public List<Pessoa> completePessoa() {
/* 177 */     return pessoaDAO().getEntities();
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbPessoa
 * JD-Core Version:    0.6.0
 */