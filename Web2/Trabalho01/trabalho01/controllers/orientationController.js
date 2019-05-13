var orientationModel = require('../models/orientation');
var teacherModel = require('../models/teacher');

module.exports = {
    save: function (req, res) {
        let orientation = new orientationModel({
            thema: req.body.thema,
            studentName: req.body.studentName,
            teacher: req.body.teacher
        });
        orientation.save().then(result => {
            return res.redirect('/orientation/get');
        }, err => {
            res.render('newOrientation', { list: [], message: 'Error in save new orientation!' });
        });
    },

    getInit: function (req, res) {
        teacherModel.find().then(result => {
            res.render('newOrientation', { list: result, message: '' });
        }, err => {
            res.render('newOrientation', { list: [], message: '' });
        });
    },

    getAll: function(req, res){
        res.render('paginaInicial', {});
    }
};