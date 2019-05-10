var userModel = require('../models/user');

module.exports = {
    save: function (req, res) {

        userModel.find({ email: req.body.email }).then(result => {
            if (result.length == 0) {
                let user = new userModel({
                    email: req.body.email,
                    password: req.body.password,
                    isDeleted: false
                });
                user.save().then(result => {
                    res.render('login');
                }, err => {
                    if (err) { return res.status(500).json({ message: 'Erro ao cadastrar usuário', error: err }) };
                })
            } else {
                res.render('newUser');
            }

        }, err => {
            if (err) { return res.status(500).json({ message: 'Erro ao cadastrar usuário', error: err }) };
        });
    },

    findById: function (req, res) {

    },
};