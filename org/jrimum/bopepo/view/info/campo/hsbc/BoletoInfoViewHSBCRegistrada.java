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
/*    */ public class BoletoInfoViewHSBCRegistrada
/*    */   extends AbstractBoletoInfoViewHSBC
/*    */ {
/*    */   public BoletoInfoViewHSBCRegistrada(ResourceBundle resourceBundle, Boleto boleto) {
/* 16 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 21 */     String agencia = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo().toString(), 4, "0");
/* 22 */     String conta = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
/* 23 */     return agencia + conta;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoRsAgenciaCodigoCedente() {
/* 28 */     return getTextoFcAgenciaCodigoCedente();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcEspecieDocumento() {
/* 33 */     return "PD";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAceite() {
/* 38 */     return "NÃO";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 43 */     return "CSB";
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\hsbc\BoletoInfoViewHSBCRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */