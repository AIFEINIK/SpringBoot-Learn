/**
 * Created by Administrator on 2017-3-10.
 */
actionApp.directive('datePicker', function(){
    return {
        restrict:'AC',
        link:function(scope, elem, attrs){
            elem.datepicker();
        }
    };
});