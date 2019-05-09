var userModel = require('../models/user');

module.exports = {
    save: function (req, res) {
        console.log(req.body, '5');
        var user = new userModel({
            email: req.body.email,
            password: req.body.password,
            isDeleted: false
        });
        user.save(function (err, result) {
            if (err) { return res.status(500).json({ message: 'Erro ao cadastrar usuário', error: err })};
            return res.render('paginaInicial');
        });
    },

    findById: function (req, res) {

    }
};