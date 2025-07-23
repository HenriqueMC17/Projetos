// Variáveis globais
let playerName = "";
let canvas, ctx, player, bullets, enemies, score, gameover, keys, gameLoopId;
let lives = 3;
let level = 1;
let gameTime = 0;
let gamePaused = false;
let powerUps = [];
let lastEnemySpawn = 0;
let enemySpawnRate = 2000;
let lastPowerUpSpawn = 0;
let powerUpSpawnRate = 10000;
let playerSpeed = 5;
let playerShield = false;
let shieldTime = 0;
let shieldDuration = 5000;
let highScore = localStorage.getItem('highScore') || 0;
let gameStarted = false;
let lastFrameTime = 0;
let fps = 60;
let frameInterval = 1000 / fps;

// Configurações do jogo
const GAME_CONFIG = {
    player: {
        width: 50,
        height: 50,
        color: "#3498db",
        maxSpeed: 8
    },
    enemy: {
        width: 40,
        height: 40,
        color: "#e74c3c",
        speed: 2,
        maxSpeed: 6
    },
    bullet: {
        width: 5,
        height: 15,
        color: "#2ecc71",
        speed: 7,
        maxSpeed: 12
    },
    powerUp: {
        width: 30,
        height: 30,
        types: {
            shield: { color: "#f1c40f", duration: 5000 },
            speed: { color: "#9b59b6", duration: 5000, multiplier: 2 },
            tripleShot: { color: "#1abc9c", duration: 5000 }
        }
    },
    game: {
        maxEnemies: 10,
        maxBullets: 5,
        scoreMultiplier: 1.1
    }
};

// Função para iniciar o jogo
function startGame() {
    playerName = document.getElementById("player-name").value.trim();
    if (!playerName) {
        showMessage("Por favor, insira seu nome.");
        return;
    }

    document.getElementById("player-form").style.display = "none";
    document.getElementById("game").style.display = "block";
    document.getElementById("score-display").textContent = "Pontuação: 0";
    document.getElementById("level-display").textContent = "Nível: 1";
    document.getElementById("lives-display").textContent = "Vidas: 3";
    document.getElementById("high-score").textContent = `Recorde: ${highScore}`;

    // Inicialização das variáveis do jogo
    canvas = document.getElementById("gameCanvas");
    ctx = canvas.getContext("2d");
    resetGameState();

    // Controles do jogador
    window.addEventListener("keydown", keydownHandler);
    window.addEventListener("keyup", keyupHandler);

    // Iniciar o loop do jogo
    gameStarted = true;
    lastFrameTime = performance.now();
    gameLoopId = requestAnimationFrame(gameLoop);
    startGameTimer();
}

// Função para resetar o estado do jogo
function resetGameState() {
    player = {
        x: canvas.width / 2,
        y: canvas.height - 30,
        width: GAME_CONFIG.player.width,
        height: GAME_CONFIG.player.height,
        speed: playerSpeed
    };
    bullets = [];
    enemies = [];
    powerUps = [];
    score = 0;
    lives = 3;
    level = 1;
    gameTime = 0;
    gameover = false;
    gamePaused = false;
    keys = {};
    playerShield = false;
    shieldTime = 0;
    GAME_CONFIG.enemy.speed = 2;
    enemySpawnRate = 2000;
}

// Função para mostrar mensagens
function showMessage(message, duration = 2000) {
    const messageElement = document.createElement('div');
    messageElement.className = 'game-message';
    messageElement.textContent = message;
    document.getElementById('game-container').appendChild(messageElement);
    
    setTimeout(() => {
        messageElement.remove();
    }, duration);
}

// Função para desenhar o jogador
function drawPlayer() {
    ctx.save();
    ctx.fillStyle = GAME_CONFIG.player.color;
    ctx.fillRect(player.x, player.y, player.width, player.height);
    
    if (playerShield) {
        ctx.strokeStyle = GAME_CONFIG.powerUp.types.shield.color;
        ctx.lineWidth = 3;
        ctx.strokeRect(player.x - 5, player.y - 5, player.width + 10, player.height + 10);
    }
    ctx.restore();
}

// Função para desenhar os inimigos
function drawEnemies() {
    ctx.save();
    enemies.forEach(enemy => {
        ctx.fillStyle = GAME_CONFIG.enemy.color;
        ctx.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
    });
    ctx.restore();
}

// Função para desenhar as balas
function drawBullets() {
    ctx.save();
    bullets.forEach(bullet => {
        ctx.fillStyle = GAME_CONFIG.bullet.color;
        ctx.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
    });
    ctx.restore();
}

// Função para desenhar power-ups
function drawPowerUps() {
    ctx.save();
    powerUps.forEach(powerUp => {
        ctx.fillStyle = powerUp.type.color;
        ctx.fillRect(powerUp.x, powerUp.y, powerUp.width, powerUp.height);
    });
    ctx.restore();
}

