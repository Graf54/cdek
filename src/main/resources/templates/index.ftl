<#import "template.ftl" as layout />
<@layout.mainLayout>
    <div class="container">
        <form action="/search" method="post">

            <div class="form-group">
                <input type="number" class="form-control" id="id" name="id"
                       placeholder="Введите номер заявки для поиска"
                       value="">
            </div>
            <button type="submit" class="btn btn-primary">Найти</button>

        </form>
    </div>
    <#if (idFind > 0)>
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
            <tr>
                <td>${findApp.id}</td>
                <td>${findApp.phone}</td>
                <td>${findApp.created?datetime?string("HH:mm:ss dd.MM.yy")}</td>
                <#if findApp.statusId==0>
                    <td>✅</td>
                <#else >
                    <td>⛔️</td>
                </#if>
                <td>
                    <a href="/delete?id=${findApp.id}" class="btn btn-danger float-right mr-2" role="button">Delete</a>
                    <a href="/edit?id=${findApp.id}" class="btn btn-secondary float-right mr-2" role="button">Edit</a>
                </td>
            </tr>
            </tbody>
        </table>
    </#if>
    <div class="container">
        <div>
            <h3>Список заявок</h3>
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
                        <a href="/delete?id=${app.id}" class="btn btn-danger float-right mr-2" role="button">Delete</a>
                        <a href="/edit?id=${app.id}" class="btn btn-secondary float-right mr-2" role="button">Edit</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
        <div class="container">
            <div class="row">
                <h3>Добавить заявку</h3>
            </div>
        </div>

        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Phone</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <form action="/new" method="post">
                <tr>
                    <td>
                        <div class="form-group">
                            <input type="text" class="form-control" max="50" id="phone" name="phone"
                                   placeholder="Enter phone"
                                   value="">
                        </div>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </td>
                </tr>
            </form>
            </tbody>
        </table>
    </div>

</@layout.mainLayout>