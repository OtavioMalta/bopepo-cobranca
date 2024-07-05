/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
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
/*    */ public class BoletoInfoCampoNossoNumero
/*    */ {
/*    */   public static String getTextoNossoNumero(Titulo titulo) {
/* 54 */     StringBuilder texto = new StringBuilder("");
/*    */     
/* 56 */     if (StringUtils.isNotBlank(titulo.getNossoNumero())) {
/* 57 */       texto.append(titulo.getNossoNumero());
/*    */       
/* 59 */       if (StringUtils.isNotBlank(titulo.getDigitoDoNossoNumero())) {
/* 60 */         texto.append("-" + titulo.getDigitoDoNossoNumero());
/*    */       }
/*    */     } 
/*    */     
/* 64 */     return texto.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoNossoNumero.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */