/**
 * Created by Administrator on 2017-3-10.
 */
actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http',
    function ($rootScope, $scope, $http) {
        $scope.$on('$viewContentLoaded', function(){
            console.log("页面加载完成");
        });

        $scope.search = function(){
            personName = $scope.personName;
            $http.get('/search',{
                params:{personName:personName}
            }).then(
                function successCallback(resp){
                    $scope.person = resp.data;
                },
                function errorCallback(data){

                }
            )
        };
    }
]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',
    function($rootScope, $scope){
        $scope.$on('viewContentLoaded', function(){
            console.log('页面加载完成');
        })
    }
])