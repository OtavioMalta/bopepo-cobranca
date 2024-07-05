/*
 * Copyright 2011 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 14/04/2011 - 20:16:07
 * 
 * ================================================================================
 * 
 * Direitos autorais 2011 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 14/04/2011 - 20:16:07
 * 
 */

package org.jrimum.bopepo.campolivre;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Teste unitário do campo livre da Caixa Econômica Federal: "Cobrança Sem
 * Registro SICOB - Nosso Número 16 posições.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class TestCLCaixaEconomicaFederalSICOBNossoNumero14 extends AbstractCampoLivreBaseTest<CLCaixaEconomicaFederalSICOBNossoNumero14> {

	private static final int NOSSO_NUMERO_LENGTH = 14;
	
	@Before
	public void setUp(){

		titulo.getContaBancaria().setBanco(BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create());
		titulo.getContaBancaria().setAgencia(new Agencia(255, "5"));
		titulo.getContaBancaria().setNumeroDaConta(new NumeroDaConta(78));
		titulo.getContaBancaria().setCarteira(new Carteira(8));
		titulo.setNossoNumero("00000000113732");

		createCampoLivreToTest();

		setCampoLivreEsperadoComoString("0007802558700000000113732");
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaContaNulo() {

		testeSeNaoPermiteNumeroDaContaNulo();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaContaComCodigoZero() {

		testeSeNaoPermiteNumeroDaContaComCodigoZero();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaContaComCodigoNegativo() {

		testeSeNaoPermiteNumeroDaContaComCodigoNegativo();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaContaComCodigoAcimaDe5Digitos() {

		testeSeNaoPermiteNumeroDaContaComCodigoAcimaDoLimite(123456);
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteAgenciaNula() {

		testeSeNaoPermiteAgenciaNula();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void seNaoPermiteAgenciaComCodigoNegativo() {

		testeSeNaoPermiteAgenciaComCodigoNegativo();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteAgenciaComCodigoZero() {

		testeSeNaoPermiteAgenciaComCodigoZero();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNumeroDaAgenciaAcimaDe4Digitos() {

		testeSeNaoPermiteNumeroDaAgenciaComDigitosAcimaDoLimite(10000);
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteCarteiraNull() {

		titulo.getContaBancaria().setCarteira(null);

		createCampoLivreToTest();

		seCampoLivreEscritoEstaCorreto();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteCarteiraComCodigoNegativo() {

		titulo.getContaBancaria().setCarteira(new Carteira(-1));

		createCampoLivreToTest();

		seCampoLivreEscritoEstaCorreto();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteCarteiraQueNaoSejaSemRegistro() {

		titulo.getContaBancaria().setCarteira(new Carteira(1));

		createCampoLivreToTest();

		seCampoLivreEscritoEstaCorreto();
	}
	
	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroNulo() {

		testeSeNaoPermiteNossoNumeroNulo();
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComBrancos() {

		testeSeNaoPermiteNossoNumeroComBrancos(NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComEspacos() {

		testeSeNaoPermiteNossoNumeroComEspacos(NOSSO_NUMERO_LENGTH);
	}

	@Test(expected = CampoLivreException.class)
	public void seNaoPermiteNossoNumeroComTamanhoDiferenteDe14() {

		testeSeNaoPermiteNossoNumeroComTamanhoDiferenteDoEspecificado(NOSSO_NUMERO_LENGTH - 1);
	}
}
