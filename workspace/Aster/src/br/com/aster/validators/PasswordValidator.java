/*    */ package br.com.aster.validators;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.validator.FacesValidator;
/*    */ import javax.faces.validator.Validator;
/*    */ import javax.faces.validator.ValidatorException;
/*    */ 
/*    */ @FacesValidator("passwordValidator")
/*    */ public class PasswordValidator
/*    */   implements Validator
/*    */ {
/* 18 */   int num = 0;
/* 19 */   int carac = 0;
/*    */ 
/* 22 */   char[] caracteresEspeciais = { '=', '|', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', ';', ':', '.', ',', '<', '>', '?', '~', '+', '-', '_', '\'', '"' };
/*    */ 
/*    */   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
/*    */   {
/* 26 */     if (value == null) {
/* 27 */       return;
/*    */     }
/*    */ 
/* 30 */     String password = (String)value;
/*    */ 
/* 34 */     for (int i = 0; i < password.length(); i++) {
/* 35 */       if ((password.charAt(i) >= '0') && (password.charAt(i) <= '9')) {
/* 36 */         this.num += 1;
/*    */       }
/*    */     }
/* 39 */     System.out.println("Foram encontrados " + this.num + " numeros na senha!");
/*    */ 
/* 43 */     for (int i = 0; i < password.length(); i++) {
/* 44 */       for (int j = 0; j < this.caracteresEspeciais.length; j++) {
/* 45 */         if (password.charAt(i) == this.caracteresEspeciais[j]) {
/* 46 */           this.carac += 1;
/*    */         }
/*    */       }
/*    */     }
/* 50 */     System.out.println("Foram encontrados " + this.carac + " caracteres especias na senha!");
/*    */ 
/* 53 */     if ((password == null) || (password.equals(""))) {
/* 54 */       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha não pode ser nula!", ""));
/*    */     }
/*    */ 
/* 58 */     if ((this.carac <= 0) || (this.num <= 0)) {
/* 59 */       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha deve conter números, caracteres especiais e letras!", ""));
/*    */     }
/*    */ 
/* 63 */     if (password.length() < 7) {
/* 64 */       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha deve ter no mínimo 7 caracteres!", ""));
/*    */     }
/* 66 */     if (password.length() >= 22)
/* 67 */       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha deve ter no máximo 22 caracteres!!!", ""));
/*    */   }
/*    */ }

/* Location:           C:\Users\gabriel\Documents\NetBeansProjects\WEB-INF\classes\
 * Qualified Name:     br.com.aster.validators.PasswordValidator
 * JD-Core Version:    0.6.0
 */