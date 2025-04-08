# avito-qa-internship-2025
 
## Task 1 – Screenshot Bug Analysis

В этом задании я проанализировал скриншот Avito. Цель состояла в том, чтобы выявить видимые ошибки и несоответствия в пользовательском интерфейсе, расставить приоритеты и предложить улучшения

---

## What I Did

- Внимательно изучил макет, текст и структуру экрана
- Внесены видимые ошибки и проблемы с UX в `bug-reports.md`

## Key Observations

- Некоторые элементы на экране логически конфликтуют (например, отображается сообщение "Ничего не найдено" при наличии результатов)
- Незначительные несоответствия в дизайне, которые могут повлиять на удобство использования
- Визуальная путаница между фильтрами и фактическими результатами

---

## Files in This Repo

| File              | Description                                              |
|-------------------|----------------------------------------------------------|
| `bug-reports.md`  | List of bugs/UX issues with priorities                   |
| `README.md`       | Summary of what was done for Task 1  &    Task 2.1       |

---

## What I’d Improve (if this were a live project)

- Add condition-based rendering to prevent "nothing found" message from showing when results exist
- Improve layout structure to clearly separate filters, results, and suggestion blocks
- Rework filters to always reflect the current mode (e.g. remove “длительный срок” for посуточная аренда)


---

## Task 2.1 – API Testing Automation

This project contains automated tests for a microservice that handles listing items (ads) via HTTP API.

## Tech Stack

- Java 17
- JUnit 5
- REST-assured (HTTP API testing)
- Maven (build tool)

## Structure

| File / Folder             | Purpose                                  |
|---------------------------|------------------------------------------|
| `CreateItemTests.java`    | Tests for `POST /api/1/item`             |
| `GetItemTests.java`       | Tests for `GET /api/1/item/{id}`         |
| `DeleteItemTests.java`    | Tests for `DELETE /api/2/item/{id}`      |
| `StatsTests.java`         | Tests for statistics endpoints (v1 & v2) |
| `pom.xml`                 | Maven dependencies                       |

---

## How to Run the Tests

### 1. Clone the repo
```bash
git clone https://github.com/YOUR_USERNAME/avito-qa-internship-spring-2025.git
cd avito-qa-internship-spring-2025
mvn test
real endpoint: https://qa-internship.avito.com

