# Desafio_Capgemini_ProWay

Desafio proposto pela Academia Técnica Capgemini e ProWay

O DESAFIO

Este projeto consiste na criação de dois programas: uma calculadora de visualizações de anúncios, para estimar a quantidade máxima de visualizações de anúncios online, e um sistema de cadastro de anúncios, que fornece um relatório dos anúncios cadastrados e permite filtrá-los por cliente e intervalo de tempo.

Ao todo, foram criadas quatro classes, uma para construir o código da calculadora, uma para construir o código do sistema de cadastro, e duas para realizar os testes unitários. Os códigos fonte se encontram dentro da pasta "DESAFIO_CAPGEMINI/anuncio/anuncio".

Todos os programas foram criados para serem compilados no console da IDE (Integrated Development Environment), inserindo os dados pelo teclado.

PROGRAMA DA CALCULADORA

No programa da calculadora, elaborou-se um sistema para entrada do valor total investido no anúncio, tendo-se como saída a quantidade máxima de pessoas que visualizarão o anúncio.

PROGRAMA DO SISTEMA DE CADASTRO

No programa do sistema de cadastro, elaborou-se um sistema para receber os dados do cliente:
- Nome do anúncio;
- Nome do cliente;
- Data de início do anúncio, com dia, mês e ano;
- Data de término do anúncio, com dia, mês e ano;
- Valor diário investido no anúncio.

Após o recebimento dos dados, é gerado um relatório com os dados do cliente e as informações calculadas a seguir:
- Valor total investido no anúncio;
- Quantidade máxima estimada de visualizações;
- Quantidade máxima estimada de cliques;
- Quantidade máxima estimada de compartilhamentos.

Em seguida, pode-se optar por filtrar o relatório pelo nome do cliente ou pelo intervalo de tempo, inserindo esses dados. No intervalo de tempo, faz-se uma comparação entre o período em que o anúncio permaneceu online e um período determinado para essa busca, resultando na impressão dos anúncios exibidos no intervalo de tempo determinado pela busca.

Ao final do programa, é possível reiniciar, inserindo novos clientes ao cadastro.

TECNOLOGIAS UTILIZADAS
- Java 11;
- JUnit.

