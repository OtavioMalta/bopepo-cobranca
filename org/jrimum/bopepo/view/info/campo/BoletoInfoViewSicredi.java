/*     */ package org.jrimum.bopepo.view.info.campo;
/*     */ 
/*     */ import org.jrimum.bopepo.Boleto;
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoSicredi;
/*     */ import org.jrimum.bopepo.view.ResourceBundle;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BoletoInfoViewSicredi
/*     */   extends AbstractBoletoInfoCampoView
/*     */ {
/*     */   BoletoInfoViewSicredi(ResourceBundle resourceBundle, Boleto boleto) {
/*  45 */     super(resourceBundle, boleto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoRsCodigoBanco() {
/*  53 */     return getTextoCodigoDoBanco();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoFcCodigoBanco() {
/*  61 */     return getTextoCodigoDoBanco();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoFcLocalPagamento() {
/*  69 */     return "Preferencialmente nas cooperativas de crédito do SICREDI";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoRsAgenciaCodigoCedente() {
/*  77 */     return getAgenciaCodigoCedente();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoFcAgenciaCodigoCedente() {
/*  85 */     return getAgenciaCodigoCedente();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoRsNossoNumero() {
/*  93 */     return getTextoNossoNumero();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoFcNossoNumero() {
/* 101 */     return getTextoNossoNumero();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextoFcAceite() {
/* 109 */     Titulo.Aceite aceite = getBoleto().getTitulo().getAceite();
/* 110 */     if (aceite == Titulo.Aceite.A) {
/* 111 */       return "SIM";
/*     */     }
/* 113 */     return "NÃO";
/*     */   }
/*     */   
/*     */   private String getAgenciaCodigoCedente() {
/* 117 */     Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
/* 118 */     Integer posto = (Integer)getBoleto().getTitulo().getParametrosBancarios().getValor((ParametroBancario)ParametroBancoSicredi.POSTO_DA_AGENCIA);
/* 119 */     Integer codigoCedente = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
/*     */     
/* 121 */     return String.format("%04d.%02d.%05d", new Object[] { agencia, posto, codigoCedente });
/*     */   }
/*     */   
/*     */   private String getTextoNossoNumero() {
/* 125 */     String nn = super.getTextoFcNossoNumero();
/* 126 */     return nn.substring(0, 2) + "/" + nn.substring(2);
/*     */   }
/*     */   
/*     */   private String getTextoCodigoDoBanco() {
/* 130 */     return super.getTextoFcCodigoBanco().replace("-0", "-X");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoViewSicredi.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */