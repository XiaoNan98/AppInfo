$(function () {
    $("#type1").change(function () {
        $("#type2").html("")
        $("#type3").html("");
        $("#type2").append("<option value='0'>--请选择--</option>")
        var $id = $(this).val();
        $.getJSON("dev/appinfolistAjax",function (data) {
            for (var i = 0;i < data.length;i++){
                if ($id == data[i].parentId && data[i].parentId != 0){
                    var option = "<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
                    $("#type2").append(option)
                }
            }
        })
    })

    $("#type2").change(function () {
        $("#type3").html("");
        $("#type3").append("<option value='0'>--请选择--</option>")
        var $id = $(this).val();
        $.getJSON("dev/appinfolistAjax",function (data) {
            for (var i = 0;i < data.length;i++){
                if ($id == data[i].parentId && data[i].parentId != 0){
                    var option = "<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
                    $("#type3").append(option)
                }
            }
        })
    })
})