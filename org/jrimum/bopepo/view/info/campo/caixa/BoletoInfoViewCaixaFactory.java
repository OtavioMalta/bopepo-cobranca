/*    */ package org.jrimum.bopepo.view.info.campo.caixa;
/*    */ 
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.BoletoInfoCampoView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCaixaFactory
/*    */ {
/*    */   private static final int NN10 = 10;
/*    */   private static final int NN14 = 14;
/*    */   private static final int NN15 = 15;
/*    */   private static final int NN17 = 17;
/*    */   
/*    */   public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
/* 19 */     String nossoNumero = boleto.getTitulo().getNossoNumero();
/* 20 */     switch (nossoNumero.length()) {
/*    */       case 10:
/* 22 */         return (BoletoInfoCampoView)new BoletoInfoViewCaixaSICOB10(resourceBundle, boleto);
/* 23 */       case 14: return (BoletoInfoCampoView)new BoletoInfoViewCaixaSICOB14(resourceBundle, boleto);
/* 24 */       case 15: return (BoletoInfoCampoView)new BoletoInfoViewCaixaSIGCB(resourceBundle, boleto);
/* 25 */       case 17: return (BoletoInfoCampoView)new BoletoInfoViewCaixaSINCO(resourceBundle, boleto);
/*    */     } 
/*    */     
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\caixa\BoletoInfoViewCaixaFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */