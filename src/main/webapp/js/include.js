function leitorDeArquivo(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if (rawFile.readyState === 4)
        {
            if (rawFile.status === 200 || rawFile.status === 0)
            {
                var allText = rawFile.responseText;
                document.write(allText);
            }
        }
    };
    rawFile.send(null);
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

cabecalhos();