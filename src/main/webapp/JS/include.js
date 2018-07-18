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
    var base = 'http://18.228.55.248/'
    if (!document.getElementById(cssId))
    {
        var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.id = cssId;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.media = 'all';
        link.href = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css';
        head.appendChild(link);
        
        var head2 = document.getElementsByTagName('head')[0];
        var link2 = document.createElement('link');
        link2.id = cssId;
        link2.rel = 'stylesheet';
        link2.type = 'text/css';
        link2.media = 'all';
        link2.href = base + 'CSS/estilo.css';
        head2.appendChild(link2);
    }
}

cabecalhos();