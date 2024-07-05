/*    */ package org.jrimum.bopepo.view.info.campo;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCecred
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   BoletoInfoViewCecred(ResourceBundle resourceBundle, Boleto boleto) {
/* 44 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcLocalPagamento() {
/* 49 */     String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
/* 50 */     return StringUtils.isBlank(textoFcLocalPagamento) ? "PAGAVEL PREFERENCIALMENTE NAS COOPERATIVAS DO SISTEMA CECRED." : textoFcLocalPagamento;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextoRsAgenciaCodigoCedente() {
/* 58 */     return getAgenciaCodigoCedente();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 66 */     return getAgenciaCodigoCedente();
/*    */   }
/*    */   
/*    */   private String getAgenciaCodigoCedente() {
/* 70 */     Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
/* 71 */     String agDv = getBoleto().getTitulo().getContaBancaria().getAgencia().getDigitoVerificador();
/* 72 */     Integer numeroDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
/* 73 */     String contaDv = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
/*    */     
/* 75 */     return String.format("%04d-%s / %07d-%s", new Object[] { agencia, agDv, numeroDaConta, contaDv });
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoViewCecred.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */