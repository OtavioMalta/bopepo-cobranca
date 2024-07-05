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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractCLBancoDoNordesteDoBrasil
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = -5036970456320987443L;
/*    */   
/*    */   protected AbstractCLBancoDoNordesteDoBrasil(Integer fieldsLength) {
/* 40 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) {
/* 50 */     return (new CLBancoDoNordesteDoBrasil()).build(titulo);
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoDoNordesteDoBrasil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */