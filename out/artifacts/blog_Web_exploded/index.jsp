<%@ page import="java.util.ArrayList" %>
<%@ page import="com.darkcraft.pojo.Commodity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>Index</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <style>
        .add_cover {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 2;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.623);
        }

        #addNewCard, #searchCard {
            width: 60%;
            position: fixed;
            top: 50%;
            left: 50%;
            margin-top: -285px; /* Negative half of height. */
            margin-left: -220px; /* Negative half of width. */
            z-index: 3;
        }


        .card-content {
            font-size: 15px;
            line-height: 30px;
            color: chocolate;
        }

        html{
            background: url('https://z3.ax1x.com/2021/10/09/5FpcVK.png');
        }
    </style>

</head>

<body>

<%
    String addSuccess = request.getParameter("addSuccess");
    String DelSuccess = request.getParameter("DelSuccess");
    String pageIndexS = request.getParameter("page");

    ArrayList<Commodity> img = (ArrayList<Commodity>) request.getAttribute("img");
    ArrayList<Commodity> img2 = (ArrayList<Commodity>) session.getAttribute("img");
    List<Commodity> imgL = null;
    int pageIndex = 1;
    if(img!=null){
        if (pageIndexS != null) {
            pageIndex = Integer.parseInt(pageIndexS);
        }
        int total = img.size();
        int start = (pageIndex - 1) * 20;
        int end = total-start>20 ? start+20 : total;
        imgL = img.subList(start,end);
        session.setAttribute("page",pageIndex);
        request.setAttribute("page",pageIndex);
    }
    request.setAttribute("page",pageIndex);


%>
<script>
    let suc = <%=addSuccess%>;
    if (suc == '1')
        alert('添加成功');
    else if (suc == '0')
        alert('添加失败')
    let Delsuc = <%=DelSuccess%>;
    if (Delsuc == '1')
        alert('删除成功');
    else if (Delsuc == '0')
        alert('删除失败')
</script>

<h4 style="text-align: center;font-family: Satisfy;">Commodity List</h4>

<p><a href="nameSearch?nameSearch=&page=1" class="waves-effect waves-light btn">显示所有商品</a></p>
<p><a class="waves-effect waves-light btn" id="search">查询</a></p>
<p><a class="waves-effect waves-light btn" id="addNew">添加</a></p>

<div id="addNewCard" class="row" style="display: none;">
    <div class="col s12 m6">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title">添加商品</span>
                <form action="addCommodity" method="post" enctype="multipart/form-data">
                    <p>id: <input type="text" name="id"></p>
                    <p>名称: <input type="text" name="name"></p>
                    <p>价格: <input type="text" name="price"></p>
                    <p>种类: <input type="text" name="category"></p>
                    <p>图片: <input id="filep" type="file" name="picture" accept="image/gif, image/jpeg, image/png"></p>
                    <br>
                    <button type="submit" id="ok">确定</button>
                    <a id="cancleAddNew" class="waves-effect waves-light btn"
                       style="position: absolute;right: 20px;">取消</a>
                </form>
            </div>
            <div class="card-action">
            </div>
        </div>
    </div>
</div>

<div id="searchCard" class="row" style="display: none;">
    <div class="col s12 m6">
        <div class="card blue-grey darken-1">
            <div class="card-content white-text">
                <span class="card-title">查找</span>
                <form action="IDSearch">
                    <h6 style="text-align: center">id查询</h6>
                    <p>请输入商品ID: <input type="text" name="idSearch"></p>
                    <button type="submit" id="idOk">确定</button>
                </form>

                <form action="nameSearch">
                    <h6 style="text-align: center">名称查询</h6>
                    <p>请输入关键字: <input type="text" name="nameSearch"></p>
                    <button type="submit" id="nameOk">确定</button>
                </form>
                <a id="cancleSearch" class="waves-effect waves-light btn" style="position: absolute;right: 20px;">取消</a>
            </div>
            <div class="card-action">
            </div>
        </div>
    </div>
</div>

<div class="row">
    <c:forEach items="<%=imgL%>" var="img" varStatus="loop">
        <div class="col s2 m2">
            <div class="card">
                <div class="card-image">
                    <img style="height: 170px;" src="${pageContext.request.contextPath}/images?id=${loop.index+1+20*(requestScope.page-1)}">
                    <span class="card-title" style="color: slategray;font-weight: bold;font-size: 15px">${img.name}</span>
                    <a href="deleteCommodity?idDelete=${img.id}"
                       class="btn-floating halfway-fab waves-effect waves-light red"><i
                            class="material-icons">Del</i></a>
                </div>
                <div class="card-content">
                    <ul>
                        <li>id:${img.id}</li>
                        <li>名称:${img.name}</li>
                        <li>价格:${img.price}</li>
                        <li>种类:${img.category}</li>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="pageSwitch" style="width: 100%;overflow: hidden">
    <p><a href="${pageContext.request.contextPath}/nameSearch?nameSearch=&page=1" class="LastPage waves-effect waves-light btn" style="float: left" id="LastPage">上一页</a></p>
    <p><a href="${pageContext.request.contextPath}/nameSearch?nameSearch=&page=2" class="NextPage waves-effect waves-light btn" style="float: right" id="NextPage">下一页</a></p>
</div>

<div class="add_cover" id="add_cover"></div>
<script>
    document.getElementById('ok').onclick = () => {
        console.log(document.getElementById('filep').value);
    }
    document.getElementById('addNew').onclick = () => {
        document.getElementById('add_cover').style = "display:block;";
        document.getElementById('addNewCard').style = "display:block;";
    }
    document.getElementById("cancleAddNew").onclick = () => {
        document.getElementById('add_cover').style = "display:none;";
        document.getElementById('addNewCard').style = "display:none;";
    }
    document.getElementById('search').onclick = () => {
        document.getElementById('add_cover').style = "display:block;";
        document.getElementById('searchCard').style = "display:block;";
    }
    document.getElementById("cancleSearch").onclick = () => {
        document.getElementById('add_cover').style = "display:none;";
        document.getElementById('searchCard').style = "display:none;";
    }
</script>
</body>

</html>