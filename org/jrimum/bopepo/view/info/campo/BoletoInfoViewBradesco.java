/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
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
/*    */ 
/*    */ public class BoletoInfoViewBradesco
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   BoletoInfoViewBradesco(ResourceBundle resourceBundle, Boleto boleto) {
/* 48 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcLocalPagamento() {
/* 53 */     String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
/* 54 */     return StringUtils.isBlank(textoFcLocalPagamento) ? "Pagável Preferencialmente na rede Bradesco ou no Bradesco expresso" : textoFcLocalPagamento;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 59 */     Agencia agencia = getBoleto().getTitulo().getContaBancaria().getAgencia();
/* 60 */     NumeroDaConta numeroDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta();
/*    */     
/* 62 */     return StringUtils.leftPad(agencia.getCodigo().toString(), 4, "0") + "-" + agencia.getDigitoVerificador() + " / " + StringUtils.leftPad(numeroDaConta.getCodigoDaConta().toString(), 7, "0") + "-" + numeroDaConta.getDigitoDaConta();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextoRsAgenciaCodigoCedente() {
/* 71 */     return getTextoFcAgenciaCodigoCedente();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcNossoNumero() {
/* 76 */     Carteira carteira = getBoleto().getTitulo().getContaBancaria().getCarteira();
/* 77 */     return StringUtils.leftPad(carteira.getCodigo().toString(), 2, "0") + "/" + getBoleto().getTitulo().getNossoNumero() + "-" + getBoleto().getTitulo().getDigitoDoNossoNumero();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextoRsNossoNumero() {
/* 85 */     return getTextoFcNossoNumero();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoViewBradesco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */