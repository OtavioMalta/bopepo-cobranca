/*    */ package org.jrimum.bopepo.campolivre;
/*    */ 
/*    */ import org.jrimum.bopepo.parametro.ParametroCECRED;
/*    */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*    */ import org.jrimum.texgit.type.Field;
/*    */ import org.jrimum.texgit.type.Filler;
/*    */ import org.jrimum.texgit.type.component.Fillers;
/*    */ import org.jrimum.texgit.type.component.FixedField;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CLCecred
/*    */   extends AbstractCLBancoDeBrasilia
/*    */ {
/*    */   private static final long serialVersionUID = 7075964070090557563L;
/* 35 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(3);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 40 */   private static final Integer CONVENIO_LENGTH = Integer.valueOf(6);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(17);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   private static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected CLCecred() {
/* 60 */     super(FIELDS_LENGTH);
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
/*    */   protected void checkValues(Titulo titulo) {
/* 73 */     checkParametroBancario(titulo, (ParametroBancario<?>)ParametroCECRED.CODIGO_DO_CONVENIO);
/* 74 */     checkParametroBancarioMenorOuIgualQue(titulo, (ParametroBancario<?>)ParametroCECRED.CODIGO_DO_CONVENIO, 999999);
/* 75 */     checkNossoNumero(titulo);
/* 76 */     checkTamanhoDoNossoNumero(titulo, 17);
/* 77 */     checkCarteiraNotNull(titulo);
/* 78 */     checkCodigoDaCarteira(titulo);
/* 79 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
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
/*    */   protected void addFields(Titulo titulo) {
/* 92 */     add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroCECRED.CODIGO_DO_CONVENIO), CONVENIO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 93 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 94 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLCecred.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */