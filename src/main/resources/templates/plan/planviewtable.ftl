<div class="bgc-w box box-primary">
    <div class="box-header">
        <a class="label label-success" href="planedit?pid=-1"><span class="glyphicon glyphicon-plus"></span>
            新增
        </a>

        <div class="input-group" style="width:150px;float:right;top:-5px">
            <input type="text" class="form-control input-sm pull-right baseKey" value="${(baseKey)!''}"
                   placeholder="查找..."/>
            <div class="input-group-btn" style="top:-1px;">
                <a class="btn btn-sm btn-default glyphicon glyphicon-search btn-change baseKetsubmit"></a>
            </div>
        </div>

    </div>
    <div class="box-body">
        <div class="table" style="padding-top: 15px;">
            <div class="table-responsive">
                <table class="table table-hover table-striped">

                    <form action="dimSelect" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-1">
                                类型名:
                                <select class="form-control" name="selectTypeName">
                                    <option selected></option>
                                    <#list typelist as t>
                                        <option ${(plan??&&plan.typeId==t.typeId)?string('selected','')}>${t.typeName}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-md-1">
                                <input type="text" placeholder="标签搜索" name="selectLabel"/>
                            </div>

                            <div class="col-md-1">
                                <input type="text" placeholder="标题搜索" name="selectTitle"/>
                            </div>

                            <div class="col-md-1">
                                <input type="text" placeholder="发布人名搜索" name="selectPushUsername"/>
                            </div>

                            <div class="col-md-1">
                                部门名：
                                <select class="form-control" name="selectDeptName">
                                    <option selected></option>
                                    <#list deptPOList as d>
                                        <option ${(plan??&&plan.userVO.deptVO.deptId==d.deptId)?string('selected','')} >${d.deptName}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-md-1">
                                状态名：
                                <select class="form-control" name="selectStatusName">
                                    <option selected></option>
                                    <#list statuslist as s>
                                        <option ${(plan??&&plan.statusId==s.statusId)?string('selected','')} >${s.statusName}</option>
                                    </#list>
                                </select>
                            </div>

                            <div class="col-md-1">
                                <input type="submit" value="搜索"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
						<span>
						<label class="control-label">开始时间</label>
						</span>
                                <input class="form-control" name="selectStartTime" value="" type="date"/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="control-label">结束时间</label>
                                <input class="form-control" name="selectEndTime" value="" type="date"/>
                            </div>
                        </div>
                    </form>


                    <tr class="table-header">
                        <th scope="col" class="paixu thistype" style="color:blue;">类型
                            <#if type?? && icon??>
                                <span class="glyphicon ${icon}"></span>
                            </#if>
                        </th>
                        <th scope="col">标签</th>
                        <th scope="col">标题</th>
                        <th scope="col"><span class="paixu thistime" style="color:blue;">发布时间
						<#if time?? && icon??>
                            <span class="glyphicon ${icon}"></span>
                        </#if>
						</span></th>
                        <th scope="col">发布人</th>
                        <th scope="col">部门</th>
                        <th scope="col"><span class="paixu thisstatus" style="color:blue;">状态
						<#if status?? && icon??>
                            <span class="glyphicon ${icon}"></span>
                        </#if>
						</span></th>
                        <th scope="col">附件</th>
                        <th scope="col">操作</th>
                    </tr>

                    <#if plist??>
                        <#list plist as plan>
                            <tr>
                                <td>
                                    <#list typelist as t>
                                        <#if plan.typeId==t.typeId>${t.typeName}</#if>
                                    </#list>
                                </td>

                                <td>
                                    <#if plan.label??>
                                        【${plan.label}】
                                    </#if>
                                </td>
                                <td>
                                    <#if plan.title??>
                                        ${plan.title}
                                    </#if>
                                </td>
                                <td>
                                    ${plan.createTime}
                                </td>
                                <td>
                                    ${plan.userVO.userName}
                                </td>
                                <td>
                                    ${plan.userVO.deptVO.deptName}
                                </td>
                                <td>
                                    <#list statuslist as s>
                                        <#if plan.statusId==s.statusId><span
                                            class="label ${s.statusColor}">${s.statusName}</span></#if>
                                    </#list>
                                </td>
                                <td>
                                    <#if plan.attachmentId??>
                                    <a style="color:#337ab7;" href="file?fileid=${plan.attachmentId}">
                                        <span class="glyphicon glyphicon-paperclip"></span>
                                        </#if>
                                </td>
                                <td>
                                    <a href="planedit?pid=${plan.planId}" class="label xiugai"><span
                                                class="glyphicon glyphicon-edit"></span> 修改</a>

                                    <#--<a onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"-->
                                    <#--<a onclick="{return alert('删除该记录将不能恢复，确定删除吗？');};"-->
                                    <#--<a onclick="{return del_sure('删除该记录将不能恢复，确定删除吗？');};"-->
                                      <a href="plandelete?pid=${plan.planId}" class="label shanchu"><span
                                                class="glyphicon glyphicon-remove"></span> 删除</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>

                </table>
            </div>
        </div>
    </div>


    <#include "/common/paging.ftl">

</div>