/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*    */ import org.jrimum.utilix.Objects;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoCampoAgenciaCodigoCedente
/*    */ {
/*    */   public static String getTextoAgenciaCodigoCedente(ContaBancaria conta) {
/* 55 */     StringBuilder texto = new StringBuilder("");
/* 56 */     boolean temAgencia = false;
/*    */ 
/*    */     
/* 59 */     if (Objects.isNotNull(conta.getAgencia())) {
/*    */       
/* 61 */       temAgencia = true;
/*    */       
/* 63 */       if (Objects.isNotNull(conta.getAgencia().getCodigo())) {
/* 64 */         texto.append(conta.getAgencia().getCodigo());
/*    */       }
/*    */       
/* 67 */       if (StringUtils.isNotBlank(conta.getAgencia().getDigitoVerificador().toString())) {
/*    */         
/* 69 */         texto.append("-");
/* 70 */         texto.append(conta.getAgencia().getDigitoVerificador());
/*    */       } 
/*    */     } 
/*    */     
/* 74 */     if (Objects.isNotNull(conta.getNumeroDaConta())) {
/*    */       
/* 76 */       if (temAgencia) {
/* 77 */         texto.append(" / ");
/*    */       }
/*    */       
/* 80 */       if (Objects.isNotNull(conta.getNumeroDaConta().getCodigoDaConta())) {
/*    */         
/* 82 */         texto.append(conta.getNumeroDaConta().getCodigoDaConta());
/*    */         
/* 84 */         if (StringUtils.isNotBlank(conta.getNumeroDaConta().getDigitoDaConta())) {
/*    */           
/* 86 */           texto.append("-");
/* 87 */           texto.append(conta.getNumeroDaConta().getDigitoDaConta());
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 92 */     return texto.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoAgenciaCodigoCedente.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */