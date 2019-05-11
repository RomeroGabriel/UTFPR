var mongoose = require('mongoose');

let TeacherSchema = new mongoose.Schema({
    name: String,
    email: String,
    department: String,
    isDeleted: Boolean,
});

module.exports = mongoose.model('teacher', TeacherSchema);