/*     */ package org.jrimum.bopepo;
/*     */ 
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jrimum.utilix.Exceptions;
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
/*     */ public final class BoletoUtil
/*     */ {
/*     */   private static final String CODIGO_DE_BARRAS_REGEX = "\\d{44}";
/*     */   private static final String LINHA_DIGITAVEL_NUMERICA_REGEX = "\\d{47}";
/*     */   private static final String LINHA_DIGITAVEL_FORMATADA_REGEX = "\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d{1} \\d{14}";
/*     */   private static final String MSG_CODIGO_DE_BARRAS = "Código de barras inválido!";
/*     */   private static final String MSG_LINHA_INVALIDA = "Linha digitável inválida!";
/*     */   private static final String MSG_STR_VAZIA = "String vazia [ \"%s\" ] tamanho [ %d ].";
/*     */   private static final String MSG_NAO_FORMATADA = "String formatada [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddd.ddddd ddddd.dddddd ddddd.dddddd d dddddddddddddd\" ] tamanho = 54.";
/*     */   private static final String MSG_STR_NUMERICA = "String numérica [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddddddddddddddddddddddddddddddddddddddddddddd\" ] tamanho = 47.";
/*     */   
/*     */   private BoletoUtil() {
/*  81 */     Exceptions.throwIllegalStateException("Instanciação não permitida!");
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
/*     */   public static String getCampoLivreDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 103 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 105 */     String linhaNumerica = linhaDigitavelFormatadaEmNumerica(linhaDigitavel);
/*     */     
/* 107 */     return linhaNumerica.substring(4, 9) + linhaNumerica.substring(10, 20) + linhaNumerica.substring(21, 31);
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
/*     */   public static String getValorDoTituloDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 131 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 133 */     return linhaDigitavelFormatadaEmNumerica(linhaDigitavel).substring(37, 47);
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
/*     */   public static String getFatorDeVencimentoDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 156 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 158 */     return linhaDigitavelFormatadaEmNumerica(linhaDigitavel).substring(33, 37);
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
/*     */   public static String getDigitoVerificadorGeralDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 181 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 183 */     return linhaDigitavelFormatadaEmNumerica(linhaDigitavel).substring(32, 33);
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
/*     */   public static String getCodigoDaMoedaDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 206 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 208 */     return linhaDigitavelFormatadaEmNumerica(linhaDigitavel).substring(3, 4);
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
/*     */   public static String getCodigoDoBancoDaLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 231 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 233 */     return linhaDigitavelFormatadaEmNumerica(linhaDigitavel).substring(0, 3);
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
/*     */   public static String getCampoLivreDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 256 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 258 */     return StringUtils.trim(codigoDeBarras).substring(19, 44);
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
/*     */   public static String getValorDoTituloDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 280 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 282 */     return StringUtils.trim(codigoDeBarras).substring(9, 19);
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
/*     */   public static String getFatorDeVencimentoDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 304 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 306 */     return StringUtils.trim(codigoDeBarras).substring(5, 9);
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
/*     */   public static String getDigitoVerificadorGeralDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 328 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 330 */     return StringUtils.trim(codigoDeBarras).substring(4, 5);
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
/*     */   public static String getCodigoDaMoedaDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 352 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 354 */     return StringUtils.trim(codigoDeBarras).substring(3, 4);
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
/*     */   public static String getCodigoDoBancoDoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 376 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 378 */     return StringUtils.trim(codigoDeBarras).substring(0, 3);
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
/*     */   public static String codigoDeBarrasEmLinhaDigitavelFormatada(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 406 */     return linhaDigitavelNumericaEmFormatada(codigoDeBarrasEmLinhaDigitavelNumerica(codigoDeBarras));
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
/*     */   public static String codigoDeBarrasEmLinhaDigitavelNumerica(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 434 */     checkFormatoCodigoDeBarras(codigoDeBarras);
/*     */     
/* 436 */     BoletoLinhaDigitavelDV calculadorDV = new BoletoLinhaDigitavelDV();
/*     */     
/* 438 */     StringBuilder linhaDigitavel = new StringBuilder();
/*     */     
/* 440 */     String c = StringUtils.trim(codigoDeBarras);
/*     */ 
/*     */ 
/*     */     
/* 444 */     linhaDigitavel.append(c.substring(0, 3));
/*     */     
/* 446 */     linhaDigitavel.append(c.substring(3, 4));
/* 447 */     linhaDigitavel.append(c.substring(19, 24));
/* 448 */     linhaDigitavel.append(calculadorDV.calcule(linhaDigitavel.toString()));
/*     */ 
/*     */     
/* 451 */     linhaDigitavel.append(c.substring(24, 34));
/* 452 */     linhaDigitavel.append(calculadorDV.calcule(c.substring(24, 34)));
/*     */ 
/*     */     
/* 455 */     linhaDigitavel.append(c.substring(34, 44));
/* 456 */     linhaDigitavel.append(calculadorDV.calcule(c.substring(34, 44)));
/*     */ 
/*     */     
/* 459 */     linhaDigitavel.append(c.substring(4, 5));
/*     */ 
/*     */     
/* 462 */     linhaDigitavel.append(c.substring(5, 19));
/*     */     
/* 464 */     return linhaDigitavel.toString();
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
/*     */   public static String linhaDigitavelFormatadaEmCodigoDeBarras(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 494 */     return linhaDigitavelNumericaEmCodigoDeBarras(linhaDigitavelFormatadaEmNumerica(linhaDigitavel));
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
/*     */   public static String linhaDigitavelNumericaEmCodigoDeBarras(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 522 */     checkFormatoLinhaDigitavelNumerica(linhaDigitavel);
/*     */     
/* 524 */     StringBuilder codigoDeBarras = new StringBuilder();
/*     */     
/* 526 */     String l = StringUtils.trim(linhaDigitavel);
/*     */ 
/*     */     
/* 529 */     codigoDeBarras.append(l.substring(0, 3));
/*     */     
/* 531 */     codigoDeBarras.append(l.substring(3, 4));
/*     */     
/* 533 */     codigoDeBarras.append(l.substring(32, 33));
/* 534 */     codigoDeBarras.append(l.substring(33, 47));
/* 535 */     codigoDeBarras.append(l.substring(4, 9));
/* 536 */     codigoDeBarras.append(l.substring(10, 20));
/* 537 */     codigoDeBarras.append(l.substring(21, 31));
/*     */     
/* 539 */     return codigoDeBarras.toString();
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
/*     */   public static String linhaDigitavelFormatadaEmNumerica(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 568 */     checkFormatoLinhaDigitavelFormatada(linhaDigitavel);
/*     */     
/* 570 */     return linhaDigitavel.replaceAll(" ", "").replaceAll("\\.", "");
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
/*     */   public static String linhaDigitavelNumericaEmFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 599 */     checkFormatoLinhaDigitavelNumerica(linhaDigitavel);
/*     */     
/* 601 */     StringBuilder linhaFormatada = new StringBuilder();
/*     */     
/* 603 */     String l = StringUtils.trim(linhaDigitavel);
/*     */     
/* 605 */     linhaFormatada.append(l.substring(0, 5));
/* 606 */     linhaFormatada.append(".");
/* 607 */     linhaFormatada.append(l.substring(5, 10));
/* 608 */     linhaFormatada.append(" ");
/* 609 */     linhaFormatada.append(l.substring(10, 15));
/* 610 */     linhaFormatada.append(".");
/* 611 */     linhaFormatada.append(l.substring(15, 21));
/* 612 */     linhaFormatada.append(" ");
/* 613 */     linhaFormatada.append(l.substring(21, 26));
/* 614 */     linhaFormatada.append(".");
/* 615 */     linhaFormatada.append(l.substring(26, 32));
/* 616 */     linhaFormatada.append(" ");
/* 617 */     linhaFormatada.append(l.substring(32, 33));
/* 618 */     linhaFormatada.append(" ");
/* 619 */     linhaFormatada.append(l.substring(33));
/*     */     
/* 621 */     return linhaFormatada.toString();
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
/*     */   public static boolean isCodigoDeBarrasValido(String codigoDeBarras) {
/* 634 */     if (StringUtils.isNotBlank(codigoDeBarras))
/*     */     {
/* 636 */       return codigoDeBarras.trim().matches("\\d{44}");
/*     */     }
/*     */     
/* 639 */     return false;
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
/*     */   public static boolean isLinhaDigitavelFormatadaValida(String linhaDigitavel) {
/* 654 */     if (StringUtils.isNotBlank(linhaDigitavel))
/*     */     {
/* 656 */       return linhaDigitavel.trim().matches("\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d{1} \\d{14}");
/*     */     }
/*     */ 
/*     */     
/* 660 */     return false;
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
/*     */   public static boolean isLinhaDigitavelNumericaValida(String linhaDigitavel) {
/* 675 */     if (StringUtils.isNotBlank(linhaDigitavel))
/*     */     {
/* 677 */       return linhaDigitavel.trim().matches("\\d{47}");
/*     */     }
/*     */ 
/*     */     
/* 681 */     return false;
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
/*     */   public static void checkFormatoLinhaDigitavelFormatada(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 720 */     checkExistsLinhaDigitavel(linhaDigitavel);
/*     */     
/* 722 */     if (!linhaDigitavel.contains(".")) {
/* 723 */       throw new LinhaDigitavelException("Linha digitável inválida! " + String.format("String formatada [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddd.ddddd ddddd.dddddd ddddd.dddddd d dddddddddddddd\" ] tamanho = 54.", new Object[] { linhaDigitavel, Integer.valueOf(linhaDigitavel.length()) }) + " A linha digitável formatada deve conter pontos!");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 730 */     if (!linhaDigitavel.trim().contains(" ")) {
/* 731 */       throw new LinhaDigitavelException("Linha digitável inválida! " + String.format("String formatada [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddd.ddddd ddddd.dddddd ddddd.dddddd d dddddddddddddd\" ] tamanho = 54.", new Object[] { linhaDigitavel, Integer.valueOf(linhaDigitavel.length()) }) + " A linha digitável formatada deve conter espaços!");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 738 */     if (!isLinhaDigitavelFormatadaValida(linhaDigitavel)) {
/* 739 */       throw new LinhaDigitavelException("Linha digitável inválida! " + String.format("String formatada [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddd.ddddd ddddd.dddddd ddddd.dddddd d dddddddddddddd\" ] tamanho = 54.", new Object[] { linhaDigitavel, Integer.valueOf(linhaDigitavel.length()) }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void checkFormatoLinhaDigitavelNumerica(String linhaDigitavel) throws IllegalArgumentException, LinhaDigitavelException {
/* 780 */     checkExistsLinhaDigitavel(linhaDigitavel);
/*     */     
/* 782 */     if (!isLinhaDigitavelNumericaValida(linhaDigitavel)) {
/* 783 */       throw new LinhaDigitavelException("Linha digitável inválida! " + String.format("String numérica [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddddddddddddddddddddddddddddddddddddddddddddd\" ] tamanho = 47.", new Object[] { linhaDigitavel, Integer.valueOf(linhaDigitavel.length()) }) + " A linha deve conter apenas 47 dígitos númericos [0-9]!");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void checkFormatoCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException, CodigoDeBarrasException {
/* 826 */     checkExistsCodigoDeBarras(codigoDeBarras);
/*     */     
/* 828 */     if (!isCodigoDeBarrasValido(codigoDeBarras)) {
/* 829 */       throw new CodigoDeBarrasException("Código de barras inválido! " + String.format("String numérica [ \"%s\" ] de tamanho [ %d ] está fora do padrão [ \"ddddddddddddddddddddddddddddddddddddddddddddddd\" ] tamanho = 47.", new Object[] { codigoDeBarras, Integer.valueOf(codigoDeBarras.length()) }) + " O código de barras deve conter apenas 44 dígitos númericos [0-9]!");
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
/*     */ 
/*     */   
/*     */   public static void checkExistsLinhaDigitavel(String linhaDigitavel) throws IllegalArgumentException {
/* 857 */     Objects.checkNotNull(linhaDigitavel, "Linha digitável inválida!");
/*     */     
/* 859 */     if (StringUtils.isBlank(linhaDigitavel)) {
/* 860 */       Exceptions.throwIllegalArgumentException("Linha digitável inválida! " + String.format("String vazia [ \"%s\" ] tamanho [ %d ].", new Object[] { linhaDigitavel, Integer.valueOf(linhaDigitavel.length()) }));
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
/*     */   public static void checkExistsCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException {
/* 884 */     Objects.checkNotNull(codigoDeBarras, "Linha digitável inválida!");
/*     */     
/* 886 */     if (StringUtils.isBlank(codigoDeBarras))
/* 887 */       Exceptions.throwIllegalArgumentException("Código de barras inválido! " + String.format("String vazia [ \"%s\" ] tamanho [ %d ].", new Object[] { codigoDeBarras, Integer.valueOf(codigoDeBarras.length()) })); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\BoletoUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */