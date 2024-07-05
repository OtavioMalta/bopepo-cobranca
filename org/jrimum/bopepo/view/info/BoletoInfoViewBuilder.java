/*     */ package org.jrimum.bopepo.view.info;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.bopepo.Boleto;
/*     */ import org.jrimum.bopepo.view.BoletoCampo;
/*     */ import org.jrimum.bopepo.view.ResourceBundle;
/*     */ import org.jrimum.bopepo.view.info.campo.BoletoInfoCampoView;
/*     */ import org.jrimum.bopepo.view.info.campo.BoletoInfoCampoViewFactory;
/*     */ import org.jrimum.utilix.Collections;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BoletoInfoViewBuilder
/*     */ {
/*  61 */   private static Logger log = Logger.getLogger(BoletoInfoViewBuilder.class);
/*     */ 
/*     */   
/*     */   private final Map<String, String> text;
/*     */ 
/*     */   
/*     */   private final Map<String, Image> image;
/*     */ 
/*     */   
/*     */   private final Map<String, String> boletoTextosExtra;
/*     */ 
/*     */   
/*     */   private final Map<String, Image> boletoImagensExtra;
/*     */ 
/*     */   
/*     */   private final BoletoInfoCampoView boletoInfoCampo;
/*     */ 
/*     */   
/*     */   private BoletoInfoViewBuilder() {
/*  80 */     Exceptions.throwIllegalStateException("Instanciação não permitida!");
/*  81 */     this.text = null;
/*  82 */     this.image = null;
/*  83 */     this.boletoTextosExtra = null;
/*  84 */     this.boletoImagensExtra = null;
/*  85 */     this.boletoInfoCampo = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public BoletoInfoViewBuilder(ResourceBundle resourceBundle, Boleto boleto) {
/*  90 */     Objects.checkNotNull(resourceBundle);
/*  91 */     Objects.checkNotNull(boleto);
/*     */     
/*  93 */     this.text = new WeakHashMap<String, String>();
/*  94 */     this.image = new WeakHashMap<String, Image>();
/*     */     
/*  96 */     this.boletoTextosExtra = boleto.getTextosExtras();
/*  97 */     this.boletoImagensExtra = boleto.getImagensExtras();
/*  98 */     this.boletoInfoCampo = BoletoInfoCampoViewFactory.create(resourceBundle, boleto);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> texts() {
/* 103 */     return new WeakHashMap<String, String>(this.text);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Image> images() {
/* 108 */     return new WeakHashMap<String, Image>(this.image);
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
/*     */   public BoletoInfoViewBuilder build() {
/* 120 */     setLogotipoDoBanco();
/* 121 */     setCodigoDoBanco();
/* 122 */     setLinhaDigitavel();
/* 123 */     setCedente();
/* 124 */     setAgenciaCodigoCedente();
/* 125 */     setEspecie();
/* 126 */     setNossoNumero();
/* 127 */     setNumeroDocumento();
/* 128 */     setCprfCedente();
/* 129 */     setDataVencimeto();
/* 130 */     setValorDocumento();
/* 131 */     setDescontoAbatimento();
/* 132 */     setOutraDeducao();
/* 133 */     setMoraMulta();
/* 134 */     setOutroAcrescimo();
/* 135 */     setValorCobrado();
/* 136 */     setInstrucaoAoSacado();
/* 137 */     setInstrucaoAoCaixa();
/* 138 */     setSacado();
/* 139 */     setLocalPagamento();
/* 140 */     setDataDocumento();
/* 141 */     setEspecieDoc();
/* 142 */     setAceite();
/* 143 */     setDataProcessamento();
/* 144 */     setSacadorAvalista();
/* 145 */     setCodigoDeBarras();
/* 146 */     setCarteira();
/* 147 */     setTodosOsCamposTexto();
/* 148 */     setTodosOsCamposImagem();
/*     */     
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   private void setInstrucaoAoSacado() {
/* 154 */     this.text.put(BoletoCampo.txtRsInstrucaoAoSacado.name(), this.boletoInfoCampo.getTextoRsInstrucaoAoSacado());
/*     */   }
/*     */   
/*     */   private void setCprfCedente() {
/* 158 */     this.text.put(BoletoCampo.txtRsCpfCnpj.name(), this.boletoInfoCampo.getTextoRsCpfCnpj());
/*     */   }
/*     */   
/*     */   private void setDataProcessamento() {
/* 162 */     this.text.put(BoletoCampo.txtFcDataProcessamento.name(), this.boletoInfoCampo.getTextoFcDataProcessamento());
/*     */   }
/*     */   
/*     */   private void setLocalPagamento() {
/* 166 */     this.text.put(BoletoCampo.txtFcLocalPagamento.name(), this.boletoInfoCampo.getTextoFcLocalPagamento());
/*     */   }
/*     */   
/*     */   private void setAceite() {
/* 170 */     this.text.put(BoletoCampo.txtFcAceite.name(), this.boletoInfoCampo.getTextoFcAceite());
/*     */   }
/*     */   
/*     */   private void setEspecieDoc() {
/* 174 */     this.text.put(BoletoCampo.txtFcEspecieDocumento.name(), this.boletoInfoCampo.getTextoFcEspecieDocumento());
/*     */   }
/*     */   
/*     */   private void setDataDocumento() {
/* 178 */     this.text.put(BoletoCampo.txtFcDataDocumento.name(), this.boletoInfoCampo.getTextoFcDataDocumento());
/*     */   }
/*     */   
/*     */   private void setCarteira() {
/* 182 */     this.text.put(BoletoCampo.txtFcCarteira.name(), this.boletoInfoCampo.getTextoFcCarteira());
/*     */   }
/*     */   
/*     */   private void setSacado() {
/* 186 */     this.text.put(BoletoCampo.txtRsSacado.name(), this.boletoInfoCampo.getTextoRsSacado());
/* 187 */     this.text.put(BoletoCampo.txtFcSacadoL1.name(), this.boletoInfoCampo.getTextoFcSacadoL1());
/* 188 */     this.text.put(BoletoCampo.txtFcSacadoL2.name(), this.boletoInfoCampo.getTextoFcSacadoL2());
/* 189 */     this.text.put(BoletoCampo.txtFcSacadoL3.name(), this.boletoInfoCampo.getTextoFcSacadoL3());
/*     */   }
/*     */   
/*     */   private void setSacadorAvalista() {
/* 193 */     this.text.put(BoletoCampo.txtFcSacadorAvalistaL1.name(), this.boletoInfoCampo.getTextoFcSacadorAvalistaL1());
/* 194 */     this.text.put(BoletoCampo.txtFcSacadorAvalistaL2.name(), this.boletoInfoCampo.getTextoFcSacadorAvalistaL2());
/* 195 */     this.text.put(BoletoCampo.txtFcSacadorAvalistaL3.name(), this.boletoInfoCampo.getTextoFcSacadorAvalistaL3());
/*     */   }
/*     */   
/*     */   private void setInstrucaoAoCaixa() {
/* 199 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa1.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa1());
/* 200 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa2.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa2());
/* 201 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa3.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa3());
/* 202 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa4.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa4());
/* 203 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa5.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa5());
/* 204 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa6.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa6());
/* 205 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa7.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa7());
/* 206 */     this.text.put(BoletoCampo.txtFcInstrucaoAoCaixa8.name(), this.boletoInfoCampo.getTextoFcInstrucaoAoCaixa8());
/*     */   }
/*     */   
/*     */   private void setMoraMulta() {
/* 210 */     this.text.put(BoletoCampo.txtRsMoraMulta.name(), this.boletoInfoCampo.getTextoRsMoraMulta());
/* 211 */     this.text.put(BoletoCampo.txtFcMoraMulta.name(), this.boletoInfoCampo.getTextoFcMoraMulta());
/*     */   }
/*     */   
/*     */   private void setOutroAcrescimo() {
/* 215 */     this.text.put(BoletoCampo.txtRsOutroAcrescimo.name(), this.boletoInfoCampo.getTextoRsOutroAcrescimo());
/* 216 */     this.text.put(BoletoCampo.txtFcOutroAcrescimo.name(), this.boletoInfoCampo.getTextoFcOutroAcrescimo());
/*     */   }
/*     */   
/*     */   private void setOutraDeducao() {
/* 220 */     this.text.put(BoletoCampo.txtRsOutraDeducao.name(), this.boletoInfoCampo.getTextoRsOutraDeducao());
/* 221 */     this.text.put(BoletoCampo.txtFcOutraDeducao.name(), this.boletoInfoCampo.getTextoFcOutraDeducao());
/*     */   }
/*     */   
/*     */   private void setDescontoAbatimento() {
/* 225 */     this.text.put(BoletoCampo.txtRsDescontoAbatimento.name(), this.boletoInfoCampo.getTextoRsDescontoAbatimento());
/* 226 */     this.text.put(BoletoCampo.txtFcDescontoAbatimento.name(), this.boletoInfoCampo.getTextoFcDescontoAbatimento());
/*     */   }
/*     */   private void setValorDocumento() {
/* 229 */     this.text.put(BoletoCampo.txtRsValorDocumento.name(), this.boletoInfoCampo.getTextoRsValorDocumento());
/* 230 */     this.text.put(BoletoCampo.txtFcValorDocumento.name(), this.boletoInfoCampo.getTextoFcValorDocumento());
/*     */   }
/*     */   
/*     */   private void setValorCobrado() {
/* 234 */     this.text.put(BoletoCampo.txtRsValorCobrado.name(), this.boletoInfoCampo.getTextoRsValorCobrado());
/* 235 */     this.text.put(BoletoCampo.txtFcValorCobrado.name(), this.boletoInfoCampo.getTextoFcValorCobrado());
/*     */   }
/*     */   
/*     */   private void setDataVencimeto() {
/* 239 */     this.text.put(BoletoCampo.txtRsDataVencimento.name(), this.boletoInfoCampo.getTextoRsDataVencimento());
/* 240 */     this.text.put(BoletoCampo.txtFcDataVencimento.name(), this.boletoInfoCampo.getTextoFcDataVencimento());
/*     */   }
/*     */   
/*     */   private void setNumeroDocumento() {
/* 244 */     this.text.put(BoletoCampo.txtRsNumeroDocumento.name(), this.boletoInfoCampo.getTextoRsNumeroDocumento());
/* 245 */     this.text.put(BoletoCampo.txtFcNumeroDocumento.name(), this.boletoInfoCampo.getTextoFcNumeroDocumento());
/*     */   }
/*     */   
/*     */   private void setCedente() {
/* 249 */     this.text.put(BoletoCampo.txtRsCedente.name(), this.boletoInfoCampo.getTextoRsCedente());
/* 250 */     this.text.put(BoletoCampo.txtFcCedente.name(), this.boletoInfoCampo.getTextoFcCedente());
/*     */   }
/*     */   
/*     */   private void setEspecie() {
/* 254 */     this.text.put(BoletoCampo.txtRsEspecie.name(), this.boletoInfoCampo.getTextoRsEspecie());
/* 255 */     this.text.put(BoletoCampo.txtFcEspecie.name(), this.boletoInfoCampo.getTextoFcEspecie());
/*     */   }
/*     */   
/*     */   private void setCodigoDoBanco() {
/* 259 */     this.text.put(BoletoCampo.txtRsCodBanco.name(), this.boletoInfoCampo.getTextoRsCodigoBanco());
/* 260 */     this.text.put(BoletoCampo.txtFcCodBanco.name(), this.boletoInfoCampo.getTextoFcCodigoBanco());
/*     */   }
/*     */   
/*     */   private void setAgenciaCodigoCedente() {
/* 264 */     this.text.put(BoletoCampo.txtRsAgenciaCodigoCedente.name(), this.boletoInfoCampo.getTextoRsAgenciaCodigoCedente());
/* 265 */     this.text.put(BoletoCampo.txtFcAgenciaCodigoCedente.name(), this.boletoInfoCampo.getTextoFcAgenciaCodigoCedente());
/*     */   }
/*     */   
/*     */   private void setNossoNumero() {
/* 269 */     this.text.put(BoletoCampo.txtRsNossoNumero.name(), this.boletoInfoCampo.getTextoRsNossoNumero());
/* 270 */     this.text.put(BoletoCampo.txtFcNossoNumero.name(), this.boletoInfoCampo.getTextoFcNossoNumero());
/*     */   }
/*     */   
/*     */   private void setLogotipoDoBanco() {
/* 274 */     if (Objects.isNotNull(this.boletoInfoCampo.getImagemFcLogoBanco())) {
/* 275 */       this.image.put(BoletoCampo.txtRsLogoBanco.name(), this.boletoInfoCampo.getImagemRsLogoBanco());
/* 276 */       this.image.put(BoletoCampo.txtFcLogoBanco.name(), this.boletoInfoCampo.getImagemFcLogoBanco());
/*     */     } else {
/* 278 */       log.warn("Banco sem imagem definida. O nome da instituição será usado como logo.");
/* 279 */       this.text.put(BoletoCampo.txtRsLogoBanco.name(), this.boletoInfoCampo.getTextoRsLogoBanco());
/* 280 */       this.text.put(BoletoCampo.txtFcLogoBanco.name(), this.boletoInfoCampo.getTextoFcLogoBanco());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setLinhaDigitavel() {
/* 285 */     this.text.put(BoletoCampo.txtRsLinhaDigitavel.name(), this.boletoInfoCampo.getTextoRsLinhaDigitavel());
/* 286 */     this.text.put(BoletoCampo.txtFcLinhaDigitavel.name(), this.boletoInfoCampo.getTextoFcLinhaDigitavel());
/*     */   }
/*     */   
/*     */   private void setCodigoDeBarras() {
/* 290 */     this.image.put(BoletoCampo.txtFcCodigoBarra.name(), this.boletoInfoCampo.getImagemFcCodigoBarra());
/*     */   }
/*     */   
/*     */   private void setTodosOsCamposTexto() {
/* 294 */     if (Collections.hasElement(this.boletoTextosExtra)) {
/* 295 */       for (Map.Entry<String, String> entry : this.boletoTextosExtra.entrySet()) {
/* 296 */         this.text.put(entry.getKey(), entry.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void setTodosOsCamposImagem() {
/* 302 */     if (Collections.hasElement(this.boletoImagensExtra))
/* 303 */       for (Map.Entry<String, Image> entry : this.boletoImagensExtra.entrySet())
/* 304 */         this.image.put(entry.getKey(), entry.getValue());  
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\BoletoInfoViewBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */