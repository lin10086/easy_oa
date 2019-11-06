<div class="bgc-w box box-primary">
				<!--盒子头-->
				<div class="box-header">
					<h3 class="box-title">
						<a href="" class="label label-success" style="padding: 5px;">
							<span class="glyphicon glyphicon-refresh"></span> 刷新
						</a> 
					</h3>
					<div class="box-tools">
						<div class="input-group" style="width: 220px;">
							<input type="text" class="form-control input-sm cha"
								placeholder="标题，申请人，类型，状态查询" />
							<div class="input-group-btn chazhao">
								<a class="btn btn-sm btn-default"><span
									class="glyphicon glyphicon-search"></span></a>
							</div>
						</div>
					</div>
				</div>
							<!--盒子身体-->
				<div class="box-body no-padding">
					<div class="table-responsive">
						<table class="table table-hover">
						<tr>
							<th scope="col">类型</th>
							<th scope="col">标题</th>
							<th scope="col">申请人</th>
							<th scope="col">申请时间</th>
							<th scope="col">紧急程度</th>
							<th scope="col">状态</th>
							<th scope="col">操作</th>
						</tr>
							<#--prolist-->
						<#if processAuditVOList?? && (processAuditVOList?size > 0)>
						<#list processAuditVOList as pro>
						<tr>
							<td>${pro.typeName}</td>
							<td><span>${pro.processName}</span></td>
							<td><span>${pro.auditUsername}</span></td>
							<td><span>${pro.applyTime}</span></td>
							<td><span>${pro.exigence}</span></td>
							<td><span class="label ${pro.statusColor}">${pro.statusName}</span></td>
							<td> <a href="auditing?processId=${pro.processId}" class="label sheding"><span
									class="glyphicon glyphicon-zoom-in"></span> 审核</a> 
								 <a href="particular?processId=${pro.processId}&typeName=${pro.typeName}" class="label xiugai"><span
									class="glyphicon glyphicon-search"></span> 查看</a> 
								<#if pro.statusName=="未通过"	|| pro.statusName=="已批准">
								 <a href="sdelete?processId=${pro.processId}" onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};" class="label shanchu">
								 	<span class="glyphicon glyphicon-remove"></span> 删除</a>	
									</#if>
									</td>
						</tr>
						</#list>
						</#if>
					</table>
					</div>
				</div>
				<!--盒子尾-->
				<#include "/common/paging.ftl">
			</div>
			
<script>
		/* 分页插件按钮的点击事件 */
		
		$('.baseKetsubmit').on('click',function(){
			var baseKey=$('.baseKey').val();
			$('.thistable').load('${url}?baseKey=baseKey');
		});
		

		   $(function(){
			   $(".chazhao").click(function(){
				   var con=$(".cha").val();
				   $(".thistable").load("serch",{val:con});
			   });
		});
	
		
</script>