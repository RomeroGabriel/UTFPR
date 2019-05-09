var mongoose = require('mongoose');

var userSchema = new mongoose.Schema({
    email: String,
    password: String,
    isDeleted: Boolean
});

module.exports = mongoose.model('user', userSchema);