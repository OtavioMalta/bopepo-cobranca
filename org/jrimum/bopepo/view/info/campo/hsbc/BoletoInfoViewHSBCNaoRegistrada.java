/*    */ package org.jrimum.bopepo.view.info.campo.hsbc;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewHSBCNaoRegistrada
/*    */   extends AbstractBoletoInfoViewHSBC
/*    */ {
/*    */   public BoletoInfoViewHSBCNaoRegistrada(ResourceBundle resourceBundle, Boleto boleto) {
/* 17 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 22 */     return StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoRsAgenciaCodigoCedente() {
/* 27 */     return getTextoFcAgenciaCodigoCedente();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcEspecieDocumento() {
/* 32 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAceite() {
/* 37 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 42 */     return "CNR";
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\hsbc\BoletoInfoViewHSBCNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */