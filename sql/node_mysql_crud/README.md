# Simple CRUD Server with Nodejs + MySQL


Run this SQL command in MySQL to switch the authentication method for your user:

```sql
ALTER USER 'your_db_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'your_db_password';
FLUSH PRIVILEGES;
```

### Create

```bash
curl -X POST -H "Content-Type: application/json" -d '{"first_name":"John Updated","last_name":"Doe","email":"john@example.com"}' http://localhost:3000/employees
```

### Delete

```bash
curl -X DELETE http://localhost:3000/employees/6
```

### Update

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"first_name":"thuta", "last_name":"sann","email":"thutasann2002@gmail.com"}' http://localhost:3000/employees/1
```