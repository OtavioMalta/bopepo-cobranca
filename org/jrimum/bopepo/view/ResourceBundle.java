/*     */ package org.jrimum.bopepo.view;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.jrimum.bopepo.pdf.Files;
/*     */ import org.jrimum.utilix.ClassLoaders;
/*     */ import org.jrimum.utilix.Exceptions;
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
/*     */ public class ResourceBundle
/*     */ {
/*     */   public static final String BOLETO_TEMPLATE_COM_SACADOR_AVALISTA = "BoletoTemplateComSacadorAvalista.pdf";
/*     */   public static final String BOLETO_TEMPLATE_SEM_SACADOR_AVALISTA = "BoletoTemplateSemSacadorAvalista.pdf";
/*  92 */   private final Map<String, Image> imagensLogoBanco = new TreeMap<String, Image>();
/*     */ 
/*     */   
/*     */   private byte[] defaultTemplateComSacadorAvalista;
/*     */ 
/*     */   
/*     */   private byte[] defaultTemplateSemSacadorAvalista;
/*     */ 
/*     */   
/*     */   public byte[] getTemplateComSacadorAvalista() {
/* 102 */     if (Objects.isNull(this.defaultTemplateComSacadorAvalista))
/*     */     {
/* 104 */       this.defaultTemplateComSacadorAvalista = loadPdf("BoletoTemplateComSacadorAvalista.pdf");
/*     */     }
/*     */     
/* 107 */     return this.defaultTemplateComSacadorAvalista;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getTemplateSemSacadorAvalista() {
/* 112 */     if (Objects.isNull(this.defaultTemplateSemSacadorAvalista))
/*     */     {
/* 114 */       this.defaultTemplateSemSacadorAvalista = loadPdf("BoletoTemplateSemSacadorAvalista.pdf");
/*     */     }
/*     */     
/* 117 */     return this.defaultTemplateSemSacadorAvalista;
/*     */   }
/*     */ 
/*     */   
/*     */   public Image getLogotipoDoBanco(String codigo) {
/* 122 */     Image logo = this.imagensLogoBanco.get(codigo);
/*     */     
/* 124 */     if (Objects.isNull(logo)) {
/* 125 */       logo = loadLogotipoDoBanco(codigo);
/* 126 */       this.imagensLogoBanco.put(codigo, logo);
/*     */     } 
/*     */     
/* 129 */     return logo;
/*     */   }
/*     */ 
/*     */   
/*     */   private BufferedImage loadLogotipoDoBanco(String codigo) {
/* 134 */     String path = "/img/%s.png";
/*     */     
/* 136 */     Strings.checkNotBlank(codigo, "Codigo do banco não informado!");
/*     */     
/* 138 */     String logo = String.format("/img/%s.png", new Object[] { codigo });
/*     */     
/* 140 */     URL url = ClassLoaders.getResource(logo, getClass());
/*     */     
/* 142 */     Objects.checkNotNull(url, String.format("Logo não \"%s\" não encontrada!", new Object[] { logo }));
/*     */     
/* 144 */     BufferedImage imageLogo = null;
/*     */     
/*     */     try {
/* 147 */       imageLogo = ImageIO.read(url);
/* 148 */       Objects.checkNotNull(imageLogo);
/* 149 */     } catch (IOException e) {
/* 150 */       Exceptions.throwIllegalStateException("Erro ao tentar ler a imagem logotipo do banco " + codigo, e);
/*     */     } 
/*     */     
/* 153 */     return imageLogo;
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[] loadPdf(String fileName) {
/* 158 */     byte[] pdf = null;
/* 159 */     InputStream is = null;
/*     */ 
/*     */     
/*     */     try {
/* 163 */       is = ClassLoaders.getResource("/pdf/" + fileName, getClass()).openStream();
/*     */ 
/*     */ 
/*     */       
/* 167 */       pdf = Files.toByteArray(is);
/*     */     }
/* 169 */     catch (Exception e) {
/*     */       
/* 171 */       Exceptions.throwIllegalStateException(e);
/*     */     } finally {
/*     */       
/* 174 */       if (is != null) {
/*     */         try {
/* 176 */           is.close();
/* 177 */         } catch (Exception e) {
/* 178 */           Exceptions.throwIllegalStateException(e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 183 */     return pdf;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\ResourceBundle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */