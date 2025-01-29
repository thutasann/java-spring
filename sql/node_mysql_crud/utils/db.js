// @ts-check
const mysql = require('mysql')
require('dotenv').config()

const db = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASS,
    database: process.env.DB_NAME,
})

db.connect((error) => {
    if(error) throw error;
    console.log("MySQL connected...")
})

module.exports = db;