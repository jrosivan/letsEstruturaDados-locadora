JORGE ROSIVAN R BATISTA

1. Questão #1 * Enunciado
Em uma locadora de carros que há anos trabalha utilizando papéis para controlar suas tarefas, um novo gerente foi contratado e este decidiu que era hora modernizar as coisas.
Ele conhecia uma pessoa muito experiente em desenvolvimento de software (sim, você mesmo) e convidou para ajudá-lo nesta missão.
Como o orçamento não é muito grande, ele escolheu algumas funções para poder priorizar no início do projeto e que foram registradas por um analista de negócios da empresa.

Especificação:
- Gostaria de uma forma de registrar as características dos veículos que tenho disponível na loja. As mais importantes para mim, neste primeiro momento, são: 
    Placa, Marca, Cor, Modelo, valor da diária do carro e se ele está disponível para aluguel.
- Na empresa temos 10 carros e não temos pretenção de aumentar o tamanho da frota por um longo período, portanto não se preocupe em criar algo muito mirabolante para guardar nossos carros (lembre-se que nosso orçamento está curto).
- As vezes precisamos ordenar nossos carros para facilitar a escolha para nossos clientes que buscam algo baseado no preço, portanto, gostaria que fosse possível ordenar nossos carros por valor da diária.
- Como agora não temos nada mais no papel, precisamos de uma forma organizada de mostrar todos os nossos carros disponíveis para aluguel, então uma função de impressão em que apareça todas as informações do carro é bastante importante. Abaixo está nossa sugestão:


2. Questão #2 * Enunciado
Terminada a nossa primeira sprint, o novo gerente da loja ficou muito satisfeito com os resultados obtidos, pois com a melhora da organização, mais clientes foram atraídos para a locadora e os lucros aumentaram. Vendo esses resultados, ele decidiu separar uma parte destes lucros para investir na melhoria da plataforma.

- Devido ao aumento de clientes, a loja não tinha veículos suficientes para atender a todos e com isso foi criada uma lista de espera. Incialmente a lista era feita em um papel, mas um dos atendentes perdeu essas folhas e não foi possível entrar em contato com os clientes. Pensando em evitar que isso volte a acontecer, o gerente priorizou para nossa próxima melhoria os seguintes itens:

- Preciso de uma forma estruturada para armazenar informações dos clientes, como: Nome, telefone, endereço e o carro desejado
- Gostaria de ter uma forma de organizar a espera dos clientes respeitando a ordem de entrada deles, ou seja, o primeiro cliente a entrar na espera, deverá ser o primeiro a ser atendido. Observação: neste momento não precisamos nos preocupar em validar qual veículo está livre, nossos atendentes foram treinados para oferecer outro veículo disponível, mesmo que não seja o desejado nos dados do cliente.
- Como o fluxo de movimentação dos carros cresceu muito, eu gostaria de ter uma forma de auditar as mudanças de disponibilidade e quem foi o cliente que usou o veículo. Por exemplo:
* 10/04/2022 às 08:50:00: Carro Hilux (marca), SW4 (modelo), ABC-1234 (placa) foi DEVOLVIDO por Frangolino da Silva (nome do cliente).
* 08/04/2022 às 19:00: Carro Hilux (marca), SW4 (modelo), ABC-1234 (placa) foi EMPRESTADO para Frangolino da Silva (nome do cliente).
* 07/04/2022 às 10:50:00: Carro VW (marca), Fox (modelo), XYZ-9876 (placa) foi DEVOLVIDO por Juvenal Moreira (nome do cliente).
* 04/04/2022 às 10:50:00: Carro VW (marca), Fox (modelo), XYZ-9876 (placa) foi EMPRESTADO por Juvenal Moreira (nome do cliente).

Agora que a lista de espera e nosso controle de trocas está automatizado, será necessário uma forma de imprimir na tela essas informações, portanto gostaria de conseguir visualizar a lista de espera com todas as informações armazenadas, bem como todos os registros de alteração de status dos carros.


3. Questão #03 * Enunciado:
Depois da contratação do novo gerente e da implementação do sistema que você construiu, as lojas passaram a faturar muito e o controle de informações ficou muito melhor para a gestão. Com todo esse sucesso, o gerente decidiu abrir algumas filiais, mas sem perder o controle que implementamos até aqui, por isso surgiram alguns novos requisitos:

1) O gerente precisa ter uma forma de controle de todas filiais;
2) Todas as filiais deverão ter as mesmas características e funções que a matriz;
3) Como a empresa está aumentando e o gerente não consegue estar em todos os lugares, ele precisa de uma forma de visualizar todas as filiais; 
4) Além de visualizar todas as filiais, o gerente deve poder escolher uma filial que terá todos os seus detalhes:

Quantidade de carros (total);
Quantidade de carros alugados;
Quantidade de clientes na lista de espera;
Valor total (em diárias) dos carros alugados;
