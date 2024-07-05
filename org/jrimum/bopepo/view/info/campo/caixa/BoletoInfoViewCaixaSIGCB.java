/*    */ package org.jrimum.bopepo.view.info.campo.caixa;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCaixaSIGCB
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   private static final String EMISSAO_BENEFICIARIO = "4";
/*    */   
/*    */   BoletoInfoViewCaixaSIGCB(ResourceBundle resourceBundle, Boleto boleto) {
/* 19 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcNossoNumero() {
/* 24 */     return getBoleto().getTitulo().getContaBancaria().getCarteira().getCodigo() + "4" + super.getTextoFcNossoNumero();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 31 */     return getBoleto().getTitulo().getContaBancaria().getCarteira().isComRegistro() ? "RG" : "SR";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcLocalPagamento() {
/* 36 */     String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
/* 37 */     return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\caixa\BoletoInfoViewCaixaSIGCB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */