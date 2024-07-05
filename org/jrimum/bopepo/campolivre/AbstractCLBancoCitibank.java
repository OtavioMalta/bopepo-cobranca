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
/*    */ abstract class AbstractCLBancoCitibank
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = 6080749970883991308L;
/*    */   
/*    */   protected AbstractCLBancoCitibank(Integer fieldsLength) {
/* 59 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/* 69 */     checkNossoNumero(titulo);
/* 70 */     checkNumeroDaContaNotNull(titulo);
/* 71 */     checkCodigoDoNumeroDaConta(titulo);
/* 72 */     checkNossoNumero(titulo);
/* 73 */     checkNumeroDaContaNotNull(titulo);
/* 74 */     checkCodigoDoNumeroDaConta(titulo);
/* 75 */     switch (titulo.getNossoNumero().length()) {
/*    */       
/*    */       case 11:
/* 78 */         return new CLBancoCitiBankNN11(titulo);
/*    */     } 
/* 80 */     throw new NotSupportedCampoLivreException("Campo livre diponivel somente para titulos com nosso nmero composto por 10 posicoes(convenio com 7), 11 posicoes ou 17 posicoes(convenio com 6).");
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoCitibank.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */