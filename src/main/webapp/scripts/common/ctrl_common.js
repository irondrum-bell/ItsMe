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
			}
		}
}