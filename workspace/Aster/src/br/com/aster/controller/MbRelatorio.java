/*     */ package br.com.aster.controller;
/*     */ 
/*     */ import br.com.aster.model.dao.HibernateDAO;
/*     */ import br.com.aster.model.dao.InterfaceDAO;
/*     */ import br.com.aster.model.entities.Movimento;
/*     */ import br.com.aster.model.entities.Pessoa;
/*     */ import br.com.aster.util.FacesContextUtil;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.RequestScoped;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.sf.jasperreports.engine.JRExporterParameter;
/*     */ import net.sf.jasperreports.engine.JasperFillManager;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*     */ import net.sf.jasperreports.engine.export.JRPdfExporter;
/*     */ 
/*     */ @ManagedBean
/*     */ @RequestScoped
/*     */ public class MbRelatorio
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   private Pessoa pessoa = new Pessoa();
/*     */   private List<Pessoa> pessoas;
/*  41 */   private Movimento movimento = new Movimento();
/*     */   private List<Movimento> movimentos;
/*     */   private Date of;
/*     */   private Date to;
/*     */   private String empresa;
/*     */   private String visitante;
/*     */   private Long acesso;
/*     */   private Long visitado;
/*     */   JasperPrint jasperPrint;
/*     */ 
/*     */   private InterfaceDAO<Movimento> movimentoDAO()
/*     */   {
/*  52 */     InterfaceDAO movimentoDAO = new HibernateDAO(Movimento.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  54 */     return movimentoDAO;
/*     */   }
/*     */ 
/*     */   private InterfaceDAO<Pessoa> pessoaDAO() {
/*  58 */     InterfaceDAO pessoaDAO = new HibernateDAO(Pessoa.class, FacesContextUtil.getRequestSession());
/*     */ 
/*  60 */     return pessoaDAO;
/*     */   }
/*     */ 
/*     */   public String limpRelatorio() {
/*  64 */     this.movimento = new Movimento();
/*  65 */     this.movimentos = new ArrayList();
/*  66 */     this.of = null;
/*  67 */     this.to = null;
/*  68 */     this.visitante = new String();
/*  69 */     this.empresa = new String();
/*  70 */     this.acesso = null;
/*  71 */     this.visitado = null;
/*  72 */     return "/restrict/relatorio.faces";
/*     */   }
/*     */ 
/*     */   public String chamaBusca() {
/*  76 */     ConsultaPorData();
/*  77 */     return "/restrict/relatorio.faces";
/*     */   }
/*     */ 
/*     */   public void ConsultaPorData()
/*     */   {
/*  82 */     this.movimentos = movimentoDAO().getListbyCriteriaBetween(getOf(), getTo(), getVisitante(), getEmpresa(), getAcesso(), getVisitado());
/*     */   }
/*     */ 
/*     */   public void imprimeRelatorio() throws IOException, SQLException
/*     */   {
/*  87 */     ConsultaPorData();
/*  88 */     JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(this.movimentos);
/*     */ 
/*  90 */     HashMap parameters = new HashMap();
/*     */     try
/*     */     {
/*  93 */       System.out.println("ponto 1");
/*  94 */       FacesContext facesContext = FacesContext.getCurrentInstance();
/*  95 */       System.out.println("ponto 2");
/*  96 */       facesContext.responseComplete();
/*  97 */       System.out.println("ponto 3");
/*  98 */       ServletContext scontext = (ServletContext)facesContext.getExternalContext().getContext();
/*  99 */       System.out.println("ponto 4");
/* 100 */       JasperPrint JP = JasperFillManager.fillReport(scontext.getRealPath("/relatorio/relatorio.jasper"), parameters, ds);
/* 101 */       System.out.println("ponto 5");
/* 102 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 103 */       System.out.println("ponto 6");
/* 104 */       JRPdfExporter exporter = new JRPdfExporter();
/* 105 */       System.out.println("ponto 7");
/* 106 */       exporter.setParameter(JRExporterParameter.JASPER_PRINT, JP);
/* 107 */       System.out.println("ponto 8");
/* 108 */       exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
/* 109 */       System.out.println("ponto 9");
/* 110 */       exporter.exportReport();
/*     */ 
/* 112 */       byte[] bytes = baos.toByteArray();
/*     */ 
/* 114 */       if ((bytes != null) && (bytes.length > 0))
/*     */       {
/* 116 */         HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
/* 117 */         System.out.println("ponto 10");
/* 118 */         response.setContentType("application/pdf");
/* 119 */         System.out.println("ponto 11");
/* 120 */         response.setHeader("Content-disposition", "inline; filename=\relatorioPorData.pdf\"");
/* 121 */         System.out.println("ponto 12");
/* 122 */         response.setContentLength(bytes.length);
/* 123 */         System.out.println("ponto 13");
/* 124 */         ServletOutputStream outputStream = response.getOutputStream();
/* 125 */         System.out.println("ponto 14");
/* 126 */         outputStream.write(bytes, 0, bytes.length);
/* 127 */         System.out.println("ponto 15");
/* 128 */         outputStream.flush();
/* 129 */         System.out.println("ponto 16");
/* 130 */         outputStream.close();
/* 131 */         System.out.println("ponto 17 FIM");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 136 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public Movimento getMovimento()
/*     */   {
/* 142 */     return this.movimento;
/*     */   }
/*     */ 
/*     */   public void setMovimento(Movimento movimento) {
/* 146 */     this.movimento = movimento;
/*     */   }
/*     */ 
/*     */   public List<Movimento> getMovimentos() {
/* 150 */     return this.movimentos;
/*     */   }
/*     */ 
/*     */   public void setMovimentos(List<Movimento> movimentos) {
/* 154 */     this.movimentos = movimentos;
/*     */   }
/*     */ 
/*     */   public Pessoa getPessoa() {
/* 158 */     return this.pessoa;
/*     */   }
/*     */ 
/*     */   public void setPessoa(Pessoa pessoa) {
/* 162 */     this.pessoa = pessoa;
/*     */   }
/*     */ 
/*     */   public List<Pessoa> getPessoas() {
/* 166 */     return this.pessoas;
/*     */   }
/*     */ 
/*     */   public void setPessoas(List<Pessoa> pessoas) {
/* 170 */     this.pessoas = pessoas;
/*     */   }
/*     */ 
/*     */   public Date getOf() {
/* 174 */     return this.of;
/*     */   }
/*     */ 
/*     */   public void setOf(Date of) {
/* 178 */     this.of = of;
/*     */   }
/*     */ 
/*     */   public Date getTo() {
/* 182 */     return this.to;
/*     */   }
/*     */ 
/*     */   public void setTo(Date to) {
/* 186 */     this.to = to;
/*     */   }
/*     */ 
/*     */   public Long getAcesso()
/*     */   {
/* 191 */     return this.acesso;
/*     */   }
/*     */ 
/*     */   public void setAcesso(Long acesso) {
/* 195 */     this.acesso = acesso;
/*     */   }
/*     */ 
/*     */   public String getEmpresa() {
/* 199 */     return this.empresa;
/*     */   }
/*     */ 
/*     */   public void setEmpresa(String empresa) {
/* 203 */     this.empresa = empresa;
/*     */   }
/*     */ 
/*     */   public JasperPrint getJasperPrint() {
/* 207 */     return this.jasperPrint;
/*     */   }
/*     */ 
/*     */   public void setJasperPrint(JasperPrint jasperPrint) {
/* 211 */     this.jasperPrint = jasperPrint;
/*     */   }
/*     */ 
/*     */   public String getVisitante() {
/* 215 */     return this.visitante;
/*     */   }
/*     */ 
/*     */   public void setVisitante(String visitante) {
/* 219 */     this.visitante = visitante;
/*     */   }
/*     */ 
/*     */   public Long getVisitado() {
/* 223 */     return this.visitado;
/*     */   }
/*     */ 
/*     */   public void setVisitado(Long visitado) {
/* 227 */     this.visitado = visitado;
/*     */   }
/*     */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.controller.MbRelatorio
 * JD-Core Version:    0.6.0
 */