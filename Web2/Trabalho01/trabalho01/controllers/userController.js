var userModel = require('../models/user');

module.exports = {
    save: async function (req, res) {

        let userEmail = await userModel.find({ email: req.body.email, isDeleted: false });
        if (!userEmail.length > 0) {
            let user = new userModel({
                email: req.body.email,
                password: req.body.password,
                isDeleted: false
            });
            user.save().then(result => {
                res.render('login');
            }, err => {
                if (err) { return res.status(500).json({ message: 'Erro ao cadastrar usuário', error: err }) };
            });
        } else {
            res.render('newUser', { error: 'Usário já existe!' });
        }
    },

    login: async function (req, res) {
        let email = req.body.email;
        let password = req.body.password;
        let user = await userModel.find({ email: email, password: password, isDeleted: false });
        if (user.length > 0) {
            res.cookie('login', email);
            res.redirect('/');
            return;
        } else {
            res.status(403);
            res.end();
        }
    },

    findById: function (req, res) {

    },
};