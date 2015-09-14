/**
 * Created by WZL on 15/8/28.
 */

/*=============================================================*/
/*========================= Read.html =========================*/
/*
 * triggle for control aside panel
 * */
var pin = $('#pin-triggle');
var navbar = $('#navbar');

pin.on('click', function () {
    if (pin.hasClass('pin-triggle-show')) {
        navbar.animate({top: "0px"}, 300);
        $('body').animate({marginTop: "53px"}, 300);
        pin.removeClass('pin-triggle-show');
    } else {
        navbar.animate({top: "-108px"}, 300);
        $('body').animate({marginTop: "-53px"}, 300);
        pin.addClass('pin-triggle-show');
    }
});

var tocbutton = $('.aside-controls .fui-list-bulleted');
var tocpanel = $('.panels-container .toc');
var bmbutton = $('.aside-controls .fui-bookmark');
var bmpanel = $('.panels-container .bookmark');
var docbutton = $('.aside-controls .fui-document');
var docpanel = $('.panels-container .document');

controlClick(tocbutton, tocpanel);
controlClick(bmbutton, bmpanel);
controlClick(docbutton, docpanel);

function controlClick(ctBtn, ctpnl) {
    ctBtn.on('click', function () {
        if (ctBtn.parents('.controls-item').hasClass('active')) {
            ctpnl.css('display', 'none');
            ctBtn.parents('.controls-item').removeClass('active');
        } else {
            ctpnl.css('display', 'block');
            ctBtn.parents('.controls-item').addClass('active');
            removeActive(ctBtn.parents('.controls-item'));
            hidePanel(ctpnl);
        }
    });
}

function removeActive(node) {
    node.siblings('.controls-item').removeClass('active');
}

function hidePanel(node) {
    node.parent('.panels-container').siblings().children('.control-panel').css('display', 'none');
}

$(function () {
    $(window).scroll(function () {
        var viewH = $(this).height(),
            contentH = $(document).height() - 53,
            scrollTop = $(this).scrollTop(),
            progress = ((viewH + scrollTop) / contentH * 100).toFixed(1);

        //if(scrollTop % 30 == 0 || (viewH + scrollTop) == contentH) {
        $('#reading-progress').val(progress);
        $('.page-detail .progress-num').html(progress+'%');
        //}
    });
//    var height = window.innerHeight;
//    $('#paper').css({'height': height + 23});
});

/*
 * triggle for jump term in page
 * */
$('.page-form-switch').on('click', function () {
    var jump = $('.page-jump');
    var show = jump.css('display');

    jump.css('display', show == 'none' ? 'block' : 'none');
})
