/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoCampoCodigoBanco
/*    */ {
/*    */   public static String getTextoCodigoDoBanco(ContaBancaria conta) {
/* 49 */     String codigoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado();
/* 50 */     String digitoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getDigito().toString();
/*    */     
/* 52 */     return codigoCompensacao + "-" + digitoCompensacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoCodigoBanco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */