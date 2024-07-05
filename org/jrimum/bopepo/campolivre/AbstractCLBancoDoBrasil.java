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
/*    */ abstract class AbstractCLBancoDoBrasil
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = -7324315662526104153L;
/*    */   
/*    */   protected AbstractCLBancoDoBrasil(Integer fieldsLength) {
/* 66 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/* 71 */     checkNossoNumero(titulo);
/* 72 */     checkNumeroDaContaNotNull(titulo);
/* 73 */     checkCodigoDoNumeroDaConta(titulo);
/*    */     
/* 75 */     switch (titulo.getNossoNumero().length()) {
/*    */       case 10:
/* 77 */         return new CLBancoDoBrasilNN10(titulo);
/*    */       case 11:
/* 79 */         return new CLBancoDoBrasilNN11(titulo);
/*    */       case 17:
/* 81 */         if (titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta().intValue() < 1000000) {
/* 82 */           return new CLBancoDoBrasilNN17Convenio6(titulo);
/*    */         }
/* 84 */         return (new CLBancoDoBrasilNN17Convenio7()).build(titulo);
/*    */     } 
/*    */     
/* 87 */     throw new NotSupportedCampoLivreException("Campo livre diponível somente para títulos com nosso número composto por 10 posições(convênio com 7), 11 posições ou 17 posições(convênio com 6).");
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoDoBrasil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */