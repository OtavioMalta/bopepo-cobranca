/*    */ package org.jrimum.bopepo.campolivre;
/*    */ 
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
/*    */ abstract class AbstractCLSantander
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = 1882819688182515282L;
/*    */   
/*    */   protected AbstractCLSantander(Integer fieldsLength) {
/* 33 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) {
/* 38 */     return new CLBancoSantander(titulo);
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLSantander.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */