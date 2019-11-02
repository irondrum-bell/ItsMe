app.controller("MemberListCtrl", function($scope, $http) {

	$(document).ready(function() {

		$("#checkAll").click(function() {

			if ($("#checkAll").prop("checked")) {

				$("input[name=chk]").prop("checked", true);

			} else {

				$("input[name=chk]").prop("checked", false);

			}

		});

	});
});
