var express = require('express');
var router = express.Router();
const controller = require('../controllers/userController');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.get('/login', function(req, res, next) {
  res.render('login');
});

router.get('/newUser', function(req, res, next) {
  res.render('newUser');
});

router.post('/createUser', controller.save);

module.exports = router;
