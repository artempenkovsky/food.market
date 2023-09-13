<!DOCTYPE html>
<html xmlns:font-size="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Добавить в заказ</title>

</head>
<body>
<header>

</header>
<br>
<br>

<div align="center">
    <h1 align="center">${product.name}</h1>


    <b>Наименование:</b> ${product.name} <br>
    <b>Описание:</b> ${product.description} <br>
    <b>Цена:</b> ${product.price} руб.<br>
    <br>
    <form action="/api/v1/clients/addProductToOrder/${product.id}" method="post">
        <input type="submit" value="Добавить в Корзину" class="button">
    </form>
    <br>
</div>
</body>
</html>