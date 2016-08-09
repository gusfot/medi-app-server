if (typeof window.jQuery === 'undefined') {
	throw new Error('AjaxController requires jQuery');
}

if (typeof window.swal === 'undefined') {
	throw new Error('AjaxController requires SweetAlert');
}

+function (factory) {
	'use strict';

	window['AjaxController'] = factory(jQuery, swal);
}(function ($, swal) {
	function AjaxController() {

	}

	var contextPath = location.pathname.replace(/(\/[a-zA-Z0-9]+)\/*.*/, '$1'),
		path = location.host + contextPath;

	// 기본 설정값
	var DEFAULTS = {
		progressClassName: 'progress-ajax-controller-overlay',
		progressImgUrl: '/resources/img/ajax-loader.gif',     // TODO 기본 프로그레스 이미지 url은 프로젝트 환경에 맞춰서 수정해야 함
		options: {
			url: '',
			type: 'get',
			async: true,
			cache: false,
			data: null,
			dataType: 'json'
		},
		callbacks: {
			done: function (data, textStatus, jqXHR) {

			},
			fail: function (jqXHR, textStatus, errorThrown) {

			},
			always: function (dataOrJqXHR, textStatus, jqXHROrErrorThrown) {

			},
			warningAlertCallback: function(param) {

			}
		},
		show: {
			progress: true,
			failMessage: true
		}
	};

	/**
	 * 공통 ajax 요청
	 * @param param - DEFAULTS 참조
	 */
	AjaxController.request = function (param) {
		var options = _getValue(param.options, DEFAULTS.options),
			func = _getValue(param.callbacks, DEFAULTS.callbacks),
			show = _getValue(param.show, DEFAULTS.show),
			progressImgUrl = param.progressImgUrl || DEFAULTS.progressImgUrl,
			beforeSend = function(jqXHR, settings) {
				// 요청을 보내기 전에 수행할 부분 설정
				var paramBeforeSend = param.options.beforeSend || function() {};

				if (show.progress) {
					$('.' + DEFAULTS.progressClassName).show();
				}

				paramBeforeSend(jqXHR, settings);
			};

		// 요청을 보내기 전 함수 설정
		options['beforeSend'] = beforeSend;

		// url이 비어있을 경우 Error
		if (options.url == '') {
			throw new Error('url must require');
		}

		// 프로그레스 화면에 그리기 및 프로그레스 이미지 변경
		_renderProgress(progressImgUrl);

		// 요청
		$.ajax(options).done(function (data, textStatus, jqXHR) {
			// 정상적으로 요청이 수행된 경우

			if (! data || ! data.success) {
				// response가 없거나 서버사이드에서 성공이 아니라 응답한 경우
				if (show.failMessage) {
					// 공통 실패 메세지를 출력하도록 인자를 전달했을 경우 서버 응답에 포함된 실패메세지 출력
					var msg = (data && data.message)|| textStatus;

					_showMessage(msg, func.warningAlertCallback, jqXHR, data);
				}
			}

			func.done(data, textStatus, jqXHR);
		}).fail(function (jqXHR, textStatus, errorThrown) {
			// 공통 fail 처리

			if (show.failMessage) {
				// 공통 실패 메세지를 출력하도록 인자를 전달했을 경우 공통 실패메세지 출력
				var status = jqXHR.status,
					msgCode = {
						400: '잘못된 요청입니다.',
						401: '권한이 없습니다.',
						403: '해당 요청이 금지되었습니다.',
						404: '해당 요청을 찾을 수 없습니다.',
						405: '허용되지 않는 방법입니다.',
						500: '일시적인 오류가 발생했습니다.'
					},
					msg = msgCode[status] || '서버와 통신이 원활하지 않습니다.';

				_showMessage(msg, func.warningAlertCallback, jqXHR);
			}

			func.fail(jqXHR, textStatus, errorThrown);
		}).always(function (dataOrJqXHR, textStatus, jqXHROrErrorThrown) {
			// 공통 always 처리

			$('.' + DEFAULTS.progressClassName).hide();
			func.always(dataOrJqXHR, textStatus, jqXHROrErrorThrown);
		});
	};

	var _showMessage = function(msg, warningAlertCallback, jqXHR, data) {
		swal({
			title: '경고',
			text: msg,
			showCancelButton: false
		},
		function() {
			warningAlertCallback({
				jqXHR: jqXHR,
				data: data || {}
			});
		});
	};

	var _getValue = function (value, defaultValue) {
		// value와 defaultValue를 비교하여 value에 defaultValue를 포함시킴
		var def = defaultValue,
			options = {};

		if (! value) {
			options = defaultValue;
		} else {
			for (var name in def) {
				var val = value[name];

				if (typeof val == 'boolean') {
					// boolean일 경우는 value를 바로 입력
					options[name] = val;
				} else {
					options[name] = val || def[name];
				}
			}
		}

		return options;
	};

	var _renderProgress = function(progressImgUrl) {
		// 프로그레스를 body에 추가하고, 프로그레스가 이미 추가되어 있는 경우는 이미지 url
		var $document = $(document),
			progressClassname = DEFAULTS.progressClassName,
			$progress = $document.find('.' + progressClassname);

		if ($progress.length > 0) {
			$progress.find('img').attr('src', progressImgUrl);
		} else {
			var template = _getProgressHTML(),
				html = template.replace('[progressClassName]', progressClassname)
					.replace('[progressImgUrl]', progressImgUrl);

			$(document.body).append(html);
		}
	};

	var _getProgressHTML = function() {
		return '<div class="[progressClassName]" style="z-index: 9999999; position: absolute; left: 0; top: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.2); display: none;">' +
			'       <img src="[progressImgUrl]" style="width: 60px; height: 60px; position: fixed; left: calc(50% - 30px); top: calc(50% - 30px);" />' +
			'</div>';
	};

	return AjaxController;
});