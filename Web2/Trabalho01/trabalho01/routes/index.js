var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
    res.render('paginaInicial');
    return;
});

router.get('/logout', function (req, res, next) {
    res.clearCookie('login', { path: '/login' });
    return res.redirect('/users/login');
});

module.exports = router;