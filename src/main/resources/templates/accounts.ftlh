<html>
<head>
    <title>Accounts</title>
</head>
<body>
<table id="accounts_table">
    <tr>
        <th>Action</th>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td>
                <form method="post" action="/accounts/${account.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>${account.id}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>

        </tr>
    </#list>
</table>
</body>
</html>
