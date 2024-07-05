/*    */ package org.jrimum.bopepo.campolivre;
/*    */ 
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*    */ import org.jrimum.vallia.digitoverificador.Modulo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class AbstractCLUnibanco
/*    */   extends AbstractCampoLivre
/*    */ {
/*    */   private static final long serialVersionUID = -6169577742706045367L;
/*    */   
/*    */   protected AbstractCLUnibanco(Integer fieldsLength) {
/* 22 */     super(fieldsLength);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/* 27 */     checkCarteiraNotNull(titulo);
/* 28 */     checkRegistroDaCarteiraNotNull(titulo);
/*    */     
/* 30 */     switch (titulo.getContaBancaria().getCarteira().getTipoCobranca()) {
/*    */       case SEM_REGISTRO:
/* 32 */         return new CLUnibancoCobrancaNaoRegistrada(titulo);
/*    */       case COM_REGISTRO:
/* 34 */         return new CLUnibancoCobrancaRegistrada(titulo);
/*    */     } 
/* 36 */     return null;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   String calculeDigitoEmModulo11(String numero) {
/* 54 */     String dv = "";
/*    */     
/* 56 */     int soma = Modulo.calculeSomaSequencialMod11(numero, 2, 9);
/*    */     
/* 58 */     soma *= 10;
/*    */     
/* 60 */     int resto = soma % 11;
/*    */     
/* 62 */     if (resto == 10 || resto == 0) {
/* 63 */       dv = "0";
/*    */     } else {
/* 65 */       dv = "" + resto;
/*    */     } 
/* 67 */     return dv;
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLUnibanco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */