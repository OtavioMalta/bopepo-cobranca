/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.Strings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CampoLivreFactory
/*     */ {
/*     */   public static CampoLivre create(Titulo titulo) throws NotSupportedBancoException, NotSupportedCampoLivreException {
/*  80 */     return AbstractCampoLivre.create(titulo);
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
/*     */   public static CampoLivre create(String strCampoLivre) {
/*  94 */     Objects.checkNotNull(strCampoLivre);
/*     */     
/*  96 */     strCampoLivre = StringUtils.strip(strCampoLivre);
/*     */     
/*  98 */     Strings.checkNotBlank(strCampoLivre, "O Campo Livre não deve ser vazio!");
/*     */     
/* 100 */     Objects.checkArgument((strCampoLivre.length() == CampoLivre.STRING_LENGTH.intValue()), "O tamanho do Campo Livre [ " + strCampoLivre + " ] deve ser igual a 25 e não [" + strCampoLivre.length() + "]!");
/* 101 */     Objects.checkArgument(!StringUtils.containsAny(strCampoLivre, " "), "O Campo Livre [ " + strCampoLivre + " ] não deve conter espaços em branco!");
/* 102 */     Objects.checkArgument(StringUtils.isNumeric(strCampoLivre), "O Campo Livre [ " + strCampoLivre + " ] deve ser uma String numérica!");
/*     */     
/* 104 */     return valueOf(strCampoLivre);
/*     */   }
/*     */   
/*     */   private static CampoLivre valueOf(String strCampoLivre) {
/* 108 */     CampoLivre campoLivre = new CampoLivre()
/*     */       {
/*     */         private static final long serialVersionUID = -7592488081807235080L;
/* 111 */         FixedField<String> campo = new FixedField("", STRING_LENGTH, (Filler)Fillers.ZERO_LEFT);
/*     */ 
/*     */         
/*     */         public void read(String str) {
/* 115 */           this.campo.read(str);
/*     */         }
/*     */         
/*     */         public String write() {
/* 119 */           return this.campo.write();
/*     */         }
/*     */       };
/* 122 */     campoLivre.read(strCampoLivre);
/* 123 */     return campoLivre;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     return Objects.toString(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CampoLivreFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */