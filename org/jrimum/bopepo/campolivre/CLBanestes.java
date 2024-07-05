/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.vallia.digitoverificador.Modulo;
/*     */ import org.jrimum.vallia.digitoverificador.TipoDeModulo;
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
/*     */ class CLBanestes
/*     */   extends AbstractCLBanestes
/*     */ {
/*     */   private static final long serialVersionUID = 476678476727564241L;
/* 108 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */   
/*     */   public CLBanestes(Titulo titulo) {
/* 112 */     super(FIELDS_LENGTH);
/*     */     
/* 114 */     add((Field)new FixedField(Integer.valueOf(titulo.getNossoNumero()), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/* 115 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(11), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 117 */     Integer codigoDaCarteiraDeCobranca = titulo.getContaBancaria().getCarteira().getCodigo();
/*     */     
/* 119 */     if (Objects.exists(codigoDaCarteiraDeCobranca)) {
/* 120 */       add((Field)new FixedField(codigoDaCarteiraDeCobranca, Integer.valueOf(1)));
/*     */     }
/*     */     else {
/*     */       
/* 124 */       TipoDeCobranca tipoDeCobranca = titulo.getContaBancaria().getCarteira().getTipoCobranca();
/*     */       
/* 126 */       if (tipoDeCobranca == null) {
/* 127 */         throw new CampoLivreException("Tipo de cobrança da carteira não foi especificado!");
/*     */       }
/*     */       
/* 130 */       switch (tipoDeCobranca) {
/*     */         
/*     */         case SEM_REGISTRO:
/* 133 */           add((Field)new FixedField(Integer.valueOf(2), Integer.valueOf(1)));
/*     */           break;
/*     */         
/*     */         case COM_REGISTRO:
/* 137 */           if (codigoDaCarteiraDeCobranca.intValue() >= 3 && codigoDaCarteiraDeCobranca.intValue() <= 7) {
/*     */             
/* 139 */             add((Field)new FixedField(codigoDaCarteiraDeCobranca, Integer.valueOf(1)));
/*     */             
/*     */             break;
/*     */           } 
/* 143 */           throw new CampoLivreException("Código da carteira de cobrança com registro deve ser especificado com 3,4,5,6 ou 7. Valor atual = [" + codigoDaCarteiraDeCobranca + "]");
/*     */ 
/*     */         
/*     */         default:
/* 147 */           throw new CampoLivreException("Tipo de cobrança [" + tipoDeCobranca + "] não é suportado!");
/*     */       } 
/*     */     
/*     */     } 
/* 151 */     add((Field)new FixedField(Byte.valueOf(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigo().byteValue()), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 152 */     add((Field)new FixedField(Byte.valueOf(calculaDuploDV()), Integer.valueOf(2), (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte calculaDuploDV() {
/*     */     byte segundoDV;
/* 164 */     String fields = writeFields();
/*     */     
/* 166 */     byte primeiroDV = calculaPrimeiroDV(fields);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     int restoDoModulo11 = (new Modulo(TipoDeModulo.MODULO11, 7, 2)).calcule(fields + primeiroDV);
/*     */     
/* 173 */     if (restoDoModulo11 == 0) {
/* 174 */       segundoDV = 0;
/* 175 */     } else if (restoDoModulo11 == 1) {
/* 176 */       if (primeiroDV == 9) {
/* 177 */         primeiroDV = 0;
/*     */       } else {
/* 179 */         primeiroDV = (byte)(primeiroDV + 1);
/*     */       } 
/* 181 */       segundoDV = (byte)(new Modulo(TipoDeModulo.MODULO11, 7, 2)).calcule(fields + primeiroDV);
/*     */     } else {
/* 183 */       segundoDV = (byte)(11 - restoDoModulo11);
/*     */     } 
/*     */     
/* 186 */     byte duploDV = Byte.parseByte(String.valueOf(primeiroDV) + String.valueOf(segundoDV));
/*     */     
/* 188 */     return duploDV;
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
/*     */   private byte calculaPrimeiroDV(String fields) {
/* 202 */     byte restoDoModulo10 = (byte)(new Modulo(TipoDeModulo.MODULO10)).calcule(fields);
/*     */ 
/*     */ 
/*     */     
/* 206 */     byte primeiroDV = (byte)((restoDoModulo10 == 0) ? 0 : (10 - restoDoModulo10));
/* 207 */     return primeiroDV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 213 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 219 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBanestes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */