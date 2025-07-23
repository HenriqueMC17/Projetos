let numero = prompt("Digite um número para ver a tabuada:");
numero = parseInt(numero);
if (!isNaN(numero)) {
  console.log(`Tabuada do ${numero}:`);
  for (let i = 1; i <= 10; i++) {
    let resultado = numero * i;
    console.log(resultado);
  }
} else {
  console.log("Por favor, insira um número válido para ver a tabuada.");
}