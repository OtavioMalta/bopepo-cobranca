/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 28/07/2010 - 21:05:00
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 28/07/2010 - 21:05:00
 * 
 */

package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
import org.junit.Before;

/**
 * <p>
 * Teste unitário do campo livre do banco caixa econômica federal para o serviço SIGCB.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class TestCLCaixaEconomicaFederalSIGCB extends AbstractCampoLivreBaseTest<CLCaixaEconomicaFederalSIGCB> {
	
	@Before
	public void setUp(){
		
		titulo.getContaBancaria().setBanco(BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create());
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(5507,"7"));
		titulo.getContaBancaria().setCarteira(new Carteira(24, TipoDeCobranca.COM_REGISTRO));
		titulo.setNossoNumero("000000000000019");
		
		createCampoLivreToTest();
		
		setCampoLivreEsperadoComoString("0055077000100040000000190");
	}
}
