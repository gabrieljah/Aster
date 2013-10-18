/*    */ package br.com.aster.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.Serializable;
/*    */ import javax.faces.FacesException;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.imageio.stream.FileImageOutputStream;
/*    */ import javax.servlet.ServletContext;
/*    */ import org.primefaces.event.CaptureEvent;
/*    */ 
/*    */ @ManagedBean
/*    */ @ViewScoped
/*    */ public class PhotoCam
/*    */   implements Serializable
/*    */ {
/*    */   private String nome;
/*    */   private int edad;
/*    */   private String foto;
/*    */ 
/*    */   public void oncapture(CaptureEvent captureEvent)
/*    */   {
/* 27 */     byte[] datos = captureEvent.getData();
/*    */ 
/* 29 */     ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
/*    */ 
/* 31 */     this.foto = "foto.png";
/*    */ 
/* 33 */     String fileFoto = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + this.foto;
/*    */ 
/* 35 */     FileImageOutputStream outputStream = null;
/*    */     try {
/* 37 */       outputStream = new FileImageOutputStream(new File(fileFoto));
/*    */ 
/* 39 */       outputStream.write(datos, 0, datos.length);
/*    */     } catch (IOException e) {
/* 41 */       throw new FacesException("Error guardando la foto.", e);
/*    */     } finally {
/*    */       try {
/* 44 */         outputStream.close();
/*    */       }
/*    */       catch (IOException e) {
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void guardarDatos() {
/*    */   }
/*    */ 
/*    */   public String getFoto() {
/* 55 */     return this.foto;
/*    */   }
/*    */ 
/*    */   public boolean isVerFoto() {
/* 59 */     return this.foto != null;
/*    */   }
/*    */ 
/*    */   public String getNome() {
/* 63 */     return this.nome;
/*    */   }
/*    */ 
/*    */   public void setNome(String nome) {
/* 67 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   public int getEdad() {
/* 71 */     return this.edad;
/*    */   }
/*    */ 
/*    */   public void setEdad(int edad) {
/* 75 */     this.edad = edad;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.util.PhotoCam
 * JD-Core Version:    0.6.0
 */