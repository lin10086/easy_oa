<table class="table table-striped table-hover table-bordered table-responsive">
    <tr>
        <th>部门</th>
        <th>成员</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
        <th>星期六</th>
        <th>星期日</th>
    </tr>
    <#-- 如果ulist 存在就执行-->
    <#if ulist??>
        <#list ulist as user>
            <tr>
                <#--获取-->
                <td>${user.deptVO.deptName}</td>
                <td>${user.userName}</td>
                <#list weekday as wd>
                    <td class="report">
                        <#if user.attendancesSet??>
                            <#list user.attendancesSet as att>
                                <#if user.userId==att.userVO.userId>
                                    <#if (att.weekOfDay??)&&(att.weekOfDay==wd)>
                                        <a href="attendceedit?aid=${att.attendsId}">
                                            <#if att.typeId==8>
                                                <div>上班：${att.attendHMtime}</div>
                                            </#if>
                                            <#if att.typeId==9>
                                                <div>下班：${att.attendHMtime}</div>
                                            </#if>
                                        </a>
                                    </#if>
                                </#if>
                            </#list>
                        </#if>
                    </td>
                </#list>
            </tr>
        </#list>
    </#if>
</table>

<#include "/common/paging.ftl">
