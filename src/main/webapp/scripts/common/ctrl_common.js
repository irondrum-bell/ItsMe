var req_http_rest_api = {
		func : {
			req_get_message : function($http, url, param, success, fail){
				$http({
					method : "GET",
					url : ctx + url,
					params : param
				}).then(success, fail);
			},
			req_post_message : function($http, url, param, success, fail){
				$http({
					method : "POST",
					url : ctx + url,
					params : param
				}).then(success, fail);
			},
			req_multipart_message : function($http, url, param, _data, success, fail){
				$http({
					method : "POST",
					url : ctx + url,
					params : param,
					data : _data,
					withCredentials: true,
					headers : {'Content-Type': undefined},
					transformRequest : angular.identity
				}).then(success, fail);
			}
		}
}