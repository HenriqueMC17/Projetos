let jogador = {
  nome: "",
};

let rodadas = [];

function obterNomeJogador() {
  let nome = prompt("Digite seu nome:");
  return nome || "Jogador";
}

function obterEscolhaJogador() {
  let escolha = prompt("Olá, " + jogador.nome + "! Escolha pedra, papel ou tesoura:");
  while (escolha !== "pedra" && escolha !== "papel" && escolha !== "tesoura") {
    escolha = prompt("Escolha inválida. Por favor, digite pedra, papel ou tesoura:");
  }
  return escolha;
}

function obterEscolhaComputador() {
  let escolhas = ["pedra", "papel", "tesoura"];
  let escolhaAleatoria = Math.floor(Math.random() * 3);
  return escolhas[escolhaAleatoria];
}

function determinarVencedor(escolhaJogador, escolhaComputador) {
  if (escolhaJogador === escolhaComputador) {
    return "Empate";
  } else if (
    (escolhaJogador === "pedra" && escolhaComputador === "tesoura") ||
    (escolhaJogador === "papel" && escolhaComputador === "pedra") ||
    (escolhaJogador === "tesoura" && escolhaComputador === "papel")
  ) {
    return "Jogador";
  } else {
    return "Computador";
  }
}

function atualizarRodadas(escolhaJogador, escolhaComputador, resultado) {
  rodadas.push({ jogador: escolhaJogador, computador: escolhaComputador, resultado: resultado });
}

function gerarTabela() {
  let tabelaHTML = "<table>";
  tabelaHTML += "<tr><th>" + jogador.nome + "</th><th>Computador</th><th>Resultado</th></tr>";
  rodadas.forEach(function (rodada) {
    tabelaHTML += "<tr><td>" + rodada.jogador + "</td><td>" + rodada.computador + "</td><td>" + rodada.resultado + "</td></tr>";
  });
  tabelaHTML += "</table>";
  document.getElementById("tabela").innerHTML = tabelaHTML;
}

function reiniciarJogo() {
  rodadas = [];
  gerarTabela();
  iniciarJogo();
}

function iniciarJogo() {
  jogador.nome = obterNomeJogador();
  let continuar = true;
  while (continuar) {
    let escolhaJogador = obterEscolhaJogador();
    let escolhaComputador = obterEscolhaComputador();
    let resultado = determinarVencedor(escolhaJogador, escolhaComputador);
    atualizarRodadas(escolhaJogador, escolhaComputador, resultado);
    continuar = confirm("Deseja continuar?");
  }
  gerarTabela();
}

// Adicionar um ouvinte de evento ao botão "Jogar Novamente"
document.getElementById("jogarNovamente").addEventListener("click", reiniciarJogo);

// Iniciar o jogo ao carregar a página
iniciarJogo();