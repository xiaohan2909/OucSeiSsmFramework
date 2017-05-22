<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 自定义权限标签 -->
<%@ taglib uri="/permission-tags" prefix="p" %>
 <!-- Left side column. contains the logo and sidebar 左边栏 -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Doctor Yang</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">HEADER</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="active"><a href="javascript:showContent('work/userProfile.action');"><i class="fa fa-link"></i> <span>用户页</span></a></li>
        <li><a href="javascript:showContent('work/prolist.action');"><i class="fa fa-link"></i> <span>动态列表</span></a></li>
       <p:permission needPermission="product.delete">
       			<li><a><i class="fa fa-link"></i> <span>超级删除</span></a></li>
       </p:permission>
       
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>多级链接</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">二级链接</a></li>
            <li><a href="#">二级链接</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>