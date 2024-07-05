/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.bopepo.BancosSuportados;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Banco;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.component.BlockOfFields;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractCampoLivre
/*     */   extends BlockOfFields
/*     */   implements CampoLivre
/*     */ {
/*     */   private static final long serialVersionUID = 4605730904122445595L;
/*  95 */   private static Logger log = Logger.getLogger(Objects.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN7 = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN8 = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN9 = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN10 = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN11 = 11;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN14 = 14;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN15 = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int NN17 = 17;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AbstractCampoLivre(Integer fieldsLength, Integer stringLength) {
/* 142 */     super(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCampoLivre(Integer fieldsLength) {
/* 153 */     setLength(CampoLivre.STRING_LENGTH);
/* 154 */     setSize(fieldsLength);
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
/*     */   protected static CampoLivre create(Titulo titulo) throws NotSupportedBancoException, NotSupportedCampoLivreException, CampoLivreException {
/* 176 */     if (log.isTraceEnabled())
/*     */     {
/* 178 */       log.trace("Instanciando Campo livre");
/*     */     }
/* 180 */     if (log.isDebugEnabled())
/*     */     {
/* 182 */       log.debug("titulo instance : " + titulo);
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 187 */       checkTituloNotNull(titulo);
/* 188 */       checkContaBancariaNotNull(titulo);
/* 189 */       checkBancoNotNull(titulo);
/*     */       
/* 191 */       if (log.isDebugEnabled())
/*     */       {
/* 193 */         log.debug(String.format("Campo Livre do Banco: %s", new Object[] { titulo.getContaBancaria().getBanco().getNome() }));
/*     */       }
/*     */       
/* 196 */       if (BancosSuportados.isSuportado(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado())) {
/*     */         
/* 198 */         BancosSuportados banco = (BancosSuportados)BancosSuportados.suportados.get(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado());
/*     */         
/* 200 */         switch (banco) {
/*     */           case BANCO_BRADESCO:
/* 202 */             return AbstractCLBradesco.create(titulo);
/* 203 */           case BANCO_DO_BRASIL: return AbstractCLBancoDoBrasil.create(titulo);
/* 204 */           case BANCO_DO_NORDESTE_DO_BRASIL: return AbstractCLBancoDoNordesteDoBrasil.create(titulo);
/* 205 */           case BANCO_ABN_AMRO_REAL: return AbstractCLBancoReal.create(titulo);
/* 206 */           case CAIXA_ECONOMICA_FEDERAL: return AbstractCLCaixaEconomicaFederal.create(titulo);
/* 207 */           case HSBC: return AbstractCLHSBC.create(titulo);
/* 208 */           case UNIBANCO: return AbstractCLUnibanco.create(titulo);
/* 209 */           case BANCO_ITAU: return AbstractCLItau.create(titulo);
/* 210 */           case BANCO_SAFRA: return AbstractCLBancoSafra.create(titulo);
/* 211 */           case BANCO_DO_ESTADO_DO_RIO_GRANDE_DO_SUL: return AbstractCLBanrisul.create(titulo);
/* 212 */           case MERCANTIL_DO_BRASIL: return AbstractCLMercantilDoBrasil.create(titulo);
/* 213 */           case BANCO_DO_ESTADO_DO_ESPIRITO_SANTO: return AbstractCLBanestes.create(titulo);
/* 214 */           case BANCO_RURAL: return AbstractCLBancoRural.create(titulo);
/* 215 */           case BANCO_SANTANDER: return AbstractCLSantander.create(titulo);
/* 216 */           case BANCO_INTEMEDIUM: return AbstractCLBancoIntermedium.create(titulo);
/* 217 */           case BANCO_SICREDI: return AbstractCLSicredi.create(titulo);
/* 218 */           case BANCOOB: return AbstractCLBancoob.create(titulo);
/* 219 */           case CITIBANK: return AbstractCLBancoCitibank.create(titulo);
/* 220 */           case BANCO_DE_BRASILIA: return AbstractCLBancoDeBrasilia.create(titulo);
/* 221 */           case CECRED: return AbstractCLCecred.create(titulo);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 232 */         throw new NotSupportedCampoLivreException("Não há implementações de campo livre para o banco " + titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado() + " compatíveis com as " + "caracteríticas do título informado.");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 247 */       throw new NotSupportedBancoException();
/*     */     }
/* 249 */     catch (CampoLivreException e) {
/*     */ 
/*     */ 
/*     */       
/* 253 */       throw e;
/*     */     }
/* 255 */     catch (Exception e) {
/*     */ 
/*     */ 
/*     */       
/* 259 */       throw new CampoLivreException(e);
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
/*     */   protected final CampoLivre build(Titulo titulo) {
/* 278 */     checkValues(titulo);
/*     */     
/* 280 */     addFields(titulo);
/*     */     
/* 282 */     return this;
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
/*     */   protected abstract void checkValues(Titulo paramTitulo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void addFields(Titulo paramTitulo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String writeFields() {
/* 323 */     StringBuilder campoLivreAtual = new StringBuilder();
/*     */     
/* 325 */     for (FixedField fixedField : this) {
/* 326 */       campoLivreAtual.append((String)fixedField.write());
/*     */     }
/*     */     
/* 329 */     return campoLivreAtual.toString();
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
/*     */   private static void checkTituloNotNull(Titulo titulo) {
/* 348 */     Objects.checkNotNull(titulo, "Título não pode ser nulo!");
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
/*     */   private static void checkContaBancariaNotNull(Titulo titulo) {
/* 363 */     Objects.checkNotNull(titulo.getContaBancaria(), "Conta bancária do título não pode ser nula!");
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
/*     */   private static void checkBancoNotNull(Titulo titulo) {
/* 378 */     Objects.checkNotNull(titulo.getContaBancaria().getBanco(), "Banco da conta bancária do título não pode ser nulo!");
/*     */     
/* 380 */     boolean expression = Banco.isCodigoDeCompensacaoOK(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado());
/*     */     
/* 382 */     Objects.checkArgument(expression, String.format("Código de compensação [%s] inválido!", new Object[] { titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado() }));
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
/*     */   protected static final void checkCarteiraNotNull(Titulo titulo) {
/* 401 */     Objects.checkNotNull(titulo.getContaBancaria().getCarteira(), "Carteira da conta bancária do título não pode ser nula!");
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
/*     */   protected static final void checkRegistroDaCarteiraNotNull(Titulo titulo) {
/* 416 */     Objects.checkNotNull(titulo.getContaBancaria().getCarteira().getTipoCobranca(), "Tipo de cobrança (COM ou SEM registro) da carteira não pode ser nulo!");
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
/*     */   protected static final void checkCodigoDaCarteira(Titulo titulo) {
/* 432 */     Objects.checkNotNull(titulo.getContaBancaria().getCarteira().getCodigo(), "Código da carteira não pode ser nulo!");
/*     */     
/* 434 */     boolean expression = (titulo.getContaBancaria().getCarteira().getCodigo().intValue() > 0);
/*     */     
/* 436 */     Objects.checkArgument(expression, String.format("Código da carteira deve ser um número inteiro natural positivo e não [%s].", new Object[] { titulo.getContaBancaria().getCarteira().getCodigo() }));
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
/*     */   protected static final void checkCodigoDaCarteiraMenorOuIgualQue(Titulo titulo, int limite) {
/* 453 */     boolean expression = (titulo.getContaBancaria().getCarteira().getCodigo().intValue() <= limite);
/*     */     
/* 455 */     Objects.checkArgument(expression, String.format("Código [%s] da carteira deve ser um número menor que ou igual a [%s].", new Object[] { titulo.getContaBancaria().getCarteira().getCodigo(), Integer.valueOf(limite) }));
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
/*     */   protected static final void checkAgenciaNotNull(Titulo titulo) {
/* 470 */     Objects.checkNotNull(titulo.getContaBancaria().getAgencia(), "Agência bancária do título não pode ser nula!");
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
/*     */   protected static final void checkCodigoDaAgencia(Titulo titulo) {
/* 485 */     Objects.checkNotNull(titulo.getContaBancaria().getAgencia().getCodigo(), "Código da agência bancária não pode ser nulo!");
/*     */     
/* 487 */     boolean expression = (titulo.getContaBancaria().getAgencia().getCodigo().intValue() > 0);
/*     */     
/* 489 */     Objects.checkArgument(expression, String.format("Código da agência bancária deve ser um número inteiro natural positivo e não [%s].", new Object[] { titulo.getContaBancaria().getAgencia().getCodigo() }));
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
/*     */   protected static final void checkCodigoDaAgenciaMenorOuIgualQue(Titulo titulo, int limite) {
/* 507 */     boolean expression = (titulo.getContaBancaria().getAgencia().getCodigo().intValue() <= limite);
/*     */     
/* 509 */     Objects.checkArgument(expression, String.format("Código [%s] da agência deve ser um número menor que ou igual a [%s].", new Object[] { titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(limite) }));
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
/*     */   protected static final void checkDigitoDoCodigoDaAgencia(Titulo titulo) {
/* 525 */     Objects.checkNotNull(titulo.getContaBancaria().getAgencia().getDigitoVerificador(), "Dígito verificador da agência bancária não pode ser nulo!");
/* 526 */     Strings.checkNotBlank(titulo.getContaBancaria().getAgencia().getDigitoVerificador(), String.format("Dígito verificador [\"%s\"] da agência bancária não pode ser vazio!", new Object[] { titulo.getContaBancaria().getAgencia().getDigitoVerificador() }));
/* 527 */     Strings.checkNotNumeric(titulo.getContaBancaria().getAgencia().getDigitoVerificador(), String.format("Nesse contexto o dígito verificador [\"%s\"] da agência bancária deve ser numérico!", new Object[] { titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta() }));
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
/*     */   protected static final void checkNumeroDaContaNotNull(Titulo titulo) {
/* 542 */     Objects.checkNotNull(titulo.getContaBancaria().getNumeroDaConta(), "Número da conta bancária do título não pode ser nulo!");
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
/*     */   protected static final void checkCodigoDoNumeroDaConta(Titulo titulo) {
/* 557 */     Objects.checkNotNull(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), "Código do número da conta bancária não pode ser nulo!");
/*     */     
/* 559 */     boolean expression = (titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta().intValue() > 0);
/*     */     
/* 561 */     Objects.checkArgument(expression, String.format("Código do número da conta bancária deve ser um número inteiro natural positivo e não [%s].", new Object[] { titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta() }));
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
/*     */   protected static final void checkCodigoDoNumeroDaContaMenorOuIgualQue(Titulo titulo, int limite) {
/* 578 */     boolean expression = (titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta().intValue() <= limite);
/*     */     
/* 580 */     Objects.checkArgument(expression, String.format("Código [%s] do número da conta deve ser um número menor que ou igual a [%s].", new Object[] { titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(limite) }));
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
/*     */   protected static final void checkDigitoDoCodigoDoNumeroDaConta(Titulo titulo) {
/* 596 */     Objects.checkNotNull(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), "Dígito verificador do número da conta bancária não pode ser nulo!");
/* 597 */     Strings.checkNotBlank(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), String.format("Dígito verificador [\"%s\"] do número da conta bancária não pode ser vazio!", new Object[] { titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta() }));
/* 598 */     Strings.checkNotNumeric(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), String.format("Nesse contexto o dígito verificador [\"%s\"] do número da conta deve ser numérico!", new Object[] { titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta() }));
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
/*     */   protected static final void checkNossoNumero(Titulo titulo) {
/* 613 */     Objects.checkNotNull(titulo.getNossoNumero(), "Nosso número do título não pode ser nulo!");
/* 614 */     Strings.checkNotBlank(titulo.getNossoNumero(), String.format("Nosso número [\"%s\"] do título não pode ser vazio!", new Object[] { titulo.getNossoNumero() }));
/* 615 */     Strings.checkNotNumeric(titulo.getNossoNumero(), String.format("Nosso número [\"%s\"] do título deve conter somente dígitos numéricos!", new Object[] { titulo.getNossoNumero() }));
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
/*     */   protected static final void checkTamanhoDoNossoNumero(Titulo titulo, int length) {
/* 633 */     checkTamanhoNossoNumero(titulo, length, String.format("Tamanho [%s] do nosso número [\"%s\"] diferente do esperado [%s]!", new Object[] { Integer.valueOf(StringUtils.length(titulo.getNossoNumero())), titulo.getNossoNumero(), Integer.valueOf(length) }));
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
/*     */   protected static final void checkTamanhoNossoNumero(Titulo titulo, int length, String msg) {
/* 655 */     Objects.checkArgument((titulo.getNossoNumero().length() == length), msg);
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
/*     */   protected static final void checkDigitoDoNossoNumero(Titulo titulo) {
/* 671 */     Objects.checkNotNull(titulo.getDigitoDoNossoNumero(), "Dígito verificador do nosso número do título não pode ser nulo!");
/* 672 */     Strings.checkNotBlank(titulo.getDigitoDoNossoNumero(), String.format("Dígito verificador [\"%s\"] do nosso número do título não pode ser vazio!", new Object[] { titulo.getDigitoDoNossoNumero() }));
/* 673 */     Strings.checkNotNumeric(titulo.getDigitoDoNossoNumero(), String.format("Nesse contexto o dígito verificador [\"%s\"] do nosso número deve ser um número inteiro positivo!", new Object[] { titulo.getDigitoDoNossoNumero() }));
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
/*     */   protected static final void checkTamanhoDigitoDoNossoNumero(Titulo titulo, int length) {
/* 691 */     checkTamanhoDigitoDoNossoNumero(titulo, length, String.format("Tamanho [%s] do dígito do nosso número [\"%s\"] diferente do esperado [%s]!", new Object[] { Integer.valueOf(StringUtils.length(titulo.getDigitoDoNossoNumero())), titulo.getDigitoDoNossoNumero(), Integer.valueOf(length) }));
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
/*     */   protected static final void checkTamanhoDigitoDoNossoNumero(Titulo titulo, int length, String msg) {
/* 713 */     Objects.checkArgument((titulo.getDigitoDoNossoNumero().length() == length), msg);
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
/*     */   protected static final void checkValor(Titulo titulo) {
/* 728 */     Objects.checkNotNull(titulo.getValor(), "Valor do título não pode ser nulo!");
/* 729 */     Objects.checkArgument((titulo.getValor().compareTo(BigDecimal.ZERO) >= 0), String.format("O valor do título deve ser um número positivo ou zero e não [%s].", new Object[] { titulo.getValor() }));
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
/*     */   protected static final void checkParametroBancario(Titulo titulo, ParametroBancario<?> param) {
/* 747 */     Objects.checkNotNull(titulo.getParametrosBancarios(), String.format("O parâmetro bancário [\"%s\"] é necessário! [titulo.getParametrosBancarios() == null]", new Object[] { param }));
/* 748 */     Objects.checkArgument(titulo.getParametrosBancarios().contemComNome(param), String.format("Parâmetro bancário [\"%s\"] não encontrado!", new Object[] { param }));
/* 749 */     Objects.checkNotNull(titulo.getParametrosBancarios().getValor(param), String.format("Parâmetro bancário [\"%s\"] não contém valor!", new Object[] { param }));
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
/*     */   protected static final void checkParametroBancarioMenorOuIgualQue(Titulo titulo, ParametroBancario<?> param, int limite) {
/* 769 */     checkParametroBancario(titulo, param);
/*     */     
/* 771 */     int valor = titulo.getParametrosBancarios().getValor(param).intValue();
/*     */     
/* 773 */     boolean expression = (valor <= limite);
/*     */     
/* 775 */     Objects.checkArgument(expression, String.format("Parâmetro [%s] com valor [%s] deve ser um número menor que ou igual a [%s].", new Object[] { param, Integer.valueOf(valor), Integer.valueOf(limite) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 784 */     return Objects.toString(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\AbstractCampoLivre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */