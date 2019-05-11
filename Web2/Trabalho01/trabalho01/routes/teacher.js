var express = require('express');
var router = express.Router();
const controller = require('../controllers/teacherController');

router.get('/create', function (req, res, next) {
    res.render('newTeacher', { message: '' });
});

router.post('/create', controller.save);