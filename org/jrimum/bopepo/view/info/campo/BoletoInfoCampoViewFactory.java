/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.jrimum.bopepo.BancosSuportados;
/*    */ import org.jrimum.bopepo.Boleto;
/*    */ import org.jrimum.bopepo.view.ResourceBundle;
/*    */ import org.jrimum.bopepo.view.info.campo.caixa.BoletoInfoViewCaixaFactory;
/*    */ import org.jrimum.bopepo.view.info.campo.hsbc.AbstractBoletoInfoViewHSBC;
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
/*    */ public class BoletoInfoCampoViewFactory
/*    */ {
/*    */   public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
/* 50 */     BancosSuportados banco = (BancosSuportados)BancosSuportados.suportados.get(boleto.getTitulo().getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado());
/*    */ 
/*    */ 
/*    */     
/* 54 */     if (Objects.isNotNull(banco)) {
/* 55 */       switch (banco) { case BANCO_BRADESCO:
/* 56 */           return new BoletoInfoViewBradesco(resourceBundle, boleto);
/*    */ 
/*    */         
/*    */         case CAIXA_ECONOMICA_FEDERAL:
/* 60 */           return BoletoInfoViewCaixaFactory.create(resourceBundle, boleto);
/* 61 */         case HSBC: return AbstractBoletoInfoViewHSBC.create(resourceBundle, boleto);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         case BANCO_SICREDI:
/* 71 */           return new BoletoInfoViewSicredi(resourceBundle, boleto);
/*    */ 
/*    */         
/*    */         case CECRED:
/* 75 */           return new BoletoInfoViewCecred(resourceBundle, boleto); }
/*    */ 
/*    */     
/*    */     }
/* 79 */     return new BoletoInfoViewDefault(resourceBundle, boleto);
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoViewFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */