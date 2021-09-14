# Projeto: Curso Código Sem Barreiras

#### By: Share RH & Alelo

#### IDE: IntelliJ Community

#### Linguagem: Java

#### Autor: Jonatas "Kallrish" Ribeiro

#### *Código: comentado, seguindo boas práticas, para auxiliar nos estudos, especialmente de iniciantes.*

Olá! Bem-vindo(a) aos meus estudos e projetos no Github! :wave:

Neste projeto, realizo exercícios propostos durante o **Curso de Java** que estou cursando da  **Share RH**, em parceria com a Alelo.

O curso está sendo ministrado pelo :man_teacher: professor ***Anderson Rocha*** (https://github.com/andersonrocha0).

Apesar do curso ser **introdutório** e priorizar **nivelamento de conhecimento** entre os participantes, é provável que eu implemente algumas soluções usando recursos um pouco mais avançados dependendo da situação.

Os códigos estão divididos em pacotes referente ao material e subdivididos em classes para cada exercício.

Abaixo deixo a lista com os enunciados de cada exercício para que seja possível entender o que foi proposto em comparação com o código da resolução. Quando não houver necessidade de código para resolução do que for proposto, deixarei tanto a pergunta como a resposta neste README (*a medida que houverem mais exercícios, vou atualizando este arquivo*):

- **1 - Package "parte01_01logicaevariaveis"**

  - *md01Exercício01* - Escreva um algoritmo que armazene o valor 99 em uma variável Y e o valor 11 em uma variável Z. A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos fazendo com que o valor que está em Y passe para Z e vice-versa. Ao final, escrever os valores que ficaram armazenados nas variáveis
  - *md01Exercício02* - Escreva um algoritmo para ler um valor (do teclado) e escrever (na tela) o seu antecessor.
  - *md01Exercício03* - Escreva um algoritmo para ler as dimensões de um retângulo (base e altura), calcular e escrever a área do retângulo.
  - *md01Exercício04* - Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos brancos, nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao total de eleitores.
  
- **2 - Package "parte01_02estruturasdecontrole"** 
  
  - *md02Exercício01* - Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.
  - *md02Exercício02* - Elabore um algoritmo que dada a idade de um nadador classifique-o em uma das seguintes categorias:
    * Infantil A = 5 a 7 anos
    * Infantil B = 8 a 11 anos
    * Juvenil A = 12 a 13 anos
    * Juvenil B = 14 a 17 anos
    * Adultos = Maiores de 18 anos
  - *md02Exercício03* - Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor. Escreva um algoritmo que determina o maior também. 
  - *md02Exercício04* - Construa um algoritmo que leia 10 valores inteiros e positivos e:
    * Encontre o maior valor
    * Encontre o menor valor
    * Calcule a média dos números lidos
  - *md02Exercício05* - Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações matemáticas (adição, subtração, multiplicação e divisão). Todas as operações serão entre dois valores. No começo do algoritmo pergunte ao usuário qual operação ele deseja fazer e quais são os valores.
  - *md02Exercício06* - Faça a implementação do Jogo Pedra, Papel e Tesoura (Jokempô). O algoritmo deverá perguntar qual é a escolha do jogador 1 (Pedra [pe], Papel [pa], Tesoura [t]) e deverá fazer o mesmo para o jogador 2. No final da execução o algoritmo deverá dizer qual é o jogador vencedor ou se houve empate.
  
- **Package "parte01_03estruturasderepeticao"**

  - *md03Exercício01* - Construa um algoritmo que leia 10 valores inteiros e positivos e:
    - Encontre o maior valor
    - Encontre o menor valor
    - Calcule a média dos números lidos
      Esse exercício foi dado na aula 3 e agora vamos otimizar ele utilizando o while e for.
  - *md03Exercício02* - Construa um algoritmo usando uma estrutura de repetição que calcule o fatorial de um número.
  
- **Package "parte02_01introducaopoo"**

  - Por que é importante se preocupar com a abstração?
    - É importante para melhorar a qualidade do código desenvolvido e sua abrangência, auxiliando na resolução do problema proposto da melhor forma possível.
  - O que é encapsulamento e qual sua importância em Orientação a objetos?
    - É programar de forma que que uma classe só saiba o que for necessário da outra para executar sua função, permitindo maior segurança no código (já que não haverá possibilidade de visualziar e alterar o que não se deve), como permitir ao usuário usar somente aquilo que ele deve e precisa.
  
- **Package "parte02_02classeseobjetos"**
  - *sub Package: Exercício01 -* Crie uma classe para representar uma pessoa, com os atributos  de nome, ano de nascimento e altura. Crie e também um método para imprimir todos dados de uma pessoa. Crie um método para calcular a idade da pessoa.
  - *sub Package: Exercício02 -* Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as seguintes operações:
    - void armazenaPessoa(String nome, int idade, float altura);
    - void removePessoa(String nome);
    - int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
    - void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
    - void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da agenda.
  - *sub Package: Exercício03 -* Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro de um prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio (desconsiderando o térreo), capacidade do elevador e quantas pessoas estão presentes nele. A classe deve também disponibilizar os seguintes métodos:
    - Inicializa : que deve receber como parâmetros a capacidade do elevador e o total de andares no prédio (os elevadores sempre começam no térreo e vazio);
    - Entra : para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço);
    - Sai : para remover uma pessoa do elevador (só deve remover se houver alguém dentro dele);
    - Sobe : para subir um andar (não deve subir se já estiver no último andar);
    - Desce : para descer um andar (não deve descer se já estiver no térreo);
  - *sub Package: Exercício04 -* Crie uma classe Televisão e uma classe ControleRemoto que pode controlar o volume e trocar os canais da televisão. O controle de volume permite:
    - aumentar ou diminuir a potência do volume de som em uma unidade de cada vez;
    - aumentar e diminuir o número do canal em uma unidade
    - trocar para um canal indicado;
    - consultar o valor do volume de som e o canal selecionado.
  
- **Package "parte02_04arrayselistas"**
  - *md04Exercício01 -* Escreva um algoritmo que leia números insira em um array e após mostre os números informados na tela.
  - *md04Exercício02 -* Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números negativos.
  - *md04Exercício03 -* Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números pares.
  - *md04Exercício04 -* Escreva um algoritmo que leia números, insira em um array e após mostre o maior valor.
  - *md04Exercício05 -* Escreva um algoritmo que simula um jogo da forca simples. o usuario precisara adivinhar uma palavra chutando cada letra em no máximo 10 chutes, caso o usuario acerte a letra o jogo dirá que ele acertou, caso tenha errado, o numero de tentativas vai diminuindo. Caso o numero de tentativas chegue a 0 o usuário perde.
  
- **Package "parte02_05encapsulamento"**
  - *md05Exercício01 -*Escreva uma classe que represente um país. 
    * Um país é representado através dos atributos: código ISO (ex.: 3166-1 [BRA]), nome (ex.: Brasil), população (ex.: 193.946.886) e a sua dimensão em Km2 (ex.: 8.515.767,049). Além disso, cada país mantém uma lista de outros países com os quais ele faz fronteira. 
  - *md05Exercício02 -*Escreva a classe e forneça os seus membros a seguir: 
    * Construtor que inicialize o código ISO, o nome e a dimensão do país; 
    * Um método que permita verificar se dois objetos representam o mesmo país (igualdade semântica). Dois países são iguais se tiverem o mesmo código ISO;
    * Um método que retorne a [densidade populacional](https://mundoeducacao.uol.com.br/geografia/densidade-demografica.htm) do país; 
    * Um método que receba um outro país como parâmetro e retorne a lista de vizinhos comuns aos dois países. Considere que um país tem no máximo 40 outros países com os quais ele faz fronteira.
  
- **Package "parte02_06composicaoagregacao"**
  
  - *md06Exercício01 -*Fazer um programa com as seguintes características:
    * Uma classe chamada Universidade que terá como atributo um nome e terá um método para informar o seu nome;
    * Uma classe Pessoa, que terá como atributo seu nome, em que universidade estuda, quando entrou na universidade e um método que dirá seu nome e em que universidade estuda;
    * Relacionar a classe Pessoa para com a classe Universidade. Cada Pessoa poderá ser associada a uma Universidade.
  - *md06Exercício02 -*Crie uma classe Televisão e uma classe ControleRemoto que pode controlar o volume e trocar os canais da televisão. O controle de volume permite:
    * Aumentar ou diminuir a potência do volume de som em uma unidade de cada vez;
    * Aumentar e diminuir o número do canal em uma unidade;
    * Trocar para um canal indicado;
    * Consultar o valor do volume de som e o canal selecionado;
    * Uma Televisão tem um ControleRemoto.
  - *md06Exercício03 -*Escreva uma classe Agenda, que contém vários contatos do tipo Contato:
    * Cada contato possui nome, telefone e e-mail;
    * A Agenda também possui um nome;
    * Crie um programa teste que peça para o usuário entrar com o nome da Agenda e em seguida 3 contatos;
    * Crie métodos que retorne uma String com a informação de cada contato e também de todos os contatos da agenda.
  - *md06Exercício04 -*Escreva uma classe para representar um curso que tem nome e horário:
    * Cada curso tem um professor, que possui nome, departamento e e-mail;
    * Cada curso também pode ter vários alunos (tipo Aluno);
    * Cada aluno tem nome, matrícula e 4 notas;
    * Escreva um programa teste que crie um Curso com 5 alunos, e que peça para o usuário entrar com as 4 notas de cada aluno;
    * Ao final, imprima a média de cada aluno, se o mesmo está aprovado (média maior que 6), e qual a média da turma.
  
- **Package "parte02_07estaticos"**
  - *md0Exercício01 -*Escreva uma classe chamada Contador que tem um atributo estático que é incrementado sempre que a classe for instanciada:
    * Crie métodos para zerar, incrementar e retornar o valor do contador;
    * Desenvolva um programa para testar essa classe.
  - *md0Exercício02 -*Escreva uma classe Calculadora que tenha os seguinte métodos:
    * somar;
    * subtrair;
    * multiplicar;
    * dividir;
    * elevar a potência n;
    * Desenvolva um programa para testar essa classe.

  - *md0Exercício03 -*Escreva um método para calcular o fatorial de um número na classe Calculadora do exercício anterior.

  - *md0Exercício04 -*Escreva a classe ConversaoDeUnidadeDeArea com métodos estáticos para conversão das unidades de área segundo a lista abaixo:
    * 1 metro quadrado = 10,76 pés quadrados
    * 1 pé quadrado = 929 centímetros quadrados
    * 1 milha quadrada = 640 acres
    * 1 acre = 43.560 pés quadrados

  - *md0Exercício05 -*Escreva a classe ConversaoDeUnidadeDeVolume com métodos estáticos para conversão das unidades de volume segundo a lista abaixo:
    * 1 litro = 1000 centímetros cúbicos
    * 1 metro cúbico = 1000 litros
    * 1 metro cúbico = 35,32 pés cúbicos
    * 1 galão americano = 231 polegadas cúbicas
    * 1 galão americano = 3.785 litros

  - *md0Exercício06 -*Escreva a classe ConversaoDeUnidadeDeTempo com métodos estáticos para conversão aproximada das unidades de tempo segundo a lista abaixo:
    * 1 minutos = 60 segundos
    * 1 hora = 60 minutos
    * 1 dia = 24 horas
    * 1 semana = 7 dias
    * 1 mês = 30 dias
    * 1 ano = 365,25 dias

- **Package "projetoempresadecartaodebeneficios"**

  1. Vocês deverão escrever um programa em Java que seja capaz de gerenciar vários cartões de benefício. Para essa versão, os cartões gerenciados serão:
  
    - Vale alimentação
    - Vale refeição
    - Vale combustível
  
  2. Todos os cartões têm atributos e comportamentos muito parecidos, que são:
  
  3. Saldo
  
    - O valor que o cartão tem naquele momento.
  
  4. Transações
  
    - Uma lista que registra os detalhes de cada transação de compra.
  
  5. Sistema anti-fraude
  
    - Não devemos passar duas compras do mesmo valor no mesmo estabelecimento em um período de **30 segundos (Período curto para facilitar os testes).**
    - Não devemos passar três compras no mesmo cartão dentro do mesmo **minuto**.
  
  6. Senha. Todo cartão deve ter sua senha de uso.
  
  7. Nome do beneficiário.
  
  8. Validade.
  
  9. Negar compra
  
    - Por falta de saldo
    - Pelo sistema anti-fraude
    - Pela data de validade
  
  10. Extrato do cartão.
  
  11. Mostrar saldo atual.
  
  12. Adicionar nova transação.
  
  13. Uma transação deve conter os seguintes dados:
  
     - Valor
     - Data e hora
     - Localização
     - Estabelecimento
  
  14. Um estabelecimento deve conter os seguintes dados:
  
     - Nome
     - Identificador (Pode ser um número sequencial)
     - Tipo
  
  15. Nosso programa deverá gerenciar cartões de mais de um beneficiário, ou seja, ao iniciar o programa, devemos cadastrar um beneficiário, seus três cartões com senha, inicializar cada cartão com um valor fictício entre 200 e 1000 e uma validade para cada cartão, que inclusive a data pode ser ontem, para demonstrar que se o cartão estiver fora do prazo de validade, a compra irá ser negada. Ao acabar o cadastro do beneficiário e dos seus cartões, o sistema poderá repetir o ciclo ou entrar no modo de gerenciamento de cada cartão, onde os métodos do cartão poderão ser acessados e adicionar novas transações.
  
  16. O menu de cadastro de beneficiários deve permitir abastecer o saldo de um determinado cartão de um beneficiário específico. Considere que haverão somente beneficiários com nomes diferentes para facilitar a implementação.
     Atributos e comportamentos específicos de cada cartão:
  
     - Vale alimentação:
       - Ao utilizar o vale alimentação, um cashback de 1.5% será devolvido.
       - Esse cartão não poderá ser aceito em estabelecimentos que são do tipo POSTO_COMBUSTIVEL
     - Vale refeição:
       - Ao utilizar o vale refeição, um cashback de 3% será devolvido.
     - Vale combustível:
       - Ao utilizar o vale combustível, uma taxa de R$1,00 deverá ser cobrada para cada transação.Esse cartão só poderá ser utilizado a cada 2 minutos, independente do valor e estabelecimentoEsse cartão só poderá ser utilizado em estabelecimentos que são do tipo POSTO_COMBUSTIVEL
  
     
  
     **O que é esperado do projeto?**
     É esperado que o projeto seja escrito em Java, usando recursos de OO. Olhando para o problema dado acima, escreva as classes necessárias e tente identificar pontos que não foram citados explicitamente, como por exemplo, algum atributo faltante, alguma classe que poderia ser criada para auxiliar no programa, etc. Codifique da melhor forma possível para resolver o problema proposto.
  
  

Espero que aproveitem! 

D​úv​i​d​a​s​, ​c​r​í​t​i​c​as​,​ ​su​ge​s​t​õe​s​, ​é ​s​ó​ ​e​nt​r​a​r ​e​m​ ​co​nt​a​t​o​ !:punch:

 :computer: *#letskeepcoding* / :rocket:#skyisnotthelimit