// Função para mover o jogador
function movePlayer() {
    if (keys["ArrowLeft"] && player.x > 0) {
        player.x -= player.speed;
    }
    if (keys["ArrowRight"] && player.x < canvas.width - player.width) {
        player.x += player.speed;
    }
}

// Função para mover as balas
function moveBullets() {
    bullets.forEach((bullet, index) => {
        bullet.y -= GAME_CONFIG.bullet.speed;
        if (bullet.y < 0) bullets.splice(index, 1);
    });
}

// Função para mover os inimigos
function moveEnemies() {
    enemies.forEach((enemy, index) => {
        enemy.y += GAME_CONFIG.enemy.speed;
        if (enemy.y > canvas.height) {
            enemies.splice(index, 1);
            loseLife();
        }
    });
}

// Função para mover power-ups
function movePowerUps() {
    powerUps.forEach((powerUp, index) => {
        powerUp.y += 2;
        if (powerUp.y > canvas.height) {
            powerUps.splice(index, 1);
        }
    });
}

// Função para criar inimigos
function createEnemy() {
    const now = Date.now();
    if (now - lastEnemySpawn > enemySpawnRate && enemies.length < GAME_CONFIG.game.maxEnemies) {
        const enemy = {
            x: Math.random() * (canvas.width - GAME_CONFIG.enemy.width),
            y: 0,
            width: GAME_CONFIG.enemy.width,
            height: GAME_CONFIG.enemy.height
        };
        enemies.push(enemy);
        lastEnemySpawn = now;
    }
}

// Função para criar power-ups
function createPowerUp() {
    const now = Date.now();
    if (now - lastPowerUpSpawn > powerUpSpawnRate) {
        const types = Object.keys(GAME_CONFIG.powerUp.types);
        const type = types[Math.floor(Math.random() * types.length)];
        const powerUp = {
            x: Math.random() * (canvas.width - GAME_CONFIG.powerUp.width),
            y: 0,
            width: GAME_CONFIG.powerUp.width,
            height: GAME_CONFIG.powerUp.height,
            type: GAME_CONFIG.powerUp.types[type]
        };
        powerUps.push(powerUp);
        lastPowerUpSpawn = now;
    }
}

// Função para criar balas
function createBullet() {
    if (bullets.length >= GAME_CONFIG.game.maxBullets) return;

    const bullet = {
        x: player.x + player.width / 2 - GAME_CONFIG.bullet.width / 2,
        y: player.y,
        width: GAME_CONFIG.bullet.width,
        height: GAME_CONFIG.bullet.height
    };
    bullets.push(bullet);
}

// Função para detectar colisões
function detectCollisions() {
    // Colisão entre balas e inimigos
    bullets.forEach((bullet, bulletIndex) => {
        enemies.forEach((enemy, enemyIndex) => {
            if (checkCollision(bullet, enemy)) {
                bullets.splice(bulletIndex, 1);
                enemies.splice(enemyIndex, 1);
                score += Math.floor(20 * GAME_CONFIG.game.scoreMultiplier);
                updateScore();
            }
        });
    });

    // Colisão entre jogador e inimigos
    if (!playerShield) {
        enemies.forEach(enemy => {
            if (checkCollision(player, enemy)) {
                loseLife();
            }
        });
    }

    // Colisão entre jogador e power-ups
    powerUps.forEach((powerUp, index) => {
        if (checkCollision(player, powerUp)) {
            activatePowerUp(powerUp.type);
            powerUps.splice(index, 1);
            showMessage(`Power-up ativado: ${powerUp.type === GAME_CONFIG.powerUp.types.shield ? 'Escudo' : 'Velocidade'}`);
        }
    });
}

// Função auxiliar para verificar colisões
function checkCollision(rect1, rect2) {
    return (
        rect1.x < rect2.x + rect2.width &&
        rect1.x + rect1.width > rect2.x &&
        rect1.y < rect2.y + rect2.height &&
        rect1.y + rect1.height > rect2.y
    );
}

// Função para perder uma vida
function loseLife() {
    lives--;
    updateLives();
    if (lives <= 0) {
        gameover = true;
        if (score > highScore) {
            highScore = score;
            localStorage.setItem('highScore', highScore);
            showMessage('Novo recorde!', 3000);
        }
    } else {
        showMessage('Você perdeu uma vida!', 1500);
    }
}

// Função para ativar power-up
function activatePowerUp(type) {
    if (type === GAME_CONFIG.powerUp.types.shield) {
        playerShield = true;
        shieldTime = Date.now();
        setTimeout(() => {
            playerShield = false;
            showMessage('Escudo desativado!', 1500);
        }, type.duration);
    } else if (type === GAME_CONFIG.powerUp.types.speed) {
        player.speed *= type.multiplier;
        setTimeout(() => {
            player.speed = playerSpeed;
            showMessage('Velocidade normalizada!', 1500);
        }, type.duration);
    }
}

// Função para atualizar a pontuação
function updateScore() {
    document.getElementById("score-display").textContent = `Pontuação: ${score}`;
    document.getElementById("current-score").textContent = `Pontuação Atual: ${score}`;
    
    const newLevel = Math.floor(score / 100) + 1;
    if (newLevel > level) {
        level = newLevel;
        updateLevel();
        increaseDifficulty();
        showMessage(`Nível ${level} alcançado!`, 2000);
    }
}

// Função para atualizar o nível
function updateLevel() {
    document.getElementById("level-display").textContent = `Nível: ${level}`;
}

// Função para atualizar as vidas
function updateLives() {
    document.getElementById("lives-display").textContent = `Vidas: ${lives}`;
}

// Função para aumentar a dificuldade
function increaseDifficulty() {
    GAME_CONFIG.enemy.speed = Math.min(GAME_CONFIG.enemy.maxSpeed, GAME_CONFIG.enemy.speed + 0.5);
    enemySpawnRate = Math.max(500, enemySpawnRate - 200);
    GAME_CONFIG.bullet.speed = Math.min(GAME_CONFIG.bullet.maxSpeed, GAME_CONFIG.bullet.speed + 0.5);
}

// Função para pausar o jogo
function togglePause() {
    gamePaused = !gamePaused;
    if (gamePaused) {
        cancelAnimationFrame(gameLoopId);
        document.getElementById("pause-menu").style.display = "block";
        document.getElementById("pause-score").textContent = score;
        document.getElementById("pause-level").textContent = level;
        document.getElementById("pause-lives").textContent = lives;
        document.getElementById("pause-time").textContent = formatTime(gameTime);
    } else {
        document.getElementById("pause-menu").style.display = "none";
        lastFrameTime = performance.now();
        gameLoopId = requestAnimationFrame(gameLoop);
    }
}

// Função para reiniciar o jogo
function resetGame() {
    document.getElementById("player-form").style.display = "block";
    document.getElementById("game").style.display = "none";
    document.getElementById("pause-menu").style.display = "none";
    playerName = "";
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    window.removeEventListener("keydown", keydownHandler);
    window.removeEventListener("keyup", keyupHandler);
    cancelAnimationFrame(gameLoopId);
    clearInterval(gameTimer);
    gameStarted = false;
}

// Função principal do jogo
function gameLoop(timestamp) {
    if (!gameover && !gamePaused) {
        const deltaTime = timestamp - lastFrameTime;
        
        if (deltaTime >= frameInterval) {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            movePlayer();
            moveBullets();
            moveEnemies();
            movePowerUps();
            createEnemy();
            createPowerUp();
            drawPlayer();
            drawBullets();
            drawEnemies();
            drawPowerUps();
            detectCollisions();
            lastFrameTime = timestamp;
        }
        
        gameLoopId = requestAnimationFrame(gameLoop);
    } else if (gameover) {
        cancelAnimationFrame(gameLoopId);
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.save();
        ctx.font = "30px 'Press Start 2P'";
        ctx.fillStyle = "#e74c3c";
        ctx.textAlign = "center";
        ctx.fillText("GAME OVER", canvas.width / 2, canvas.height / 2 - 20);
        ctx.fillText(`Pontuação: ${score}`, canvas.width / 2, canvas.height / 2 + 20);
        ctx.restore();
        updateScoreTable();
        document.getElementById("play-again").style.display = "block";
    }
}

// Função para atualizar a tabela de pontuação
function updateScoreTable() {
    const tbody = document.getElementById("score-table-body");
    const row = document.createElement("tr");
    const cellName = document.createElement("td");
    const cellScore = document.createElement("td");
    const cellLevel = document.createElement("td");
    const cellTime = document.createElement("td");

    cellName.textContent = playerName;
    cellScore.textContent = score;
    cellLevel.textContent = level;
    cellTime.textContent = formatTime(gameTime);

    row.appendChild(cellName);
    row.appendChild(cellScore);
    row.appendChild(cellLevel);
    row.appendChild(cellTime);
    tbody.appendChild(row);
}

// Função para formatar o tempo
function formatTime(seconds) {
    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = seconds % 60;
    return `${minutes}:${remainingSeconds.toString().padStart(2, '0')}`;
}

// Função para iniciar o timer do jogo
function startGameTimer() {
    gameTimer = setInterval(() => {
        if (!gamePaused && !gameover) {
            gameTime++;
            document.getElementById("game-time").textContent = `Tempo: ${formatTime(gameTime)}`;
        }
    }, 1000);
}

// Handlers de evento para teclas
function keydownHandler(event) {
    if (event.code === "Space") {
        event.preventDefault();
        createBullet();
    } else if (event.code === "Escape") {
        event.preventDefault();
        togglePause();
    }
    keys[event.code] = true;
}

function keyupHandler(event) {
    keys[event.code] = false;
}

// Chamar a função resetGame no carregamento da página
window.onload = resetGame;