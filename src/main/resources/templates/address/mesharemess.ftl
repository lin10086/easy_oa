<link rel="stylesheet" type="text/css" href="css/sharemess.css"/>
<div class="box-header">
    <h3 class="box-title">我共享的</h3>
    <a class="btn btn-sm btn-default thisrefresh" href="javascript:void(0);" title="刷新"
       style="padding: 5px;margin-top: -8px;">
        <span class="glyphicon glyphicon-refresh"></span>
    </a>
    <div class="box-tools">
        <div class="input-group" style="width: 150px;">
            <input type="text" class="form-control input-sm searchbaseKey" placeholder="查找..." value="${(baseKey)!''}"/>
            <div class="input-group-btn">
                <a class="btn btn-sm btn-default searchbaseKeySumbit">
                    <span class="glyphicon glyphicon-search"></span>
                </a>
            </div>
        </div>
    </div>
</div>
<div style="margin-bottom:20px;">
    <#if dus?size gt 0>
        <#list dus as du>
            <div class="sharemess">
                <div class="sharecontent">
                    <div>
                        <div class="sharecontent-left" style="height: 30px;">
                            你将联系人:
                            <a href="javascript:void(0);"
                               class="othershow"
                               title="${du.directorVO.userName}"
                               thistel="${du.directorVO.phoneNumber}"
                               thissex="${du.directorVO.sex}"
                               thisemail="${(du.directorVO.email)!'空的'}"
                               thiscompany="${(du.directorVO.companyname)!'空的'}">
                                <img src="/image/${(du.directorVO.imagePath)!'timg.jpg'}" class="img-circle"
                                     style="width:24px;height:24px"/>
                                <span> ${du.directorVO.userName},${du.directorVO.phoneNumber}</span>
                            </a>
                            共享给了:
                            <a href="javascript:void(0);"
                               class="usershow"
                               title="${du.userVO.userName}"
                               thisdept="${du.userVO.deptVO.deptName}"
                               thisrole="${du.userVO.roleVO.roleName}"
                               thistel="${(du.userVO.userTel)!'空的'}"
                               thisemail="${(du.userVO.userEmail)!'空的'}"
                            >
                                <img src="/image/${(du.userVO.imgPath)!'timg.jpg'}" class="img-circle"
                                     style="width:24px;height:24px"/> ${du.userVO.userName}
                            </a>
                        </div>
                        <div class="share-right" style="height:30px;">
                            <div style="display: inline-block;">
                                <span>状态:</span>
                                <#if du.handle==false>
                                    <span class="label label-default">未处理</span>
                                <#else>
                                    <span class="label label-success">已处理</span>
                                </#if>
                            </div>
                            <p style="float: right;margin:0;">${du.shareTime}</p>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    <#else>
        <table class="table table-hover table-striped">
            <tr>
                <td colspan="7" style="text-align: center;background: #eee;">没能找到相关消息~~~</td>
            </tr>
        </table>
    </#if>
</div>
<#include "/common/paging.ftl"/>
<script>
    $('.searchbaseKeySumbit').on('click', function () {
        var baseKey = $('.searchbaseKey').val();
        console.log(baseKey);
        $('.thistable').load('${url}?baseKey=' + baseKey + '${(catalog)!''}');
    });
</script>
<script type="text/javascript" src="js/usershow.js"></script>