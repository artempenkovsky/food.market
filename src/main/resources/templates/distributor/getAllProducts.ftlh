<!DOCTYPE html>
<html>
<head>
    <title>Список товаров</title>

</head>
<body align ="center">
<h2>Список товаров</h2>
<table>
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Единица измерения</th>
        <th>Статус</th>
        <th>Категория товаров</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <th>${product.name}</th>
            <th>${product.description}</th>
            <th>${product.price}</th>
            <th>${product.measurementUnit}</th>
            <th>${product.active?c}</th>
            <th>${product.productCategoryDTO.name}</th>
        </tr>
    </#list>
    </tbody>
</table>
<h2>Создать новый товар</h2>
<form action="/api/v1/distributors/addProduct" method="post">
    <h3>
        Наименование товара<input type="text" name="name">
        <br>
        <br>
        Описание<input type="text" name="description">
        <br>
        <br>
        Цена<input type="number" name="price" step="0.01">
        <br>
        <br>
        Единица измерения
        <select name="measurementUnit">
        <option value="шт">шт</option>
        <option value="кг">кг</option>
        </select>
        <br>
        <br>
        Категория товара
        <select name = "categoryId">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select>
        <br>
        <br>
        <input type="submit" value="Добавить" class="button2">
    </h3>

</body>
</html>