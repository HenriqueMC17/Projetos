// Obtém referências para o display e os botões
const display = document.getElementById('display');
const buttons = document.querySelectorAll('button');
const x = 'INCOGNITA';

// Adiciona um ouvinte de evento de clique para cada botão
buttons.forEach(button => {
  button.addEventListener('click', () => {
    const buttonText = button.textContent; // Obtém o texto do botão clicado
    if (buttonText === 'X'){
      try {
        display.value = x; // Mostar a constante X
      } catch (error) { // Trata erros de cálculo (ex: divisão por zero)
        display.value = 'Error';
      }
    }
    else if (buttonText === '=') { // Se o botão for "=", calcula o resultado
      try {
        display.value = eval(display.value); // Avalia a expressão no display
      } catch (error) { // Trata erros de cálculo (ex: divisão por zero)
        display.value = 'Error';
      }
    } else if (buttonText === 'C') { // Se o botão for "C", limpa o display
      display.value = '';
    } else { // Caso contrário, adiciona o texto do botão ao display
      display.value += buttonText;
    }
  });
});