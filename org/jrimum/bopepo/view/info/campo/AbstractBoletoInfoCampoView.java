/*     */ package org.jrimum.bopepo.view.info.campo;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jrimum.bopepo.Boleto;
/*     */ import org.jrimum.bopepo.pdf.CodigoDeBarras;
/*     */ import org.jrimum.bopepo.view.ResourceBundle;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.EntidadeDeCobranca;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.DateFormat;
/*     */ import org.jrimum.utilix.text.DecimalFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractBoletoInfoCampoView
/*     */   implements BoletoInfoCampoView
/*     */ {
/*     */   private final ResourceBundle resourceBundle;
/*     */   private final Boleto boleto;
/*     */   
/*     */   private AbstractBoletoInfoCampoView() {
/*  76 */     Exceptions.throwIllegalStateException("Instanciação não permitida!");
/*  77 */     this.resourceBundle = null;
/*  78 */     this.boleto = null;
/*     */   }
/*     */   
/*     */   public AbstractBoletoInfoCampoView(ResourceBundle resourceBundle, Boleto boleto) {
/*  82 */     Objects.checkNotNull(resourceBundle);
/*  83 */     Objects.checkNotNull(boleto);
/*  84 */     this.resourceBundle = resourceBundle;
/*  85 */     this.boleto = boleto;
/*     */   }
/*     */   
/*     */   public String getTextoRsInstrucaoAoSacado() {
/*  89 */     return getValue(this.boleto.getInstrucaoAoSacado());
/*     */   }
/*     */   
/*     */   public String getTextoRsCpfCnpj() {
/*  93 */     return this.boleto.getTitulo().getCedente().getCPRF().getCodigoFormatado();
/*     */   }
/*     */   
/*     */   public String getTextoRsSacado() {
/*  97 */     return getTextoFcSacadoL1();
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadoL1() {
/* 101 */     return BoletoInfoCampoPessoa.getTextoNomeCprfDaPessoa((EntidadeDeCobranca)this.boleto.getTitulo().getSacado());
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadoL2() {
/* 105 */     return BoletoInfoCampoEndereco.getTextoEnderecoLinha1((EntidadeDeCobranca)this.boleto.getTitulo().getSacado());
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadoL3() {
/* 109 */     return BoletoInfoCampoEndereco.getTextoEnderecoLinha2((EntidadeDeCobranca)this.boleto.getTitulo().getSacado());
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadorAvalistaL1() {
/* 113 */     return BoletoInfoCampoPessoa.getTextoNomeCprfDaPessoa((EntidadeDeCobranca)this.boleto.getTitulo().getSacadorAvalista());
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadorAvalistaL2() {
/* 117 */     return BoletoInfoCampoEndereco.getTextoEnderecoLinha1((EntidadeDeCobranca)this.boleto.getTitulo().getSacadorAvalista());
/*     */   }
/*     */   
/*     */   public String getTextoFcSacadorAvalistaL3() {
/* 121 */     return BoletoInfoCampoEndereco.getTextoEnderecoLinha2((EntidadeDeCobranca)this.boleto.getTitulo().getSacadorAvalista());
/*     */   }
/*     */   
/*     */   public String getTextoFcDataProcessamento() {
/* 125 */     return getValue(this.boleto.getDataDeProcessamento());
/*     */   }
/*     */   
/*     */   public String getTextoFcAceite() {
/* 129 */     return getValue(this.boleto.getTitulo().getAceite());
/*     */   }
/*     */   
/*     */   public String getTextoFcEspecieDocumento() {
/* 133 */     return (String)Objects.whenNull(this.boleto.getTitulo().getTipoDeDocumento(), "", this.boleto.getTitulo().getTipoDeDocumento().getSigla());
/*     */   }
/*     */   
/*     */   public String getTextoFcDataDocumento() {
/* 137 */     return getValue(this.boleto.getTitulo().getDataDoDocumento());
/*     */   }
/*     */   
/*     */   public String getTextoFcLocalPagamento() {
/* 141 */     return getValue(this.boleto.getLocalPagamento());
/*     */   }
/*     */   
/*     */   public String getTextoFcCarteira() {
/* 145 */     return (String)Objects.whenNull(this.boleto.getTitulo().getContaBancaria().getCarteira(), "", this.boleto.getTitulo().getContaBancaria().getCarteira().getCodigo().toString());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa1() {
/* 149 */     return getValue(this.boleto.getInstrucao1());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa2() {
/* 153 */     return getValue(this.boleto.getInstrucao2());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa3() {
/* 157 */     return getValue(this.boleto.getInstrucao3());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa4() {
/* 161 */     return getValue(this.boleto.getInstrucao4());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa5() {
/* 165 */     return getValue(this.boleto.getInstrucao5());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa6() {
/* 169 */     return getValue(this.boleto.getInstrucao6());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa7() {
/* 173 */     return getValue(this.boleto.getInstrucao7());
/*     */   }
/*     */   
/*     */   public String getTextoFcInstrucaoAoCaixa8() {
/* 177 */     return getValue(this.boleto.getInstrucao8());
/*     */   }
/*     */   
/*     */   public String getTextoRsMoraMulta() {
/* 181 */     return getTextoFcMoraMulta();
/*     */   }
/*     */   
/*     */   public String getTextoFcMoraMulta() {
/* 185 */     return getValue(this.boleto.getTitulo().getMora());
/*     */   }
/*     */   
/*     */   public String getTextoRsOutroAcrescimo() {
/* 189 */     return getTextoFcOutroAcrescimo();
/*     */   }
/*     */   
/*     */   public String getTextoFcOutroAcrescimo() {
/* 193 */     return getValue(this.boleto.getTitulo().getAcrecimo());
/*     */   }
/*     */   
/*     */   public String getTextoRsOutraDeducao() {
/* 197 */     return getTextoFcOutraDeducao();
/*     */   }
/*     */   
/*     */   public String getTextoFcOutraDeducao() {
/* 201 */     return getValue(this.boleto.getTitulo().getDeducao());
/*     */   }
/*     */   
/*     */   public String getTextoRsDescontoAbatimento() {
/* 205 */     return getTextoFcDescontoAbatimento();
/*     */   }
/*     */   
/*     */   public String getTextoFcDescontoAbatimento() {
/* 209 */     return getValue(this.boleto.getTitulo().getDesconto());
/*     */   }
/*     */   
/*     */   public String getTextoRsValorDocumento() {
/* 213 */     return getTextoFcValorDocumento();
/*     */   }
/*     */   
/*     */   public String getTextoFcValorDocumento() {
/* 217 */     return getValue(this.boleto.getTitulo().getValor());
/*     */   }
/*     */   
/*     */   public String getTextoRsValorCobrado() {
/* 221 */     return getTextoFcValorCobrado();
/*     */   }
/*     */   
/*     */   public String getTextoFcValorCobrado() {
/* 225 */     return getValue(this.boleto.getTitulo().getValorCobrado());
/*     */   }
/*     */   
/*     */   public String getTextoRsDataVencimento() {
/* 229 */     return getTextoFcDataVencimento();
/*     */   }
/*     */   
/*     */   public String getTextoFcDataVencimento() {
/* 233 */     return getValue(this.boleto.getTitulo().getDataDoVencimento());
/*     */   }
/*     */   
/*     */   public String getTextoRsNumeroDocumento() {
/* 237 */     return getTextoFcNumeroDocumento();
/*     */   }
/*     */   
/*     */   public String getTextoFcNumeroDocumento() {
/* 241 */     return getValue(this.boleto.getTitulo().getNumeroDoDocumento());
/*     */   }
/*     */   
/*     */   public String getTextoRsCedente() {
/* 245 */     return getTextoFcCedente();
/*     */   }
/*     */   
/*     */   public String getTextoFcCedente() {
/* 249 */     return getValue(this.boleto.getTitulo().getCedente().getNome());
/*     */   }
/*     */   
/*     */   public String getTextoRsEspecie() {
/* 253 */     return getTextoFcEspecie();
/*     */   }
/*     */   
/*     */   public String getTextoFcEspecie() {
/* 257 */     return getValue(this.boleto.getTitulo().getTipoDeMoeda());
/*     */   }
/*     */   
/*     */   public String getTextoRsCodigoBanco() {
/* 261 */     return getTextoFcCodigoBanco();
/*     */   }
/*     */   
/*     */   public String getTextoFcCodigoBanco() {
/* 265 */     return BoletoInfoCampoCodigoBanco.getTextoCodigoDoBanco(this.boleto.getTitulo().getContaBancaria());
/*     */   }
/*     */   
/*     */   public String getTextoRsAgenciaCodigoCedente() {
/* 269 */     return getTextoFcAgenciaCodigoCedente();
/*     */   }
/*     */   
/*     */   public String getTextoFcAgenciaCodigoCedente() {
/* 273 */     return BoletoInfoCampoAgenciaCodigoCedente.getTextoAgenciaCodigoCedente(this.boleto.getTitulo().getContaBancaria());
/*     */   }
/*     */   
/*     */   public String getTextoRsNossoNumero() {
/* 277 */     return getTextoFcNossoNumero();
/*     */   }
/*     */   
/*     */   public String getTextoFcNossoNumero() {
/* 281 */     return BoletoInfoCampoNossoNumero.getTextoNossoNumero(this.boleto.getTitulo());
/*     */   }
/*     */   
/*     */   public Image getImagemRsLogoBanco() {
/* 285 */     return getImagemFcLogoBanco();
/*     */   }
/*     */   
/*     */   public Image getImagemFcLogoBanco() {
/* 289 */     return BoletoInfoCampoLogoBanco.getImagemBanco(this.resourceBundle, this.boleto.getTitulo().getContaBancaria());
/*     */   }
/*     */   
/*     */   public String getTextoRsLogoBanco() {
/* 293 */     return getTextoFcLogoBanco();
/*     */   }
/*     */   
/*     */   public String getTextoFcLogoBanco() {
/* 297 */     return this.boleto.getTitulo().getContaBancaria().getBanco().getNome();
/*     */   }
/*     */   
/*     */   public String getTextoRsLinhaDigitavel() {
/* 301 */     return getTextoFcLinhaDigitavel();
/*     */   }
/*     */   
/*     */   public String getTextoFcLinhaDigitavel() {
/* 305 */     return this.boleto.getLinhaDigitavel().write();
/*     */   }
/*     */   
/*     */   public Image getImagemFcCodigoBarra() {
/* 309 */     return CodigoDeBarras.valueOf(this.boleto.getCodigoDeBarras().write()).toImage();
/*     */   }
/*     */   
/*     */   protected final Boleto getBoleto() {
/* 313 */     return this.boleto;
/*     */   }
/*     */   
/*     */   private String getValue(String value) {
/* 317 */     if (StringUtils.isNotBlank(value)) {
/* 318 */       return value;
/*     */     }
/* 320 */     return "";
/*     */   }
/*     */   
/*     */   private String getValue(Date value) {
/* 324 */     if (Objects.isNotNull(value)) {
/* 325 */       return DateFormat.DDMMYYYY_B.format(value);
/*     */     }
/* 327 */     return "";
/*     */   }
/*     */   
/*     */   private String getValue(BigDecimal value) {
/* 331 */     if (Objects.isNotNull(value)) {
/* 332 */       return DecimalFormat.MONEY_DD_BR.format(value);
/*     */     }
/* 334 */     return "";
/*     */   }
/*     */   
/*     */   private <T extends Enum<?>> String getValue(T value) {
/* 338 */     if (Objects.isNotNull(value)) {
/* 339 */       return value.name();
/*     */     }
/* 341 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\AbstractBoletoInfoCampoView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */