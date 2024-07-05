/*    */ package org.jrimum.bopepo.view.info.campo.caixa;
/*    */ 
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.parametro.ParametroCaixaEconomicaFederal;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView;
/*    */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
/*    */ import org.jrimum.utilix.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCaixaSICOB10
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   public BoletoInfoViewCaixaSICOB10(ResourceBundle resourceBundle, Boleto boleto) {
/* 21 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 26 */     String textoCarteira = "";
/* 27 */     Carteira carteira = getBoleto().getTitulo().getContaBancaria().getCarteira();
/* 28 */     if (Objects.isNotNull(carteira) && Objects.isNotNull(carteira.getTipoCobranca())) {
/* 29 */       textoCarteira = carteira.getTipoCobranca().equals(TipoDeCobranca.COM_REGISTRO) ? "CR" : "SR";
/*    */     }
/* 31 */     return textoCarteira;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 36 */     Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
/* 37 */     Integer codigoOperacao = (Integer)getBoleto().getTitulo().getParametrosBancarios().getValor((ParametroBancario)ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
/* 38 */     Integer codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
/* 39 */     String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
/*    */     
/* 41 */     return String.format("%04d.%03d.%08d-%s", new Object[] { agencia, codigoOperacao, codigoBeneficiario, digitoDaConta });
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\caixa\BoletoInfoViewCaixaSICOB10.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */