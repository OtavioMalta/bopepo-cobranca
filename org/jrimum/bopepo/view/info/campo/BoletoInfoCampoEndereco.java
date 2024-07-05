/*     */ package org.jrimum.bopepo.view.info.campo;
/*     */ 
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.EntidadeDeCobranca;
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
/*     */ public class BoletoInfoCampoEndereco
/*     */ {
/*     */   public static String getTextoEnderecoLinha1(EntidadeDeCobranca pessoa) {
/*  46 */     if (Objects.isNotNull(pessoa)) {
/*  47 */       return getTextoEnderecoLinha1(pessoa.getNextEndereco());
/*     */     }
/*  49 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTextoEnderecoLinha1(Endereco endereco) {
/*  54 */     StringBuilder texto = new StringBuilder("");
/*     */     
/*  56 */     if (Objects.isNotNull(endereco)) {
/*     */       
/*  58 */       boolean temBairro = false;
/*  59 */       boolean temLocalidade = false;
/*     */       
/*  61 */       if (StringUtils.isNotBlank(endereco.getBairro())) {
/*  62 */         temBairro = true;
/*  63 */         texto.append(endereco.getBairro());
/*     */       } 
/*     */       
/*  66 */       if (StringUtils.isNotBlank(endereco.getLocalidade())) {
/*  67 */         temLocalidade = true;
/*  68 */         if (temBairro) {
/*  69 */           texto.append(" - ");
/*     */         }
/*  71 */         texto.append(endereco.getLocalidade());
/*     */       } 
/*     */       
/*  74 */       if (Objects.isNotNull(endereco.getUF())) {
/*  75 */         if (temBairro || temLocalidade) {
/*  76 */           texto.append(" / ");
/*     */         }
/*  78 */         texto.append(endereco.getUF().getSigla());
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     return texto.toString();
/*     */   }
/*     */   
/*     */   public static String getTextoEnderecoLinha2(EntidadeDeCobranca pessoa) {
/*  86 */     if (Objects.isNotNull(pessoa)) {
/*  87 */       return getTextoEnderecoLinha2(pessoa.getNextEndereco());
/*     */     }
/*  89 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTextoEnderecoLinha2(Endereco endereco) {
/*  94 */     StringBuilder texto = new StringBuilder("");
/*     */     
/*  96 */     if (Objects.isNotNull(endereco)) {
/*     */       
/*  98 */       if (StringUtils.isNotBlank(endereco.getLogradouro())) {
/*  99 */         texto.append(endereco.getLogradouro());
/*     */       }
/*     */       
/* 102 */       if (StringUtils.isNotBlank(endereco.getNumero())) {
/* 103 */         texto.append(", n°: ").append(endereco.getNumero());
/*     */       }
/*     */ 
/*     */       
/* 107 */       if (StringUtils.isNotBlank(endereco.getComplemento())) {
/* 108 */         texto.append(" / ").append(endereco.getComplemento());
/*     */       }
/*     */ 
/*     */       
/* 112 */       if (Objects.isNotNull(endereco.getCEP()) && StringUtils.isNotBlank(endereco.getCEP().getCep())) {
/* 113 */         texto.append(" - ").append("CEP: ").append(endereco.getCEP().getCep());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     return texto.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoEndereco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */