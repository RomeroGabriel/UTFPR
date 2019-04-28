let http = require('http'), server;
let fs = require('fs');

server = http.createServer(function(req, res){
    console.log(req.headers);
    console.log('Escutando requisições');
    let lingua = req.headers['accept-language'] ? req.headers['accept-language'].split(';') : [];
    console.log(lingua);
    if(lingua[0] == 'pt-BR,pt'){
        fs.readFile('./indexPortugues.html', function(err, data){
            res.write(data);
            res.end();
        });
    } else {
        fs.readFile('./index.html', function(err, data){
            res.write(data);
            res.end();
        });
    }
});

server.listen(8000);