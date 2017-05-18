<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        产品列表
        <small>分页展示</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
   		<div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">商城产品列表</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                <!-- 用于分页和搜索 -->
                <form id="pageForm">
						<input type="hidden" name="pageCur"value="${page.pageNum }" /> 
						 <input type="text" name="productName" value="${productName }" class="form-control pull-right" placeholder="产品名称">
					</form>
                  <div class="input-group-btn">
                    <button type="button" onclick="toPage(1)" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody><tr>
                  <th>序号</th>
                  <th>类型ID</th>
                  <th>名称</th>
                  <th>价格</th>
                  <!-- <th>描述</th> -->
                </tr>
                <c:forEach items="${page.list}" var="product" varStatus="status">
                	<tr>
	                  <td>${status.count }</td>
	                  <td>${product.productType.name }</td>
	                  <td>${product.name }</td>
	                   <td>${product.price }</td>
                    </tr>
                </c:forEach>
              </tbody></table>
            </div>
            <!-- /.box-body -->
            
            <!-- /.box-footer-->
            <div class="box-footer clearfix">
					<ul class="pagination pagination-sm no-margin pull-right">
						<c:if test="${page.pageNum==1 }">
							<li class="disabled"><a>前一页</a></li>
						</c:if>
						<c:if test="${page.pageNum!=1}">
							<li><a href="javascript:toPage(${page.prePage })">前一页</a></li>
						</c:if>
						<c:forEach begin="${page.navigateFirstPage}"
							end="${page.navigateLastPage}" var="wp">
							<c:if test="${wp==page.pageNum}">
								<li class="disabled"><a>${wp}</a></li>
							</c:if>
							<c:if test="${wp!=page.pageNum}">
								<li><a href="javascript:toPage(${wp})">${wp}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${page.pageNum==page.pages || page.pages==0}">
							<li class="disabled"><a>后一页</a></li>
						</c:if>
						<c:if test="${(page.pageNum!= page.pages) && page.pages!=0}">
							<li><a href="javascript:toPage(${page.nextPage})">后一页
							</a></li>
						</c:if>
					</ul>
				</div>
            <!-- /.box-footer-->
          </div>
          <!-- /.box -->
        </div>
      </div>
      <script type="text/javascript">
      /*分页查看,转至page指定的页*/
		function toPage(page) {
			$("input[name='pageCur']").val(page);
			$.ajax({
				type: "POST",
		         url: "work/prolist.action",
		         data:	$('#pageForm').serialize() ,
		        dataType: 'html',
		         success: function(msg) {
			        	$("#content_panel").html(msg);
		        	 }
				});//ajax
		}
      </script>
    </section>
    <!-- /.content -->