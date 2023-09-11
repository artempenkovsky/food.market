<!DOCTYPE html>
<html>
<head>
    <title>Couriers</title>

</head>
<body align ="center">
<h2>Список курьеров</h2>
<table>
    <thead>
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Логин</th>
        <th>Статус активности</th>
        <th>Изменить статус</th>
    </tr>
    </thead>
    <tbody>
    <#list couriers as courier>
        <tr>
            <th>${courier.surName}</th>
            <th>${courier.name}</th>
            <th>${courier.login}</th>
            <th>${courier.approved?c}</th>
            <th> <form method="post" action="/api/v1/admin/couriers/changeStatusCouriers/${courier.id}">
                    <input type="submit" value="Подтвердить/Заблокировать">
                </form> </th>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>