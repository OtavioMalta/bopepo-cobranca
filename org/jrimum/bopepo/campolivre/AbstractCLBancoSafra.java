/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
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
/*     */ abstract class AbstractCLBancoSafra
/*     */   extends AbstractCampoLivre
/*     */ {
/*     */   private static final long serialVersionUID = -555393808447532987L;
/*     */   
/*     */   protected enum TipoDeCobranca
/*     */   {
/*  68 */     BOLETO_EMITIDO_PELO_BANCO,
/*     */ 
/*     */ 
/*     */     
/*  72 */     DIRETA_BOLETO_EMITIDO_PELO_CLIENTE,
/*     */ 
/*     */ 
/*     */     
/*  76 */     EXPRESS_BOLETO_EMITIDO_PELO_CLIENTE;
/*     */     
/*     */     public int codigo() {
/*  79 */       switch (this) {
/*     */         case COM_REGISTRO:
/*  81 */           return 1;
/*     */         case SEM_REGISTRO:
/*  83 */           return 2;
/*     */         case null:
/*  85 */           return 4;
/*     */       } 
/*  87 */       return ((Integer)Exceptions.throwIllegalStateException(String.format("Tipo \"%s\" sem código atribuído!", new Object[] { this }))).intValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private static final Integer CONSTANT_LENGTH_SISTEMA = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   private static final Integer CONSTANT_VALUE_SISTEMA = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   protected static final FixedField<Integer> SISTEMA_CONSTANT_FIELD = new FixedField(CONSTANT_VALUE_SISTEMA, CONSTANT_LENGTH_SISTEMA);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   protected static final Integer TIPO_COBRANCA_FIELD_LENGTH = Integer.valueOf(1);
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
/*     */   protected AbstractCLBancoSafra(Integer fieldsLength) {
/* 131 */     super(fieldsLength);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/* 137 */     checkCarteiraNotNull(titulo);
/* 138 */     checkRegistroDaCarteiraNotNull(titulo);
/*     */     
/* 140 */     switch (titulo.getContaBancaria().getCarteira().getTipoCobranca()) {
/*     */       case COM_REGISTRO:
/* 142 */         return (new CLBancoSafraCobrancaRegistrada()).build(titulo);
/*     */       case SEM_REGISTRO:
/* 144 */         return (new CLBancoSafraCobrancaNaoRegistrada()).build(titulo);
/*     */     } 
/* 146 */     throw new NotSupportedCampoLivreException("Campo livre diponível somente para títulos com carteiras com tipo de cobrança COM_REGISTRO ou SEM_REGISTRO.");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBancoSafra.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */