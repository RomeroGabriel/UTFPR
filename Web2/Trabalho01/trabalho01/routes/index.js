var express = require('express');
var router = express.Router();
const controller = require('../controllers/userController');

/* GET home page. */
router.get('/', function (req, res, next) {
    if (req.cookies && req.cookies.login) {
        res.render('paginaInicial', { user: req.cookies.login });
        return;
    }
    res.render('login', { message: '' });
});

router.get('/login', function (req, res, next) {
    res.render('login', { message: '' });
});

router.post('/login', controller.login);

router.get('/logout', function (req, res, next) {
    res.clearCookie('login', { path: '/' });
    res.render('login', { message: '' });
});

module.exports = router;