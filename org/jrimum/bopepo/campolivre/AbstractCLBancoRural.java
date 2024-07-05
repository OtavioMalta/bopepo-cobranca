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
/*    */ abstract class AbstractCLBancoRural
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = -602454445158254612L;
/*    */   
/*    */   protected AbstractCLBancoRural(Integer fieldsLength) {
/* 35 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) {
/* 40 */     checkCarteiraNotNull(titulo);
/* 41 */     checkRegistroDaCarteiraNotNull(titulo);
/*    */     
/* 43 */     switch (titulo.getContaBancaria().getCarteira().getTipoCobranca()) {
/*    */       case SEM_REGISTRO:
/* 45 */         return campoSemRegistro(titulo);
/*    */       case COM_REGISTRO:
/* 47 */         return new CLBancoRuralCobrancaRegistrada(titulo);
/*    */     } 
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static CampoLivre campoSemRegistro(Titulo titulo) {
/* 62 */     checkNossoNumero(titulo);
/*    */     
/* 64 */     switch (titulo.getNossoNumero().length()) {
/*    */       case 10:
/* 66 */         return new CLBancoRuralCobrancaNaoRegistradaSeguradora(titulo);
/*    */       case 15:
/* 68 */         return new CLBancoRuralCobrancaNaoRegistrada(titulo);
/*    */     } 
/* 70 */     throw new NotSupportedCampoLivreException("Combrança sem registro com campo livre diponível somente para títulos com nosso número composto por 10 posições(apólice de seguro com I.O.S.) e 15 posições(padrão).");
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoRural.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */