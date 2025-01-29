// @ts-check
const express = require('express')
const db = require('./utils/db')

const app = express()
app.use(express.json())

const PORT = 3000;

app.get('/employees', (req, res) => {
    const sql = "SELECT * FROM employees"
    db.query(sql, (err, results) => {
        if (err) return res.status(500).json({ error: err.message })
        res.json(results)
    })
})

app.post("/employees", (req, res) => {
  const { first_name, last_name, email } = req.body;
  console.log('first_name', {first_name, last_name, email})
  const sql = "INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)"
  db.query(sql, [first_name, last_name, email], (err, result) => {
    if (err) return res.status(500).json({ error: err.message })
    res.json({ id: result.insertId, first_name, last_name, email })
  })
})

app.get("/employees/:id", (req, res) => {
  const sql = "SELECT * FROM employees WHERE employee_id = ?"
  db.query(sql, [req.params.id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    if (result.length === 0) return res.status(404).json({ message: "User not found" })
    res.json(result[0])
  })
})

app.put("/employees/:id", (req, res) => {
  const { first_name, last_name, email } = req.body;
   const sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ? WHERE employee_id = ?";
  db.query(sql, [first_name, last_name, email, req.params.id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: "User updated successfully" })
  })
})

app.delete("/employees/:id", (req, res) => {
  const sql = "DELETE FROM employees WHERE employee_id = ?"
  db.query(sql, [req.params.id], (err, result) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json({ message: "User deleted successfully" });
  })
})

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`)
})