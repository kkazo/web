<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layout/default/layout}">
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head th:replace="includes/header :: common_header(~{::title},~{::link},~{::script})">
<title>Sample 인덱스</title>
<link href="/static/js/plugins/jsTree/style.min.css" rel="stylesheet">
<script src="/static/js/plugins/jsTree/jstree.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	var save = function (){
		swal({
			title: "저장 하시겠습니까?"
			, text: "You will not be able to recover this imaginary file!"
			, type: "warning"
			, showCancelButton: true
			, confirmButtonColor: "#DD6B55"
			, confirmButtonText: "Yes, delete it!"
			, cancelButtonText: "No, cancel plx!"
			, closeOnConfirm: false
			, closeOnCancel: true
			, showLoaderOnConfirm: true
		}, function () {
			if ($("#frmDefault").valid()) {
				$("#frmDefault").submit();
				swal("Deleted!", "Your imaginary file has been deleted.", "success");
			} else {
				swal.close();
			}
		});
	};
	$(document).ready(function () {
		tree.init();

		$("#frmDefault").validate({
			submitHandler: function (form) {
				tree.actions.update();
			}
		});

	});
	var tree = {
		init: function () {
			var _this = this;
			$('#divCodes').jstree({
				'core': {
					'data' : function (node, callback) {
						$.getJSON("./code.json", {"parentId" : node.id}).done(function (result) {
							var data = result.result.content;
							var mappingData = [];
							_.forEach(data, function(value, key) {
								mappingData.push({
									id: value.id
									, text: "[" + value.code + "] " + value.name
									, icon: value.folderYn == "Y" ? "fa fa-folder" : "fa fa-file-text-o"
									, children: value.folderYn == "Y"
								});
							});
							callback(mappingData);
						});
					}
					,"check_callback" : true
				}
				, "plugins" : ["contextmenu", "dnd", "search","state"]
				, contextmenu: {
					items: {
						renameItem: { // The "rename" menu item
							label: "하위추가",
							action: function () {
								alert("TODO");
							}
						},
						deleteItem: { // The "delete" menu item
							label: "Delete",
							'icon': 'fa fa-folder',
							action: function () {
								alert("delete");
							}
						}
					}
				}
			}).on("changed.jstree", function (event, data) {
				_this.actions.get(data);
			}).on('move_node.jstree', function (event, data) {
				_this.actions.move(data);
				//data.instance.refresh();
			});

		}, actions: {
			get: function (data) {
				$("#divDetail").hide();
				if(data && data.selected && data.selected.length) {
					if (data.selected.length == 1 && data.selected[0] != "CODE") {	// 선택된 아이템이 1개일때만 동작
						$.getJSON("./get.json", {id: data.selected[0]}, function (result) {
							var item = result.result;
							$("#divDetail").data("selected", data).show();
							$("#inpId").val(item.id);
							$("#inpParentId").val(item.parentId);
							$("#inpCode").val(item.code).prop("readonly", true);
							$("#inpName").val(item.name);
							$("#inpValue1").val(item.value1);
							$("#inpValue2").val(item.value2);
							$("#inpValue3").val(item.value3);
							$("#inpValue4").val(item.value4);
							$("#inpValue5").val(item.value5);
							item.folderYn.trim() == "Y" ? $("#rdoFolderYn1").prop("checked", true) : $("#rdoFolderYn2").prop("checked", true);
							item.useYn.trim() == "Y" ? $("#rdoUseYn1").prop("checked", true) : $("#rdoUseYn2").prop("checked", true);
						});
					}
				}
			}, move: function (data) {
				console.log(data);
				if (data.old_parent.trim() == data.parent.trim()) {	// 동일한 정보로 순서만 변경
					if (data.old_position === data.position) {
						return;
					} else {
						$.getJSON((data.old_position > data.position ? "./moveUp.json" : "./moveDown.json"), {
							id: data.node.id
							, parentId: data.parent
							, ord: data.position
							, position: data.position
							, oldPosition: data.old_position});
					}
				} else {	// 신규 그룹으로 이동
					$.getJSON("./move.json", {id: data.selected[0], parentId: data.parentId});
				}
			}, update: function () {
				$.ajax({
					type: 'post'
					, dataType: 'json'
					, url: './update.json'
					, data: $("#frmDefault").serialize()
				});
				return false;
			}
		}
	}
</script>
</head>
<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row">
				<div class="col-lg-5">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>코드관리
								<small>등록된 전체 코드.</small>
							</h5>
						</div>
						<div class="ibox-content">
							<div id="divCodes"></div>
						</div>
					</div>
				</div>
				<div id="divDetail" class="col-lg-7 animated fadeInRight" style="display: none;">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>코드 정보
								<small>코드 정보 조회/입력/수정</small>
							</h5>
							<div class="ibox-tools">
								<a class="collapse-link">
									<i class="fa fa-chevron-up"></i>
								</a>
								<a class="close-link">
									<i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<form id="frmDefault" name="default" class="form-horizontal">
								<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
								<input type="hidden" id="inpParentId" name="parentId" value=""/>
								<div class="form-group">
									<label class="col-lg-2 control-label">ID</label>
									<div class="col-lg-10">
										<input type="text" id="inpId" name="id" placeholder="아이디는 수정 불가 하며 자동생성 됩니다." class="form-control" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">코드</label>
									<div class="col-lg-10">
										<input type="text" id="inpCode" name="code" placeholder="코드 입력(필수)" class="form-control" maxlength="20" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">코드명</label>
									<div class="col-lg-10">
										<input type="text" id="inpName" name="name" placeholder="코드명 입력(필수)" class="form-control" maxlength="20" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Value1</label>
									<div class="col-lg-10">
										<input type="text" id="inpValue1" name="value1" placeholder="Value1" class="form-control" maxlength="250"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Value2</label>
									<div class="col-lg-10">
										<input type="text" id="inpValue2" name="value2" placeholder="Value2(Option)" class="form-control" maxlength="250"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Value3</label>
									<div class="col-lg-10">
										<input type="text" id="inpValue3" name="value3" placeholder="Value3(Option)" class="form-control" maxlength="250"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Value4</label>
									<div class="col-lg-10">
										<input type="text" id="inpValue4" name="value4" placeholder="Value4(Option)" class="form-control" maxlength="20"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Value5</label>
									<div class="col-lg-10">
										<input type="text" id="inpValue5" name="value5" placeholder="Value5(Option)" class="form-control" maxlength="20"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">그룹여부</label>
									<div class="col-lg-10">
										<div class="radio radio-info radio-inline">
											<input type="radio" id="rdoFolderYn1" value="Y" name="folderYn" checked="checked">
											<label for="rdoFolderYn1">그룹</label>
										</div>
										<div class="radio radio-default radio-inline">
											<input type="radio" id="rdoFolderYn2" value="N" name="folderYn">
											<label for="rdoFolderYn2">코드</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">사용여부</label>
									<div class="col-lg-10">
										<div class="radio radio-info radio-inline">
											<input type="radio" id="rdoUseYn1" value="Y" name="useYn" checked="checked">
											<label for="rdoUseYn1">사용 </label>
										</div>
										<div class="radio radio-danger radio-inline">
											<input type="radio" id="rdoUseYn2" value="N" name="useYn">
											<label for="rdoUseYn2">사용안함</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<button class="btn btn-sm btn-white" type="button" onclick="save()">저장</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div th:substituteby="includes/footer :: footer"/>
	</div>
</div>
</body>
</html>