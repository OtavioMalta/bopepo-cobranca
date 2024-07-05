/*     */ package org.jrimum.bopepo;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.bopepo.campolivre.CampoLivre;
/*     */ import org.jrimum.bopepo.campolivre.CampoLivreFactory;
/*     */ import org.jrimum.bopepo.campolivre.NotSupportedBancoException;
/*     */ import org.jrimum.bopepo.campolivre.NotSupportedCampoLivreException;
/*     */ import org.jrimum.bopepo.view.BoletoCampo;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.DateFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Boleto
/*     */ {
/*  75 */   private static Logger log = Logger.getLogger(Boleto.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private Titulo titulo;
/*     */ 
/*     */ 
/*     */   
/*     */   private Date dataDeProcessamento;
/*     */ 
/*     */ 
/*     */   
/*     */   private CodigoDeBarras codigoDeBarras;
/*     */ 
/*     */ 
/*     */   
/*     */   private LinhaDigitavel linhaDigitavel;
/*     */ 
/*     */ 
/*     */   
/*     */   private CampoLivre campoLivre;
/*     */ 
/*     */ 
/*     */   
/*     */   private String localPagamento;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucaoAoSacado;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao1;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao2;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao3;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao4;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao5;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao6;
/*     */ 
/*     */ 
/*     */   
/*     */   private String instrucao7;
/*     */ 
/*     */   
/*     */   private String instrucao8;
/*     */ 
/*     */   
/*     */   private Map<String, String> textosExtras;
/*     */ 
/*     */   
/*     */   private Map<String, Image> imagensExtras;
/*     */ 
/*     */ 
/*     */   
/*     */   public Boleto() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Boleto(Titulo titulo) throws IllegalArgumentException, NotSupportedBancoException, NotSupportedCampoLivreException {
/* 149 */     if (log.isTraceEnabled()) {
/* 150 */       log.trace("Instanciando boleto");
/*     */     }
/* 152 */     if (log.isDebugEnabled()) {
/* 153 */       log.debug("titulo instance : " + titulo);
/*     */     }
/* 155 */     if (Objects.isNotNull(titulo)) {
/*     */       
/* 157 */       setTitulo(titulo);
/* 158 */       setCampoLivre(CampoLivreFactory.create(titulo));
/* 159 */       load();
/*     */       
/* 161 */       if (log.isDebugEnabled()) {
/* 162 */         log.debug("boleto instance : " + this);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 167 */       if (log.isDebugEnabled()) {
/* 168 */         log.debug("Título Nulo - Valor Não Permitido!");
/*     */       }
/*     */       
/* 171 */       Exceptions.throwIllegalArgumentException("Título nulo!");
/*     */     } 
/*     */     
/* 174 */     if (log.isDebugEnabled() || log.isTraceEnabled()) {
/* 175 */       log.trace("Boleto Instanciado : " + this);
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
/*     */   public Boleto(Titulo titulo, CampoLivre campoLivre) {
/* 187 */     if (log.isTraceEnabled()) {
/* 188 */       log.trace("Instanciando boleto");
/*     */     }
/* 190 */     if (log.isDebugEnabled()) {
/* 191 */       log.debug("titulo instance : " + titulo);
/*     */     }
/* 193 */     if (log.isDebugEnabled()) {
/* 194 */       log.debug("campoLivre instance : " + campoLivre);
/*     */     }
/* 196 */     if (Objects.isNotNull(titulo)) {
/*     */       
/* 198 */       setTitulo(titulo);
/* 199 */       setCampoLivre(campoLivre);
/* 200 */       load();
/*     */       
/* 202 */       if (log.isDebugEnabled()) {
/* 203 */         log.debug("boleto instance : " + this);
/*     */       }
/*     */     } else {
/* 206 */       IllegalArgumentException e = new IllegalArgumentException("Título nulo!");
/* 207 */       log.error("Valor Não Permitido!", e);
/* 208 */       throw e;
/*     */     } 
/*     */     
/* 211 */     if (log.isDebugEnabled() || log.isTraceEnabled())
/*     */     {
/* 213 */       log.trace("Boleto Instanciado : " + this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void load() {
/* 220 */     this.codigoDeBarras = new CodigoDeBarras(this.titulo, this.campoLivre);
/* 221 */     this.linhaDigitavel = new LinhaDigitavel(this.codigoDeBarras);
/* 222 */     this.dataDeProcessamento = new Date();
/*     */     
/* 224 */     if (log.isInfoEnabled())
/*     */     {
/* 226 */       log.info("Data de Processamento do Boleto : " + DateFormat.DDMMYYYY_B.format(this.dataDeProcessamento));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CampoLivre getCampoLivre() {
/* 235 */     return this.campoLivre;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCampoLivre(CampoLivre campoLivre) {
/* 243 */     Objects.checkNotNull(campoLivre);
/*     */     
/* 245 */     int length = ((String)campoLivre.write()).length();
/*     */     
/* 247 */     if (length == CampoLivre.STRING_LENGTH.intValue()) {
/* 248 */       this.campoLivre = campoLivre;
/*     */ 
/*     */     
/*     */     }
/* 252 */     else if (length > CampoLivre.STRING_LENGTH.intValue()) {
/* 253 */       Exceptions.throwIllegalArgumentException("O tamanho da String [" + length + "] é maior que o especificado [" + CampoLivre.STRING_LENGTH + "]!");
/*     */     } else {
/*     */       
/* 256 */       Exceptions.throwIllegalArgumentException("O tamanho da String [" + length + "] é menor que o especificado [" + CampoLivre.STRING_LENGTH + "]!");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Titulo getTitulo() {
/* 265 */     return this.titulo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitulo(Titulo titulo) {
/* 272 */     this.titulo = titulo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDataDeProcessamento() {
/* 281 */     return this.dataDeProcessamento;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataDeProcessamento(Date dataDeProcessamento) {
/* 292 */     this.dataDeProcessamento = dataDeProcessamento;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CodigoDeBarras getCodigoDeBarras() {
/* 299 */     return this.codigoDeBarras;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodigoDeBarras(CodigoDeBarras codigoDeBarras) {
/* 306 */     this.codigoDeBarras = codigoDeBarras;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinhaDigitavel getLinhaDigitavel() {
/* 313 */     return this.linhaDigitavel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinhaDigitavel(LinhaDigitavel linhaDigitavel) {
/* 320 */     this.linhaDigitavel = linhaDigitavel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalPagamento() {
/* 329 */     return this.localPagamento;
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
/*     */   public void setLocalPagamento(String localPagamento1) {
/* 344 */     this.localPagamento = localPagamento1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucaoAoSacado() {
/* 353 */     return this.instrucaoAoSacado;
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
/*     */   public void setInstrucaoAoSacado(String insturcaoAoSacado) {
/* 365 */     this.instrucaoAoSacado = insturcaoAoSacado;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao1() {
/* 372 */     return this.instrucao1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao1(String instrucao1) {
/* 379 */     this.instrucao1 = instrucao1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao2() {
/* 386 */     return this.instrucao2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao2(String instrucao2) {
/* 393 */     this.instrucao2 = instrucao2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao3() {
/* 400 */     return this.instrucao3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao3(String instrucao3) {
/* 407 */     this.instrucao3 = instrucao3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao4() {
/* 414 */     return this.instrucao4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao4(String instrucao4) {
/* 421 */     this.instrucao4 = instrucao4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao5() {
/* 428 */     return this.instrucao5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao5(String instrucao5) {
/* 435 */     this.instrucao5 = instrucao5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao6() {
/* 442 */     return this.instrucao6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao6(String instrucao6) {
/* 449 */     this.instrucao6 = instrucao6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao7() {
/* 456 */     return this.instrucao7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao7(String instrucao7) {
/* 463 */     this.instrucao7 = instrucao7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstrucao8() {
/* 470 */     return this.instrucao8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstrucao8(String instrucao8) {
/* 477 */     this.instrucao8 = instrucao8;
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
/*     */   public void sobrescrevaCampo(BoletoCampo campo, String conteudo) {
/* 489 */     addTextosExtras(campo.name(), conteudo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getTextosExtras() {
/* 499 */     return this.textosExtras;
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
/*     */   public void setTextosExtras(Map<String, String> textosExtras) {
/* 511 */     this.textosExtras = textosExtras;
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
/*     */   public void addTextosExtras(String campo, String conteudo) {
/* 525 */     if (Objects.isNull(getTextosExtras())) {
/* 526 */       setTextosExtras(new HashMap<String, String>());
/*     */     }
/*     */     
/* 529 */     getTextosExtras().put(campo, conteudo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Image> getImagensExtras() {
/* 537 */     return this.imagensExtras;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImagensExtras(Map<String, Image> imagensExtras) {
/* 547 */     this.imagensExtras = imagensExtras;
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
/*     */   public void addImagensExtras(String campo, Image conteudo) {
/* 561 */     if (Objects.isNull(getImagensExtras())) {
/* 562 */       setImagensExtras(new HashMap<String, Image>());
/*     */     }
/*     */     
/* 565 */     getImagensExtras().put(campo, conteudo);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 570 */     return Objects.toString(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\Boleto.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */