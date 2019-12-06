<div class="box-footer no-padding" style="margin-top: -20px;">
    <div style="padding: 5px;">
        <div id="page"
             style="background: #fff; border: 0px; margin-top: 0px; padding: 2px; height: 25px;">
            <div style="width: 40%; float: left;">
                <div class="pageInfo" style="margin-left: 5px;">
                    共<span>${page.totalCount}</span>条 | 每页<span>${page.pageSize}</span>条
                    | 共<span>${page.totalPageCount}</span>页
                </div>
            </div>
            <div style="width: 60%; float: left;">
                <div class="pageOperation">
                    <!--判断是否是第一页  -->
                    <#if page.isFirstPage()==true>
                        <a class="btn btn-sm btn-default no-padding tablefirst" disabled="disabled"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-backward"></span></a>
                        <a class="btn btn-sm btn-default no-padding tableup" disabled="disabled"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-triangle-left"></span></a>
                    <#else>
                        <a class="btn btn-sm btn-default no-padding tablefirst" style="width: 30px; height: 20px;">
                            <span class="glyphicon glyphicon-backward"></span></a>
                        <a class="btn btn-sm btn-default no-padding tableup" style="width: 30px; height: 20px;">
                            <span class="glyphicon glyphicon-triangle-left"></span></a>
                    </#if>
                    <a disabled="disabled" class="btn btn-default no-padding" style="width: 30px; height: 20px;">
                        <#if (page.pageNo) gte page.totalPageCount>
                            ${page.totalPageCount}
                        <#else>
                            ${page.pageNo}
                        </#if>
                    </a>
                    <!--判断是否是最后一页  -->
                    <#if page.isLastPage()==true>
                        <a class="btn btn-sm btn-default no-padding tabledown" disabled="disabled"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-triangle-right"></span></a>
                        <a class="btn btn-sm btn-default no-padding tablelast" disabled="disabled"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-forward"></span></a>
                    <#else>
                        <a class="btn btn-sm btn-default no-padding tabledown"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-triangle-right"></span></a>
                        <a class="btn btn-sm btn-default no-padding tablelast"
                           style="width: 30px; height: 20px;"> <span
                                    class="glyphicon glyphicon-forward"></span></a>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    /* 分页插件按钮的点击事件 */
    /* url是从后台接收过来的链接，sort是记录排序规则 */
    $('.tablefirst').on('click', function () {
        if (${page.isFirstPage()?string('true','false')}==false
    )
        {
            $('.thistable').load('${url}?page=1${(sort)!''}');
        }
    });
    $('.tableup').on('click', function () {
        if (${page.isFirstPage()?string('true','false')}==false
    )
        {
            $('.thistable').load('${url}?page=${(page.pageNo)-1}${(sort)!''}');
        }
    });
    $('.tabledown').on('click', function () {
        if (${page.isLastPage()?string('true','false')}==false
    )
        {
            $('.thistable').load('${url}?page=${(page.pageNo)+1}${(sort)!''}');
        }
    });
    $('.tablelast').on('click', function () {
        if (${page.isLastPage()?string('true','false')}==false
    )
        {
            $('.thistable').load('${url}?page=${(page.totalPageCount)}${(sort)!''}');
        }

    });

    /* 查找 */
    $('.baseKetsubmit').on('click', function () {
        var baseKey = $('.baseKey').val();
        console.log(baseKey);
        $('.thistableson').load('${url}?baseKey=' + baseKey + '${(catalog)!''}');
    });
</script>