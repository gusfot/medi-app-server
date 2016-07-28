<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-lg-12">
		<div class="ibox-content">
			<form class="form-horizontal" id="frm">
				<div class="form-group"><label class="col-sm-0 control-label" style="float: left; margin-left: 15px;">작성자</label>
				    <div class="col-sm-5"><input type="text" class="form-control" id="writer"></div>
				</div>
				<div class="form-group"><label class="col-sm-0 control-label" style="float: left; margin-left: 15px;">글제목</label>
				    <div class="col-sm-5"><input type="text" class="form-control" id="title"></div>
				</div>
				<textarea id="smarteditor" name="smarteditor"  rows="10" cols="100" style="width:766px; height:412px;"></textarea>
				<button class="btn btn-warning" id="savebutton"><i class="fa fa-check"></i>&nbsp;서버전송</button>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "${resourcePath}/smarteditor/SmartEditor2Skin.html", // 해당 경로에 있는 html 호출 (iframe 형식으로 올 듯?)
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true, 
            fOnBeforeUnload : function(){} // 이 페이지에서 나가시겠습니까 alert창 무효화
        }
    });
     
    //전송버튼 클릭이벤트
    $("#savebutton").click(function(e){
    	e.preventDefault();
		//id가 smarteditor인 textarea에 에디터에서 내용 가져오기
        var content = editor_object[0].getIR(); // 스마트 에디터에 입력한 내용을 가져와서 저장해놓는다.
        
        AjaxController.request({
			options : {
				url : '/rest/article/regist',
				data : {
					writer : $("#writer").val(),
					title : $("#title").val(),
					content : content
				},
				type : 'post'
			},
			callbacks : {
				done : function(data, textStatus, jqXHR) {
					if (data.success === true) {
						location.href = "/layout/board";
					}
				}
			},
			show : {
				progress : true,
				failMessage : true
			}
		});
    });
})

</script>