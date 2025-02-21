# Projeto Bopepo Cobranca

![](https://api.visitorbadge.io/api/VisitorHit?user=OtavioMaltaf&repo=bopepo-cobranca&countColor=%237B1E7A)

Este projeto é uma engenharia reversa do projeto open-source [JRimum Bopepo](http://www.jrimum.org), versão 0.2.3.

## Introdução

O [JRimum Bopepo](http://www.jrimum.org) é uma biblioteca Java para a geração de boletos bancários no formato padrão do Brasil. A versão 0.2.3 é uma versão antiga, mas ainda utilizada em muitos sistemas para geração de boletos.

Este projeto tem como objetivo estender a funcionalidade da biblioteca para suportar a geração de boletos após a data limite estabelecida pela versão original do Bopepo.

## Objetivos

O principal objetivo deste projeto é:

- **Habilitar a geração de boletos** após a data limite estabelecida pela versão 0.2.3 do Bopepo, que é 21/02/2025.

Além disso, o projeto visa:

- **Manter as dependências** da versão 0.2.3 do projeto principal para garantir compatibilidade com o sistema legado.
- **Corrigir o erro** relacionado ao cálculo do fator de vencimento, que atualmente exige uma data entre 07/10/1997 e 21/02/2025.

## Features

- Geração de boletos bancários com a capacidade de estender a data de vencimento além da data limite original.
- Compatibilidade com a versão 0.2.3 do [JRimum Bopepo](http://www.jrimum.org).
- Correção de erros no cálculo do fator de vencimento.

## Artefato do Maven Central

O artefato do Maven Central pode ser adicionado ao seu `pom.xml` com a seguinte dependência:

```xml
<dependency>
  <groupId>io.github.otaviomalta</groupId>
  <artifactId>bopepo-cobranca</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```
E instalar via linha de comando:
```bash
mvn install
```
