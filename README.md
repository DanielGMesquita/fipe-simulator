# Simulador Fipe


Aplicação para consultar o valor médio de veículos (carros, motos ou caminhões) de acordo com a tabela FIPE, que pode ser acessada através [desse site](https://veiculos.fipe.org.br/).

- A consulta aos valores dos veículos pelo site tem o seguinte fluxo:
- Primeiramente é necessário escolher o tipo do veículo: carro, moto ou caminhão.

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/c64bc1d1-2957-4bca-9965-0ce2bf9a6207)


- Depois disso, é necessário preencher a MARCA, MODELO e ANO para consulta.

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/6d85805f-d6b6-40e8-a65d-17cb13a740ed)


- Por fim, é exibida a avaliação apenas daquele ano escolhido.

  ![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/94910321-15ed-49fe-bffc-25e1c4ab52dc)



## 🔨 Objetivos do projeto

- O objetivo do projeto é ter um fluxo similar ao que é feito no site, porém com algumas melhorias.
- Criaremos um projeto Spring com linha de comando, utilizando a classe Scanner para fazer interações com o usuário via terminal.
- Solicitaremos que o usuário digite o tipo de veículo desejado (carro, caminhão ou moto).
- Feito isso, listaremos todas as marcas daquele tipo de veículo, solicitando que o usuário escolha uma marca pelo código.
- Após essa escolha, listaremos todos os modelos de veículos daquela marca.
- Solicitaremos que o usuário digite um trecho do modelo que ele quer visualizar, por exemplo **PALIO**.
- Listaremos apenas os modelos que tiverem a palavra **PALIO** no nome.
- Usuário escolherá um modelo específico pelo código e, diferente do site, já listaremos as avaliações para **TODOS** os anos disponíveis daquele modelo, retornando uma lista de forma similar à imagem abaixo:

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/3d0ac772-3eff-4bad-a1fd-e7c2f34a39bc)



## Observações:

- Realizamos consumo de uma API para obtenção de dados, documentada [nesse link](https://deividfortuna.github.io/fipe/).

- De acordo com o escolhido (carro, moto, ou caminhão) vamos fazer uma chamada a um dos endpoints abaixo para buscar as marcas:

https://parallelum.com.br/fipe/api/v1/carros/marcas

https://parallelum.com.br/fipe/api/v1/motos/marcas

https://parallelum.com.br/fipe/api/v1/caminhoes/marcas

- O retorno dessa requisição será uma lista com código e marca desejada. Caso o usuário queira por exemplo fazer uma consulta a modelos de carros da Fiat, que possui o código 21, terá que fazer uma nova requisição para o endpoint:

https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos

- Feito isso, irá escolher um código de modelo, por exemplo esse **Palio Weekend Stile 1.6 mpi 16V 4p**, representado pelo código 560. Então deverá fazer uma terceira requisição para o endpoint:

https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos/560/anos

- Para saber a avaliação para cada ano disponível, teremos que fazer requisições pelo código por ano, onde obteremos um retorno similar ao que é mostrado abaixo:

https://parallelum.com.br/fipe/api/v1/carros/marcas/21/modelos/560/anos/2003-1