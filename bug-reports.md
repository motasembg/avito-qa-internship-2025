# Bug Report – Avito QA Internship (Task 1)

## Описание
Анализ интерфейса страницы результатов поиска на Avito (посуточная аренда домов, дач, коттеджей, таунхаусов в Москве и МО) на основе предоставленного скриншота.

---

## Найденные баги / UX-проблемы

ID 1 :
Описание проблемы : Блок “Ничего не найдено в выбранной области поиска” отображается при наличии карточек выше. Это может сбить пользователя
Приоритет : High

ID 2 :
Описание проблемы : Отображается фильтр “Снять на длительный срок” в разделе “Посуточная аренда”, что не соответствует текущему режиму поиска
Приоритет : Medium

ID 3 : 
Описание проблемы : Карточка “Вас может заинтересовать” визуально идёт сразу после блока “ничего не найдено” без чёткого разделения
Приоритет : Medium

ID 4 : 
Описание проблемы : Бейджи “Новое объявление” и “Промо” визуально не выделяются — слабый контраст, легко не заметить
Приоритет : Low

ID 5 :
Описание проблемы : Кнопка “Показать объявления на карте” визуально перекрывается границей между картой и фильтрами — выглядит "прилипшей"
Приоритет : Low


---

## Рекомендации по улучшению
- Скрывать блок “ничего не найдено”, если есть хоть одно объявление в выдаче.
- Уточнить отображение фильтра аренды по сроку — скрывать “длительный срок” в посуточной аренде.
- Добавить визуальные отступы или разделители между результатами поиска и рекомендациями.
- Сделать бейджи более яркими (контрастными), чтобы выделялись в карточках.
- Разнести фильтры и выдачу визуально — добавить тень или цвет фона.


## Task 2.1

## 1. POST /api/1/item accepts empty body

- **Steps:**
  1. Send a POST request to `/api/1/item` with `{}` as body
- **Expected:**
  - Validation error (400 Bad Request)
- **Actual:**
  - API returns 200 OK and creates a "blank" item
- **Priority:** Medium
- **Impact:** May allow invalid data into system

---

## 2. POST response does not return `id`

- **Steps:**
  1. Create a valid item
- **Expected:**
  - Response contains `id` field
- **Actual:**
  - Response body does not include `id`, which breaks flow of testing `GET` and `DELETE`
- **Priority:** High
- **Impact:** Chained tests cannot use created data

---

## 3. No validation on price or name

- **Steps:**
  1. Send POST with missing `name` or negative price
- **Expected:**
  - API should return 400 Bad Request
- **Actual:**
  - Still returns 200 OK
- **Priority:** Medium
- **Impact:** Bad data may be accepted silently
