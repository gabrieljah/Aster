/*    */ package br.com.aster.conversores;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ 
/*    */ @FacesConverter("converterSHA1")
/*    */ public class ConverterSHA1
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext context, UIComponent component, String value)
/*    */   {
/* 23 */     return cipher(value);
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext context, UIComponent component, Object value)
/*    */   {
/* 28 */     return value.toString();
/*    */   }
/*    */ 
/*    */   public static String cipher(String value) {
/* 32 */     String algorithm = "SHA1";
/* 33 */     byte[] buffer = value.getBytes();
/*    */     try
/*    */     {
/* 36 */       MessageDigest md = MessageDigest.getInstance(algorithm);
/* 37 */       md.update(buffer);
/* 38 */       byte[] digest = md.digest();
/* 39 */       String hexValue = "";
/* 40 */       for (int i = 0; i < digest.length; i++) {
/* 41 */         int b = digest[i] & 0xFF;
/* 42 */         if (Integer.toHexString(b).length() == 1) {
/* 43 */           hexValue = hexValue + "0";
/*    */         }
/* 45 */         hexValue = hexValue + Integer.toHexString(b);
/*    */       }
/* 47 */       return hexValue;
/*    */     } catch (NoSuchAlgorithmException ex) {
/* 49 */       Logger.getLogger(ConverterSHA1.class.getName()).log(Level.SEVERE, null, ex);
/* 50 */     }return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.conversores.ConverterSHA1
 * JD-Core Version:    0.6.0
 */