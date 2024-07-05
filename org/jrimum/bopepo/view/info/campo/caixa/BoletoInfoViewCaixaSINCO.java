/*    */ package org.jrimum.bopepo.view.info.campo.caixa;
/*    */ 
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoViewCaixaSINCO
/*    */   extends AbstractBoletoInfoCampoView
/*    */ {
/*    */   private static final String CARTEIRA_SINCO = "01";
/*    */   private static final int CONSTANTE_NOSSO_NUMERO = 9;
/*    */   
/*    */   BoletoInfoViewCaixaSINCO(ResourceBundle resourceBundle, Boleto boleto) {
/* 18 */     super(resourceBundle, boleto);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcNossoNumero() {
/* 23 */     return '\t' + super.getTextoFcNossoNumero();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextoFcCarteira() {
/* 28 */     return "01";
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\caixa\BoletoInfoViewCaixaSINCO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */