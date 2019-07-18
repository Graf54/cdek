<#import "template.ftl" as layout />
<@layout.mainLayout>
    <div class="row m-1">
        <h3>Активные задачи</h3>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Номер</th>
            <th scope="col">Телефон</th>
            <th scope="col">Создана</th>
            <th scope="col">Активна</th>
            <th scope="col">Редактор</th>
        </tr>
        </thead>
        <tbody>
        <#list apps as app>
            <tr>
                <td>${app.id}</td>
                <td>${app.phone}</td>
                <td>${app.created?datetime?string("HH:mm:ss dd.MM.yy")}</td>
                <#if app.statusId==0>
                    <td>✅</td>
                <#else >
                    <td>⛔️</td>
                </#if>
                <td>
                    <a href="/cancel?id=${app.id}" class="btn btn-danger float-right mr-2" role="button">Не успеваю</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@layout.mainLayout>