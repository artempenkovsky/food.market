<!DOCTYPE html>
<html>
<head>
    <title>Список товаров</title>

</head>
<body align="center">
<h2>Список товаров</h2>
<table>
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Единица измерения</th>
        <th>Категория товаров</th>
        <th>Добавить в корзину</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <th>${product.name}</th>
            <th>${product.description}</th>
            <th>${product.price}</th>
            <th>${product.measurementUnit}</th>
            <th>${product.productCategoryDTO.name}</th>
            <th>
                <a href="/api/v1/clients/infoProduct/${product.id}">Подробная информация</a>
            </th>

        </tr>
    </#list>
    </tbody>
</table>
<br>
<h2>Моя корзина</h2>
<table>
    <thead>
    <tr>
        <th>Наименование</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Кол-во</th>
        <th>Общая сумма</th>
    </tr>
    </thead>
    <tbody>
    <#list baskets as basket>
        <tr>
            <th>${basket.name}</th>
            <th>${basket.description}</th>
            <th>${basket.price}</th>
            <th>${basket.count}</th>
            <th>${basket.amount}</th>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>