var http = require('http'), server;
var fs = require('fs');

server = http.createServer(function(req, res){
    console.log('ESCUTANDO ...');
    if(req.headers['accept'].search('text/html') >= 0){
        fs.readFile('./index.html', function(err, data){
            res.setHeader('Content-type', 'text/html');
            res.write(data);
            res.end();
        });
    } else {
        fs.readFile('./src/layout.css', function(err, data){
            res.setHeader('Content-type', 'text/css');
            res.write(data);
            res.end();
        });
    }
    
});

server.listen(8000);