# 📘 MongoDB Students Dataset Queries

## 📂 Dataset

``` js
db.students.insertMany([
  {
    name: "Rahul",
    age: 22,
    course: "Computer Science",
    marks: 85,
    city: "mumbai",
    skills: ["JAVA", "MongoDB", "React"]
  },
  {
    name: "Priya",
    age: 23,
    course: "Information Tech",
    marks: 92,
    city: "dehli",
    skills: ["Python", "Django", "SQL"]
  },
  {
    name: "Amit",
    age: 21,
    course: "Electronics",
    marks: 76,
    city: "Pune",
    skills: ["C", "C++", "Embb System"]
  }
]);
```

### 1. Fetch all documents

``` js
db.students.find();
```
### 2. Find students from **Mumbai**

``` js
db.students.find({ city: "mumbai" });
```
### 3. Find students with marks **greater than 80**

``` js
db.students.find({ marks: { $gt: 80 } });
```
### 4. Show only **name** and **marks** (exclude `_id`)

``` js
db.students.find({}, { name: 1, marks: 1, _id: 0 });
```
### 5. Count students from **Mumbai**

``` js
db.students.countDocuments({ city: "mumbai" });
```
### 6. Find **average marks** of all students

``` js
db.students.aggregate([
  { $group: { _id: null, avgMarks: { $avg: "$marks" } } }
]);
```
### 7. Count students in each **course**

``` js
db.students.aggregate([
  { $group: { _id: "$course", totalStudents: { $sum: 1 } } }
]);
```

### 8. Sort students by marks (ascending)

``` js
db.students.find().sort({ marks: 1 });
```

### 9. Sort students by marks (descending)

``` js
db.students.find().sort({ marks: -1 });
```

##  Summary

This dataset and queries demonstrate **basic MongoDB operations**:\
- `find()` → Filtering documents\
- `projection` → Selecting specific fields\
- `countDocuments()` → Counting results\
- `aggregate()` → Performing calculations (avg, group)\
- `sort()` → Sorting results
