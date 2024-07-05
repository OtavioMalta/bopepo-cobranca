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
/*    */ public abstract class AbstractCLBancoDeBrasilia
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = 3200353843356508888L;
/*    */   
/*    */   protected AbstractCLBancoDeBrasilia(Integer fieldsLength) {
/* 55 */     super(fieldsLength);
/*    */   }
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) {
/* 59 */     return (new CLBancoDeBrasilia()).build(titulo);
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoDeBrasilia.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */