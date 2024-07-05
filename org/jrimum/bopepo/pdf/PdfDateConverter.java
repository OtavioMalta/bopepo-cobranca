/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.TimeZone;
/*     */ import org.jrimum.texgit.type.component.Fillers;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PdfDateConverter
/*     */ {
/*     */   public static String convert(Calendar date) {
/* 101 */     Objects.checkNotNull(date, "Null não pode ser convertido em uma data no formato PDF!");
/*     */ 
/*     */     
/* 104 */     int NOT_INDEX = 1;
/*     */     
/* 106 */     StringBuilder dateTime = (new StringBuilder("D:")).append(date.get(1)).append(Fillers.ZERO_LEFT.fill(date.get(2) + 1, 2)).append(Fillers.ZERO_LEFT.fill(date.get(5), 2)).append(Fillers.ZERO_LEFT.fill(date.get(11), 2)).append(Fillers.ZERO_LEFT.fill(date.get(12), 2)).append(Fillers.ZERO_LEFT.fill(date.get(13), 2)).append(convertTimeZone(date));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     return dateTime.toString();
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
/*     */   private static String convertTimeZone(Calendar date) {
/* 129 */     int MINUTES_PER_HOUR = 60;
/* 130 */     int MILLISECONDS_PER_SECOND = 1000;
/* 131 */     int SECONDS_PER_MINUTE = 60;
/*     */     
/* 133 */     TimeZone tz = date.getTimeZone();
/*     */     
/* 135 */     String timeZone = "Z00'00'";
/*     */     
/* 137 */     if (Objects.isNotNull(tz)) {
/*     */       
/* 139 */       long offset = tz.getOffset(date.getTimeInMillis());
/*     */       
/* 141 */       long timeInMinutes = Math.abs(offset) / 1000L / 60L;
/*     */       
/* 143 */       String signal = (offset == 0L) ? "Z" : ((offset > 0L) ? "+" : "-");
/*     */       
/* 145 */       long hours = 0L;
/* 146 */       long minutes = 0L;
/*     */       
/* 148 */       if (timeInMinutes > 60L) {
/*     */         
/* 150 */         hours = timeInMinutes / 60L;
/* 151 */         minutes = timeInMinutes % 60L;
/*     */       } else {
/*     */         
/* 154 */         minutes = timeInMinutes;
/*     */       } 
/*     */       
/* 157 */       timeZone = String.format("%1$s%2$02d'%3$02d'", new Object[] { signal, Long.valueOf(hours), Long.valueOf(minutes) });
/*     */     } 
/*     */     
/* 160 */     return timeZone;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PdfDateConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */