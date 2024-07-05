/*     */ package org.jrimum.bopepo;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.bopepo.campolivre.CampoLivre;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.BlockOfFields;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.DecimalFormat;
/*     */ import org.jrimum.vallia.digitoverificador.BoletoCodigoDeBarrasDV;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodigoDeBarras
/*     */   extends BlockOfFields
/*     */ {
/*     */   private static final long serialVersionUID = 748913164143978133L;
/* 122 */   private static Logger log = Logger.getLogger(CodigoDeBarras.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   private static final Integer STRING_LENGTH = Integer.valueOf(44);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<String> codigoDoBanco;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<Integer> codigoDaMoeda;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<Integer> digitoVerificadorGeral;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<Integer> fatorDeVencimento;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<BigDecimal> valorNominalDoTitulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FixedField<String> campoLivre;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CodigoDeBarras(Titulo titulo, CampoLivre campoLivre) {
/* 181 */     setLength(STRING_LENGTH);
/* 182 */     setSize(FIELDS_LENGTH);
/*     */     
/* 184 */     if (log.isTraceEnabled()) {
/* 185 */       log.trace("Instanciando o CodigoDeBarras");
/*     */     }
/* 187 */     if (log.isDebugEnabled()) {
/* 188 */       log.debug("titulo instance : " + titulo);
/* 189 */       log.debug("campoLivre instance : " + campoLivre);
/*     */     } 
/*     */     
/* 192 */     this.codigoDoBanco = new FixedField("0", Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT);
/* 193 */     this.codigoDaMoeda = new FixedField(Integer.valueOf(0), Integer.valueOf(1), (Filler)Fillers.ZERO_LEFT);
/* 194 */     this.digitoVerificadorGeral = new FixedField(Integer.valueOf(0), Integer.valueOf(1), (Filler)Fillers.ZERO_LEFT);
/* 195 */     this.fatorDeVencimento = new FixedField(Integer.valueOf(0), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT);
/* 196 */     this.valorNominalDoTitulo = new FixedField(new BigDecimal(0), Integer.valueOf(10), DecimalFormat.NUMBER_DD_BR.copy(), (Filler)Fillers.ZERO_LEFT);
/* 197 */     this.campoLivre = new FixedField("", Integer.valueOf(25));
/*     */     
/* 199 */     add((Field)this.codigoDoBanco);
/* 200 */     add((Field)this.codigoDaMoeda);
/* 201 */     add((Field)this.digitoVerificadorGeral);
/* 202 */     add((Field)this.fatorDeVencimento);
/* 203 */     add((Field)this.valorNominalDoTitulo);
/* 204 */     add((Field)this.campoLivre);
/*     */     
/* 206 */     ContaBancaria contaBancaria = titulo.getContaBancaria();
/* 207 */     this.codigoDoBanco.setValue(contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado());
/* 208 */     this.codigoDaMoeda.setValue(Integer.valueOf(titulo.getTipoDeMoeda().getCodigo()));
/* 209 */     calculateAndSetFatorDeVencimento(titulo.getDataDoVencimento());
/* 210 */     this.valorNominalDoTitulo.setValue(titulo.getValor());
/* 211 */     this.campoLivre.setValue(campoLivre.write());
/* 212 */     calculateAndSetDigitoVerificadorGeral();
/*     */     
/* 214 */     if (log.isDebugEnabled() || log.isTraceEnabled()) {
/* 215 */       log.debug("codigoDeBarra instanciado : " + this);
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculateAndSetDigitoVerificadorGeral() {
/* 220 */     if (log.isTraceEnabled()) {
/* 221 */       log.trace("Calculando Digito Verificador Geral");
/*     */     }
/*     */     
/* 224 */     BoletoCodigoDeBarrasDV calculadorDV = new BoletoCodigoDeBarrasDV();
/*     */ 
/*     */ 
/*     */     
/* 228 */     StringBuilder toCalculateDV = (new StringBuilder(this.codigoDoBanco.write())).append(this.codigoDaMoeda.write()).append(this.fatorDeVencimento.write()).append(this.valorNominalDoTitulo.write()).append(this.campoLivre.write());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     this.digitoVerificadorGeral.setValue(Integer.valueOf(calculadorDV.calcule(toCalculateDV.toString())));
/*     */ 
/*     */ 
/*     */     
/* 240 */     if (log.isDebugEnabled()) {
/* 241 */       log.debug("Digito Verificador Geral calculado : " + this.digitoVerificadorGeral.getValue());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculateAndSetFatorDeVencimento(Date vencimento) {
/* 267 */     this.fatorDeVencimento.setValue(Integer.valueOf(FatorDeVencimento.toFator(vencimento)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<String> getCodigoDoBanco() {
/* 275 */     return this.codigoDoBanco;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setCodigoDoBanco(FixedField<String> codigoDoBanco) {
/* 282 */     this.codigoDoBanco = codigoDoBanco;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<Integer> getCodigoDaMoeda() {
/* 289 */     return this.codigoDaMoeda;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setCodigoDaMoeda(FixedField<Integer> codigoDaMoeda) {
/* 296 */     this.codigoDaMoeda = codigoDaMoeda;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<Integer> getDigitoVerificadorGeral() {
/* 303 */     return this.digitoVerificadorGeral;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setDigitoVerificadorGeral(FixedField<Integer> digitoVerificadorGeral) {
/* 310 */     this.digitoVerificadorGeral = digitoVerificadorGeral;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<Integer> getFatorDeVencimento() {
/* 317 */     return this.fatorDeVencimento;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFatorDeVencimento(FixedField<Integer> fatorDeVencimento) {
/* 324 */     this.fatorDeVencimento = fatorDeVencimento;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<BigDecimal> getValorNominalDoTitulo() {
/* 331 */     return this.valorNominalDoTitulo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setValorNominalDoTitulo(FixedField<BigDecimal> valorNominalDoTitulo) {
/* 338 */     this.valorNominalDoTitulo = valorNominalDoTitulo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FixedField<String> getCampoLivre() {
/* 345 */     return this.campoLivre;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setCampoLivre(FixedField<String> campoLivre) {
/* 352 */     this.campoLivre = campoLivre;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 357 */     return Objects.toString(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\CodigoDeBarras.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */