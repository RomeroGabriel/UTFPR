let cliente = require('mongodb').MongoClient;
let config  = require('./config');
let con = cliente.connect(config.uri, config.options).then((conn) => {
    return {
        db: conn.db(config.db),
        close: function() {
            conn.close();
        }
    };
});

module.exports = class ConnectionMongo {
    save(date){
        if(this._id){
            return con.then((conn) => {
                conn.db.collection(this.collection).updateOne( {_id: this._id }, { $set: date } );
            });
        }

        return con.then((conn) => {
            return conn.db.collection(this.collection).insertOne(date);
        });
    }

    find(query = { }, sort = { }, limit = 5){
        return con.then((conn) => {
            return conn.db.collection(this.collection).find(query).sort(sort).limit(limit).toArray();
        });
    }

    delete(id){
        return con.then((conn) => {
            return conn.db.collection(this.collection).deleteOne({ _id : ObjectId(id) });
        });
    }
}