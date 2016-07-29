<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function logoutAjax() {
	AjaxController.request({
		options : {
			url : '/rest/user/logout'
		},
		callbacks : {
			done : function(data, textStatus, jqXHR) {
				console.log("성공");
				$("#tilesBody").off();
			}
		},
		show : {
			progress : false,
			failMessage : false
		}
	});
}

	var logoutModule = (function() {
		var logoutTerm = 500000;
		var log = '';

		var logout = function() {
			log = window.setTimeout('logoutAjax();', logoutTerm);
		}

		var reset = function() {
			window.clearTimeout(log);
			logout();
		}

		$("#tilesBody").mousemove(function() {
			reset();
		});

		return {
			logout : function() {
				logout();
			},
			initLog : function() {
				return log;
			}
		}
	})();
</script>
</head>
<body>
	<div class="layout-header">
		<div class="header-info">
			
		</div>
	</div>
</body>
</html>