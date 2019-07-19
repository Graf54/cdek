<#import "template.ftl" as layout />
<@layout.mainLayout>
    <div class="container">
        <div class="row">
            <h3>Создать заявку</h3>
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
                        <input type="text" class="form-control" required="required" minlength="3" maxlength="50"
                               id="phone" name="phone"
                               placeholder="Введите номер телефона"
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
            <tr>
                <form action="/search" method="get">
                    <th scope="col">
                        <#if (idNotFound>0)>
                            <div class="form-group">
                                <input type="number" class="form-control" min="1" id="id" name="id"
                                       placeholder="${idNotFound} не найден"
                                       value="">
                            </div>
                        <#else >
                            <div class="form-group">
                                <input type="number" class="form-control" min="1" id="id" name="id"
                                       placeholder="По номеру"
                                       value="">
                            </div>
                        </#if>
                    </th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">
                        <button type="submit" class="btn btn-primary">Отфильтровать</button>
                    </th>
                </form>
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
        <#if (total>limit)>


            <div class="container mt-3">
                <div class="row">
                    <ul class="pagination col justify-content-center">
                        <li class="page-item active">
                            <a class="page-link" href="/changePage?button=back&currentPage=${currentPage}"
                               tabindex="-1">Назад</a>
                        </li>
                        <li class="page-item disabled">
                            <a class="page-link" href="#"
                               tabindex="-1">${currentPage}</a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="/changePage?button=next&currentPage=${currentPage}"
                               tabindex="-1">Вперед</a>
                        </li>
                    </ul>
                </div>
            </div>
        </#if>
    </div>

</@layout.mainLayout>