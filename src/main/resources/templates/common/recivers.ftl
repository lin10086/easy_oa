
									<div class="table-r">
										<table class="table  table-hover  container-fluid ">
										<thead>
											<tr class="row">
												<th class=" col-xs-1">
													<span class="labels"  style="display:none;"><label><input id="checkedAll" type="checkbox"><i>✓</i></label></span>
												</th>
												<th class=" col-xs-1">
													<span class="labels"  style="display:block;"></span>
												</th>
												<th class=" col-xs-2 b">部门</th>
												<th class=" col-xs-2 b">真实姓名 </th>
												<th class="col-xs-2 b">用户名</th>
												<th class="col-xs-2 b">职位</th>
												<th class=" col-xs-2">电话</th>
											</tr>
										</thead>
										<tbody>
											<#list userVOList as userVO>
											<tr class="row">
												<td class=" col-xs-1">
													<span class="labels"><label><input name="id" type="checkbox"><i>✓</i></label></span>
												</td>
												<td class=" col-xs-1">
													<span class="imgs center-block">
														<#if userVO.imgPath?? && userVO.imgPath!=''  >
														<img style="width: 30px;height: 30px;"
															class="profile-user-img img-responsive img-circle"
															src="/image/${userVO.imgPath}" />
														<#else>
														<img style="width: 30px;height: 30px;"
															class="profile-user-img img-responsive img-circle"
															src="images/timg.jpg" alt="images"/>
														
														</#if>	
															</span>
												</td>
												<#list deptVOList as deptVO>
												<#if userVO.deptVO.deptId==deptVO.deptId>
												<td class="col-xs-2">${deptVO.deptName}</td>
												</#if>
												</#list>
												<td class=" col-xs-2">${userVO.realName} </td>
												<td class="col-xs-2 na">${userVO.userName}</td>
												<#list positionVOList as positionVO>
												<#if userVO.positionVO.positionId==positionVO.positionId>
												<td class=" col-xs-2">${positionVO.positionName}</td>
												</#if>
												</#list>
												<td class=" col-xs-2">${userVO.userTel}</td>

											</tr>
											</#list>
											</tbody>
										</table>
										</div>

										<#include "/common/paging.ftl">

								