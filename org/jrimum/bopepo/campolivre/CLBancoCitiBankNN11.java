/*    */ package org.jrimum.bopepo.campolivre;
/*    */ 
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
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
/*    */ class CLBancoCitiBankNN11
/*    */   extends AbstractCLBancoDoBrasil
/*    */ {
/*    */   private static final long serialVersionUID = -7675528811239346517L;
/* 46 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*    */ 
/*    */ 
/*    */   
/*    */   CLBancoCitiBankNN11(Titulo titulo) {
/* 51 */     super(FIELDS_LENGTH);
/* 52 */     ContaBancaria conta = titulo.getContaBancaria();
/* 53 */     String nossoNumero = titulo.getNossoNumero();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addFields(Titulo titulo) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void checkValues(Titulo titulo) {
/* 70 */     throw new UnsupportedOperationException("AINDA NÃƒO IMPLEMENTADO!");
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoCitiBankNN11.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */