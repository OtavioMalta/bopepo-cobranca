/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.vallia.digitoverificador.Modulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractCLItau
/*     */   extends AbstractCampoLivre
/*     */ {
/*     */   private static final long serialVersionUID = -3082903872777434482L;
/*  67 */   private static final Set<Integer> CARTEIRAS_ESPECIAIS = new HashSet<Integer>(8);
/*     */ 
/*     */   
/*     */   static {
/*  71 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(106));
/*  72 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(107));
/*  73 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(122));
/*  74 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(142));
/*  75 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(143));
/*  76 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(195));
/*  77 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(196));
/*  78 */     CARTEIRAS_ESPECIAIS.add(Integer.valueOf(198));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCLItau(Integer fieldsLength) {
/*  90 */     super(fieldsLength);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static CampoLivre create(Titulo titulo) {
/*  95 */     checkCarteiraNotNull(titulo);
/*  96 */     checkCodigoDaCarteira(titulo);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (CARTEIRAS_ESPECIAIS.contains(titulo.getContaBancaria().getCarteira().getCodigo()))
/*     */     {
/* 103 */       return new CLItauComCarteirasEspeciais(titulo);
/*     */     }
/*     */ 
/*     */     
/* 107 */     return new CLItauPadrao(titulo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Integer calculeDigitoVerificador(String campo) {
/* 128 */     int restoDivisao = Modulo.calculeMod10(campo, 1, 2);
/* 129 */     int digito = Modulo.MOD10 - restoDivisao;
/*     */     
/* 131 */     if (digito > 9) {
/* 132 */       digito = 0;
/*     */     }
/*     */     
/* 135 */     return new Integer(digito);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLItau.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */