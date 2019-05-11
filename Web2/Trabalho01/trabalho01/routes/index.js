var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
    if (req.cookies && req.cookies.login) {
        res.render('paginaInicial', { user: req.cookies.login });
        return;
    }
    res.redirect('/users/login', { message: '' });
});

module.exports = router;