function novoCookie(nome, valor, diasParaExpirar) {
    var d = new Date();
    d.setTime(d.getTime() + (diasParaExpirar * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = nome + "=" + valor + ";" + expires + ";path=/";
}

function pegaCookie(nomeDoCookie) {
    var nome = nomeDoCookie + "=";
    var cookieDecodificado = decodeURIComponent(document.cookie);
    var partesDoCookie = cookieDecodificado.split(';');
    for (var i = 0; i < partesDoCookie.length; i++) {
        var c = partesDoCookie[i];
        while (c.charAt(0) === ' ')
            c = c.substring(1);
        if (c.indexOf(nome) === 0)
            return c.substring(nome.length, c.length);
    }
    return "";
}

function checaCookie(nomeDoCookie) {
    var valorDoCookie = pegaCookie(nomeDoCookie);
    if (valorDoCookie !== "") {
        // Acao com o valor do cookie
    } else {
        // Ações se não encontrar o cookie
        if (valorDoCookie !== "" && valorDoCookie !== null) {
            novoCookie("username", valorDoCookie, 30);
        }
    }
}

function leitorDeArquivo(file, id) {
    var arquivoOrigem = new XMLHttpRequest();
    arquivoOrigem.onreadystatechange = function () {
        if (arquivoOrigem.readyState === 4) {
            if (arquivoOrigem.status === 200 || arquivoOrigem.status === 0) {
                var allText = arquivoOrigem.responseText;
                document.getElementById(id).innerHTML = allText;
            }
        }
    };
    arquivoOrigem.open("GET", file, true);
    arquivoOrigem.send(null);
}

function analisaSintaxe() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200)
            document.getElementById("idSaida").innerHTML = this.responseText;
    };
    xhttp.open("GET", "analisar?entrada=" + encodeURIComponent(document.getElementById("idCampoEntrada").value), true);
    xhttp.send();
}

function cabecalhos() {
    var cssId = 'externo';  // you could encode the css path itself to generate id..
    var base = '';
    if (!document.getElementById(cssId))
    {
        var head = document.getElementsByTagName('head')[0];

        var meta = document.createElement('meta');
        meta.charset = "UTF-8";
        meta.content = "text/html";
        meta.httpequiv = "Content-Type";
        head.appendChild(meta);

        var link = document.createElement('link');
        link.id = cssId;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.media = 'all';
        link.crossorigin = 'anonymous';
        link.href = 'https://use.fontawesome.com/releases/v5.1.1/css/all.css';
        head.appendChild(link);

        var link2 = document.createElement('link');
        link2.id = cssId;
        link2.rel = 'stylesheet';
        link2.type = 'text/css';
        link2.media = 'all';
        link2.href = base + 'css/estilo.css';
        head.appendChild(link2);
    }
}

function entra() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200)
            if (this.responseText === "Seja bem vindo!")
                window.location.href = "/entrada.jsp";
            else
                document.getElementById("idSaida").innerHTML = "As credenciais estão erradas";
    };
    xhttp.open("GET", ""
            + "entrar?usuario="
            + encodeURIComponent(document.getElementById("idCampoEntrada").value)
            + "&senha="
            + encodeURIComponent(document.getElementById("idCampoEntrada2").value, false));
    xhttp.send();
}

cabecalhos();

function CarregarPos() {
    leitorDeArquivo("esqueletos/menu.html", "menu");
    leitorDeArquivo("esqueletos/rodape.html", "rodape");
}

function Navega(local) {
    var indice = {
        "urlHome": "../",
        "urlPerfil": "https://psdavid1911.github.io/"
    };
    window.location.href = indice[local];
}