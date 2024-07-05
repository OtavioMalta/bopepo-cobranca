/*    */ package org.jrimum.bopepo.view.info.campo.hsbc;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView;
/*    */ import org.jrimum.bopepo.view.info.campo.BoletoInfoCampoView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AbstractBoletoInfoViewHSBC
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
/* 18 */     if (boleto.getTitulo().getContaBancaria().getCarteira().isComRegistro()) {
/* 19 */       return (BoletoInfoCampoView)new BoletoInfoViewHSBCRegistrada(resourceBundle, boleto);
/*    */     }
/* 21 */     return (BoletoInfoCampoView)new BoletoInfoViewHSBCNaoRegistrada(resourceBundle, boleto);
/*    */   }
/*    */   
/*    */   public AbstractBoletoInfoViewHSBC(ResourceBundle resourceBundle, Boleto boleto) {
/* 25 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcLocalPagamento() {
/* 30 */     String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
/* 31 */     return StringUtils.isBlank(textoFcLocalPagamento) ? "PAGAR PREFERENCIALMENTE EM AGÊNCIA DO HSBC" : textoFcLocalPagamento;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 36 */     return StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcNossoNumero() {
/* 41 */     return getBoleto().getTitulo().getNossoNumero() + getBoleto().getTitulo().getDigitoDoNossoNumero();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoRsNossoNumero() {
/* 46 */     return getTextoFcNossoNumero();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\hsbc\AbstractBoletoInfoViewHSBC.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */