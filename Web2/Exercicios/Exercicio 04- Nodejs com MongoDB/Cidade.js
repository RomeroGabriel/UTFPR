let Connection = require('./connection/ConnectionMongo');

module.exports = class Cidade extends Connection {
    constructor(){
        super();
        this.collection = 'Cidades';
    }

    static save(date){
        super.save(date).then((err, data) => {
            if(err) throw err;
            return data;
        });
    }

    static find(query = {}, limit = 5){
        super.find(query, { nome: 1 } , limit).then((res) => {
            return res;
        })
    }
}