/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import org.jrimum.bopepo.BancosSuportados;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
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
/*    */ public class BoletoInfoCampoLogoBanco
/*    */ {
/*    */   public static Image getImagemBanco(ResourceBundle resourceBundle, ContaBancaria conta) {
/* 49 */     if (Objects.isNotNull(conta.getBanco().getImgLogo())) {
/* 50 */       return conta.getBanco().getImgLogo();
/*    */     }
/*    */     
/* 53 */     if (BancosSuportados.isSuportado(conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado()))
/*    */     {
/* 55 */       conta.getBanco().setImgLogo(resourceBundle.getLogotipoDoBanco(conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado()));
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     return conta.getBanco().getImgLogo();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoLogoBanco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */