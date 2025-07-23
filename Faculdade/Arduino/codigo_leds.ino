// Definição dos pinos dos botões
int b1 = 8;    // Botão 1 conectado ao pino 8
int b2 = 9;    // Botão 2 conectado ao pino 9
int b3 = 10;   // Botão 3 conectado ao pino 10
int b4 = 7;    // Botão 4 conectado ao pino 7
int b5 = 6;    // Botão 5 conectado ao pino 6
int b6 = 5;    // Botão 6 conectado ao pino 5

// Definição dos pinos dos LEDs
int ledvermelho = 13;  // LED vermelho conectado ao pino 13
int ledazul = 12;      // LED azul conectado ao pino 12
int ledverde = 11;     // LED verde conectado ao pino 11

void setup()
{
  // Configuração dos botões como entradas
  pinMode(b1, INPUT);
  pinMode(b2, INPUT);
  pinMode(b3, INPUT);
  pinMode(b4, INPUT);
  pinMode(b5, INPUT);
  
  // Configuração dos LEDs como saídas
  pinMode(ledvermelho, OUTPUT);
  pinMode(ledazul, OUTPUT);
  pinMode(ledverde, OUTPUT);
}

void loop()
{
  // Verifica o estado de cada botão e aciona os LEDs correspondentes
  
  // Botão 1: Acende apenas o LED vermelho
  if(digitalRead(b1)){
    digitalWrite(ledvermelho, HIGH);
  }
  // Botão 2: Acende apenas o LED azul
  else if(digitalRead(b2)){
    digitalWrite(ledazul, HIGH);
  }
  // Botão 3: Acende apenas o LED verde
  else if(digitalRead(b3)){
    digitalWrite(ledverde, HIGH); 
  }
  // Botão 4: Acende LED vermelho e azul (combinação magenta)
  else if(digitalRead(b4)){
    digitalWrite(ledvermelho, HIGH);
    digitalWrite(ledazul, HIGH);
    digitalWrite(ledverde, LOW);
  }
  // Botão 5: Acende LED vermelho e verde (combinação amarela)
  else if(digitalRead(b5)){
    digitalWrite(ledvermelho, HIGH);
    digitalWrite(ledazul, LOW);
    digitalWrite(ledverde, HIGH);
  }
  // Botão 6: Acende LED azul e verde (combinação ciano)
  else if(digitalRead(b6)){
    digitalWrite(ledvermelho, LOW);
    digitalWrite(ledazul, HIGH);
    digitalWrite(ledverde, HIGH);
  }
  // Se nenhum botão estiver pressionado, apaga todos os LEDs
  else{
    digitalWrite(ledvermelho, LOW);
    digitalWrite(ledazul, LOW);
    digitalWrite(ledverde, LOW);
  }
} 