/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.component.FixedField;
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
/*     */ abstract class AbstractCLBanrisul
/*     */   extends AbstractCampoLivre
/*     */ {
/*     */   private static final long serialVersionUID = -259398499475894938L;
/*     */   
/*     */   protected AbstractCLBanrisul(Integer fieldsLength) {
/*  68 */     super(fieldsLength);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
/*  73 */     checkCarteiraNotNull(titulo);
/*  74 */     checkRegistroDaCarteiraNotNull(titulo);
/*     */     
/*  76 */     switch (titulo.getContaBancaria().getCarteira().getTipoCobranca()) {
/*     */       
/*     */       case COM_REGISTRO:
/*  79 */         return new CLBanrisulCobrancaRegistrada(titulo);
/*     */       case SEM_REGISTRO:
/*  81 */         return new CLBanrisulCobrancaNaoRegistrada(titulo);
/*     */     } 
/*  83 */     throw new NotSupportedCampoLivreException("Campo livre diponível apenas para carteiras com ou sem cobrança.");
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
/*     */   protected String calculaDuploDigito(String seisPrimeirosCamposConcatenados) {
/* 100 */     int somaMod10 = Modulo.calculeSomaSequencialMod10(seisPrimeirosCamposConcatenados, 1, 2);
/*     */ 
/*     */     
/* 103 */     byte restoMod10 = calculeRestoMod10(somaMod10);
/*     */ 
/*     */     
/* 106 */     byte primeiroDV = calculePrimeiroDV(restoMod10);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     int somaMod11 = Modulo.calculeSomaSequencialMod11(seisPrimeirosCamposConcatenados + primeiroDV, 2, 7);
/*     */ 
/*     */     
/* 114 */     byte restoMod11 = calculeRestoMod11(somaMod11);
/*     */ 
/*     */ 
/*     */     
/* 118 */     while (restoMod11 == 1) {
/*     */ 
/*     */       
/* 121 */       primeiroDV = encontreValorValidoParaPrimeiroDV(primeiroDV);
/*     */ 
/*     */ 
/*     */       
/* 125 */       somaMod11 = Modulo.calculeSomaSequencialMod11(seisPrimeirosCamposConcatenados + primeiroDV, 2, 7);
/*     */ 
/*     */       
/* 128 */       restoMod11 = calculeRestoMod11(somaMod11);
/*     */     } 
/*     */ 
/*     */     
/* 132 */     byte segundoDV = calculeSegundoDV(restoMod11);
/*     */ 
/*     */ 
/*     */     
/* 136 */     return String.valueOf(primeiroDV) + String.valueOf(segundoDV);
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
/*     */   private byte calculeSegundoDV(byte restoMod11) {
/*     */     byte segundoDV;
/* 151 */     if (restoMod11 == 0) {
/* 152 */       segundoDV = restoMod11;
/*     */     } else {
/* 154 */       segundoDV = (byte)(11 - restoMod11);
/* 155 */     }  return segundoDV;
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
/*     */   private byte calculePrimeiroDV(byte restoMod10) {
/*     */     byte primeiroDV;
/* 170 */     if (restoMod10 == 0) {
/* 171 */       primeiroDV = 0;
/*     */     } else {
/* 173 */       primeiroDV = (byte)(10 - restoMod10);
/* 174 */     }  return primeiroDV;
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
/*     */   private byte calculeRestoMod10(int somaMod10) {
/*     */     byte restoMod10;
/* 189 */     if (somaMod10 < 10) {
/* 190 */       restoMod10 = (byte)somaMod10;
/*     */     } else {
/* 192 */       restoMod10 = (byte)(somaMod10 % 10);
/* 193 */     }  return restoMod10;
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
/*     */   private byte encontreValorValidoParaPrimeiroDV(byte primeiroDV) {
/*     */     byte novoValorDoPrimeiroDV;
/* 208 */     if (primeiroDV == 9) {
/* 209 */       novoValorDoPrimeiroDV = 0;
/*     */     } else {
/* 211 */       novoValorDoPrimeiroDV = (byte)(primeiroDV + 1);
/* 212 */     }  return novoValorDoPrimeiroDV;
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
/*     */   private byte calculeRestoMod11(int somaMod11) {
/*     */     byte restoMod11;
/* 227 */     if (somaMod11 < 11) {
/* 228 */       restoMod11 = (byte)somaMod11;
/*     */     } else {
/* 230 */       restoMod11 = (byte)(somaMod11 % 11);
/* 231 */     }  return restoMod11;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String concateneOsCamposExistentesAteOMomento() {
/* 236 */     StringBuilder camposExistentesAteOMomentoConcatenados = new StringBuilder("");
/*     */     
/* 238 */     for (FixedField fixedField : this) {
/* 239 */       camposExistentesAteOMomentoConcatenados.append((String)fixedField.write());
/*     */     }
/*     */     
/* 242 */     return camposExistentesAteOMomentoConcatenados.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCLBanrisul.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */