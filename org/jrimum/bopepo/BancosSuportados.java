/*     */ package org.jrimum.bopepo;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.jrimum.domkee.comum.pessoa.id.cprf.CNPJ;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Banco;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.CodigoDeCompensacaoBACEN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum BancosSuportados
/*     */ {
/* 126 */   BANCO_DO_BRASIL("001", "00000000000191", "BANCO DO BRASIL S.A.", "Banco do Brasil - Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   BANCO_DO_NORDESTE_DO_BRASIL("004", "07237373000120", "BANCO DO NORDESTE DO BRASIL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   BANCO_DO_ESTADO_DO_ESPIRITO_SANTO("021", "28127603000178", "BANCO DO ESTADO DO ESPIRITO SANTO S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   BANCO_SANTANDER("033", "90400888000142", "BANCO SANTANDER (BRASIL) S. A.", "Banco Mútiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   BANCO_DO_ESTADO_DO_RIO_GRANDE_DO_SUL("041", "92702067000196", "BANCO DO ESTADO DO RIO GRANDE DO SUL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   BANCO_DE_BRASILIA("070", "00000208000100", "BRB- Banco de Brasília S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   BANCO_INTEMEDIUM("077", "00416968000101", "BANCO INTERMEDIUM S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   CECRED("085", "05.463.212/0001-29", "COOPERATIVA CENTRAL DE CRÉDITO URBANO - CECRED", "Cooperativa de Crédito"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   CAIXA_ECONOMICA_FEDERAL("104", "00360305000104", "CAIXA ECONOMICA FEDERAL", "Caixa Econômica Federal"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   BANCO_BRADESCO("237", "60746948000112", "BANCO BRADESCO S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 216 */   BANCO_ITAU("341", "60701190000104", "BANCO ITAÚ S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 229 */   BANCO_ABN_AMRO_REAL("356", "33066408000115", "BANCO ABN AMRO REAL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 237 */   MERCANTIL_DO_BRASIL("389", "17184037000110", "BANCO MERCANTIL DO BRASIL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 246 */   HSBC("399", "01701201000189", "HSBC BANK BRASIL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 255 */   UNIBANCO("409", "33700394000140", "UNIBANCO-UNIAO DE BANCOS BRASILEIROS S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 264 */   BANCO_SAFRA("422", "58160789000128", "BANCO SAFRA S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 273 */   CITIBANK("745", "33479023000180", "BANCO CITIBANK S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 282 */   BANCO_SICREDI("748", "01181521000155", "BANCO COOPERATIVO SICREDI S.A.", "Banco Mútiplo Cooperativo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 291 */   BANCO_RURAL("453", "58160789000128", "BANCO RURAL S.A.", "Banco Múltiplo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 300 */   BANCOOB("756", "02038232000164", "BANCO COOPERATIVO DO BRASIL S.A. - BANCOOB", "Banco Comercial Cooperativo");
/*     */   public static final Map<String, BancosSuportados> suportados;
/*     */   private String codigoDeCompensacaoBACEN;
/*     */   private String cNPJ;
/*     */   private String instituicao;
/*     */   private String segmento;
/*     */   
/*     */   static {
/* 308 */     suportados = new HashMap<String, BancosSuportados>((values()).length);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     suportados.put(BANCO_DO_BRASIL.codigoDeCompensacaoBACEN, BANCO_DO_BRASIL);
/* 314 */     suportados.put(BANCO_DO_NORDESTE_DO_BRASIL.codigoDeCompensacaoBACEN, BANCO_DO_NORDESTE_DO_BRASIL);
/* 315 */     suportados.put(CAIXA_ECONOMICA_FEDERAL.codigoDeCompensacaoBACEN, CAIXA_ECONOMICA_FEDERAL);
/* 316 */     suportados.put(BANCO_BRADESCO.codigoDeCompensacaoBACEN, BANCO_BRADESCO);
/* 317 */     suportados.put(BANCO_ABN_AMRO_REAL.codigoDeCompensacaoBACEN, BANCO_ABN_AMRO_REAL);
/* 318 */     suportados.put(UNIBANCO.codigoDeCompensacaoBACEN, UNIBANCO);
/* 319 */     suportados.put(HSBC.codigoDeCompensacaoBACEN, HSBC);
/* 320 */     suportados.put(BANCO_ITAU.codigoDeCompensacaoBACEN, BANCO_ITAU);
/* 321 */     suportados.put(BANCO_SAFRA.codigoDeCompensacaoBACEN, BANCO_SAFRA);
/* 322 */     suportados.put(BANCO_DO_ESTADO_DO_RIO_GRANDE_DO_SUL.codigoDeCompensacaoBACEN, BANCO_DO_ESTADO_DO_RIO_GRANDE_DO_SUL);
/* 323 */     suportados.put(MERCANTIL_DO_BRASIL.codigoDeCompensacaoBACEN, MERCANTIL_DO_BRASIL);
/* 324 */     suportados.put(BANCO_DO_ESTADO_DO_ESPIRITO_SANTO.codigoDeCompensacaoBACEN, BANCO_DO_ESTADO_DO_ESPIRITO_SANTO);
/* 325 */     suportados.put(BANCO_RURAL.codigoDeCompensacaoBACEN, BANCO_RURAL);
/* 326 */     suportados.put(BANCO_SANTANDER.codigoDeCompensacaoBACEN, BANCO_SANTANDER);
/* 327 */     suportados.put(BANCO_INTEMEDIUM.codigoDeCompensacaoBACEN, BANCO_INTEMEDIUM);
/* 328 */     suportados.put(BANCO_SICREDI.codigoDeCompensacaoBACEN, BANCO_SICREDI);
/* 329 */     suportados.put(BANCOOB.codigoDeCompensacaoBACEN, BANCOOB);
/* 330 */     suportados.put(CITIBANK.codigoDeCompensacaoBACEN, CITIBANK);
/* 331 */     suportados.put(BANCO_DE_BRASILIA.codigoDeCompensacaoBACEN, BANCO_DE_BRASILIA);
/* 332 */     suportados.put(CECRED.codigoDeCompensacaoBACEN, CECRED);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BancosSuportados(String codigoDeCompensacaoBACEN, String cnpj, String instituicao, String segmento) {
/* 388 */     this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;
/* 389 */     this.cNPJ = cnpj;
/* 390 */     this.instituicao = instituicao;
/* 391 */     this.segmento = segmento;
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
/*     */   public static boolean isSuportado(String codigoDeCompensacao) {
/* 407 */     return suportados.containsKey(codigoDeCompensacao);
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
/*     */   
/*     */   public Banco create() {
/* 433 */     return new Banco(new CodigoDeCompensacaoBACEN(this.codigoDeCompensacaoBACEN), this.instituicao, new CNPJ(this.cNPJ), this.segmento);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCodigoDeCompensacao() {
/* 443 */     return this.codigoDeCompensacaoBACEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCNPJ() {
/* 452 */     return this.cNPJ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstituicao() {
/* 461 */     return this.instituicao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSegmento() {
/* 470 */     return this.segmento;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\BancosSuportados.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */