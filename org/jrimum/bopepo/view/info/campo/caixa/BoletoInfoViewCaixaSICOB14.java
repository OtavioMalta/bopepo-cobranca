/*    */ package org.jrimum.bopepo.view.info.campo.caixa;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.parametro.ParametroCaixaEconomicaFederal;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView;
/*    */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*    */ import org.jrimum.utilix.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCaixaSICOB14
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   private static final int CODIGO_OPERACAO_PADRAO = 870;
/*    */   
/*    */   public BoletoInfoViewCaixaSICOB14(ResourceBundle resourceBundle, Boleto boleto) {
/* 22 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 27 */     return "SR";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcAgenciaCodigoCedente() {
/* 32 */     Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
/* 33 */     Integer codigoOperacao = getCodigoOperacao();
/* 34 */     Integer codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
/* 35 */     String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
/*    */     
/* 37 */     return String.format("%04d.%03d.%08d-%s", new Object[] { agencia, codigoOperacao, codigoBeneficiario, digitoDaConta });
/*    */   }
/*    */   
/*    */   private Integer getCodigoOperacao() {
/* 41 */     Titulo titulo = getBoleto().getTitulo();
/* 42 */     Integer codigoOperacao = Integer.valueOf(870);
/*    */     
/* 44 */     if (titulo.hasParametrosBancarios() && Objects.isNotNull(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroCaixaEconomicaFederal.CODIGO_OPERACAO))) {
/* 45 */       codigoOperacao = (Integer)titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
/*    */     }
/*    */     
/* 48 */     return codigoOperacao;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcLocalPagamento() {
/* 53 */     String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
/* 54 */     return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\caixa\BoletoInfoViewCaixaSICOB14.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */