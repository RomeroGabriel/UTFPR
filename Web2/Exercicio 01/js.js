var http = require('http'), server;
let fs = require('fs');

server = http.createServer(function(req, res) {
    console.log('Escutando requisições');
    
    fs.readFile('./index.html', function(err, data) {
        res.write(data)
        res.end();
    });
});

server.listen(8000);