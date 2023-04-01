<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signUp.page.title'/></title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1><@spring.message 'signUp.page.header'/></h1>
<h2><@spring.message 'signUp.page.description'/></h2>

<form action="/signUp" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="firstName"><@spring.message 'signUp.form.label.enterFirstName'/></label>
    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.firstName"/></#assign>
    <@spring.formInput "signUpForm.firstName" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br><br>
    <label for="lastName"><@spring.message 'signUp.form.label.enterLastName'/></label>
    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.lastName"/></#assign>
    <@spring.formInput "signUpForm.lastName" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br><br>
    <label for="email"><@spring.message 'signUp.form.label.enterEmail'/></label>
    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
    <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br><br>
    <label for="password"><@spring.message 'signUp.form.label.enterPassword'/></label>
    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
    <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
    <@spring.showErrors "<br>" "error"/>
    <br><br>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>