<!DOCTYPE html>
<html>
<head>
    <title>Distributors</title>

</head>
<body align ="center">
<h2>Список дистрибьюторов</h2>
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
    <#list distributors as distributor>
        <tr>
            <th>${distributor.surName}</th>
            <th>${distributor.name}</th>
            <th>${distributor.login}</th>
            <th>${distributor.approved?c}</th>
            <th> <form method="post" action="/api/v1/admin/distributors/changeStatusDistributors/${distributor.id}">
                    <input type="submit" value="Подтвердить/Заблокировать">
                </form> </th>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>