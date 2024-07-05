/*    */ package org.jrimum.bopepo.campolivre;
/*    */ 
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class AbstractCLHSBC
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = 3179450500491723317L;
/*    */   
/*    */   protected AbstractCLHSBC(Integer fieldsLength) {
/* 66 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) {
/* 71 */     checkCarteiraNotNull(titulo);
/* 72 */     checkRegistroDaCarteiraNotNull(titulo);
/*    */     
/* 74 */     switch (titulo.getContaBancaria().getCarteira().getTipoCobranca()) {
/*    */       case SEM_REGISTRO:
/* 76 */         return new CLHSBCCobrancaNaoRegistrada(titulo);
/*    */       case COM_REGISTRO:
/* 78 */         return new CLHSBCCobrancaRegistrada(titulo);
/*    */     } 
/* 80 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLHSBC.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */