// Função para obter cookie
function getCookie(nome) {
    const valor = `; ${document.cookie}`;
    const partes = valor.split(`; ${nome}=`);
    if (partes.length === 2) return partes.pop().split(';').shift();
}

// Função para definir cookie (expira em 30 dias)
function setCookie(nome, valor) {
    const data = new Date();
    data.setTime(data.getTime() + (30 * 24 * 60 * 60 * 1000)); // 30 dias
    const expira = "expires=" + data.toUTCString();
    document.cookie = `${nome}=${valor}; ${expira}; path=/`;
}

document.addEventListener("DOMContentLoaded", function () {
    const botaoTema = document.getElementById("botao-tema");
    const corpo = document.body;

    // Aplica o tema salvo no cookie ou padrão claro
    const temaSalvo = getCookie("tema");
    corpo.className = temaSalvo ? temaSalvo : "light";

    // Evento de clique no botão
    botaoTema.addEventListener("click", function () {
        corpo.classList.toggle("dark");
        corpo.classList.toggle("light");

        const temaAtual = corpo.className;
        setCookie("tema", temaAtual);
    });
});
