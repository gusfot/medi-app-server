/**
 * 
 */

var mapModule = (function() {
	function findByNaver(searchKeyword) {
		var url = "http://map.naver.com/?dlevel=7&type=ALL&queryRank=1&menu=location&tab=1&mapMode=0&query="+searchKeyword;
		window.open(url);
	}
	
	function findByGoogle(searchKeyword) {
		var url = "http://maps.google.co.kr/maps?hl=ko&ie=UTF8&t=m&z=15&q="+searchKeyword;
		window.open(url);
	}
	
	function findByDaum(searchKeyword) {
		var url = "http://map.daum.net/?map_type=TYPE_MAP&map_terrain=off&q="+searchKeyword;
		window.open(url);
	}
	
	return {
		findByNaver : function(searchKeyword) {
			findByNaver(searchKeyword);
		},
		findByGoogle : function(searchKeyword) {
			findByGoogle(searchKeyword);
		},
		findByDaum : function(searchKeyword) {
			findByDaum(searchKeyword);
		}
	}
	
})();
