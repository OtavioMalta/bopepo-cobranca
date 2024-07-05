/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
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
/*     */ public class Files
/*     */ {
/*     */   private static final int DEFAULT_BUFFER_SIZE = 4096;
/*     */   public static final String ZIP_SUFFIX = ".zip";
/*     */   
/*     */   private Files() {
/*  82 */     Exceptions.throwIllegalStateException("Instanciação não permitida!");
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
/*     */   public static File bytesToFile(String pathName, byte[] bytes) throws FileNotFoundException, IOException {
/* 107 */     Strings.checkNotBlank(pathName);
/* 108 */     Objects.checkNotNull(bytes);
/*     */     
/* 110 */     return bytesToFile(new File(pathName), bytes);
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
/*     */   public static File bytesToFile(File file, byte[] bytes) throws FileNotFoundException, IOException {
/* 136 */     Objects.checkNotNull(file);
/* 137 */     Objects.checkNotNull(bytes);
/*     */     
/* 139 */     if (file.length() > 2147483647L) {
/* 140 */       Exceptions.throwIllegalArgumentException("TAMANHO DO ARQUIVO MAIOR DO QUE O SUPORTADO: 2147483647");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 145 */     OutputStream out = new FileOutputStream(file);
/*     */     
/* 147 */     out.write(bytes);
/* 148 */     out.flush();
/* 149 */     out.close();
/*     */     
/* 151 */     return file;
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
/*     */   public static ByteArrayOutputStream bytesToStream(byte[] bytes) throws IOException {
/* 173 */     Objects.checkNotNull(bytes);
/*     */     
/* 175 */     ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
/* 176 */     byteOut.write(bytes);
/*     */     
/* 178 */     return byteOut;
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
/*     */   public static byte[] fileToBytes(File file) throws IOException {
/* 192 */     Objects.checkNotNull(file);
/*     */     
/* 194 */     InputStream is = new FileInputStream(file);
/*     */     
/* 196 */     byte[] bytes = new byte[(int)file.length()];
/*     */     
/* 198 */     int offset = 0;
/* 199 */     int numRead = 0;
/*     */     
/* 201 */     while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)
/*     */     {
/* 203 */       offset += numRead;
/*     */     }
/*     */     
/* 206 */     is.close();
/*     */     
/* 208 */     Objects.checkArgument((offset == bytes.length), "Não foi possível completar a leitura do arquivo: " + file.getName());
/*     */ 
/*     */ 
/*     */     
/* 212 */     return bytes;
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
/*     */   public static byte[] toByteArray(InputStream input) throws IOException {
/* 230 */     Objects.checkNotNull(input);
/*     */     
/* 232 */     ByteArrayOutputStream output = new ByteArrayOutputStream();
/*     */     
/* 234 */     byte[] buffer = new byte[4096];
/*     */     
/* 236 */     int n = 0;
/*     */     
/* 238 */     while (-1 != (n = input.read(buffer)))
/*     */     {
/* 240 */       output.write(buffer, 0, n);
/*     */     }
/*     */     
/* 243 */     input.close();
/*     */     
/* 245 */     return output.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static File zip(File f) {
/* 250 */     return zip(f.getName(), f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File zip(String zipedName, File f) {
/*     */     try {
/* 257 */       return bytesToFile(File.createTempFile(zipedName, ".zip"), zip(toByteArray(f), f.getName()));
/*     */     }
/* 259 */     catch (IOException e) {
/*     */       
/* 261 */       throw new IllegalStateException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] zip(byte[] fileToZip, String fileZipedName) {
/* 267 */     ByteArrayOutputStream obout = new ByteArrayOutputStream();
/*     */     
/* 269 */     ZipOutputStream out = null;
/*     */ 
/*     */     
/*     */     try {
/* 273 */       out = new ZipOutputStream(obout);
/* 274 */       out.setMethod(8);
/* 275 */       out.putNextEntry(new ZipEntry(fileZipedName));
/*     */       
/* 277 */       out.write(fileToZip);
/*     */     
/*     */     }
/* 280 */     catch (IOException e) {
/*     */       
/* 282 */       throw new IllegalStateException(e);
/*     */     }
/*     */     finally {
/*     */       
/* 286 */       if (out != null) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 291 */           out.close();
/*     */         }
/* 293 */         catch (Exception e) {
/*     */           
/* 295 */           return (byte[])Exceptions.throwIllegalStateException(e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 300 */     return obout.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static File zip(Collection<File> files) {
/* 305 */     Map<String, File> toZip = new WeakHashMap<String, File>(files.size());
/*     */     
/* 307 */     for (File f : files) {
/* 308 */       toZip.put(f.getName(), f);
/*     */     }
/*     */     
/* 311 */     return zip(toZip);
/*     */   }
/*     */ 
/*     */   
/*     */   public static File zip(Map<String, File> files) {
/* 316 */     return zip("ZipedFiles", files);
/*     */   }
/*     */ 
/*     */   
/*     */   public static File zip(String zipedName, Map<String, File> files) {
/* 321 */     Map<String, byte[]> bytFiles = (Map)new HashMap<String, byte>(files.size());
/*     */     
/* 323 */     for (Map.Entry<String, File> nameAndFile : files.entrySet())
/*     */     {
/* 325 */       bytFiles.put(nameAndFile.getKey(), toByteArray(nameAndFile.getValue()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 331 */       return bytesToFile(File.createTempFile(zipedName, ".zip"), zipBytes(bytFiles));
/*     */     }
/* 333 */     catch (IOException e) {
/*     */       
/* 335 */       throw new IllegalStateException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] zipBytes(Map<String, byte[]> files) {
/* 342 */     byte[] buf = new byte[4096];
/*     */     
/* 344 */     ByteArrayOutputStream outs = new ByteArrayOutputStream();
/*     */ 
/*     */     
/*     */     try {
/* 348 */       ZipOutputStream out = new ZipOutputStream(outs);
/*     */ 
/*     */       
/* 351 */       for (Map.Entry<String, byte[]> entry : files.entrySet()) {
/*     */         
/* 353 */         if (entry.getValue() != null) {
/*     */           
/* 355 */           ByteArrayInputStream in = new ByteArrayInputStream(entry.getValue());
/*     */ 
/*     */ 
/*     */           
/* 359 */           out.putNextEntry(new ZipEntry(normalizeName(entry.getKey())));
/*     */ 
/*     */           
/*     */           int len;
/*     */           
/* 364 */           while ((len = in.read(buf)) > 0) {
/* 365 */             out.write(buf, 0, len);
/*     */           }
/*     */ 
/*     */           
/* 369 */           out.closeEntry();
/* 370 */           in.close();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 375 */       out.close();
/*     */       
/* 377 */       return outs.toByteArray();
/*     */     }
/* 379 */     catch (IOException e) {
/*     */       
/* 381 */       throw new IllegalStateException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] toByteArray(File file) {
/*     */     try {
/* 389 */       InputStream is = new FileInputStream(file);
/*     */       
/* 391 */       long length = file.length();
/*     */       
/* 393 */       if (length > 2147483647L) {
/* 394 */         Exceptions.throwIllegalArgumentException(String.format("File is too large! Max file length capacity is %s bytes.", new Object[] { Long.valueOf(length) }));
/*     */       }
/*     */       
/* 397 */       byte[] bytes = new byte[(int)length];
/*     */       
/* 399 */       int offset = 0;
/* 400 */       int numRead = 0;
/* 401 */       while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)
/*     */       {
/* 403 */         offset += numRead;
/*     */       }
/*     */       
/* 406 */       is.close();
/*     */       
/* 408 */       if (offset < bytes.length) {
/* 409 */         throw new IOException("Could not completely read file " + file.getName());
/*     */       }
/*     */       
/* 412 */       return bytes;
/*     */     }
/* 414 */     catch (Exception e) {
/* 415 */       return (byte[])Exceptions.throwIllegalStateException(e);
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
/*     */   public static String normalizeName(String name) {
/* 429 */     name = name.replaceAll(" ", "_");
/* 430 */     name = Strings.eliminateAccent(name);
/* 431 */     name = name.replaceAll("[^\\p{ASCII}]", "");
/* 432 */     return name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\Files.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */