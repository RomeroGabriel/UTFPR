var teacherModel = require('../models/teacher');

module.exports = {
    save: async function (req, res) {
        let teacherEmail = await teacherModel.find({ email: req.body.email, isDeleted: false });
        if (!teacherEmail.length > 0) {
            let teacher = new teacherModel({
                name: req.body.name,
                email: req.body.email,
                department: req.body.department,
                isDeleted: false,
            });
            teacher.save().then(result => {
                res.render('paginaInicial', {});
            }, err => {
                if (err) { return res.status(500).json({ message: 'Erro ao cadastrar usuário', error: err }) };
            });
        } else {
            res.render('newTeacher', { message: 'Já existe professor com este email!' })
        }
    }
}