/*    */ package org.jrimum.bopepo.view.info.campo;
/*    */ 
/*    */ import org.jrimum.domkee.financeiro.banco.febraban.EntidadeDeCobranca;
/*    */ import org.jrimum.utilix.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoletoInfoCampoPessoa
/*    */ {
/*    */   public static String getTextoNomeCprfDaPessoa(EntidadeDeCobranca pessoa) {
/* 57 */     StringBuilder sb = new StringBuilder("");
/* 58 */     boolean temNome = false;
/*    */     
/* 60 */     if (Objects.isNotNull(pessoa)) {
/*    */       
/* 62 */       if (Objects.isNotNull(pessoa.getNome())) {
/* 63 */         temNome = true;
/* 64 */         sb.append(pessoa.getNome());
/*    */       } 
/*    */       
/* 67 */       if (Objects.isNotNull(pessoa.getCPRF())) {
/*    */         
/* 69 */         if (temNome) {
/* 70 */           sb.append(", ");
/*    */         }
/*    */         
/* 73 */         if (pessoa.getCPRF().isFisica()) {
/* 74 */           sb.append("CPF: ");
/*    */         }
/* 76 */         else if (pessoa.getCPRF().isJuridica()) {
/* 77 */           sb.append("CNPJ: ");
/*    */         } 
/*    */         
/* 80 */         sb.append(pessoa.getCPRF().getCodigoFormatado());
/*    */       } 
/*    */     } 
/*    */     
/* 84 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\info\campo\BoletoInfoCampoPessoa.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */