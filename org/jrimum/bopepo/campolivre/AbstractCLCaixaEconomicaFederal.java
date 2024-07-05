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
/*    */ 
/*    */ 
/*    */ abstract class AbstractCLCaixaEconomicaFederal
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = -4104858478390595830L;
/*    */   
/*    */   protected AbstractCLCaixaEconomicaFederal(Integer fieldsLength) {
/* 68 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/* 73 */     checkNossoNumero(titulo);
/*    */     
/* 75 */     switch (titulo.getNossoNumero().length()) {
/*    */       case 10:
/* 77 */         return new CLCaixaEconomicaFederalSICOBNossoNumero10(titulo);
/*    */       case 14:
/* 79 */         return (new CLCaixaEconomicaFederalSICOBNossoNumero14()).build(titulo);
/*    */       case 15:
/* 81 */         return new CLCaixaEconomicaFederalSIGCB(titulo);
/*    */       case 17:
/* 83 */         return new CLCaixaEconomicaFederalSINCO(titulo);
/*    */     } 
/* 85 */     throw new NotSupportedCampoLivreException(String.format("Campo Livre não suportado para o Nosso Número [%s] de tamanho [%s]. Apenas títulos com Nosso Número de tamanho [%s] são suportados (SICOB, SIGCB e SINCO respectivamente).", new Object[] { titulo.getNossoNumero(), Integer.valueOf(titulo.getNossoNumero().length()), "10,14,15,17" }));
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLCaixaEconomicaFederal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */