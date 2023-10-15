Trabalho

1. Desenvolver um aplicativo de força de vendas com objetivo de gerar um pedido de
venda contendo os itens e valores do pedido:
a. Possuir uma tela para cadastrar Cliente;
b. Possuir uma tela para cadastrar o Endereço, onde esse endereço será vinculado ao
cliente e posteriormente ao pedido;
c. Criar uma tela para cadastrar os itens que serão utilizados para realizar pedidos de
venda;
d. Criar uma tela de Pedido de venda;
e. Na tela de pedido, deverá ser capaz de selecionar o cliente.
f. Deverá selecionar o item de venda e campos para informar a quantidade, e um botão
para adicionar o item no pedido, deverá ser exibido o valor unitário e a unidade de
medida;
g. Uma lista para exibir os itens adicionados ao pedido;
h. Um campo informando o valor total e total de itens adicionados;
i. Abaixo da lista um campo para informar a condição de pagamento (á vista ou á prazo);
j. Caso selecionado a prazo, deverá exibir um campo para informar a quantidade de
parcelas, e abaixo uma lista informando o valor de cada parcela;
k. Um campo para exibir o valor total do pedido, onde para vendas a vista deverá ter um
desconto de 5% no valor total, e a prazo adicionar o acréscimo de 5% no valor total;
l. Um campo para adicionar o endereço de entrega, deverá ser possivel selecionar o
endereço do cliente ou outro endereço que esteja cadastrado no banco, caso o
endereço seja em outra cidade (diferente de Toledo-PR), deverá ser adicionado o valor
de frete de R$20,00, caso seja de outro estado, adicionar 50,00 ao valor do frente.
m. Um botão para concluir o pedido, exibindo uma mensagem informando que o pedido
de venda foi cadastrado com sucesso;

Segue tabelas de cadastro para o aplicativo:

A tabela de PedidoVenda fica a critério do desenvolvedor para criar a tabela conforme as
diretrizes acima informadas.
Características técnicas:

1. Para cada processo deverá validar se o campos digitados não estão nulos;
2. Validar campo de valores para não deixar adicionar valores < = 0 (zero);
3. Deverá ter um campo para gerar o código do pedido, ao digitar o código do
pedido deverá ser capaz de retornar as informações do pedido em questão;
4. Código do pedido deve ser gerado automaticamente;
5. Ao concluir o pedido deverá ser exibido uma mensagem informando que o
pedido foi cadastrado com sucesso exibindo o número do pedido (Toast);
6. Ao concluir o pedido todos os campos deverão ser "limpos", e gerado um novo
código de pedido.
7. Para as telas de cadastro e pedido deverá ter uma lista contendo os dados
cadastrados em banco;
8. Para cada tela de cadastro deverá possuir a classe MODELO, DAO e
CONTROLLER;
9. Toda a parte de regra de negócio deverá estar na classe CONTROLLER;
10. Por fim, o aplicativo deve ser projetado utilizando os componentes vistos em
sala com uma interface de usuário atraente e intuitiva, seguindo as diretrizes
de design de material do Android, e ser responsivo em diferentes tamanhos de
tela.
