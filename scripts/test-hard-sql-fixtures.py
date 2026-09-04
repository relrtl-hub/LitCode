import json
import sqlite3
from pathlib import Path

problems = {
    item["id"]: item
    for item in json.loads(Path("src/main/resources/data/problems.json").read_text())
}
connection = sqlite3.connect(":memory:")
cursor = connection.cursor()

cursor.executescript(
    """
    CREATE TABLE maintable_XXXX (
        ID INTEGER, Name TEXT, DivisionID INTEGER, ManagerID INTEGER, Salary INTEGER
    );
    CREATE TABLE cb_companydivisions (ID INTEGER, DivisionName TEXT);
    INSERT INTO maintable_XXXX VALUES
        (1, 'Boss', 1, NULL, 150),
        (2, 'Alice', 1, 1, 140),
        (3, 'Bob', 2, 1, 125),
        (4, 'Cara', 2, 2, 100);
    INSERT INTO cb_companydivisions VALUES (1, 'Engineering'), (2, 'Sales');
    """
)
assert cursor.execute(problems["sql-employee-salaries"]["solutionCode"]).fetchall() == [
    (3, "Bob", "Sales", "Boss", 125)
]

cursor.executescript(
    """
    CREATE TABLE Employee (id INTEGER, name TEXT, salary INTEGER, managerId INTEGER);
    INSERT INTO Employee VALUES
        (1, 'Boss', 100, NULL),
        (2, 'Alice', 150, 1),
        (3, 'Bob', 80, 1),
        (4, 'Cara', 90, 1);
    CREATE TABLE Department (id INTEGER, name TEXT);
    INSERT INTO Department VALUES (1, 'Engineering');
    ALTER TABLE Employee ADD COLUMN departmentId INTEGER;
    UPDATE Employee SET departmentId = 1;
    """
)
assert cursor.execute(problems["sql-employees-more-than-managers"]["solutionCode"]).fetchall() == [
    ("Alice", 150, "Boss", 100)
]
assert cursor.execute(problems["sql-department-top-salaries"]["solutionCode"]).fetchall() == [
    ("Engineering", "Alice", 150)
]

cursor.executescript(
    """
    CREATE TABLE categories (id INTEGER, parent_id INTEGER, name TEXT);
    CREATE TABLE products (id INTEGER, category_id INTEGER, price INTEGER);
    INSERT INTO categories VALUES
        (1, NULL, 'Catalog'), (2, 1, 'Hardware'), (3, 2, 'Keyboards');
    INSERT INTO products VALUES (1, 3, 10), (2, 3, 20);
    """
)
assert cursor.execute(problems["sql-parent-child-rollup"]["solutionCode"]).fetchall() == [
    ("Hardware", "Catalog", "Keyboards", 2, 30)
]

print("hard SQL SQLite fixtures passed")
