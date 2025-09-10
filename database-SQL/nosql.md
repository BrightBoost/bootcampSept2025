# MongoDB Employees Dataset – Practice & Queries

---

## 📌 Dataset Overview

We’ll use an **`employees`** collection with documents like:

```json
{
  "name": "Arjun",
  "age": 30,
  "department": "IT",
  "salary": 60000,
  "city": "Mumbai",
  "joiningDate": ISODate("2020-03-15")
}
```

### Sample Data

```js
db.employees.insertMany([
  { name: "Arjun", age: 30, department: "IT", salary: 60000, city: "Mumbai", joiningDate: new Date("2020-03-15") },
  { name: "Meera", age: 28, department: "HR", salary: 45000, city: "Delhi", joiningDate: new Date("2021-06-01") },
  { name: "Ravi", age: 35, department: "Finance", salary: 75000, city: "Bangalore", joiningDate: new Date("2018-11-20") },
  { name: "Anita", age: 26, department: "IT", salary: 55000, city: "Mumbai", joiningDate: new Date("2022-01-10") },
  { name: "Vikram", age: 40, department: "Finance", salary: 90000, city: "Delhi", joiningDate: new Date("2017-09-05") },
  { name: "Kavya", age: 32, department: "HR", salary: 50000, city: "Bangalore", joiningDate: new Date("2019-05-12") }
]);
```

---

##  Basic Practice Queries

1. Find all employees:

```js
db.employees.find()
```

2. Find employees in IT department:

```js
db.employees.find({ department: "IT" })
```

3. Find employees with salary greater than 60,000:

```js
db.employees.find({ salary: { $gt: 60000 } })
```

4. Show only name and salary:

```js
db.employees.find({}, { name: 1, salary: 1, _id: 0 })
```

5. Count employees in each department:

```js
db.employees.aggregate([
  { $group: { _id: "$department", total: { $sum: 1 } } }
])
```

---

## 🔹 Complex Queries

1. Employees earning above average salary

```js
const avgSalary = db.employees.aggregate([
  { $group: { _id: null, avgSalary: { $avg: "$salary" } } }
]).toArray()[0].avgSalary;

db.employees.find({ salary: { $gt: avgSalary } })
```

2. Top 2 highest-paid employees in each department

```js
db.employees.aggregate([
  { $sort: { salary: -1 } },
  { $group: { _id: "$department", top: { $push: { name: "$name", salary: "$salary" } } } },
  { $project: { top: { $slice: ["$top", 2] } } }
])
```

3. Find employees who joined in the last 2 years

```js
db.employees.find({
  joiningDate: { $gte: new Date(new Date().setFullYear(new Date().getFullYear() - 2)) }
})
```

4. Department with highest average salary

```js
db.employees.aggregate([
  { $group: { _id: "$department", avgSalary: { $avg: "$salary" } } },
  { $sort: { avgSalary: -1 } },
  { $limit: 1 }
])
```

5. Employees grouped by city with avg salary & count

```js
db.employees.aggregate([
  { $group: { _id: "$city", avgSalary: { $avg: "$salary" }, count: { $sum: 1 } } }
])
```

6. Youngest employee in each department

```js
db.employees.aggregate([
  { $sort: { age: 1 } },
  { $group: { _id: "$department", youngest: { $first: "$$ROOT" } } },
  { $project: { "youngest.name": 1, "youngest.age": 1 } }
])
```

7. Employees with duplicate salaries

```js
db.employees.aggregate([
  { $group: { _id: "$salary", employees: { $push: "$name" }, count: { $sum: 1 } } },
  { $match: { count: { $gt: 1 } } }
])
```

8. Find employees with name containing "vi" (case-insensitive)

```js
db.employees.find({ name: { $regex: "vi", $options: "i" } })
```

9. Find top 2 highest-paid employees overall

```js
db.employees.find().sort({ salary: -1 }).limit(2)
```

10. Add a calculated field `experienceYears`

```js
db.employees.aggregate([
  { $addFields: { experienceYears: { $subtract: [ { $year: new Date() }, { $year: "$joiningDate" } ] } } },
  { $project: { name: 1, department: 1, experienceYears: 1 } }
])
```

---

##  Challenge Questions (Try Yourself)

1. Find the **highest-paid employee** in each city.
2. List employees who joined **before 2020** and earn less than 60,000.
3. Find the **second highest salary** in the IT department.
4. Calculate the **total salary expense** per department.
5. Show employees sorted by **joining year**.
6. Find employees with salary between **50,000 and 80,000**.
7. Get the **count of employees per department, only if count > 1**.
8. Show all employees with a field `bonus` = 10% of salary (without updating DB).
9. Find employees in **Finance** whose names start with "V".
10. Find employees with **experience > 5 years**.


