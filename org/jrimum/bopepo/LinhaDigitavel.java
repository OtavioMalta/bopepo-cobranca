/*     */ package org.jrimum.bopepo;
/*     */ 
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.component.BlockOfFields;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.vallia.digitoverificador.BoletoLinhaDigitavelDV;
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
/*     */ public class LinhaDigitavel
/*     */   extends BlockOfFields
/*     */ {
/*     */   private static final long serialVersionUID = -6089634012523938802L;
/* 172 */   private static Logger log = Logger.getLogger(LinhaDigitavel.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   private static final Integer STRING_LENGTH = Integer.valueOf(54);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<InnerCampo1> innerCampo1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<InnerCampo2> innerCampo2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<InnerCampo3> innerCampo3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<Integer> campo4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<InnerCampo5> innerCampo5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LinhaDigitavel(CodigoDeBarras codigoDeBarras) {
/* 227 */     setLength(STRING_LENGTH);
/* 228 */     setSize(FIELDS_LENGTH);
/*     */     
/* 230 */     if (log.isTraceEnabled()) {
/* 231 */       log.trace("Instanciando Linha Digitável");
/*     */     }
/* 233 */     if (log.isDebugEnabled()) {
/* 234 */       log.debug("codigoDeBarra instance : " + codigoDeBarras);
/*     */     }
/* 236 */     this.innerCampo1 = new FixedField(new InnerCampo1(Integer.valueOf(4), Integer.valueOf(11)), Integer.valueOf(11));
/* 237 */     this.innerCampo2 = new FixedField(new InnerCampo2(Integer.valueOf(2), Integer.valueOf(12)), Integer.valueOf(12));
/* 238 */     this.innerCampo3 = new FixedField(new InnerCampo3(Integer.valueOf(2), Integer.valueOf(12)), Integer.valueOf(12));
/* 239 */     this.campo4 = new FixedField(new Integer(0), Integer.valueOf(1));
/* 240 */     this.innerCampo5 = new FixedField(new InnerCampo5(Integer.valueOf(2), Integer.valueOf(14)), Integer.valueOf(14));
/*     */     
/* 242 */     add((Field)this.innerCampo1);
/* 243 */     add((Field)this.innerCampo2);
/* 244 */     add((Field)this.innerCampo3);
/* 245 */     add((Field)this.campo4);
/* 246 */     add((Field)this.innerCampo5);
/*     */     
/* 248 */     ((InnerCampo1)this.innerCampo1.getValue()).load(codigoDeBarras);
/* 249 */     ((InnerCampo2)this.innerCampo2.getValue()).load(codigoDeBarras);
/* 250 */     ((InnerCampo3)this.innerCampo3.getValue()).load(codigoDeBarras);
/*     */     
/* 252 */     this.campo4.setValue(codigoDeBarras.getDigitoVerificadorGeral().getValue());
/*     */     
/* 254 */     if (log.isDebugEnabled()) {
/* 255 */       log.debug("InnerCampo 4 da Linha Digitável : " + this.campo4.getValue());
/*     */     }
/* 257 */     ((InnerCampo5)this.innerCampo5.getValue()).load(codigoDeBarras);
/*     */     
/* 259 */     if (log.isDebugEnabled() || log.isTraceEnabled()) {
/* 260 */       log.debug("linhaDigitavel instanciada : " + write());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String write() {
/* 271 */     return this.innerCampo1.write() + " " + this.innerCampo2.write() + " " + this.innerCampo3.write() + " " + this.campo4.write() + " " + this.innerCampo5.write();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class InnerCampo
/*     */     extends BlockOfFields
/*     */   {
/*     */     private static final long serialVersionUID = 6746400538765124943L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 292 */     protected final BoletoLinhaDigitavelDV calculadorDV = new BoletoLinhaDigitavelDV();
/*     */ 
/*     */ 
/*     */     
/*     */     protected InnerCampo(Integer fieldsLength, Integer stringLength) {
/* 297 */       setLength(stringLength);
/* 298 */       setSize(fieldsLength);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class InnerCampoFormatado
/*     */     extends InnerCampo
/*     */   {
/*     */     private static final long serialVersionUID = 3650450185403697045L;
/*     */ 
/*     */ 
/*     */     
/*     */     protected InnerCampoFormatado(Integer fieldsLength, Integer stringLength) {
/* 312 */       super(fieldsLength, stringLength);
/*     */     }
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
/*     */     public String write() {
/* 331 */       StringBuilder lineOfFields = new StringBuilder("");
/*     */       
/* 333 */       for (FixedField<?> field : (Iterable<FixedField<?>>)this) {
/* 334 */         lineOfFields.append(field.write());
/*     */       }
/*     */       
/* 337 */       lineOfFields.insert(5, ".");
/*     */       
/* 339 */       return lineOfFields.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class InnerCampo1
/*     */     extends InnerCampoFormatado
/*     */   {
/*     */     private static final long serialVersionUID = 2948116051922000890L;
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
/*     */     private InnerCampo1(Integer fieldsLength, Integer stringLength) {
/* 370 */       super(fieldsLength, stringLength);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void load(CodigoDeBarras codigoDeBarras) {
/* 378 */       if (LinhaDigitavel.log.isTraceEnabled()) {
/* 379 */         LinhaDigitavel.log.trace("Compondo campo 1 da Linha Digitável");
/*     */       }
/* 381 */       add((Field)new FixedField(codigoDeBarras.write().substring(0, 3), Integer.valueOf(3)));
/* 382 */       add((Field)new FixedField(codigoDeBarras.write().substring(3, 4), Integer.valueOf(1)));
/* 383 */       add((Field)new FixedField(codigoDeBarras.write().substring(19, 24), Integer.valueOf(5)));
/* 384 */       add((Field)new FixedField(Integer.valueOf(this.calculadorDV.calcule(((FixedField)get(0)).write() + ((FixedField)get(1)).write() + ((FixedField)get(2)).write())), Integer.valueOf(1)));
/*     */       
/* 386 */       if (LinhaDigitavel.log.isDebugEnabled()) {
/* 387 */         LinhaDigitavel.log.debug("Digito verificador do Field 1 da Linha Digitável : " + ((FixedField)get(3)).getValue());
/*     */       }
/*     */       
/* 390 */       if (LinhaDigitavel.log.isDebugEnabled() || LinhaDigitavel.log.isTraceEnabled()) {
/* 391 */         LinhaDigitavel.log.debug("Field 1 da Linha Digitável composto : " + write());
/*     */       }
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
/*     */ 
/*     */   
/*     */   private class InnerCampo2
/*     */     extends InnerCampoFormatado
/*     */   {
/*     */     private static final long serialVersionUID = -2201847536243988819L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private InnerCampo2(Integer fieldsLength, Integer stringLength) {
/* 419 */       super(fieldsLength, stringLength);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void load(CodigoDeBarras codigoDeBarras) {
/* 428 */       if (LinhaDigitavel.log.isTraceEnabled()) {
/* 429 */         LinhaDigitavel.log.trace("Compondo campo 2 da Linha Digitável");
/*     */       }
/* 431 */       add((Field)new FixedField(codigoDeBarras.write().substring(24, 34), Integer.valueOf(10)));
/* 432 */       add((Field)new FixedField(Integer.valueOf(this.calculadorDV.calcule(((FixedField)get(0)).write())), Integer.valueOf(1)));
/*     */       
/* 434 */       if (LinhaDigitavel.log.isDebugEnabled()) {
/* 435 */         LinhaDigitavel.log.debug("Digito verificador do campo 2 da Linha Digitável : " + ((FixedField)get(1)).getValue());
/*     */       }
/* 437 */       if (LinhaDigitavel.log.isDebugEnabled() || LinhaDigitavel.log.isTraceEnabled()) {
/* 438 */         LinhaDigitavel.log.debug("InnerCampo 2 da Linha Digitável composto : " + write());
/*     */       }
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
/*     */ 
/*     */   
/*     */   private class InnerCampo3
/*     */     extends InnerCampoFormatado
/*     */   {
/*     */     private static final long serialVersionUID = -4248472044788156665L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private InnerCampo3(Integer fieldsLength, Integer stringLength) {
/* 466 */       super(fieldsLength, stringLength);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void load(CodigoDeBarras codigoDeBarras) {
/* 474 */       if (LinhaDigitavel.log.isTraceEnabled()) {
/* 475 */         LinhaDigitavel.log.trace("Compondo campo 3 da Linha Digitável");
/*     */       }
/* 477 */       add((Field)new FixedField(codigoDeBarras.write().substring(34, 44), Integer.valueOf(10)));
/* 478 */       add((Field)new FixedField(Integer.valueOf(this.calculadorDV.calcule(((FixedField)get(0)).write())), Integer.valueOf(1)));
/*     */       
/* 480 */       if (LinhaDigitavel.log.isDebugEnabled()) {
/* 481 */         LinhaDigitavel.log.debug("Digito verificador do campo 3 da Linha Digitável : " + ((FixedField)get(1)).getValue());
/*     */       }
/* 483 */       if (LinhaDigitavel.log.isDebugEnabled() || LinhaDigitavel.log.isTraceEnabled()) {
/* 484 */         LinhaDigitavel.log.debug("InnerCampo 3 da Linha Digitável composto : " + write());
/*     */       }
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
/*     */ 
/*     */   
/*     */   private class InnerCampo5
/*     */     extends InnerCampo
/*     */   {
/*     */     private static final long serialVersionUID = -8040082112684009827L;
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
/*     */     private InnerCampo5(Integer fieldsLength, Integer stringLength) {
/* 513 */       super(fieldsLength, stringLength);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void load(CodigoDeBarras codigoDeBarras) {
/* 521 */       if (LinhaDigitavel.log.isTraceEnabled()) {
/* 522 */         LinhaDigitavel.log.trace("Compondo campo 5 da Linha Digitável");
/*     */       }
/* 524 */       add((Field)new FixedField(codigoDeBarras.write().substring(5, 9), Integer.valueOf(4)));
/* 525 */       add((Field)new FixedField(codigoDeBarras.write().substring(9, 19), Integer.valueOf(10)));
/*     */       
/* 527 */       if (LinhaDigitavel.log.isDebugEnabled() || LinhaDigitavel.log.isTraceEnabled()) {
/* 528 */         LinhaDigitavel.log.debug("InnerCampo 5 da Linha Digitável composto : " + write());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 536 */     return Objects.toString(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\LinhaDigitavel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */