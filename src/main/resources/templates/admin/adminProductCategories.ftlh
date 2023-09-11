<!DOCTYPE html>
<html>
<head>
    <title>Категории товаров</title>

</head>
<body align ="center">
<h2>Список категорий товаров</h2>
<table>
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Приоритет</th>
    </tr>
    </thead>
    <tbody>
    <#list productCategories as category>
        <tr>
            <th>${category.name}</th>
            <th>${category.priority}</th>
        </tr>
    </#list>
    </tbody>
</table>
<br>
<h2>Создать новую категорию</h2>
<form action="/api/v1/admin/distributors/createCategory" method="post">
    <h3>
        Наименование категории<input type="text" name="name">
        <br>
        <br>
        Приоритет категории<input type="number" name="priority" min="1" max="1000">
        <br>
        <br>
        <input type="submit" value="Добавить" class="button2">
    </h3>
</form>
</body>
</html>