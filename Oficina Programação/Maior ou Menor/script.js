let num1 = prompt("Digite um primeiro número:");
let num2 = prompt("Digite um segundo número:");

function encontrarMaior() {
    if (num1 > num2) {
        console.log(num1);
        return num1;
    } else {
        console.log(num2);
        return num2;
    }
  }