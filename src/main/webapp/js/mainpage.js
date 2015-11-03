/**
 * Created by jinglingmei on 15/11/2.
 */
$(function () {
    $('.dropdown a:first b').before(getCookie("userName"));
    $('.dropdown a:first').css('color','red');
});

