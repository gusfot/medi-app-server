<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-10">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>업체홍보게시판</h5>
				<div class="ibox-tools">
					총 게시물 수 : 
				</div>
			</div>
			<div class="ibox-content">

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>작성일</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>첨부파일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
							<td>@mdo</td>
							<td>@mdo</td>
						</tr>
					</tbody>
					<tr>
						<td style="border: 1px solid white; text-align: center;"><button style="margin-top: 3px;">목록</button></td>
						<td colspan="4" style="border: 1px solid white; text-align: center;">
							<ul class="pagination" style="margin-top: 3px;">
								<li class="paginate_button previous disabled" id="DataTables_Table_0_previous">
									<a href="#" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">Previous</a>
								</li>
								<li class="paginate_button ">
									<a href="javascript:controller.goTo(12)" aria-controls="DataTables_Table_0" data-dt-idx="6" tabindex="0">6</a>
								</li>
								<li class="paginate_button next" id="DataTables_Table_0_next">
									<a href="javascript:controller.goTo()" aria-controls="DataTables_Table_0" data-dt-idx="7" tabindex="0">Next</a>
								</li>
							</ul>
						</td>
						<td style="border: 1px solid white; text-align: center;"><button style="margin-top: 3px;" id="writeBtn">글쓰기</button></td>
					</tr>
					<tr>
						<td colspan="6" style="border: 1px solid white; text-align: center;">
							<form style="margin: 0; padding: 0;">
								<select name="keyList" id="keyList">
									<!-- DB에 접근할 떄 value와 db컬럼명이 같아야한다. -->
									<option value="title" selected="selected">제목</option>
									<option value="writer">작성자</option>
								</select> 
								<input type="text" id="keyword" name="keyword" value="" /> 
								<input type="submit" id="searchBtn" name="searchBtn" value="검색" />
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$("#writeBtn").click(function() {
		location.href = "/layout/smartEditor";
	});
</script>